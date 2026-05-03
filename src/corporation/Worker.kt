package corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int? = null,
    val position: EmployeeType
) {

    abstract fun work()

    override fun toString(): String {
        return "ID: $id, Name: $name, age: $age, Position: ${position.title}"
    }
}