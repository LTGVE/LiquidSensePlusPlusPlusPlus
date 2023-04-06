package net.ccbluex.liquidbounce.features.module.modules.misc

import net.ccbluex.liquidbounce.LiquidBounce
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketEntityAction
import net.ccbluex.liquidbounce.event.EventTarget
import net.ccbluex.liquidbounce.features.module.Module
import net.ccbluex.liquidbounce.features.module.ModuleCategory
import net.ccbluex.liquidbounce.features.module.ModuleInfo
import net.ccbluex.liquidbounce.features.module.modules.exploit.Kick
import net.ccbluex.liquidbounce.utils.ClientUtils
import net.ccbluex.liquidbounce.utils.MinecraftInstance
import net.ccbluex.liquidbounce.utils.createUseItemPacket
import net.ccbluex.liquidbounce.value.BoolValue
import net.ccbluex.liquidbounce.value.TextValue

@ModuleInfo(name="Fakeban", description = "Display a Fake Ban", category = ModuleCategory.MISC)
class FakeBan : Module() {
    val names  = TextValue("Name","狂笑的蛇将写散文")
    var namess = names.get()
    var get  = LiquidBounce.moduleManager.getModule(Kick::class.java)
    val kick= BoolValue("Kick",false)
    @EventTarget
    override fun onEnable(){
        ClientUtils.displayChatMessage("§c■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■")
        ClientUtils.displayChatMessage("§c➤")
        ClientUtils.displayChatMessage("§c➤ 玩家 §e§l $namess §c在本局游戏中行为异常, 已被踢出游戏并封禁处罚")
        ClientUtils.displayChatMessage("§c➤")
        ClientUtils.displayChatMessage("§c■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■")
        if(kick.get()){
            get.state=true
            get.state=false
        }
        this.state=false
    }
}