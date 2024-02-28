package fluttersim.gameobjects

import fluttersim.Game

object Fluttershy : Pony("Fluttershy", "A beautiful shy pegasus.", Gender.Female, aliases = listOf("shy", "flutter", "flutters")) {
    override fun getDropMessage(): String {
        return "You gently put $name back on the ground."
    }
}

class Waffle : Item(
    name = "waffle",
    description = "A tasty looking waffle. You could <action>eat</action> it or <action>feed</action> it to somepony special.",
    pickUpMessage = "You take the waffle from the plate and put it in your inventory.",
    tags = listOf(ObjectTag.Food)
) {
    override fun getSeeMessage(): String {
        return if (isInOriginalPlace) {
            "There is a plate with a tasty looking <target>waffle</target> on the table."
        } else {
            "There is a plate with a tasty looking <target>waffle</target> on the ground."
        }
    }

    override fun getEatMessage(): String {
        return if (Game.currentPlace.gameObjects.contains(Fluttershy)) {
            super.getEatMessage() + " Fluttershy seems slightly disappointed."
        } else {
            super.getEatMessage() + " It is pretty tasty."
        }
    }
}

class FluttershysBed : GameObject(
    name = "bed",
    description = "Fluttershy's bed.",
    seeMessage = "Fluttershy's <target>bed</target> is in the bedroom upstairs.",
) {
    var jumpCounter = 0

    override fun getDescription(): String {
        return "$description " + if (jumpCounter == 0) "It looks cozy and tidy. A tired pony could <action>sleep</action> here."
        else "It is very messy, the pillows and blanket are all over the bed. You could <action>sleep</action> on it, but it would be more polite to <action>tidy</action> it up again."
    }
}

class FluttershysBedScrap : GameObject(
    name = "pile of scrap",
    description = "What's left of Fluttershy's bed. I hope you are proud of yourself.",
    seeMessage = "There is a <target>pile of scrap</target> in the corner of Fluttershy's bedroom.",
    pickUpMessage = "It's better to leave that alone for now.",
    aliases = listOf("pile", "scrap")
)