package corporation

fun main() {

    Accountant(id = 0, name = "Nick", age = 13).loadEmployees().forEach { it.work() }

}