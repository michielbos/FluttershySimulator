package fluttersim.gameobjects

open class Item(
    name: String,
    description: String,
    gender: Gender = Gender.Object,
    tags: List<ObjectTag> = listOf(),
    seeMessage: String? = null,
    pickUpMessage: String? = null

) : GameObject(name, description, gender, tags, seeMessage, pickUpMessage) {
    override fun getPickUpMessage(): String = pickUpMessage ?: "You pick up the $name and put ${gender.objectPronoun} in your inventory."
}