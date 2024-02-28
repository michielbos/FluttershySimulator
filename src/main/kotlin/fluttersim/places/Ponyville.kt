package fluttersim.places

import fluttersim.gameobjects.MessageOnly
import fluttersim.gameobjects.ObjectTag
import fluttersim.gameobjects.PlaceLink

object EastPonyville : Place("East Ponyville") {
    init {
        add(
            PlaceLink(
                "Ponyville Square",
                "The center of Ponyville.",
                PonyvilleSquare,
                listOf("center", "square", "ponyville"),
                seeMessage = "The shops are currently closed, but you can check out <target>Ponyville square</target> for more life."
            )
        )
        add(
            PlaceLink(
                "Fluttershy's cottage",
                "A gentle shy pegasus lives here.",
                FluttershyGarden,
                aliases = listOf("fluttershys cottage", "cottage"),
                seeMessage = "You can follow the road out of town to go back to <target>Fluttershy's cottage</target>."
            )
        )
    }
}

object WestPonyville : Place("West Ponyville") {
    init {
        add(
            PlaceLink(
                "Ponyville Square",
                "The center of Ponyville.",
                PonyvilleSquare,
                listOf("center", "square", "ponyville"),
                seeMessage = "The shops are currently closed, but you can check out <target>Ponyville square</target> for more life."
            )
        )
    }
}

object NorthPonyville : Place("North Ponyville") {
    init {
        add(
            PlaceLink(
                "Ponyville Square",
                "The center of Ponyville.",
                PonyvilleSquare,
                listOf("center", "square", "ponyville"),
                seeMessage = "The shops are currently closed, but you can check out <target>Ponyville square</target> for more life."
            )
        )
    }
}

object SouthPonyville : Place("South Ponyville") {
    init {
        add(
            PlaceLink(
                "Ponyville Square",
                "The center of Ponyville.",
                PonyvilleSquare,
                listOf("center", "square", "ponyville"),
                seeMessage = "The shops are currently closed, but you can check out <target>Ponyville square</target> for more life."
            )
        )
    }
}

object PonyvilleSquare : Place("Ponyville Square", enterMessage = "You enter Ponyville Square. It appears to be quiet here.") {
    init {
        add(MessageOnly("You can go <target>north</target>, <target>west</target>, <target>south</target> or <target>east</target> to explore the rest of Ponyville."))
        add(
            PlaceLink(
                "north ponyville",
                "The north side of Ponyville.",
                NorthPonyville,
                aliases = listOf("north"),
                enterMessage = "You proceed north.",
                tags = listOf(ObjectTag.HideSeeMessage)
            )
        )
        add(
            PlaceLink(
                "west ponyville",
                "The west side of Ponyville.",
                WestPonyville,
                aliases = listOf("west"),
                enterMessage = "You proceed west.",
                tags = listOf(ObjectTag.HideSeeMessage)
            )
        )
        add(
            PlaceLink(
                "south ponyville",
                "The south side of Ponyville.",
                SouthPonyville,
                aliases = listOf("south"),
                enterMessage = "You proceed south.",
                tags = listOf(ObjectTag.HideSeeMessage)
            )
        )
        add(
            PlaceLink(
                "east ponyville",
                "The east side of Ponyville.",
                EastPonyville,
                aliases = listOf("east"),
                enterMessage = "You proceed east.",
                tags = listOf(ObjectTag.HideSeeMessage)
            )
        )
    }
}