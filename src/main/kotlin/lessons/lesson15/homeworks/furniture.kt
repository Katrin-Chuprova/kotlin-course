package org.example.lessons.lesson15.homeworks

// Базовый класс
open class Furniture(val title: String, val material: String) {
    open fun info() = println("$title ($material)")
}

// Производные
open class Seating(title: String, material: String, val seats: Int) : Furniture(title, material)
open class Table(title: String, material: String, val shape: String) : Furniture(title, material)
open class StorageFurniture(title: String, material: String, val capacityLiters: Int) : Furniture(title, material)

// Доп. разветвление для Seating
class Chair(title: String, material: String, val hasArmrests: Boolean)
    : Seating(title, material, seats = 1)

class Sofa(title: String, material: String, val foldsOut: Boolean)
    : Seating(title, material, seats = 3)

// Прогон
fun main() {
    val ch = Chair("Стул кухонный", "дерево", hasArmrests = false)
    val sf = Sofa("Диван", "ткань", foldsOut = true)
    val tb = Table("Обеденный стол", "МДФ", "прямоугольный")

    ch.info(); sf.info(); tb.info()
}
