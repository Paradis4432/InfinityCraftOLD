package com.infinitycraft.plugin.skyblock.market;

import com.infinitycraft.plugin.general.storageManager.SQLDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MarketRequestInformationFromSQL {
    public ArrayList<ArrayList<Object>> getPriceItemBlaze() {
        ArrayList<ArrayList<Object>> blazeTiersPrice = null;
        try {
            //creates the list to storage the info
            blazeTiersPrice = new ArrayList<>();
            //get info from sql database
            PreparedStatement selectBlaze = SQLDatabase.connection.prepareStatement("SELECT price,item FROM market WHERE item like'%blaze%'");
            //gets the info in rs to use in the while
            ResultSet rs = selectBlaze.executeQuery();
            //loops trouhg the information
            while (rs.next()) {
                //creates the list inside the list
                ArrayList<Object> item = new ArrayList<>();
                //Bukkit.getLogger().info(rs.getString("price")); prints information on console
                //get the information from the columns (the things on top) and saves them on the list
                item.add(rs.getString("item"));
                item.add(rs.getString("price"));
                blazeTiersPrice.add(item);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return blazeTiersPrice;
    }
}
