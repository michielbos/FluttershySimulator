package fluttersim

import fluttersim.actions.*
import fluttersim.gameobjects.GameObject
import fluttersim.places.FluttershyCottage

object Game {
    val currentPlace = FluttershyCottage
    val inventory = Inventory()

    val actions = listOf(
        WhereAction(),
        ExamineAction(),
        TakeAction(),
        InventoryAction(),
        EatAction(),
        FeedAction(),
        DropAction(),
        HugAction(),
        KissAction(),
        HelpAction()
    )

    fun start() : String {
        return currentPlace.getWhereMessage()
    }

    fun doInput(input: String): String {
        val split = input.lowercase().split(' ', limit = 2)
        val command = split[0]
        val paramString = if (split.size > 1) split[1] else ""

        val action = actions.firstOrNull {
            it.commandNames.contains(command)
        }

        if (action == null) {
            return "You don't know how to ${command}."
        }

        return action.doAction(command, paramString)
    }

    fun getItemFromWorldOrInventory(name: String): GameObject? {
        return currentPlace.getGameObjectByName(name)
            ?: inventory.getItemByName(name)
    }

    fun removeItemFromWorldOrInventory(gameObject: GameObject): Boolean {
        return currentPlace.remove(gameObject) || inventory.removeItem(gameObject)
    }
}