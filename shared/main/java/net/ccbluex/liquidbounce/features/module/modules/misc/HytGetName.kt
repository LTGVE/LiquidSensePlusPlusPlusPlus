package net.ccbluex.liquidbounce.features.module.modules.misc

import net.ccbluex.liquidbounce.LiquidBounce
import net.ccbluex.liquidbounce.event.EventTarget
import net.ccbluex.liquidbounce.event.PacketEvent
import net.ccbluex.liquidbounce.event.WorldEvent
import net.ccbluex.liquidbounce.features.module.Module
import net.ccbluex.liquidbounce.features.module.ModuleCategory
import net.ccbluex.liquidbounce.features.module.ModuleInfo
import net.ccbluex.liquidbounce.utils.ClientUtils
import net.ccbluex.liquidbounce.value.ListValue
import java.util.regex.Pattern

@ModuleInfo(name = "HytGetName", description = "Edit By LT_GVE", category =ModuleCategory.MISC)
class HytGetName : Module() {

    private val mode = ListValue("GetNameMode", arrayOf("4V4/1V1", "32/64", "16V16","KitPvP"), "4V4/1V1")

    override fun onDisable() {
        clearAll()
        super.onDisable()
    }

    @EventTarget
    fun onPacket(event: PacketEvent) {
        val packet = event.packet
        if (classProvider.isSPacketChat(packet)) {
            when (mode.get().toLowerCase()) {
                "4v4/1v1", "32/64" -> {
                    val matcher = Pattern.compile("杀死了 (.*?)\\(").matcher(packet.asSPacketChat().chatComponent.unformattedText)
                    val matcher2 = Pattern.compile("起床战争>> (.*?) (\\((((.*?)死了!)))").matcher(packet.asSPacketChat().chatComponent.unformattedText)
                    if (matcher.find()) {
                        val name = matcher.group(1).trim()
                        if (name != "") {
                            LiquidBounce.fileManager.friendsConfig.addFriend(name)
                            ClientUtils.displayChatMessage("§f[§eLiquidSense++++§f] Add Bot : " + name)
                            Thread {
                                try {
                                    Thread.sleep(5000)
                                    LiquidBounce.fileManager.friendsConfig.removeFriend(name)
                                    ClientUtils.displayChatMessage("§f[§eLiquidSense++++§f] Remove Bot : " + name)
                                } catch (ex: InterruptedException) {
                                    ex.printStackTrace()
                                }
                            }.start()
                        }
                    }
                    if (matcher2.find()) {
                        val name = matcher2.group(1).trim()
                        if (name != "") {
                            LiquidBounce.fileManager.friendsConfig.addFriend(name)
                            ClientUtils.displayChatMessage("§eLiquidSense++++§f] Add Bot : " + name)
                            Thread {
                                try {
                                    Thread.sleep(5000)
                                    LiquidBounce.fileManager.friendsConfig.removeFriend(name)
                                    ClientUtils.displayChatMessage("§f[§eLiquidSense++++§f] Remove Bot : " + name)
                                } catch (ex: InterruptedException) {
                                    ex.printStackTrace()
                                }
                            }.start()
                        }
                    }
                }
                "16v16" ->{
                    val matcher = Pattern.compile("击败了 (.*?)!").matcher(packet.asSPacketChat().chatComponent.unformattedText)
                    val matcher2 = Pattern.compile("玩家 (.*?)死了！").matcher(packet.asSPacketChat().chatComponent.unformattedText)
                    if (matcher.find()) {
                        val name = matcher.group(1).trim()
                        if (name != "") {
                            LiquidBounce.fileManager.friendsConfig.addFriend(name)
                            ClientUtils.displayChatMessage("§f[§eLiquidSense++++§f] Add Bot : " + name)
                            Thread {
                                try {
                                    Thread.sleep(10000)
                                    LiquidBounce.fileManager.friendsConfig.removeFriend(name)
                                    ClientUtils.displayChatMessage("§f[§eLiquidSense++++§f] Remove Bot : " + name)
                                } catch (ex: InterruptedException) {
                                    ex.printStackTrace()
                                }
                            }.start()
                        }
                    }
                    if (matcher2.find()) {
                        val name = matcher2.group(1).trim()
                        if (name != "") {
                            LiquidBounce.fileManager.friendsConfig.addFriend(name)
                            ClientUtils.displayChatMessage("§f[§eLiquidSense++++§f] Add Bot : " + name)
                            Thread {
                                try {
                                    Thread.sleep(10000)
                                    LiquidBounce.fileManager.friendsConfig.removeFriend(name)
                                    ClientUtils.displayChatMessage("&f[§eLiquidSense++++&f] Remove Bot : " + name)
                                } catch (ex: InterruptedException) {
                                    ex.printStackTrace()
                                }
                            }.start()
                        }
                    }
                }
                "KitPvP" -> {
                    ClientUtils.displayChatMessage("§f[§eLiquidSense++++§f]Anti HYT Bot Enable!")
                    var local =
                        Pattern.compile("击杀了(.*?)\\(!").matcher(packet.asSPacketChat().chatComponent.unformattedText)

                    var local2 =
                        Pattern.compile("(.*?)\\(被").matcher(packet.asSPacketChat().chatComponent.unformattedText)

                    if (local.find()) {
                        val name = local.group(1).trim()
                        if (name != "") {
                            LiquidBounce.fileManager.friendsConfig.addFriend(name)
                            ClientUtils.displayChatMessage("§f[§eLiquidSense++++§f] Add Bot : " + name)
                            Thread {
                                try {
                                    Thread.sleep(5000)
                                    LiquidBounce.fileManager.friendsConfig.removeFriend(name)
                                    ClientUtils.displayChatMessage("§f[§eLiquidSense++++§f] Remove Bot : " + name)
                                } catch (e: InterruptedException) {
                                    e.printStackTrace()
                                }
                            }.start()
                        }
                    }
                    if (local2.find()) {
                        val name = local2.group(1).trim()
                        if (name != "") {
                            LiquidBounce.fileManager.friendsConfig.addFriend(name)
                            ClientUtils.displayChatMessage("§f[§eLiquidSense++++§f] Add Bot : " + name)
                            Thread {
                                try {
                                    Thread.sleep(5000)
                                    LiquidBounce.fileManager.friendsConfig.removeFriend(name)
                                    ClientUtils.displayChatMessage("§f[§eLiquidSense++++§f] Remove Bot : " + name)
                                } catch (e: InterruptedException) {
                                    e.printStackTrace()
                                }
                            }.start()
                        }
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
        LiquidBounce.fileManager.friendsConfig.clearFriends()
    }
}