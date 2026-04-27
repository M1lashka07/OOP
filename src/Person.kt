class Person(
    private val name: String,
    private val age: Int,
    private val height: Double,
    private val weight: Double
) {

    fun sayHello() {
        println("Hello! My name is $name")
    }

    fun run() {
        repeat(10) {
            println("Running...")
        }
    }

}