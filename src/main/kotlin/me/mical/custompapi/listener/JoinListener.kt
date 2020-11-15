package me.mical.custompapi.listener

import io.izzel.taboolib.module.inject.TListener
import me.mical.custompapi.util.Util.toCCPlayer
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

@TListener
class JoinListener : Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        event.player.toCCPlayer().initData()
    }
}