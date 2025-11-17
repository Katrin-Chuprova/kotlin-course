package org.example.lessons.lesson19.homeworks

/**
 * По условию требуется проверять ЧЁТНОСТЬ.
 * Имя оставлено как в задании.
 */
class OddValidator : Validator<Int> {
    override fun isValid(value: Int): Boolean = value % 2 == 0
}
