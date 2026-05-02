package corporation

class Director(
    id: Int,
    name: String,
    age: Int,
) : Worker(
    id = id,
    name = name,
    age = age,
    position = EmployeeType.DIRECTOR
) {

    fun takeCoffee(assistant: Assistant) {
        val drinkName = assistant.bringCoffee()
        println("Thank you ${assistant.name}. This $drinkName is very tasti!")
    }

    fun getConsultantToWork(consultant: Consultant) {
        val count = consultant.serveClient()
        println("employee.Consultant: ${consultant.name} served $count clients.")
    }

}