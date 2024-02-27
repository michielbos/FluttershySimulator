package fluttersim.gameobjects

open class GameObject (
    val name: String,
    val description: String,
    val gender: Gender = Gender.Object,
    val aliases: List<String> = listOf(),
    val tags: List<ObjectTag> = listOf(),
    val seeMessage: String? = null,
    val pickUpMessage: String? = null
) {
    open fun getDescription() = description

    open fun getArticledName() = "the $name"

    open fun getSeeMessage() = seeMessage ?: "You see a <target>${name}</target>."

    open fun getPickUpMessage(): String = pickUpMessage ?: if (canPickUp())
        "You pick up the $name and put ${gender.objectPronoun} in your inventory."
    else
        "You can't pick up ${getArticledName()}."

    open fun getEatMessage(): String = if (isEdible()) "You eat the ${name}." else "You can't eat the ${name}."

    open fun isEdible() = tags.contains(ObjectTag.Food)

    open fun getDropMessage(): String = "You drop the ${name}."

    open fun isDroppable(): Boolean = true

    open fun canPickUp() = tags.contains(ObjectTag.CanPickUp)
}