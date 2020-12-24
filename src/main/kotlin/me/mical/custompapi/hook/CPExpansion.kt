package me.mical.custompapi.hook

import me.clip.placeholderapi.expansion.PlaceholderExpansion
import me.mical.custompapi.CustomPapi
import me.mical.custompapi.util.Util.toCPPlayer
import org.bukkit.OfflinePlayer

class CPExpansion : PlaceholderExpansion() {
    override fun getIdentifier(): String = "cp"

    override fun getAuthor(): String = "Mical"

    override fun getVersion(): String = CustomPapi.plugin.description.version

    override fun onRequest(player: OfflinePlayer?, params: String): String? {
        val args = params.split("_")
        if (!player!!.toCPPlayer().getData().getKeys(false).contains(args[1])) return null
        if (args[0].toLowerCase() == "time") {
            val varArg = args[1]
            if (CustomPapi.global_dataMap.containsKey(varArg)) {
                val current = System.currentTimeMillis().toInt()
                val timestamp = player.toCPPlayer().getTiming(varArg).toInt()
                val timing = CustomPapi.global_dataMap[varArg]!!.getLong("Timing").toInt() * 1000
                if ((current - timestamp) >= timing) {
                    player.toCPPlayer().setDefault(varArg)
                }
                return ((System.currentTimeMillis() - player.toCPPlayer().getTiming(varArg)) / 1000).toString()
            }
        }
        return null
    }

}