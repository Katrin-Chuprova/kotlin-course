package lessons.lesson16.homeworks.shapes

import kotlin.math.PI
import kotlin.math.sin

/** Две стороны и угол между ними (в градусах) */
class Triangle(private val a: Double, private val b: Double, private val angleDeg: Double) : Shape() {
    override fun area(): Double {
        val rad = angleDeg * PI / 180.0
        return 0.5 * a * b * sin(rad)
    }
    override fun toString(): String = "Triangle(a=$a, b=$b, angle=$angleDeg°)"
}