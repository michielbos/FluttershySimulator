package fluttersim.places

import fluttersim.gameobjects.Fluttershy
import fluttersim.gameobjects.Waffle

object FluttershyCottage : Place("Fluttershy's cottage") {
    init {
        add(Fluttershy)
        add(Waffle())
    }
}