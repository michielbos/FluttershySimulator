package fluttersim.gameobjects

open class Item(
    name: String,
    description: String,
    gender: Gender = Gender.Object,
    aliases: List<String> = listOf(),
    tags: List<ObjectTag> = listOf(),
    seeMessage: String? = null,
    pickUpMessage: String? = null

) : GameObject(name, description, gender, aliases, (tags + listOf(ObjectTag.CanPickUp)).distinct(), seeMessage, pickUpMessage) {
}