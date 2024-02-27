package fluttersim

import fluttersim.gameobjects.GameObject

class Inventory {
    val items = mutableListOf<GameObject>()

    fun addItem(item: GameObject) {
        items.add(item)
    }

    fun removeItem(item: GameObject): Boolean {
        return items.remove(item)
    }

    fun getItemByName(name: String): GameObject? {
        val lowerName = name.lowercase()
        // Check the aliases separately, since multiple objects could have the same alias.
        return items.firstOrNull { it.name.lowercase() == lowerName }
            ?: items.firstOrNull { it.aliases.contains(lowerName) }
    }
}