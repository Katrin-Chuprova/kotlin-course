package lessons.lesson16.homeworks.cart

class Cart {
    private val items: MutableMap<Int, Int> = mutableMapOf()

    /** +1 шт. по id */
    fun addToCart(itemId: Int) {
        items[itemId] = (items[itemId] ?: 0) + 1
    }

    /** Конкретное количество */
    fun addToCart(itemId: Int, amount: Int) {
        if (amount <= 0) return
        items[itemId] = (items[itemId] ?: 0) + amount
    }

    /** Словарь id -> qty */
    fun addToCart(batch: Map<Int, Int>) {
        for ((id, qty) in batch) {
            if (qty > 0) addToCart(id, qty)
        }
    }

    /** Список id (по 1 шт) */
    fun addToCart(ids: List<Int>) {
        for (id in ids) addToCart(id)
    }

    fun entries(): Map<Int, Int> = items.toMap()

    override fun toString(): String {
        if (items.isEmpty()) return "Cart is empty"
        val header = "ID\tQTY"
        val rows = items.entries.sortedBy { it.key }.joinToString("\n") { (id, q) -> "$id\t$q" }
        val distinct = items.size
        val total = items.values.sum()
        val footer = "----\nDistinct items: $distinct | Total qty: $total"
        return "$header\n$rows\n$footer"
    }
}
