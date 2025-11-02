package lessons.lesson16.homeworks.animal
import lessons.lesson16.homeworks.Ansi

class Cat : Animal() {
    override fun makeSound() {
        println(Ansi.color("Meow", Ansi.FG_MAGENTA))
    }
}