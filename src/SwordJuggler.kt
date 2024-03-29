import java.lang.Exception
import java.lang.IllegalStateException

fun main() {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() ==3
    if (isJugglingProficient){
        swordsJuggling = 2
    }

    try {
        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)
   } catch(e: Exception) {
        println(e)
    }

    println("You juggling $swordsJuggling swords!")
}

fun proficiencyCheck(swordJuggling: Int?){
//    swordJuggling ?: throw IllegalStateException("Player cannot juggle swords")
//    swordJuggling ?: throw UnskilledSwordJugglerException()
    checkNotNull(swordJuggling,{"Player cannot juggle swords"})
}

class UnskilledSwordJugglerException :
        IllegalStateException("Player cannot juggle swords")
