package me.mical.custompapi.listener

import io.izzel.taboolib.module.inject.TListener
import me.mical.custompapi.CustomPapi
import me.mical.custompapi.hook.CPExpansion
import me.mical.custompapi.hook.ParamsExpansion
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.server.PluginEnableEvent

@TListener
class PluginListener : Listener {
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun onPluginLoad(event: PluginEnableEvent) {
        if (event.plugin.name == "PlaceholderAPI") {
            if (CustomPapi.hookPapi && !(CPExpansion().isRegistered || ParamsExpansion().isRegistered)) {
                CPExpansion().register()
                ParamsExpansion().register()
            }
        }
    }
}