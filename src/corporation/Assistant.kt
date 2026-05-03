package corporation

class Assistant(
    id: Int,
    name: String,
    age: Int,
) : Worker(
    id = id,
    name = name,
    age = age,
    position = EmployeeType.ASSISTANT
), Cleaner, Supplier {

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