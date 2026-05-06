package corporation

class Director(
    id: Int,
    name: String,
    age: Int,
    salary: Int,
) : Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = EmployeeType.DIRECTOR
), Supplier {

    override fun work() {}

    override fun copy(salary: Int): Director {
        return Director(this.id, this.name, this.age, salary)
    }

    fun takeCoffee(assistant: Assistant) {
        val drinkName = assistant.bringCoffee()
        println("Thank you ${assistant.name}. This $drinkName is very tasti!")
    }

    fun getConsultantToWork(consultant: Consultant) {
        val count = consultant.serveClient()
        println("employee.Consultant: ${consultant.name} served $count clients.")
    }

}