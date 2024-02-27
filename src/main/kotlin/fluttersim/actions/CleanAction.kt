package fluttersim.actions

import fluttersim.Game
import fluttersim.gameobjects.FluttershysBed
import fluttersim.gameobjects.FluttershysBedScrap

class CleanAction : GameAction(listOf("clean", "tidy", "make", "fix")) {
    override fun doAction(command: String, paramString: String): String {
        if (paramString.isEmpty()) {
            return "$command what?"
        }

        val split = paramString.split(" ", limit = 2)
        val targetString = if (split.size == 2 && split[0] == "up") {
            split[1]
        } else {
            paramString
        }

        val target = Game.currentPlace.getGameObjectByName(targetString)

        if (target == null) {
            return "You don't see any $targetString."
        }

        return if (target is FluttershysBed && target.jumpCounter > 0) {
            target.jumpCounter = 0
            "You fix the pillows and straighten the blanket again."
        } else if (target is FluttershysBedScrap) {
            "It's a little bit too late for that."
        } else {
            if (command == "clean") {
                "${target.getArticledName()} doesn't need cleaning."
            } else {
                "${target.getArticledName()} is tidy enough."
            }
        }
    }

}