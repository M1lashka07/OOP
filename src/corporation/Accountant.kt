package corporation

import java.io.File


class Accountant(
    id: Int,
    name: String,
    age: Int
) : Worker(
    id = id,
    name = name,
    age = age,
    position = EmployeeType.ACCOUNTANT
) {

    val productFile = File("items.txt")
    val employeeFile = File("employee.txt")

    fun registerNewItem() {
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

        saveProductCard(card)

    }

    fun readFile(): MutableList<ProductCard> {
        val products = mutableListOf<ProductCard>()
        productFile.forEachLine {
            val elements = it.split("%")
            val card = when (ProductType.valueOf(elements.last())) {
                ProductType.FOOD -> FoodCard(
                    name = elements[0],
                    brand = elements[1],
                    price = elements[2].toInt(),
                    caloric = elements[3].toInt(),
                )

                ProductType.APPLIANCE -> ApplianceCard(
                    name = elements[0],
                    brand = elements[1],
                    price = elements[2].toInt(),
                    wattage = elements[3].toInt(),
                )

                ProductType.SHOE -> ShoeCard(
                    name = elements[0],
                    brand = elements[1],
                    price = elements[2].toInt(),
                    size = elements[3].toFloat()
                )
            }
            products.add(card)
        }
        return products
    }

    fun showAllItems() {

        readFile().forEach { println(it) }

    }

    fun removeProductCard() {

        val cards = readFile()
        print("Enter the product name for removed items: ")
        val name = readln().trim()
        cards.removeIf { it.name == name }

        productFile.writeText("")
        cards.forEach { saveProductCard(it) }
    }

    fun saveProductCard(productCard: ProductCard) {

        productFile.appendText("${productCard.name}%${productCard.brand}%${productCard.price}%")

        when (productCard) {
            is FoodCard -> productFile.appendText("${productCard.caloric}%")
            is ApplianceCard -> productFile.appendText("${productCard.wattage}%")
            is ShoeCard -> productFile.appendText("${productCard.size}%")
        }

        productFile.appendText("${productCard.productType}\n")

    }

    fun registerNewEmployee() {
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

        val employee = when (employeeTypes[index]) {
            EmployeeType.DIRECTOR -> Director(
                id = employeeId,
                name = employeeName,
                age = employeeAge
            )
            EmployeeType.ACCOUNTANT -> Accountant(
                id = employeeId,
                name = employeeName,
                age = employeeAge
            )
            EmployeeType.ASSISTANT -> Assistant(
                id = employeeId,
                name = employeeName,
                age = employeeAge
            )
            EmployeeType.CONSULTANT -> Consultant(
                id = employeeId,
                name = employeeName,
                age = employeeAge
            )
        }

        saveEmployee(employee)

    }

    fun removeEmployee() {

        val employees = loadEmployees()
        print("Enter the employee ID for removed: ")
        val id = readln().trim().toInt()

        employees.removeIf { it.id == id }

        employeeFile.writeText("")
        employees.forEach { saveEmployee(it) }

    }

    fun showAllEmployees() {

        loadEmployees().forEach { println(it) }

    }

    fun loadEmployees() : MutableList<Worker> {
        val workers = mutableListOf<Worker>()
        employeeFile.forEachLine {
            val elements = it.split("%")
            val worker = when (EmployeeType.valueOf(elements.last())) {
                EmployeeType.DIRECTOR -> Director(
                    id = elements[0].toInt(),
                    name = elements[1],
                    age = elements[2].toInt(),
                )
                EmployeeType.ACCOUNTANT -> Accountant(
                    id = elements[0].toInt(),
                    name = elements[1],
                    age = elements[2].toInt(),
                )
                EmployeeType.ASSISTANT -> Assistant(
                    id = elements[0].toInt(),
                    name = elements[1],
                    age = elements[2].toInt(),
                )
                EmployeeType.CONSULTANT -> Consultant(
                    id = elements[0].toInt(),
                    name = elements[1],
                    age = elements[2].toInt(),
                )
            }
            workers.add(worker)
        }
        return workers
    }

    fun saveEmployee(worker: Worker) {

        employeeFile.appendText("${worker.id}%${worker.name}%${worker.age}%${worker.position}")

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
                OperationCode.EXIT -> return
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
                OperationCode.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                OperationCode.FIRE_AN_EMPLOYEE -> removeEmployee()
                OperationCode.SHOW_ALL_EMPLOYEES -> showAllEmployees()
            }
        }
    }

}