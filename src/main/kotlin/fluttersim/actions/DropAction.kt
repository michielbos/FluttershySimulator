package fluttersim.actions

import fluttersim.Game

class DropAction : GameAction(listOf("drop", "discard")) {
    override fun doAction(command: String, paramString: String): String {
        if (paramString.isEmpty()) {
            return "Drop what?"
        }

        val target = Game.inventory.getItemByName(paramString)

        if (target == null) {
            return "You don't have any ${paramString}."
        }

        if (target.isDroppable()) {
            Game.inventory.removeItem(target)
            Game.currentPlace.add(target)
            return target.getDropMessage()
        } else {
            return target.getDropMessage()
        }
    }
}