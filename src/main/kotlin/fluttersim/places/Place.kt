package fluttersim.places

import fluttersim.gameobjects.GameObject
import fluttersim.gameobjects.ObjectTag
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
        // Check the aliases separately, since multiple objects could have the same alias.
        return gameObjects.firstOrNull { it.name.lowercase() == lowerName }
            ?: gameObjects.firstOrNull { it.aliases.contains(lowerName) }
    }

    open fun getWhereMessage() = (whereMessage ?: "You are in ${name}.") + " " + getSeeMessages()

    fun getSeeMessages() = gameObjects.filter { !it.tags.contains(ObjectTag.HideSeeMessage) }
        .joinToString(" ") { it.getSeeMessage() }

    fun getAllPonies() = gameObjects.filterIsInstance<Pony>()
}