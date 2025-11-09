package lessons.lesson17.homeworks.why

abstract class BaseClass(
    // 1. Почему доступно для чтения из ChildrenClass в main: передаётся в конструктор родителя,
    //    а затем используется в методах родителя (например, getAll()).
    private val privateVal: String,

    // 2. Почему недоступно в main: модификатор protected — видно в наследниках, но не снаружи.
    protected val protectedVal: String,

    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }

    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"

    private var privateField = "6. добавь сеттер чтобы изменить меня из main()"

    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }

    fun printText() {
        privatePrint()
    }

    // 7. Не может быть public: тогда любой код смог бы получать внутренний ProtectedClass,
    //    ломая инкапсуляцию. Protected — только для иерархии.
    protected open fun getProtectedClass() = ProtectedClass()

    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }

    // 8. Может быть переопределён в наследнике — поэтому в getAll() будет другой текст.
    open fun generate(): String {
        return "Это генерация из родительского класса"
    }

    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }

    // 9. Не может быть public/protected: PrivateClass — полностью внутренний механизм.
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass
    private class PrivateClass
}
