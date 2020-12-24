package me.mical.custompapi

import io.izzel.taboolib.loader.Plugin
import io.izzel.taboolib.module.config.TConfig
import io.izzel.taboolib.module.inject.TInject
import me.mical.custompapi.config.CPConfig
import me.mical.custompapi.config.CPFile
import me.mical.custompapi.config.CPFolder
import me.mical.custompapi.hook.CPExpansion
import me.mical.custompapi.hook.ParamsExpansion
import me.mical.custompapi.util.Util.toCPPlayer
import org.bukkit.Bukkit
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.configuration.file.YamlConfiguration
import java.util.*

object CustomPapi : Plugin() {
    fun getCPFolder(): CPFolder = CPFolder(this)
    fun getCPFile(): CPFile = CPFile(this)
    fun getCPConfig(): CPConfig = CPConfig(this)
    val cp_dataMap = hashMapOf<UUID, YamlConfiguration>()
    val global_dataMap = hashMapOf<String, ConfigurationSection>()
    var hookPapi = try {
        Class.forName("me.clip.placeholderapi.PlaceholderAPI")
        true
    } catch (e: Throwable) {
        false
    }

    @TInject("config.yml", locale = "Language")
    lateinit var CONFIG: TConfig

    override fun onEnable() {
        getCPFolder().load()
        getCPConfig().load()
        getCPFolder().setAllTimings()
        Bukkit.getOnlinePlayers().forEach { it.toCPPlayer().initData() }
        if (hookPapi && !(ParamsExpansion().isRegistered || CPExpansion().register())) {
            CPExpansion().register()
            ParamsExpansion().register()
        }
    }

    override fun onDisable() {
        if (hookPapi && (ParamsExpansion().isRegistered || CPExpansion().register())) {
            CPExpansion().unregister()
            ParamsExpansion().unregister()
        }
    }

}