package org.example.lessons.lesson19.homeworks

interface Validator<T> {
    fun isValid(value: T): Boolean
}
