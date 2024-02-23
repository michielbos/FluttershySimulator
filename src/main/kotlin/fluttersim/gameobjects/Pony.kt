package fluttersim.gameobjects

open class Pony(
    name: String,
    description: String,
    gender: Gender,
    tags: List<ObjectTag> = listOf(),
    seeMessage: String? = null,
    pickUpMessage: String? = null
) : GameObject(name, description, gender, tags, seeMessage, pickUpMessage) {
    override fun getPickUpMessage(): String = pickUpMessage ?: "$name doesn't want to be picked up."

    override fun getEatMessage(): String = "$name raises ${gender.possesive} eyebrows at you."
}