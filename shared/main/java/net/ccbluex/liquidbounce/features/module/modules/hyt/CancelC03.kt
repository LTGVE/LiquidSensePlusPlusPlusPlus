package net.ccbluex.liquidbounce.features.module.modules.exploit

import net.ccbluex.liquidbounce.LiquidBounce
import net.ccbluex.liquidbounce.event.EventTarget
import net.ccbluex.liquidbounce.event.PacketEvent
import net.ccbluex.liquidbounce.event.UpdateEvent
import net.ccbluex.liquidbounce.features.module.Module
import net.ccbluex.liquidbounce.features.module.ModuleCategory
import net.ccbluex.liquidbounce.features.module.ModuleInfo
import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura
import net.ccbluex.liquidbounce.injection.backend.unwrap
import net.ccbluex.liquidbounce.utils.ClientUtils
import net.ccbluex.liquidbounce.value.BoolValue
import net.ccbluex.liquidbounce.value.FloatValue
import net.ccbluex.liquidbounce.value.IntegerValue
import net.minecraft.network.play.client.CPacketPlayer


@ModuleInfo(name = "CancelC03",description = "CancelC03", category = ModuleCategory.EXPLOIT)
class CancelC03 : Module() {
    val debugValue = BoolValue("Debug",true)
    val range = FloatValue("Range",5f,4f,8f)
    var Aura = LiquidBounce.moduleManager[KillAura::class.java] as KillAura
    private val fsrange = FloatValue("originalRange",Aura.rangeValue.get(),4f,8f)
    private var motionX = 0.0
    private var motionY = 0.0
    private var motionZ = 0.0
    private var x = 0.0
    private var y = 0.0
    private var z = 0.0

    override fun onEnable() {
        Aura.rangeValue.set(range.get())
        if (mc.thePlayer == null) {
            return
        }

        x = mc.thePlayer!!.posX
        y = mc.thePlayer!!.posY
        z = mc.thePlayer!!.posZ
        motionX = mc.thePlayer!!.motionX
        motionY = mc.thePlayer!!.motionY
        motionZ = mc.thePlayer!!.motionZ
    }

    @EventTarget
    fun onUpdate(event: UpdateEvent) {
        mc.thePlayer!!.motionX = 0.0
        mc.thePlayer!!.motionY = 0.0
        mc.thePlayer!!.motionZ = 0.0
        mc.thePlayer!!.setPositionAndRotation(x, y, z, mc.thePlayer!!.rotationYaw, mc.thePlayer!!.rotationPitch)
    }

    @EventTarget
    fun onPacket(event: PacketEvent) {
        val packet = event.packet.unwrap()
        if(packet is CPacketPlayer){
            event.cancelEvent()
            if(debugValue.get()) ClientUtils.displayChatMessage("Cancel C03")
        }
        if (event.packet is CPacketPlayer){
            event.cancelEvent()
        }

        if (event.packet is CPacketPlayer) {
            x = event.packet.x
            y = event.packet.y
            z = event.packet.z
            motionX = 0.0
            motionY = 0.0
            motionZ = 0.0
        }
    }

    override fun onDisable() {
        Aura.rangeValue.set(fsrange.get())
        mc.thePlayer!!.motionX = motionX
        mc.thePlayer!!.motionY = motionY
        mc.thePlayer!!.motionZ = motionZ
        mc.thePlayer!!.setPositionAndRotation(x, y, z, mc.thePlayer!!.rotationYaw, mc.thePlayer!!.rotationPitch)
    }
}