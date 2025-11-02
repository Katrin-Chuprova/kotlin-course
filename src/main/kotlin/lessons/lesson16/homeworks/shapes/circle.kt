package lessons.lesson16.homeworks.shapes

import kotlin.math.PI

class Circle(private val radius: Double) : Shape() {
    override fun area(): Double = PI * radius * radius
    override fun toString(): String = "Circle(r=$radius)"
}