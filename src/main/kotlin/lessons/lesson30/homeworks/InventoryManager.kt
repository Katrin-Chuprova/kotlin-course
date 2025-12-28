package org.example.lessons.lesson30.homeworks

class InventoryManager(private val capacity: Int) {

    private val items = mutableMapOf<String, Int>()

    /**
     * Возвращает количество инвентаря по имени, либо 0 если такого нет.
     */
    fun getItemCount(itemName: String): Int = items[itemName] ?: 0

    /**
     * Добавляет инвентарь к уже существующему количеству.
     * @throws IllegalArgumentException если имя пустое или quantity <= 0
     * @throws IllegalStateException если добавление превысит capacity
     */
    fun addItem(itemName: String, quantity: Int) {
        require(itemName.isNotBlank()) { "itemName must not be blank" }
        require(quantity > 0) { "quantity must be > 0" }
        checkCapacity(quantity)
        items[itemName] = (items[itemName] ?: 0) + quantity
    }

    /**
     * Удаляет указанное количество.
     * @return true если удаление состоялось, false если нет наименования или не хватает количества
     * @throws IllegalArgumentException если quantity <= 0
     */
    fun removeItem(itemName: String, quantity: Int): Boolean {
        require(quantity > 0) { "quantity must be > 0" }
        val current = items[itemName] ?: return false
        if (quantity > current) return false
        val left = current - quantity
        if (left == 0) items.remove(itemName) else items[itemName] = left
        return true
    }

    /**
     * Проверка суммарной вместимости склада.
     */
    private fun checkCapacity(itemsForAdding: Int) {
        val used = items.values.sum()
        check(used + itemsForAdding <= capacity) {
            "Количество инвентаря не должно превышать $capacity единиц"
        }
    }
}
