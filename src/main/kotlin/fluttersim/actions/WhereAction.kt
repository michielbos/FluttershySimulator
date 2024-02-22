package fluttersim.actions

import fluttersim.Game

class WhereAction : GameAction(listOf("where")) {
    override fun doAction(command: String, paramString: String): String {
        return Game.currentPlace.getWhereMessage()
    }
}