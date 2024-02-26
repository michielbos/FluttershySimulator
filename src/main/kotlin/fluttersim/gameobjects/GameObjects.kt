package fluttersim.gameobjects

import fluttersim.Game

object Fluttershy : Pony("Fluttershy", "A beautiful shy pegasus.", Gender.Female) {
    override fun getDropMessage(): String {
        return "You gently put $name back on the ground."
    }
}

class Waffle : Item(
    name = "waffle",
    description = "A tasty looking waffle. You could <action>eat</action> it or <action>feed</action> it to somepony special.",
    seeMessage = "There is a plate with a tasty looking <target>waffle</target> on the table.",
    pickUpMessage = "You take the waffle from the plate and put it in your inventory.",
    tags = listOf(ObjectTag.Food)
) {
    override fun getEatMessage(): String {
        return if (Game.currentPlace.gameObjects.contains(Fluttershy)) {
            super.getEatMessage() + " Fluttershy seems slightly disappointed."
        } else {
            super.getEatMessage() + " It is pretty tasty."
        }
    }
}