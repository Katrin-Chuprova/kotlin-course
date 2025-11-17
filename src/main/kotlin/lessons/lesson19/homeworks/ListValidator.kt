package org.example.lessons.lesson19.homeworks

/**
 * Валидатор списка чисел:
 *  - ни один элемент не равен null
 *  - ни один элемент (toDouble) не равен 0.0
 */
class ListValidator<T : Number> : Validator<List<T?>> {
    override fun isValid(value: List<T?>): Boolean {
        if (value.any { it == null }) return false
        if (value.any { it!!.toDouble() == 0.0 }) return false
        return true
    }
}
