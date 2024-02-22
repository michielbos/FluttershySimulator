class Game {
    fun doInput(input: String): String {
        val split = input.split(' ', limit = 2)
        if (split.size == 1) {
            return "${split[0]} what?"
        } else {
            return "You ${split[0]} the ${split[1]}."
        }
    }
}