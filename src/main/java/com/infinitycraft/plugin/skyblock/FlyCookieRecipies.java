package com.infinitycraft.plugin.skyblock;

import com.infinitycraft.plugin.main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import sun.tools.jar.Main;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getServer;


public class FlyCookieRecipies implements Listener {
    /**
     * ON PAUSE UNTIL WE FINISH CUSTOM DROPS AND SEE HOW LONG IT WOULD TAKE TO CRAFT EACH COOKIE
     * https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ShapedRecipe.html
     * https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/PrepareItemCraftEvent.html
     * tier 1: 5 minutes
     * tier 2: 30 minutes
     * tier 3: 1 hour
     * tier 4: 3 hours
     * tier 5: 12 hours
     */


    /***
    public static ShapedRecipe CookieRecipie(){
        ItemStack customItem = new ItemStack(Material.STONE);
        ItemMeta cim = customItem.getItemMeta();
        cim.setDisplayName("Cool Item");
        customItem.setItemMeta(cim);

        ItemStack result = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = result.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "this is a test");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.WHITE + "This is the lore");
        meta.setLore(lore);
        result.setItemMeta(meta);

        NamespacedKey nsk = new NamespacedKey(main.getInstance(), "custom_recipe");

        ShapedRecipe recipe = new ShapedRecipe(nsk, result);
        recipe.shape("ccc", " c ", "ccc");
        recipe.setIngredient('c', new RecipeChoice.ExactChoice(customItem));

        return recipe;
    }
     */



    public static void FlyCookieTier1(){
        //ingredients
        ItemStack ing0 = new ItemStack(Material.EMERALD,1);
        //ItemMeta ing0meta = ing0.getItemMeta();
        //ing0meta.setDisplayName("Fly Cookie Tier 1 ing 0");
        //ing0.setItemMeta(ing0meta);

        //final product
        ItemStack finalProd = new ItemStack(Material.COOKIE);
        ItemMeta meta = finalProd.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Fly Cookie Tier 1 ");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Use this item for");
        lore.add(ChatColor.GRAY + "5 minutes of Fly!");
        meta.setLore(lore);
        finalProd.setItemMeta(meta);

        //item creation
        ShapelessRecipe recipe = new ShapelessRecipe(finalProd);
        recipe.addIngredient(new RecipeChoice.ExactChoice(ing0));

        getServer().addRecipe(recipe);
    }

}


/**


 public void unshaped(){
 ItemStack item = new ItemStack(Material.ENDER_PEARL, 1);

 ShapelessRecipe slr = new ShapelessRecipe(item);

 slr.addIngredient(3,Material.LAVA_BUCKET);
 slr.addIngredient(3, Material.FLINT);
 plugin.getServer().addRecipe(slr);

 *********

 ItemStack customItem = new ItemStack(Material.STONE);
 ItemMeta cim = customItem.getItemMeta();
 cim.setDisplayName("Cool Item");
 customItem.setItemMeta(cim);

 ItemStack result = new ItemStack(Material.DIAMOND_SHOVEL);
 ItemMeta meta = result.getItemMeta();
 meta.setDisplayName(ChatColor.GOLD + "this is a test");
 ArrayList<String> lore = new ArrayList<String>();
 lore.add(ChatColor.WHITE + "This is the lore");
 meta.setLore(lore);
 result.setItemMeta(meta);

 NamespacedKey nsk = new NamespacedKey(this, "custom_recipe"); //this extends JavaPlugin

 ShapedRecipe recipe = new ShapedRecipe(nsk, result);
 recipe.shape("cc", "cc");
 recipe.setIngredient('c', new RecipeChoice.ExactChoice(customItem));

 getServer().addRecipe(recipe);
 */
