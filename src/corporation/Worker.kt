package corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int,
    val salary: Int = 15000,
    val position: EmployeeType
) {

    abstract fun copy(salary: Int = this.salary): Worker

    abstract fun work()

    override fun toString(): String {
        return "ID: $id, Name: $name, age: $age, Position: ${position.title}, Salary: $salary"
    }



}