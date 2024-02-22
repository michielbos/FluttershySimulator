package fluttersim.gameobjects

open class GameObject (
    val name: String,
    val description: String,
    val seeMessage: String? = null
) {
    open fun getDescription() = description
    open fun getSeeMessage() = seeMessage ?: "You see a ${name}."
}