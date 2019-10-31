import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"
var playerGold = 10
var playerSilver = 10


fun main(args: Array<String>) {
    placeOrder("shandy,Dragon's Breath,5.91")
//    placeOrder("elexir,Shirley's Tample,4.12")

}

fun perfomPurchase(price: Double){
    displayBalance()
    val totalPurse = playerGold + (playerSilver/100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price.")

    val remaningBalans = totalPurse - price
    println("Remaining balance: ${"%.2f".format(remaningBalans)}")

    val remainingGold = remaningBalans.toInt()
    val remainingSilver = (remaningBalans % 1*100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()

}

private fun displayBalance(){
    println("Player purse balance: Gold: $playerGold Silver: $playerSilver")
}

//  Основная функция
private fun placeOrder(menuData: String){
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')  // Получение индекса апострофа
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe) // Получение имени из названия(до апострофа)
    println("Madrigal speaks with $tavernMaster about their order." ) // Вывод обращения к хозяину таверны

    val (type,name,price) = menuData.split(',') // Назнчаения переменных из списка меню, через разделитель
    val message = "Madrigal buys a $name($type) for $price"
    println(message)

    perfomPurchase(price.toDouble())


    val phrase = if (name == "Dragon's Breath"){
        "Madrigal exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "Madrigal says: Thanks for the $name."
    }

    println(phrase)

}

// Функция первода на дракний язык
private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")){
        when(it.value){
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }

    }