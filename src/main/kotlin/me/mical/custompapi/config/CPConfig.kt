package me.mical.custompapi.config

import io.izzel.taboolib.module.locale.TLocale
import me.mical.custompapi.CustomPapi
import org.bukkit.configuration.ConfigurationSection

class CPConfig constructor(plugin: CustomPapi) {
    private val data = plugin.CONFIG
    fun getGlobalMap() : HashMap<String, ConfigurationSection> = hashMapOf()

    fun load() {
        val allData = data.getConfigurationSection("Global")
        if (allData == null) {
            TLocale.sendToConsole("GlobalData.Load.None")
            return
        }
        for (varArg in allData.getKeys(false)) {
            val configSec = data.getConfigurationSection(varArg)
            if (configSec != null && configSec.getKeys(false).containsAll(listOf("Default", "Timing"))) {
                getGlobalMap()[varArg] = configSec
            }
        }
    }

    fun reload() {
        getGlobalMap().clear()
        load()
    }

}