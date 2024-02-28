package fluttersim.places

import fluttersim.gameobjects.*

object FluttershyCottage : Place("Fluttershy's cottage") {
    init {
        add(Fluttershy)
        add(Waffle())
        add(FluttershysBed())
        add(
            PlaceLink(
                "outside",
                "No longer inside.",
                FluttershyGarden,
                seeMessage = "You can <action>leave</action> and go <target>outside</target> when you are done here.",
            )
        )
    }
}

object FluttershyGarden : Place("Fluttershy's garden") {
    init {
        add(
            PlaceLink(
                "Fluttershy's cottage",
                "A gentle shy pegasus lives here.",
                FluttershyCottage,
                aliases = listOf("fluttershys cottage", "cottage", "inside"),
                seeMessage = "You can go <target>inside</target> the <target>cottage</target> to see what Fluttershy is up to."
            )
        )
        add(PlaceLink("Ponyville", "Ponies live here.", EastPonyville, seeMessage = "You can follow the road to visit <target>Ponyville</target>."))
    }
}