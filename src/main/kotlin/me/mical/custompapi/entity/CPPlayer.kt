package me.mical.custompapi.entity

import me.mical.custompapi.CustomPapi
import org.bukkit.entity.Player
import java.io.File

class CPPlayer constructor(private val player: Player) {
    fun hasData() : Boolean = CustomPapi.cp_dataMap.containsKey(player.uniqueId)
    fun initData() {
        //if (!(CustomPapi.cp_dataMap.containsKey(player.uniqueId) || File(CustomPapi.getCPFolder().getCPFolderFile(), "${player.uniqueId}.yml").exists())) {

        //}
    }
}