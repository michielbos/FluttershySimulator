package fluttersim.actions

import fluttersim.Game

class LeaveAction : GameAction(listOf("leave")) {
    override fun doAction(command: String, paramString: String): String {
        val leaveTarget = Game.currentPlace.leaveTarget
        return if (leaveTarget == null) {
            "You are already outside."
        } else {
            Game.currentPlace = leaveTarget.destination
            leaveTarget.getEnterMessage()
        }
    }
}