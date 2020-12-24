package me.mical.custompapi.hook

import me.clip.placeholderapi.expansion.PlaceholderExpansion
import me.mical.custompapi.CustomPapi
import me.mical.custompapi.util.Util.toCPPlayer
import org.bukkit.OfflinePlayer

class ParamsExpansion : PlaceholderExpansion() {

    override fun getIdentifier(): String = CustomPapi.CONFIG.getString("Prefix").toString()

    override fun getAuthor(): String = "Mical"

    override fun getVersion(): String = CustomPapi.plugin.description.version

    override fun onRequest(player: OfflinePlayer?, params: String): String? {
        if (!player!!.toCPPlayer().getData().getKeys(false).contains(params)) return null
        val current = System.currentTimeMillis().toInt()
        val timestamp = player.toCPPlayer().getTiming(params).toInt()
        val timing = CustomPapi.global_dataMap[params]!!.getLong("Timing").toInt() * 1000
        if ((current - timestamp) >= timing) {
            player.toCPPlayer().setDefault(params)
        }
        return player.toCPPlayer().getDum(params).toString()
    }


}