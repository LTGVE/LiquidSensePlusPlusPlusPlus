package net.ccbluex.liquidbounce.features.module.modules.misc

import net.ccbluex.liquidbounce.LiquidBounce
import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase
import net.ccbluex.liquidbounce.event.EventTarget
import net.ccbluex.liquidbounce.event.PacketEvent
import net.ccbluex.liquidbounce.event.WorldEvent
import net.ccbluex.liquidbounce.features.module.Module
import net.ccbluex.liquidbounce.features.module.ModuleCategory
import net.ccbluex.liquidbounce.features.module.ModuleInfo
import net.ccbluex.liquidbounce.features.module.modules.misc.AntiBot
import net.ccbluex.liquidbounce.value.BoolValue
import java.util.ArrayList
import java.util.regex.Pattern

@ModuleInfo(name = "NoHurt", description = "faq", category = ModuleCategory.HYT)
class NoHurt : Module() {
    private val playerName: MutableList<String> = ArrayList()
    override fun onDisable() {
        clearAll()
        super.onDisable()
    }

    @EventTarget
    fun onPacket(event: PacketEvent) {
        if (mc.thePlayer == null || mc.theWorld == null)
            return
        val packet = event.packet
        if (classProvider.isSPacketChat(packet)) {
            val chatMessage= packet.asSPacketChat()
            val matcher = Pattern.compile("杀死了 (.*?)\\(").matcher(chatMessage.getChat.getUnformattedText())
            val matcher2 = Pattern.compile("> (.*?)\\(").matcher(chatMessage.getChat.getUnformattedText())
            if (matcher.find()) {
                val name = matcher.group(1)
                if (name != "") {
                    if (!playerName.contains(name)) {
                        playerName.add(name)
                        Thread {
                            try {
                                Thread.sleep(6000)
                                playerName.remove(name)
                            } catch (ex: InterruptedException) {
                                ex.printStackTrace()
                            }
                        }.start()
                    }
                }
            }
            if (matcher2.find()) {
                val name = matcher2.group(1)
                if (name != "" && !name.contains("[")) {
                    if (!playerName.contains(name)) {
                        Thread {
                            try {
                                Thread.sleep(6000)
                                playerName.remove(name)
                            } catch (ex: InterruptedException) {
                                ex.printStackTrace()
                            }
                        }.start()
                    }
                }
            }
        }
    }
    @EventTarget
    fun onWorld(event: WorldEvent?) {
        clearAll()
    }

    private fun clearAll() {
        playerName.clear()
    }
    companion object {
        @JvmStatic
        fun isBot(entity: IEntityLivingBase): Boolean {
            if (!classProvider.isEntityPlayer(entity)) return false
            val antiBot = LiquidBounce.moduleManager.getModule(NoHurt::class.java) as NoHurt?
            if (antiBot == null || !antiBot.state) return false
            if (antiBot.playerName.contains(entity.name)) return true
            return entity.name!!.isEmpty() || entity.name == mc.thePlayer!!.name
        }
    }
}