package fluttersim.actions

import fluttersim.Game
import fluttersim.gameobjects.Pony

class HugAction : GameAction(listOf("hug", "embrace", "cuddle")) {
    override fun doAction(command: String, paramString: String): String {
        if (paramString.isEmpty()) {
            val randomPony = Game.currentPlace.getAllPonies().randomOrNull()
            return if (randomPony == null) {
                "You embrace yourself."
            } else {
                "You embrace yourself. ${randomPony.getFrownMessage()}"
            }
        }

        val target = Game.getItemFromWorldOrInventory(paramString)

        if (target == null) {
            return "You don't see any ${paramString}."
        }

        if (target is Pony) {
            return "You $command ${target.name}. ${target.getLikesSlightlyMessage()}"
        }

        val randomPony = Game.currentPlace.getAllPonies().randomOrNull()
        return if (randomPony == null) {
            "You press ${target.getArticledName()} against your chest."
        } else {
            "You press ${target.getArticledName()} against your chest. ${randomPony.getFrownMessage()}"
        }
    }
}