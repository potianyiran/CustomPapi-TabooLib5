package me.mical.custompapi.command

import io.izzel.taboolib.module.command.base.BaseCommand
import io.izzel.taboolib.module.command.base.BaseMainCommand
import io.izzel.taboolib.module.command.base.BaseSubCommand
import io.izzel.taboolib.module.command.base.SubCommand
import me.mical.custompapi.command.sub.CommandReload

@BaseCommand(name = "CustomPapi", aliases = ["cp", "cpapi"], permission = "CustomPapi.use")
class CPCommand : BaseMainCommand() {

    @SubCommand(permission = "CustomPapi.reload", description = "重载插件")
    val reload : BaseSubCommand = CommandReload()

}
