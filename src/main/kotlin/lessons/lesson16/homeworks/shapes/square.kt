package lessons.lesson16.homeworks.shapes

class Square(private val side: Double) : Shape() {
    override fun area(): Double = side * side
    override fun toString(): String = "Square(a=$side)"
}