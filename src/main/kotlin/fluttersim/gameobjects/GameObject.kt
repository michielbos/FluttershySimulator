package fluttersim.gameobjects

open class GameObject (
    val name: String,
    val description: String,
    val gender: Gender = Gender.Object,
    val tags: List<ObjectTag> = listOf(),
    val seeMessage: String? = null,
    val pickUpMessage: String? = null
) {
    open fun getDescription() = description

    open fun getArticledName() = "the $name"

    open fun getSeeMessage() = seeMessage ?: "You see a <target>${name}</target>."

    open fun getPickUpMessage(): String = pickUpMessage ?: "You can't pick up the ${name}."

    open fun getEatMessage(): String = if (isEdible()) "You eat the ${name}." else "You can't eat the ${name}."

    open fun isEdible() = tags.contains(ObjectTag.Food)

    open fun getDropMessage(): String = "You drop the ${name}."

    open fun isDroppable(): Boolean = true
}