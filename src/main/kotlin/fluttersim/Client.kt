package fluttersim

import kotlinx.html.dom.append
import org.w3c.dom.Node
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.html.js.div
import org.w3c.dom.Element
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.KeyboardEvent

fun main() {
    window.onload = {
        document.getElementById("subtitle")?.textContent = "Day 6: \uD83D\uDECF\uFE0F Fluttershy's bed "
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

                // Ensure we stay at the bottom.
                (gameLog.lastChild as? Element)?.scrollIntoView()
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
            val element = div("gameMessage")
            element.innerHTML = message.replace("\n", "<br>")
        }
    }
}