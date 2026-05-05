package corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int? = null,
    private var salary: Int = 15000,
    val position: EmployeeType
) {

    fun getSalary() = salary

    fun setSalary(value: Int) {
        if (value <= this.salary) println("Salary is too small...")
        else this.salary = value
    }

    abstract fun work()

    override fun toString(): String {
        return "ID: $id, Name: $name, age: $age, Position: ${position.title}, Salary: $salary"
    }



}