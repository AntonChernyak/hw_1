fun main() {

    //val index = bodyMassIndex(1.82, 120.5)
    //val index = bodyMassIndex(1.82, 50.5)
    val index = bodyMassIndex(1.7, 71.0)

    val verdict = when (index) {
        in 0..16 -> "Налегай на пончики"
        in 16.0..18.0 -> "Кризис сказывается"
        in 18.5..25.0 -> "Это норма!"
        in 25.0..30.0 -> "Шевелись, Плотва"
        in 30.0..35.0 -> "Зам депутата"
        in 35.0..40.0 -> "Депутат"
        else -> "В космосе у Вас была бы своя орбита"
    }

    println("ИМТ - %.2f, вердикт - $verdict".format(index))
}

fun bodyMassIndex(height: Double, weight: Double): Double {
    return weight / (height * height)
}