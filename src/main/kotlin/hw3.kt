fun main() {

    println(secondsToText(1))
    println(secondsToText(59))
    println(secondsToText(60*5))
    println(secondsToText(60*60*4))
    println(secondsToText(60*60*24))
    println(secondsToText(3600*24*20))
    println(secondsToText(3600*24*31))
    println(secondsToText(3600*24*31*5))
    println(secondsToText(3600*24*31*12))
    println(secondsToText(3600*24*31*12*2))
}

fun secondsToText(seconds: Int): String {

    var unit = 0
    var base: String

    when (seconds) {
        in 0..59 -> {
            base = "секунд"
            unit = seconds
        }
        in 60..3599 -> {
            base = "минут"
            unit = seconds / 60
        }
        in 3600..86399 -> {
            base = "час"
            unit = seconds / 3600
        }
        in 86400..172799 -> {
            base = "день"
            unit = 1
        }
        in 172_800..2_678_399 -> base = "несколько дней"
        in 2_678_400..5_270_399 -> base = "месяц"
        in 5_270_400..31_535_999 -> base = "несколько месяцев"
        in 31_536_000..63_071_999 -> base = "год"
        else -> base = "несколько лет"
    }

    // остаток от деления количества секунд на 10
    val remainder = unit % 10

    if (seconds < 3600) {
        // для секунд и минут
        base = when {
            unit in 5..20 -> base
            remainder == 1 -> base + "у"
            remainder in 2..4 -> base + "ы"
            else -> base
        }
    } else if (seconds in 3600..86399) {
        // для часов
        base = when {
            unit in 5..20 -> base + "ов"
            remainder == 1 -> base
            remainder in 2..4 -> base + "а"
            else -> base
        }
    }

    return if (unit != 0) {
        "Был $unit $base назад"
    } else "Был $base назад"
}
