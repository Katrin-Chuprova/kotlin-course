package org.example.lessons.lesson31.homeworks

class PhoneNumberFormatter {

    /**
     * Преобразует входящую строку к формату +7 (XXX) XXX-XX-XX.
     * Правила:
     * - убираем все нецифры
     * - допускаются 10 или 11 цифр
     * - при 11 цифрах первый символ должен быть 7 или 8 (и отбрасывается)
     */
    fun formatPhoneNumber(input: String): String {
        val digits = input.replace("\\D".toRegex(), "")
        val ten = when (digits.length) {
            10 -> digits
            11 -> {
                val first = digits[0]
                if (first != '7' && first != '8') {
                    throw IllegalArgumentException("Невалидный префикс для 11-значного номера")
                }
                digits.substring(1)
            }
            else -> throw IllegalArgumentException("Номер должен содержать 10 или 11 цифр")
        }

        // ten = DDDDDDDDDD (ровно 10)
        val c = ten.substring(0, 3)
        val p1 = ten.substring(3, 6)
        val p2 = ten.substring(6, 8)
        val p3 = ten.substring(8, 10)
        return "+7 ($c) $p1-$p2-$p3"
    }
}
