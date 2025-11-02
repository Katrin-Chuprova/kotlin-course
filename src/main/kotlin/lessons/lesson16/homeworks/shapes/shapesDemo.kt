package lessons.lesson16.homeworks.shapes

fun demoShapes() {
    val shapes: List<Shape> = listOf(
        Circle(5.0),
        Square(4.0),
        Triangle(3.0, 6.0, 30.0),
        object : Shape() {} // базовый (0.0)
    )
    shapes.forEach { s ->
        println("${s}: area=${"%.3f".format(s.area())}")
    }
}
fun main() {
    // соберём разные фигуры
    val shapes: List<Shape> = listOf(
        Circle(radius = 3.0),
        Square(side = 4.0),
        Triangle(a = 5.0, b = 6.0, angleDeg = 30.0) // ← правильное имя параметра
    )

    println("=== Площади фигур ===")
    shapes.forEachIndexed { i, s ->
        val areaText = "%.2f".format(s.area())
        println("${i + 1}. ${s::class.simpleName}: $areaText")
    }
}
