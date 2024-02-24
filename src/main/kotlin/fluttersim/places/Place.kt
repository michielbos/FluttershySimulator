package fluttersim.places

import fluttersim.gameobjects.GameObject
import fluttersim.gameobjects.Pony

open class Place(
    val name: String,
    val whereMessage: String? = null,
    val enterMessage: String? = null,
) {
    val gameObjects: MutableList<GameObject> = mutableListOf()

    fun add(gameObject: GameObject) {
        gameObjects.add(gameObject)
    }

    fun remove(gameObject: GameObject): Boolean {
        return gameObjects.remove(gameObject)
    }

    fun getGameObjectByName(name: String): GameObject? {
        val lowerName = name.lowercase()
        return gameObjects.firstOrNull { it.name.lowercase() == lowerName }
    }

    open fun getWhereMessage() = (whereMessage ?: "You are in ${name}.") + " " + getSeeMessages()

    open fun getEnterMessage() = (enterMessage ?: "You enter ${name}.") + " " + getSeeMessages()

    fun getSeeMessages() = gameObjects.joinToString(" ") { it.getSeeMessage() }

    fun getAllPonies() = gameObjects.filterIsInstance<Pony>()
}