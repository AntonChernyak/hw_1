fun main() {
    print(
        calculateFee(200.0, 10500.0) + "\n" +
                calculateFee(200.0, 10500.0, true) + "\n" +
                calculateFee(100_000.5, 10_000_000.7, true) + "\n" +
                calculateFee(33.5, 100.0) + "\n" +
                calculateFee(-20.0, 1000.45)
    )
}

fun calculateFee(amount: Double, total: Double, exclusive: Boolean = false): String {
    // Проверяем входные данные
    if (amount < 0 || total < 0){
        return "Ошибка ввода данных. Значения не должны быть отрицательными"
    }
    // Устанавливаем начальное значение скидки в зависимости от категории покупателя
    var discount = 0
    if (exclusive) discount = 5

    // Считаем скидку в зависимости от общей суммы покупок
    discount = when (total) {
        in 0..1000 -> 30 - discount
        in 1001..10000 -> 25 - discount
        in 10001..50000 -> 20 - discount
        else -> 15 - discount
    }

    // Возвращаем рассчитанное значение комиссии
    return "${amount * discount * 0.01} rub"
}