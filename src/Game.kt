fun main() {
    val name = "Martines"
    val healthPoints = 89
    val isBlessed = true
    val isImmortal = false

// Аура
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)


    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

// Состояние игрока
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    castFireball()
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println(
        "(Aura: $auraColor) " +
                "(Blessed: ${if (isBlessed) "Yes" else "No"})"
    )
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String =
    when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }


private fun castFireball (numFireballs: Int = 2)=
    println("A glass of Fireball springs into existence. (x$numFireballs)")