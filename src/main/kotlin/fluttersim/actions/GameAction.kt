package fluttersim.actions

abstract class GameAction(
    val commandNames: List<String>,
) {
    abstract fun doAction(command: String, paramString: String) : String
}