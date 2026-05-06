package corporation

import kotlin.random.Random

class Consultant(
    id: Int,
    name: String,
    age: Int,
    salary: Int,
) : Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = EmployeeType.CONSULTANT
), Cleaner {

    override fun work() {
        serveClient()
    }

    override fun copy(salary: Int): Consultant {
        return Consultant(this.id, this.name, this.age, salary)
    }

    fun sayHello() {
        print("Hello! My name is $name. ")
    }

    fun serveClient(): Int {
        var count = 0

        repeat(Random.nextInt(1, 10)) {
            print("Client served! Consultant: $name\n")
            count++
        }

        return count
    }

}