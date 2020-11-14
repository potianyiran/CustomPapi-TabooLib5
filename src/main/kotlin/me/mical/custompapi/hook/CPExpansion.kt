package me.mical.custompapi.hook

import me.clip.placeholderapi.expansion.PlaceholderExpansion
import me.mical.custompapi.CustomPapi
import org.bukkit.OfflinePlayer

class CPExpansion : PlaceholderExpansion() {

    override fun getIdentifier(): String = CustomPapi.CONFIG.getString("Prefix").toString()

    override fun getAuthor(): String = "Mical"

    override fun getVersion(): String = CustomPapi.plugin.description.version

    override fun onRequest(player: OfflinePlayer?, params: String): String {
        return super.onRequest(player, params)
    }


}