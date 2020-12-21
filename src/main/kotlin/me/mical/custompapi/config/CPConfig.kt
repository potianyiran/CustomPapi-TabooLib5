package me.mical.custompapi.config

import me.mical.custompapi.CustomPapi

class CPConfig constructor(private val plugin: CustomPapi) {
    private val data = plugin.CONFIG

    private fun getInternalIDs() : Set<String> {
        return data.getConfigurationSection("Global")!!.getKeys(false)
    }

    fun getInternalIDDataType(internalID: String) : String {
        if (getInternalIDs().contains(internalID))
            return data.getString("Global.${internalID}.DataType", "int")!!
        return "int"
    }

    fun getInternalIDDsfaultValue(internalID: String) : Any {
        if (getInternalIDs().contains(internalID))
            return data.get("Global.${internalID}.DataType")!!
        return 100
    }
}