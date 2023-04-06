package net.ccbluex.liquidbounce.features.module.modules.hyt

import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketEntityAction
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketKeepAlive
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayer
import net.ccbluex.liquidbounce.event.EventTarget
import net.ccbluex.liquidbounce.event.PacketEvent
import net.ccbluex.liquidbounce.features.module.Module
import net.ccbluex.liquidbounce.features.module.ModuleCategory
import net.ccbluex.liquidbounce.features.module.ModuleInfo
import net.ccbluex.liquidbounce.value.BoolValue
import net.minecraft.network.handshake.client.C00Handshake

@ModuleInfo(name = "NoPackets", description = "NoFaBao", category = ModuleCategory.HYT )
class NoPackets : Module() {
    val C00 = BoolValue("C00",false)
    val C03 = BoolValue("C03",false)
    val C0F = BoolValue("C0F",false)
    @EventTarget
    fun onPacket(event: PacketEvent){
        val packet = event.packet
        if(C00.get()){
            if(packet is C00Handshake){
                event.cancelEvent()
            }
        }
        if(C03.get()){
            if(packet is ICPacketEntityAction){
                event.cancelEvent()
            }
        }
        if(C0F.get()){
            if(packet is ICPacketKeepAlive){
                event.cancelEvent()
            }
            if(packet is ICPacketPlayer){
                event.cancelEvent()
            }
        }
    }

}