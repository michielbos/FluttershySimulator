package fluttersim

import fluttersim.actions.ExamineAction
import fluttersim.actions.WhereAction
import fluttersim.places.FluttershyCottage

object Game {
    val currentPlace = FluttershyCottage

    val actions = listOf(
        WhereAction(),
        ExamineAction()
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
}