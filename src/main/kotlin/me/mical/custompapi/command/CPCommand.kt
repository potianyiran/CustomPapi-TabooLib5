package me.mical.custompapi.command

import io.izzel.taboolib.module.command.base.BaseCommand
import io.izzel.taboolib.module.command.base.BaseMainCommand
import io.izzel.taboolib.module.command.base.BaseSubCommand
import io.izzel.taboolib.module.command.base.SubCommand
import me.mical.custompapi.command.sub.CommandAdd
import me.mical.custompapi.command.sub.CommandReload

@BaseCommand(name = "CustomPapi", aliases = ["cp", "cpapi"], permission = "CustomPapi.use")
class CPCommand : BaseMainCommand() {

    @SubCommand(permission = "CustomPapi.reload", description = "重载插件")
    val reload : BaseSubCommand = CommandReload()

    @SubCommand(permission = "CustomPapi.add", description = "增加指定变量的整数值")
    val add : BaseSubCommand = CommandAdd()

    @SubCommand(permission = "CustomPapi.take", description = "减少指定变量的整数值")
    val take : BaseSubCommand = CommandAdd()

    @SubCommand(permission = "CustomPapi.set", description = "设置指定变量的整数值")
    val set : BaseSubCommand = CommandAdd()

}
