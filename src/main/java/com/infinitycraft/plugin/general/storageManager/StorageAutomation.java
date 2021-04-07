package com.infinitycraft.plugin.general.storageManager;

import com.infinitycraft.plugin.general.authentication.TwoFactorAuthEvent;
import com.infinitycraft.plugin.main;
import dev.samstevens.totp.code.CodeGenerator;
import dev.samstevens.totp.code.CodeVerifier;
import dev.samstevens.totp.code.DefaultCodeGenerator;
import dev.samstevens.totp.code.DefaultCodeVerifier;
import dev.samstevens.totp.time.SystemTimeProvider;
import dev.samstevens.totp.time.TimeProvider;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.inventory.ItemStack;

import java.sql.SQLException;
import java.util.Collections;

public class StorageAutomation implements Listener {
    /** Completes actions when a player joins
     *
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        // Run Stuff
        if (!(e.getPlayer().hasPlayedBefore())) {
            NewObject.newPlayer(e.getPlayer());
        }
        String name = (String) GetObject.getPlayer(e.getPlayer().getUniqueId(), "name");
        if (!name.equals(e.getPlayer().getName())) {
            EditObject.editPlayer(e.getPlayer().getUniqueId(), "name", e.getPlayer().getName());
        }
        Player player = e.getPlayer();
        // Intercept 2FA
        if (GetObject.getPlayer(player.getUniqueId(), "secret") != "") {
            TwoFactorAuthEvent.authing.add(player);
            new AnvilGUI.Builder()
                    .onComplete((player1, s) -> {
                        s = s.replaceAll("\\s", "");
                        TimeProvider timeProvider = new SystemTimeProvider();
                        CodeGenerator codeGenerator = new DefaultCodeGenerator();
                        CodeVerifier verifier = new DefaultCodeVerifier(codeGenerator, timeProvider);
                        boolean successful = verifier.isValidCode((String) GetObject.getPlayer(player.getUniqueId(), "secret"), s);
                        if (!successful) {
                            player.kickPlayer("Your 2FA code was wrong. Please try again or contact support.");
                        }
                        else {
                            player.sendMessage(ChatColor.DARK_GREEN + "Your 2FA code was correct!");
                            TwoFactorAuthEvent.authing.removeAll(Collections.singleton(player));
                        }
                        return AnvilGUI.Response.close();
                    })
                    .text("")
                    .itemLeft(new ItemStack(Material.PAPER))
                    .title("Enter 2FA Code")
                    .plugin(main.getInstance())
                    .preventClose()
                    .open(player);
        }
        // Run Stuff
        EditObject.editPlayer(player.getUniqueId(), "online", true);
        if ((boolean) GetObject.getPlayer(e.getPlayer().getUniqueId(), "staffMode")) {
            e.getPlayer().performCommand("staff");
            e.setJoinMessage("");
        }
    }

    /**
     * Mark a player as offline when they leave
     */
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        EditObject.editPlayer(player.getUniqueId(), "online", false);
    }

    @EventHandler
    public void serverStart(ServerLoadEvent e){
        try {
            SQLDatabase.statement.execute("UPDATE players SET online = false");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}