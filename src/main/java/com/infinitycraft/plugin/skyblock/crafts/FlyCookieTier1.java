package com.infinitycraft.plugin.skyblock.crafts;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getServer;

public class FlyCookieTier1 {

    public static void FlyCookieTier1Craft(){
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
