package fluttersim.actions

class HelpAction : GameAction(listOf("help", "commands")) {
    override fun doAction(command: String, paramString: String): String {
        return "Type in actions to execute them. Many actions also take one or more parameters. For example: \"hug fluttershy\"\n\n" +
                "Some important actions are: <action>examine</action>, <action>where</action>, <action>take</action>, <action>inventory</action>, <action>drop</action>\n\n" +
                "Some items can be examined to discover more actions. Potential actions are marked in <action>green</action> and potential targets are marked in <target>blue</target>."
    }
}