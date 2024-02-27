package fluttersim.actions

import fluttersim.Game
import fluttersim.gameobjects.FluttershysBed
import fluttersim.gameobjects.FluttershysBedScrap
import fluttersim.gameobjects.Pony

class SleepAction : GameAction(listOf("sleep", "rest")) {
    override fun doAction(command: String, paramString: String): String {
        if (paramString.isEmpty()) {
            return "$command where?"
        }

        val split = paramString.split(" ", limit = 2)
        val targetString = if (split.size == 2 && (split[0] == "on" || split[0] == "in")) {
            split[1]
        } else {
            paramString
        }

        val target = Game.currentPlace.getGameObjectByName(targetString)

        if (target == null) {
            return "You don't see any $targetString."
        }

        return if (target is FluttershysBed) {
            "You get in ${target.getArticledName()} and quickly fall asleep.\n\nYou wake up some time later."
        } else if (target is FluttershysBedScrap) {
            "You didn't think this through, did you?"
        } else if (target is Pony) {
            "The ${target.name} looks comfortable, but also somewhat judging."
        } else {
            "${target.getArticledName()} doesn't look comfortable enough to sleep on."
        }
    }

}