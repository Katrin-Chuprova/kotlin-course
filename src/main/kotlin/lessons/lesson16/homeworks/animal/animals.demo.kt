package lessons.lesson16.homeworks.animal

fun main() {
    val zoo: List<Animal> = listOf(Dog(), Cat(), Bird(), Animal())
    zoo.forEach { it.makeSound() }
}

fun demoAnimals() {
    val zoo: List<Animal> = listOf(Dog(), Cat(), Bird(), Animal())
    zoo.forEach { it.makeSound() }
}