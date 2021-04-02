package com.infinitycraft.plugin.essentialCommands;

public class ReportCommand {
    /**
     * A simple /report command
     * @param sender The sender of the command
     * @param cmd The command
     * @param label The label of the command
     * @param args The commands arguments
     * @return Whether or not the command was used successfully
     * reports a player
     * open sql search for player and table, set reports += 1
     * every 10 minutes check if a player reaches 15 negative points (upvotes - reports = -15) , is this happens send a message to discord or tag this player as a "bad player"
     * if a player has more than 30 reports then kick this player for 24 hours and flag him as a "high risk player"
     * a player can only report the same person once
     */
}
