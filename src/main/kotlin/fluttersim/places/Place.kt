package fluttersim.places

import fluttersim.gameobjects.GameObject

open class Place(
    val name: String,
    val whereMessage: String? = null,
    val enterMessage: String? = null,
) {
    val gameObjects: MutableList<GameObject> = mutableListOf()

    fun add(gameObject: GameObject) {
        gameObjects.add(gameObject)
    }

    open fun getWhereMessage() = (whereMessage ?: "You are in ${name}.") + " " + getSeeMessages()

    open fun getEnterMessage() = (enterMessage ?: "You enter ${name}.") + " " + getSeeMessages()

    fun getSeeMessages() = gameObjects.joinToString(", ") { it.getSeeMessage() }
}