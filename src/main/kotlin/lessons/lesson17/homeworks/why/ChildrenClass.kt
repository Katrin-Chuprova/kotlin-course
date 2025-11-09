package lessons.lesson17.homeworks.why

class ChildrenClass(
    // своё публичное свойство ребёнка — не связано с private полем в BaseClass
    val privateVal: String,
    protectedVal: String,
    // это просто аргумент конструктора, поле даёт родитель (см. пояснение №10)
    publicVal: String
) : BaseClass(privateVal, protectedVal, publicVal) {

    /** (3–4) Ослабляем верификацию, чтобы setter у publicField принимал любое значение. */
    override fun verifyPublicField(value: String): Boolean = true

    /** (5) Публичная «прокладка» до protected-поля родителя. */
    fun setProtectedFieldFromMain(newValue: String) {
        protectedField = newValue
    }

    /**
     * (6) Единственный способ изменить private-поле родителя без правки BaseClass — рефлексия.
     * ⚠ Это учебный хак — в проде так не делаем.
     */
    fun setPrivateFieldFromMain(newValue: String) {
        val f = BaseClass::class.java.getDeclaredField("privateField")
        f.isAccessible = true
        f.set(this, newValue)
    }

    /** (12) Это НЕ переопределение private-метода родителя, а отдельный метод ребёнка. */
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    /** (8) Полиморфизм: BaseClass.getAll() будет вызывать именно эту версию. */
    override fun generate(): String = "Это генерация из дочернего класса"
}
