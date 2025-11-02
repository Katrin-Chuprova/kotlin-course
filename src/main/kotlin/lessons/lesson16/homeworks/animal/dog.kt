package lessons.lesson16.homeworks.animal
import lessons.lesson16.homeworks.Ansi

class Dog : Animal() {
    override fun makeSound() {
        println(Ansi.color("Bark", Ansi.FG_GREEN))
    }
}