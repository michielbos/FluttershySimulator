package fluttersim.actions

import fluttersim.Game
import fluttersim.gameobjects.Pony

class KissAction : GameAction(listOf("kiss")) {
    override fun doAction(command: String, paramString: String): String {
        if (paramString.isEmpty()) {
            return "Kiss what?"
        }

        val target = Game.getItemFromWorldOrInventory(paramString)

        if (target == null) {
            return "You don't see any ${paramString}."
        }

        if (target is Pony) {
            return "You $command ${target.name}. ${target.getBlushMessage()}"
        }

        val randomPony = Game.currentPlace.getAllPonies().randomOrNull()
        return if (randomPony == null) {
            "You kiss ${target.getArticledName()}."
        } else {
            "You kiss ${target.getArticledName()}. ${randomPony.getFrownMessage()}"
        }
    }
}