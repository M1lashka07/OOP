package corporation

import java.io.File

object WorkersRepository {

    private val _workers = loadEmployees()
    val workers: MutableList<Worker>
        get() = _workers

    private val employeeFile = File("employee.txt")

    fun saveWorker(worker: Worker) {

        workers.add(worker)

    }

    fun saveChanges(){

        val content = StringBuilder()
        workers.forEach {worker ->
            content.append("${worker.id}%${worker.name}%${worker.age}%${worker.getSalary()}%${worker.position}")
        }

        employeeFile.writeText(content.toString())

    }

    private fun loadEmployees(): MutableList<Worker> {
        val workers = mutableListOf<Worker>()
        employeeFile.forEachLine {
            val elements = it.split("%")
            val worker = when (EmployeeType.valueOf(elements.last())) {
                EmployeeType.DIRECTOR -> Director(
                    id = elements[0].toInt(),
                    name = elements[1],
                    age = elements[2].toInt(),
                    salary = elements[3].toInt()
                )

                EmployeeType.ACCOUNTANT -> Accountant(
                    id = elements[0].toInt(),
                    name = elements[1],
                    age = elements[2].toInt(),
                    salary = elements[3].toInt()
                )

                EmployeeType.ASSISTANT -> Assistant(
                    id = elements[0].toInt(),
                    name = elements[1],
                    age = elements[2].toInt(),
                    salary = elements[3].toInt()
                )

                EmployeeType.CONSULTANT -> Consultant(
                    id = elements[0].toInt(),
                    name = elements[1],
                    age = elements[2].toInt(),
                    salary = elements[3].toInt()
                )
            }
            workers.add(worker)
        }
        return workers
    }

    fun removeEmployee(id: Int) {

        workers.removeIf { it.id == id }

    }

    fun changeSalary(id: Int, salary: Int) {
        workers.forEach {
            if (it.id == id) it.setSalary(salary)
        }
    }

}