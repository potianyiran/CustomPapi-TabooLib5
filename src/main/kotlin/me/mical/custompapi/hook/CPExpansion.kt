package me.mical.custompapi.hook

import me.clip.placeholderapi.expansion.PlaceholderExpansion
import me.mical.custompapi.CustomPapi
import me.mical.custompapi.util.Util.toCPPlayer
import org.bukkit.OfflinePlayer

class CPExpansion : PlaceholderExpansion() {

    override fun getIdentifier(): String = CustomPapi.CONFIG.getString("Prefix").toString()

    override fun getAuthor(): String = "Mical"

    override fun getVersion(): String = CustomPapi.plugin.description.version

    override fun onRequest(player: OfflinePlayer?, params: String): String? {
        if (!player!!.toCPPlayer().getData().getKeys(false).contains(params)) return null
        if (player.toCPPlayer().getTiming(params) != 0L && ((System.currentTimeMillis() - player.toCPPlayer().getTiming(params)) % CustomPapi.CONFIG.getLong("Global.${params}.Timing") == 0L )) {
            player.toCPPlayer().setDefault(params)
        }
        return player.toCPPlayer().getDum(params).toString()
    }


}