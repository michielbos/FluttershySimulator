package fluttersim.gameobjects

enum class Gender(val subjectPronoun: String, val objectPronoun: String, val possesive: String) {
    Object("it", "it", "its"),
    Female("she", "her", "her"),
    Male("he", "him", "his"),
    Plural("they", "them", "their");
}