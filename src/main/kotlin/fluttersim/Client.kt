package fluttersim

import kotlinx.html.dom.append
import org.w3c.dom.Node
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.html.js.div
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.KeyboardEvent

fun main() {
    window.onload = {
        Client()
    }
}

class Client {
    val gameLog: Node = document.getElementById("gameLog")!!
    val gameInput: HTMLInputElement = document.getElementById("gameInput") as HTMLInputElement
    val game = Game

    init {
        addGameMessage(game.start())
        gameInput.onkeypress = this::onEnter
    }

    fun onEnter(event: KeyboardEvent) {
        if (event.key == "Enter") {
            val input = gameInput.value.trim()
            if (input.isNotBlank()) {
                addInputMessage(input)
                val response = game.doInput(input)
                addGameMessage(response)
            }
            gameInput.value = ""
        }
    }

    fun addInputMessage(message: String) {
        gameLog.append {
            div("inputMessage") {
                +"> "
                +message
            }
        }
    }

    fun addGameMessage(message: String) {
        gameLog.append {
            div("gameMessage") {
                +message
            }
        }
    }
}