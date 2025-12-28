package org.example.lessons.lesson31.homeworks

package org.example.lessons.lesson32.homeworks.phone

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.api.Test

class PhoneNumberFormatterTest {

    private val f = PhoneNumberFormatter()

    /* ---- валидные варианты, все приводятся к одному результату ---- */

    @ParameterizedTest
    @ValueSource(strings = [
        "8 (922) 941-11-11",
        "79229411111",
        "+7 922 941 11 11",
        "9229411111",
        "abc +7 922 941 11 11"
    ])
    fun valid_variants_normalize_to_single_expected(raw: String) {
        assertEquals("+7 (922) 941-11-11", f.formatPhoneNumber(raw))
    }

    /* ---- парные проверки разных входов и своих ожидаемых результатов ---- */

    @ParameterizedTest
    @CsvSource(
        // 10 цифр
        "4951234567, +7 (495) 123-45-67",
        // 11 цифр, начинается с 8
        "'8 495 123 45 67', +7 (495) 123-45-67",
        // 11 цифр, начинается с 7
        "'+7-495-123-45-67', +7 (495) 123-45-67",
        // мусорные символы
        "' (812) ** 000 00 00 ', +7 (812) 000-00-00"
    )
    fun csv_valid_inputs(raw: String, expected: String) {
        assertEquals(expected, f.formatPhoneNumber(raw))
    }

    /* ---- невалидные длины ---- */

    @ParameterizedTest
    @ValueSource(strings = [
        "12345",
        "123456789",        // 9
        "123456789012",     // 12
        "abcdef"
    ])
    fun invalid_length_throws(raw: String) {
        assertThrows(IllegalArgumentException::class.java) {
            f.formatPhoneNumber(raw)
        }
    }

    /* ---- 11 цифр, но неправильный префикс ---- */

    @ParameterizedTest
    @ValueSource(strings = [
        "+1 (922) 941-11-11",
        "61234567890",
        "01234567890"
    ])
    fun invalid_prefix_for_11_digits_throws(raw: String) {
        assertThrows(IllegalArgumentException::class.java) {
            f.formatPhoneNumber(raw)
        }
    }

    /* ---- точечные проверки ---- */

    @Test
    fun ten_zeros_is_technically_formatted() {
        // Алгоритм допускает 10 любых цифр.
        assertEquals("+7 (000) 000-00-00", f.formatPhoneNumber("0000000000"))
    }
}
