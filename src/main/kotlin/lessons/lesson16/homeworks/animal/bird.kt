package lessons.lesson16.homeworks.animal
import lessons.lesson16.homeworks.Ansi

class Bird : Animal() {
    override fun makeSound() {
        println(Ansi.color("Tweet", Ansi.FG_CYAN))
    }
}
