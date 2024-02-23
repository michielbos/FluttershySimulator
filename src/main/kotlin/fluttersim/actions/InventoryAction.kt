package fluttersim.actions

import fluttersim.Game

class InventoryAction : GameAction(listOf("inventory", "items")) {
    override fun doAction(command: String, paramString: String): String {
        val items = Game.inventory.items

        if (items.isEmpty()) {
            return "Your inventory is currently empty."
        } else {
            return "You are currently carrying: ${items.map { it.name }.joinToString(", ")}"
        }
    }
}