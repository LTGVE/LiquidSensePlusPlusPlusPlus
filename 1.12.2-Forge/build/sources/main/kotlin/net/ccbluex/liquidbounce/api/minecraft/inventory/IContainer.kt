/*
 * LiquidBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/CCBlueX/LiquidBounce/
 */

package net.ccbluex.liquidbounce.api.minecraft.inventory

import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack

interface IContainer {
    val windowId: Int

    fun getSlot(id: Int): ISlot

}
