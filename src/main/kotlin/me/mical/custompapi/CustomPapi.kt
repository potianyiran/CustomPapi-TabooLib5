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
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.util.*

object CustomPapi : Plugin() {
    fun getCPFolder(): CPFolder = CPFolder(this)
    fun getCPFile(): CPFile = CPFile(this)
    fun getCPConfig(): CPConfig = CPConfig(this)
    val cp_dataMap = hashMapOf<UUID, YamlConfiguration>()
    val global_dataMap = hashMapOf<String, ConfigurationSection>()

    @TInject("config.yml", locale = "Language")
    lateinit var CONFIG: TConfig

    override fun onEnable() {
        getCPFolder().load()
        getCPConfig().load()
        CPExpansion().register()
        getCPFolder().setAllTimings()
        Bukkit.getOnlinePlayers().forEach { it.toCPPlayer().initData() }
        println(getCPConfig().getGlobalMap())
    }

}