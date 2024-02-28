package fluttersim

import fluttersim.actions.*
import fluttersim.gameobjects.GameObject
import fluttersim.places.FluttershyCottage
import fluttersim.places.Place

object Game {
    var currentPlace: Place = FluttershyCottage
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
        HelpAction(),
        CleanAction(),
        SleepAction(),
        JumpAction(),
        EnterAction(),
        LeaveAction()
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

        return action.doAction(command, paramString).replaceFirstChar { it.titlecase() }
    }

    fun getItemFromWorldOrInventory(name: String): GameObject? {
        return currentPlace.getGameObjectByName(name)
            ?: inventory.getItemByName(name)
    }

    fun removeItemFromWorldOrInventory(gameObject: GameObject): Boolean {
        return currentPlace.remove(gameObject) || inventory.removeItem(gameObject)
    }
}