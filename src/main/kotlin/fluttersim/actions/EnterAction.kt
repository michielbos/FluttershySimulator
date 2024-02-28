package fluttersim.actions

import fluttersim.Game
import fluttersim.gameobjects.PlaceLink

class EnterAction : GameAction(listOf("enter", "goto", "go")) {
    override fun doAction(command: String, paramString: String): String {
        if (paramString.isEmpty()) {
            return "$command where?"
        }

        val split = paramString.split(" ", limit = 2)
        val targetString = if (split.size == 2 && (split[0] == "to" || split[0] == "into" || split[0] == "inside" || split[0] == "in")) {
            split[1]
        } else {
            paramString
        }

        val target = Game.currentPlace.getGameObjectByName(targetString)

        if (target == null) {
            return "You don't see any ${paramString}."
        }
        if (target !is PlaceLink) {
            return "You can't enter ${target.getArticledName()}."
        }

        Game.currentPlace = target.destination

        return target.getEnterMessage()
    }
}