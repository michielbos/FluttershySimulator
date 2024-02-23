package fluttersim.actions

import fluttersim.Game

class EatAction : GameAction(listOf("eat")) {
    override fun doAction(command: String, paramString: String): String {
        if (paramString.isEmpty()) {
            return "Eat what?"
        }

        val target = Game.getItemFromWorldOrInventory(paramString)

        if (target == null) {
            return "You don't have any $paramString."
        }

        if (target.isEdible()) {
            Game.removeItemFromWorldOrInventory(target)
            return target.getEatMessage()
        } else {
            return target.getEatMessage()
        }
    }

}