package lessons.lesson17.homeworks.why

fun main() {
    val child = ChildrenClass(
        privateVal   = "child-private copy",
        protectedVal = "hidden",
        publicVal    = "public-from-base"
    )

    // (1) читаем собственное свойство ребёнка
    println("1) child.privateVal = ${child.privateVal}")

    // (10) читаем publicVal — это поле у родителя, инициализированное нашим аргументом
    println("10) child.publicVal (из BaseClass) = ${child.publicVal}")

    // (3–4) меняем publicField на «Антонио Бандераса» — сработает из-за override verifyPublicField
    child.publicField = "Антонио Бандераса"

    // (5) меняем protectedField через публичный метод ребёнка
    child.setProtectedFieldFromMain("protected изменён из main")

    // (6) меняем privateField родителя через рефлексию
    child.setPrivateFieldFromMain("private изменён из main")

    // (8,11) getAll() унаследован от BaseClass, но вызовет child.generate()
    println("\n=== getAll() после изменений ===")
    println(child.getAll())

    // (12) вызов метода, который внутри родителя дергает privatePrint родителя
    println("\n=== printText() ===")
    child.printText()

    // (2) Показать, что protectedVal наружу недоступен невозможно — это compile error.
    // println(child.protectedVal) // <- не компилируется: protected видно только внутри класса/наследников
}
