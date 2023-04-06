package net.ccbluex.liquidbounce.features.module.modules.hyt

import net.ccbluex.liquidbounce.LiquidBounce
import net.ccbluex.liquidbounce.event.EventTarget
import net.ccbluex.liquidbounce.event.UpdateEvent
import net.ccbluex.liquidbounce.features.module.Module
import net.ccbluex.liquidbounce.features.module.ModuleCategory
import net.ccbluex.liquidbounce.features.module.ModuleInfo
import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura
import net.ccbluex.liquidbounce.value.BoolValue
import net.ccbluex.liquidbounce.value.IntegerValue
import net.ccbluex.liquidbounce.value.TextValue

@ModuleInfo(name="TKRun", description = "taoyi", category = ModuleCategory.HYT)
class TKRun : Module() {
    val thePlayer = mc.thePlayer!!
    var health = IntegerValue("Health",5)
    val Lobby  = TextValue("Lobby","/lobby 1145")
    var dis = BoolValue("DisableKillAura",true)
    val killaura = LiquidBounce.moduleManager.getModule(KillAura::class.java)
    @EventTarget
    fun onUpdate(event : UpdateEvent){
        if(thePlayer.health.toInt()<health.get()){
            thePlayer.sendChatMessage(Lobby.get())
            if(dis.get()){
                killaura.state=false
            }

        }
    }
}