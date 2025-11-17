package org.example.lessons.lesson20.homeworks

import kotlin.math.absoluteValue

// Проверка допуска: |this - other| <= deviation
fun Number.within(other: Number, deviation: Number): Boolean {
    val diff = (this.toDouble() - other.toDouble()).absoluteValue
    return diff <= deviation.toDouble()
}
