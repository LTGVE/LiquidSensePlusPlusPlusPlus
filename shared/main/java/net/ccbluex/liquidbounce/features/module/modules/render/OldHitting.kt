package net.ccbluex.liquidbounce.features.module.modules.render

import net.ccbluex.liquidbounce.features.module.Module
import net.ccbluex.liquidbounce.features.module.ModuleCategory
import net.ccbluex.liquidbounce.features.module.ModuleInfo
import net.ccbluex.liquidbounce.value.ListValue

@ModuleInfo(name = "OldHitting", description = "faq", category = ModuleCategory.RENDER)
class OldHitting : Module() {

    private val modeValue = ListValue("Mode", arrayOf("LiquidSense", "Push", "1.8"), "LiquidSense")

    fun getModeValue(): ListValue? {
        return modeValue
    }

}