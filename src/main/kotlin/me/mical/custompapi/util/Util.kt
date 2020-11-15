package me.mical.custompapi.util

import me.mical.custompapi.entity.CPPlayer
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player

object Util {
    fun OfflinePlayer.toCPPlayer() : CPPlayer = CPPlayer(this)
    fun Player.toCCPlayer() : CPPlayer = CPPlayer(this)
}