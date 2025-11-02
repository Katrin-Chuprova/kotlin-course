package org.example.lessons.lesson15.homeworks

    // Базовый класс
    abstract class GeometricFigure(val name: String) {
        open fun info() = println("Фигура: $name")
    }

    // Разветвление 1: Многоугольник и Круг
    open class Polygon(name: String, open val sides: Int) : GeometricFigure(name) {
        override fun info() = println("Фигура: $name, сторон: $sides")
    }

    class Circle(val radius: Double) : GeometricFigure("Круг") {
        override fun info() = println("Фигура: $name, радиус: $radius")
    }

    // Доп. разветвление для Многоугольника
    class Triangle(val a: Double, val b: Double, val c: Double) : Polygon("Треугольник", 3)
    class Quadrilateral(val a: Double, val b: Double, val c: Double, val d: Double) : Polygon("Четырёхугольник", 4)

    // Быстрый прогон
    fun main() {
        val f1: GeometricFigure = Circle(5.0)
        val f2: GeometricFigure = Triangle(3.0, 4.0, 5.0)
        val f3: GeometricFigure = Quadrilateral(2.0, 3.0, 4.0, 5.0)

        f1.info()
        f2.info()
        f3.info()
    }
