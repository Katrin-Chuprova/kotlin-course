package lessons.lesson16.homeworks.cart

fun demoCart() {
    val cart = Cart()
    cart.addToCart(101)                 // +1
    cart.addToCart(101, 2)              // +2
    cart.addToCart(mapOf(102 to 5, 201 to 1))
    cart.addToCart(listOf(101, 102, 303))
    println(cart)
}

fun main() {
    val cart = Cart()

    // 1) добавить по одной штуке
    cart.addToCart(101)
    cart.addToCart(101)              // увеличит количество для 101

    // 2) добавить с количеством
    cart.addToCart(itemId = 202, amount = 3)

    // 3) добавить словарь id -> количество
    cart.addToCart(mapOf(303 to 2, 404 to 1))

    // 4) добавить список id (по одной штуке каждого)
    cart.addToCart(listOf(101, 505, 202))

    println("=== Корзина ===")
    println(cart)                    // toString() с красивым форматированием
}
