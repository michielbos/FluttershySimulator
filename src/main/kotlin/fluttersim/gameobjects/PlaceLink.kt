package fluttersim.gameobjects

import fluttersim.places.Place

open class PlaceLink(
    name: String,
    description: String,
    val destination: Place,
    aliases: List<String> = listOf(),
    tags: List<ObjectTag> = listOf(),
    seeMessage: String? = null,
    val enterMessage: String? = null,
) : GameObject(name, description, Gender.Object, aliases, tags, seeMessage) {
    open fun getEnterMessage(): String = (enterMessage
        ?: destination.enterMessage
        ?: "You enter ${destination.name}.") + " " + destination.getSeeMessages()
}