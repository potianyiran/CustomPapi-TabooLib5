package me.mical.custompapi.util

import me.mical.custompapi.entity.CPPlayer
import org.bukkit.ChatColor
import org.bukkit.entity.Player

object Util {
    fun Player.toCPPlayer() : CPPlayer = CPPlayer(this)
}