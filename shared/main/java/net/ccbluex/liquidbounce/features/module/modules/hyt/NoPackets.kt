package net.ccbluex.liquidbounce.features.module.modules.hyt

import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketEntityAction
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketKeepAlive
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayer
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayerBlockPlacement
import net.ccbluex.liquidbounce.event.EventTarget
import net.ccbluex.liquidbounce.event.PacketEvent
import net.ccbluex.liquidbounce.features.module.Module
import net.ccbluex.liquidbounce.features.module.ModuleCategory
import net.ccbluex.liquidbounce.features.module.ModuleInfo
import net.ccbluex.liquidbounce.injection.backend.CPacketPlayerBlockPlacementImpl
import net.ccbluex.liquidbounce.injection.backend.unwrap
import net.ccbluex.liquidbounce.utils.ClientUtils
import net.ccbluex.liquidbounce.value.BoolValue
import net.minecraft.network.handshake.client.C00Handshake
import net.minecraft.network.play.client.CPacketConfirmTransaction
import net.minecraft.network.play.client.CPacketKeepAlive

@ModuleInfo(name = "NoPackets", description = "NoFaBao", category = ModuleCategory.HYT )
class NoPackets : Module() {
    val C00 = BoolValue("C00", false)
    val C08 = BoolValue("C08", false)
    val C0F = BoolValue("C0F", false)
    val debug = BoolValue("Debug", true)

    @EventTarget
    fun onPacket(event: PacketEvent) {
        val packet = event.packet.unwrap()
        if (debug.get()) {
            if (C00.get()) {
                if (packet is CPacketKeepAlive) {
                    ClientUtils.displayChatMessage("Cancel C00")
                    event.cancelEvent()

                }
                if (C08.get()) {
                    if (packet is ICPacketPlayerBlockPlacement) {
                        ClientUtils.displayChatMessage("Cancel C08")
                        event.cancelEvent()
                    }
                }
                if (C0F.get()) {
                    if (packet is CPacketConfirmTransaction) {
                        ClientUtils.displayChatMessage("Cancel C0F")
                        event.cancelEvent()
                    }
                } else {
                    if (C00.get()) {
                        if (packet is CPacketKeepAlive) {
                            event.cancelEvent()
                        }
                    }
                    if (C08.get()) {
                        if (packet is ICPacketPlayerBlockPlacement) {
                            event.cancelEvent()
                        }
                    }
                    if (C0F.get()) {
                        if (packet is CPacketConfirmTransaction) {
                            event.cancelEvent()
                        }
                    }
                }

            }
        }
    }
}