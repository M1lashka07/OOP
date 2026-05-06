package corporation

class Assistant(
    id: Int,
    name: String,
    age: Int,
    salary: Int,
) : Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = EmployeeType.ASSISTANT
), Cleaner, Supplier {

    override fun copy(salary: Int): Assistant {
        return Assistant(this.id, this.name, this.age, salary)
    }

    override fun work() {
        bringCoffee()
    }

    fun bringCoffee(count: Int = 1, type: String = "Cappuccino"): String {

        repeat(count) {
            println("Stand up")
            println("Go to coffee machine")
            println("Make $type")
            println("Bring coffee")
        }

        return type

    }
}