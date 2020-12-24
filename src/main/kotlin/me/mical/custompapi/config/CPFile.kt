package me.mical.custompapi.config

import me.mical.custompapi.CustomPapi
import me.mical.custompapi.util.Util.toCPPlayer
import org.bukkit.OfflinePlayer
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

class CPFile constructor(private val plugin: CustomPapi) {

    fun getData(player: OfflinePlayer): YamlConfiguration {
        if (!plugin.cp_dataMap.containsKey(player.uniqueId))
            player.toCPPlayer().initData()
        return plugin.cp_dataMap[player.uniqueId]!!
    }

    fun getDataFile(player: OfflinePlayer): File {
        if (!plugin.cp_dataMap.containsKey(player.uniqueId))
            player.toCPPlayer().initData()
        return plugin.getCPFolder().getPlayerDataFile(player.uniqueId)
    }
}