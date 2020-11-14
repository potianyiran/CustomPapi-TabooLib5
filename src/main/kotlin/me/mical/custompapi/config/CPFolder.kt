package me.mical.custompapi.config

import io.izzel.taboolib.module.locale.TLocale
import me.mical.custompapi.CustomPapi
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.util.*

class CPFolder constructor(private val plugin: CustomPapi) {
    init {
        if (!getCPFolderFile().exists()) getCPFolderFile().mkdirs()
    }

    fun getCPFolderFile() : File {
        return File(plugin.plugin.dataFolder, "data")
    }
    fun load() {
        val files = getCPFolderFile().listFiles { _, name -> name.endsWith("yml") }
        if (files != null) {
            for (file in files) {
                val data = YamlConfiguration.loadConfiguration(file)
                val name = file.name.removeSuffix(".yml")
                val uuid = UUID.fromString(name)
                CustomPapi.cp_dataMap[uuid] = data
            }
            if (files.isEmpty())
                TLocale.Logger.warn("NoDataLoad")
            else TLocale.Logger.info("LoadedData", files.size.toString())
        } else TLocale.Logger.error("FailLoadData")
    }
}