package fluttersim.actions

import fluttersim.Game
import fluttersim.gameobjects.Fluttershy
import fluttersim.gameobjects.FluttershysBed
import fluttersim.gameobjects.FluttershysBedScrap
import fluttersim.gameobjects.Pony

class JumpAction : GameAction(listOf("jump")) {
    override fun doAction(command: String, paramString: String): String {
        if (paramString.isEmpty()) {
            return "$command on what?"
        }

        val split = paramString.split(" ", limit = 2)
        val targetString = if (split.size == 2 && (split[0] == "on")) {
            split[1]
        } else {
            paramString
        }

        val target = Game.currentPlace.getGameObjectByName(targetString)

        if (target == null) {
            return "You don't see any $targetString."
        }

        return if (target is FluttershysBed) {
            val hasFluttershy = Game.currentPlace.gameObjects.contains(Fluttershy)
            val response = when (target.jumpCounter) {
                0 -> "You playfully jump on ${target.getArticledName()}. The neatly tidied pillows and blanket are all over the bed now."
                1 -> "You playfully jump on ${target.getArticledName()}. The bed begins to crack a little."
                else -> "${target.getArticledName()} collapses with a loud crash!"
            }
            if (target.jumpCounter < 2) {
                target.jumpCounter++
                response + if (hasFluttershy) " " + Fluttershy.getFrownMessage() else ""
            } else {
                Game.currentPlace.remove(target)
                Game.currentPlace.add(FluttershysBedScrap())
                response + if (hasFluttershy) " ${Fluttershy.name} seems distressed." else  ""
            }
        } else if (target is FluttershysBedScrap) {
            if (Game.currentPlace.gameObjects.contains(Fluttershy)) {
                "${Fluttershy.name} glares at you."
            } else {
                "Isn't that enough damage for today?"
            }
        }  else if (target is Pony) {
            "That would hurt both of you."
        } else {
            "You don't trust your athletic abilities enough to make that work."
        }
    }

}