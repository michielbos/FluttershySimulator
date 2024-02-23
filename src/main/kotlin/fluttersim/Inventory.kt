package fluttersim

import fluttersim.gameobjects.GameObject
import fluttersim.gameobjects.Item

class Inventory {
    val items = mutableListOf<GameObject>()

    fun addItem(item: Item) {
        items.add(item)
    }

    fun removeItem(item: GameObject): Boolean {
        return items.remove(item)
    }

    fun getItemByName(name: String): GameObject? {
        val lowerName = name.lowercase()
        return items.firstOrNull { it.name.lowercase() == lowerName }
    }
}