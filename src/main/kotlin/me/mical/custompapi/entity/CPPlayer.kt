package me.mical.custompapi.entity

import io.izzel.taboolib.module.locale.TLocale
import me.mical.custompapi.CustomPapi
import org.bukkit.OfflinePlayer
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

class CPPlayer constructor(private val player: OfflinePlayer) {
    fun getData() : YamlConfiguration = CustomPapi.getCPFile().getData(player)
    fun hasData() : Boolean = CustomPapi.cp_dataMap.containsKey(player.uniqueId)
    fun initData() {
        if (!(CustomPapi.cp_dataMap.containsKey(player.uniqueId) || File(CustomPapi.getCPFolder().getCPFolderFile(), "${player.uniqueId}.yml").exists())) {
            CustomPapi.getCPFolder().initPlayerData(player.uniqueId)
            CustomPapi.cp_dataMap[player.uniqueId] = YamlConfiguration.loadConfiguration(File(CustomPapi.getCPFolder().getCPFolderFile(), "${player.uniqueId}.yml"))
            TLocale.sendToConsole("InitedData", player.uniqueId.toString())
        }
    }

    fun getDum(varArg: String) : Int {
        return getData().getInt("${varArg}.Amount", 0)
    }

    fun getTiming(varArg: String) : Long {
        return getData().getLong("${varArg}.Amount", System.currentTimeMillis())
    }

    fun setDum(varArg: String, dum: Int) {
        getData().set("${varArg}.Amount", dum)
        save()
    }

    fun addDum(varArg: String, dum: Int) {
        getData().set("${varArg}.Amount", getDum(varArg) + dum)
        save()
    }

    fun takeDum(varArg: String, dum: Int) {
        getData().set("${varArg}.Amount", getDum(varArg) - dum)
        save()
    }

    fun setDefault(varArg: String) {
        getData().set("${varArg}.Amount", CustomPapi.CONFIG.getInt("Global.${varArg}.Default"))
        save()
    }

    private fun save() {
        kotlin.runCatching { getData().save(CustomPapi.getCPFolder().getPlayerDataFile(player.uniqueId)) }.onFailure { TLocale.sendToConsole("Data.SaveFailure", player.uniqueId) }
    }
}