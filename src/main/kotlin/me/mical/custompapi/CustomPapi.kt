package me.mical.custompapi

import io.izzel.taboolib.loader.Plugin
import io.izzel.taboolib.module.config.TConfig
import io.izzel.taboolib.module.inject.TInject
import me.mical.custompapi.config.CPConfig
import me.mical.custompapi.config.CPFile
import me.mical.custompapi.config.CPFolder
import me.mical.custompapi.hook.CPExpansion
import me.mical.custompapi.util.Util.toCPPlayer
import org.bukkit.Bukkit
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.util.*

object CustomPapi : Plugin() {
    fun getCPFolder(): CPFolder = CPFolder(this)
    fun getCPFile(): CPFile = CPFile(this)
    fun getCPConfig(): CPConfig = CPConfig(this)
    val cp_dataMap = hashMapOf<UUID, YamlConfiguration>()

    @TInject("config.yml", locale = "Language")
    lateinit var CONFIG: TConfig
    lateinit var dataFolder: File

    override fun onEnable() {
        dataFolder = if (CONFIG.getString("Storage") == "this")
            plugin.dataFolder
        else {
            val file = File(CONFIG.getString("Storage")!!)
            if (file.exists()) file else plugin.dataFolder
        }
        getCPFolder().load()
        Bukkit.getOnlinePlayers().forEach { it.toCPPlayer().initData() }
        getCPConfig().load()
        CPExpansion().register()
    }

}