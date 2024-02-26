package fluttersim.gameobjects

open class Item(
    name: String,
    description: String,
    gender: Gender = Gender.Object,
    tags: List<ObjectTag> = listOf(),
    seeMessage: String? = null,
    pickUpMessage: String? = null

) : GameObject(name, description, gender, (tags + listOf(ObjectTag.CanPickUp)).distinct(), seeMessage, pickUpMessage) {
}