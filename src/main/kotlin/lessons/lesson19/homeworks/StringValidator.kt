package org.example.lessons.lesson19.homeworks

/** Строка должна быть не null, не пустой и не состоять только из пробелов. */
class StringValidator : Validator<String?> {
    override fun isValid(value: String?): Boolean = !value.isNullOrBlank()
}
