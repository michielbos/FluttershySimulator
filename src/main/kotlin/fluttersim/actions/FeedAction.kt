package fluttersim.actions

import fluttersim.Game
import fluttersim.gameobjects.Fluttershy
import fluttersim.gameobjects.GameObject
import fluttersim.gameobjects.Pony

class FeedAction : GameAction(listOf("feed")) {
    override fun doAction(command: String, paramString: String): String {
        if (paramString.isEmpty()) {
            return "Feed what?"
        }

        val target: GameObject?
        val feedable: GameObject?
        val split = paramString.split(" ", limit = 3)

        if (split.size > 1 && split[1] == "to") {
            feedable = Game.getItemFromWorldOrInventory(split[0])
            if (feedable == null) {
                return "You don't have any ${split[0]}"
            }
            if (split.size == 2) {
                return "Feed ${feedable.name} to what?"
            }
            target = Game.getItemFromWorldOrInventory(split[2])
            if (target == null) {
                return "You don't see any ${split[2]}."
            }
        } else {
            target = Game.getItemFromWorldOrInventory(split[0])
            if (target == null) {
                return "You don't see any ${split[0]}"
            }
            if (split.size == 1) {
                return "Feed ${target.name} what?"
            }
            feedable = Game.getItemFromWorldOrInventory(split[1])
            if (feedable == null) {
                return "You don't have any ${split[1]}."
            }
        }

        if (target == feedable) {
            return "The ${target.name} can't eat ${target.gender.objectPronoun}self."
        }
        if (target !is Pony) {
            return "${target.name} doesn't need to be fed."
        }

        if (feedable.isEdible()) {
            Game.removeItemFromWorldOrInventory(feedable)
            if (target == Fluttershy) {
                return "You feed the ${feedable.name} to ${target.name}. She munches on it happily."
            } else {
                return "You feed the ${feedable.name} to ${target.name}."
            }
        } else {
            return "${target.name} won't eat that."
        }
    }
}