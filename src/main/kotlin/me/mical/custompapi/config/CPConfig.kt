package me.mical.custompapi.config

import io.izzel.taboolib.module.locale.TLocale
import me.mical.custompapi.CustomPapi
import org.bukkit.configuration.ConfigurationSection

class CPConfig constructor(plugin: CustomPapi) {
    private val data = plugin.CONFIG
    fun getGlobalMap() = CustomPapi.global_dataMap

    fun load() {
        val allData = data.getConfigurationSection("Global")
        if (allData == null) {
            TLocale.sendToConsole("GlobalData.Load.None")
            return
        }
        if (allData.getKeys(false).size != 0) {
            for (varArg in allData.getKeys(false)) {
                val configSec = allData.getConfigurationSection(varArg)
                if (configSec != null && configSec.getKeys(false).containsAll(listOf("Default", "Timing"))) {
                    getGlobalMap()[varArg] = configSec
                    TLocale.sendToConsole("LoadedVar", varArg)
                }
            }
            TLocale.sendToConsole("LoadedAllVar", allData.getKeys(false).size)
        } else {
            TLocale.sendToConsole("GlobalData.Load.None")
        }
    }

    fun reload() {
        getGlobalMap().clear()
        load()
    }

}