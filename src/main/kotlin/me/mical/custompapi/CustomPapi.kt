package me.mical.custompapi

import io.izzel.taboolib.loader.Plugin
import io.izzel.taboolib.module.config.TConfig
import io.izzel.taboolib.module.inject.TInject
import me.mical.custompapi.config.CPFile
import me.mical.custompapi.config.CPFolder
import me.mical.custompapi.hook.CPExpansion
import org.bukkit.configuration.file.YamlConfiguration
import java.util.*

object CustomPapi : Plugin() {
    fun getCPFolder() : CPFolder = CPFolder(this)
    fun getCPFile() : CPFile = CPFile(this, getCPFolder().getCPFolderFile())
    val cp_dataMap = hashMapOf<UUID, YamlConfiguration>()
    @TInject("config.yml")
    lateinit var CONFIG : TConfig

    override fun onEnable() {
        getCPFolder().load()
        CPExpansion().register()
    }
}