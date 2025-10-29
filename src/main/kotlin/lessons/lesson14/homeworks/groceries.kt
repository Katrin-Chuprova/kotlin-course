package org.example.lessons.lesson14.homeworks

// Дата-класс «продукт»
data class Product(
    val name: String,
    val price: Double,   // цена в у.е. (для курса ОК; см. заметку ниже)
    val quantity: Int
)

fun main() {
    val bread = Product(name = "Хлеб", price = 1.49, quantity = 2)
    println(bread)                       // Product(name=Хлеб, price=1.49, quantity=2)

    val moreBread = bread.copy(quantity = 3) // copy — фишка data class
    val total = moreBread.price * moreBread.quantity
    println("Итого за ${moreBread.name}: $total")
}

