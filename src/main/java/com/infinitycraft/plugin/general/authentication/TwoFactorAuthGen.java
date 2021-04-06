package com.infinitycraft.plugin.general.authentication;

import com.infinitycraft.plugin.general.storageManager.EditObject;
import com.infinitycraft.plugin.general.storageManager.GetObject;
import com.infinitycraft.plugin.general.tools.permissions.CheckPermission;
import com.infinitycraft.plugin.main;
import dev.samstevens.totp.code.*;
import dev.samstevens.totp.exceptions.QrGenerationException;
import dev.samstevens.totp.qr.QrData;
import dev.samstevens.totp.qr.QrGenerator;
import dev.samstevens.totp.qr.ZxingPngQrGenerator;
import dev.samstevens.totp.secret.DefaultSecretGenerator;
import dev.samstevens.totp.secret.SecretGenerator;
import dev.samstevens.totp.time.SystemTimeProvider;
import dev.samstevens.totp.time.TimeProvider;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.bukkit.Bukkit.createMap;

public class TwoFactorAuthGen implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You can't run this command in the console!");
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage(ChatColor.DARK_RED + "To use this command, run \"/2fa [enable, disable, status, test]\".");
            return true;
        }
        if (args[0].equals("status")) {
            if (GetObject.getPlayer(player.getUniqueId(), "secret") == "") {
                player.sendMessage(ChatColor.GOLD + "Two factor authentication is disabled on this account.");
            }
            else {
                player.sendMessage(ChatColor.GOLD + "Two factor authentication is enabled on this account.");
            }
            return true;
        }
        if (args[0].equals("disable")) {
            if (GetObject.getPlayer(player.getUniqueId(), "secret") == "") {
                player.sendMessage(ChatColor.DARK_RED + "2FA is already disabled! Use /2fa enable to turn it on!");
                return true;
            }
            EditObject.editPlayer(player.getUniqueId(), "secret", "");
            player.sendMessage(ChatColor.GOLD + "Two factor authentication has been disabled.");
            return true;
        }
        if (args[0].equals("enable")) {
            if (GetObject.getPlayer(player.getUniqueId(), "secret") != "") {
                player.sendMessage(ChatColor.DARK_RED + "2FA is already enabled! Use /2fa disable to turn it off!");
                return true;
            }
            SecretGenerator secretGenerator = new DefaultSecretGenerator();
            String secret = secretGenerator.generate();
            QrData data = new QrData.Builder()
                    .label(player.getName())
                    .secret(secret)
                    .issuer("InfinityCraft")
                    .algorithm(HashingAlgorithm.SHA1)
                    .digits(6)
                    .period(30)
                    .build();
            QrGenerator generator = new ZxingPngQrGenerator();
            byte[] imageData = null;
            try {
                imageData = generator.generate(data);
            } catch (QrGenerationException e) {
                e.printStackTrace();
            }
            String url = ImageUploader.uploadImage(imageData);
            player.sendMessage(ChatColor.GOLD + "Scan this QR code using an app like Authy or Google Authenticator: " + url + ". Then run /2fa test!");
            EditObject.editPlayer(player.getUniqueId(), "secret", secret);
            return true;
        }
        if (args[0].equals("test")) {
            if (GetObject.getPlayer(player.getUniqueId(), "secret") == "") {
                player.sendMessage(ChatColor.DARK_RED + "You haven't enabled 2fa. Use /2fa enable to enable two factor authentication.");
                return true;
            }
            else {
                new AnvilGUI.Builder()
                        .onComplete((player1, s) -> {
                            s = s.replaceAll("\\s", "");
                            TimeProvider timeProvider = new SystemTimeProvider();
                            CodeGenerator codeGenerator = new DefaultCodeGenerator();
                            CodeVerifier verifier = new DefaultCodeVerifier(codeGenerator, timeProvider);
                            boolean successful = verifier.isValidCode((String) GetObject.getPlayer(player.getUniqueId(), "secret"), s);
                            if (!successful) {
                                player.sendMessage(ChatColor.DARK_RED + "Your 2FA code was incorrect.");
                            }
                            else {
                                player.sendMessage(ChatColor.DARK_GREEN + "Your 2FA code was correct!");
                            }
                            return AnvilGUI.Response.close();
                        })
                        .text("")
                        .itemLeft(new ItemStack(Material.PAPER))
                        .title("Enter 2FA Code")
                        .plugin(main.getInstance())
                        .open(player);
            }
            return true;
        }


        return false;
    }
}
