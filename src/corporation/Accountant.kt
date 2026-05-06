package corporation


class Accountant(
    id: Int,
    name: String,
    age: Int,
    salary: Int,
) : Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = EmployeeType.ACCOUNTANT
), Cleaner, Supplier {

    override fun copy(salary: Int): Accountant {
        return Accountant(this.id, this.name, this.age, salary)
    }

    private fun registerNewItem() {
        val productTypes = ProductType.entries
        print("Enter the product type. ")
        productTypes.forEach { type ->
            print("${type.ordinal} - ${type.title}")
            if (type == productTypes.last()) print(": ")
            else print(", ")
        }

        val productType = productTypes[readln().trim().toInt()]
        print("Enter the product name: ")
        val productName = readln().trim()
        print("Enter the product brand: ")
        val productBrand = readln().trim()
        print("Enter the product price: ")
        val productPrice = readln().trim().toInt()
        val card = when (productType) {

            ProductType.FOOD -> {
                print("Enter the caloric: ")
                val caloric = readln().trim().toInt()
                FoodCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    caloric = caloric
                )
            }

            ProductType.APPLIANCE -> {
                print("Enter the wattage: ")
                val wattage = readln().trim().toInt()
                ApplianceCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    wattage = wattage
                )
            }

            ProductType.SHOE -> {
                print("Enter the size: ")
                val size = readln().trim().toFloat()
                ShoeCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    size = size
                )
            }
        }

        ProductRepository.saveProductCard(card)

    }

    private fun showAllItems() {

        ProductRepository.products.forEach { println(it) }

    }

    private fun removeProductCard() {
        print("Enter the product name for removed items: ")
        val name = readln().trim()

        ProductRepository.removeProductCard(name)
    }

    private fun registerNewEmployee() {
        val employeeTypes = EmployeeType.entries

        print("Choose position: ")
        employeeTypes.forEach { type ->
            print("${type.ordinal} - ${type.title}")
            if (type == employeeTypes.last()) print(": ")
            else print(", ")
        }
        val index = readln().trim().toInt()

        print("Enter id: ")
        val employeeId = readln().trim().toInt()
        print("Enter name: ")
        val employeeName = readln().trim()
        print("Enter age: ")
        val employeeAge = readln().trim().toInt()
        print("Enter salary: ")
        val employeeSalary = readln().trim().toInt()

        val employee = when (employeeTypes[index]) {
            EmployeeType.DIRECTOR -> Director(
                id = employeeId,
                name = employeeName,
                age = employeeAge,
                salary = employeeSalary
            )

            EmployeeType.ACCOUNTANT -> Accountant(
                id = employeeId,
                name = employeeName,
                age = employeeAge,
                salary = employeeSalary
            )

            EmployeeType.ASSISTANT -> Assistant(
                id = employeeId,
                name = employeeName,
                age = employeeAge,
                salary = employeeSalary
            )

            EmployeeType.CONSULTANT -> Consultant(
                id = employeeId,
                name = employeeName,
                age = employeeAge,
                salary = employeeSalary
            )
        }
        WorkersRepository.saveWorker(employee)

    }

    private fun removeEmployee() {

        print("Enter the employee ID for removed: ")
        val id = readln().trim().toInt()
        WorkersRepository.removeEmployee(id)

    }

    private fun showAllEmployees() {

        WorkersRepository.workers.forEach { println(it) }

    }

    private fun changeSalary() {
        print("Enter worker ID for change salary: ")
        val id = readln().trim().toInt()
        print("Enter new salary: ")
        val salary = readln().trim().toInt()

        WorkersRepository.changeSalary(id, salary)
    }

    override fun work() {

        while (true) {
            val operations = OperationCode.entries

            print("Enter the operation code.\n")
            operations.forEach { operation ->
                print("${operation.ordinal} - ${operation.title}\n")
            }

            val operationCode = operations[readln().trim().toInt()]
            when (operationCode) {
                OperationCode.EXIT -> {
                    WorkersRepository.saveChanges()
                    ProductRepository.saveChanges()
                    return
                }

                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
                OperationCode.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                OperationCode.FIRE_AN_EMPLOYEE -> removeEmployee()
                OperationCode.SHOW_ALL_EMPLOYEES -> showAllEmployees()
                OperationCode.CHANGE_SALARY -> changeSalary()
            }
        }
    }

}