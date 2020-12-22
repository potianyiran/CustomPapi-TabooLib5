package me.mical.custompapi.command.sub

import io.izzel.taboolib.module.command.base.BaseSubCommand
import io.izzel.taboolib.module.locale.TLocale
import me.mical.custompapi.CustomPapi
import me.mical.custompapi.hook.CPExpansion
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

class CommandReload : BaseSubCommand() {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>) {
        val start = System.currentTimeMillis()
        TLocale.reload()
        CustomPapi.CONFIG.reload()
        CustomPapi.getCPFolder().reload()
        CPExpansion().unregister()
        CustomPapi.getCPConfig().reload()
        CPExpansion().register()
        TLocale.sendTo(sender, "ReloadComplete", (System.currentTimeMillis() - start))
    }

}