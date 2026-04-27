fun main() {
    val person = Person()

//    print("Enter your name: ")
//    person.name = readlnOrNull()
//
//    print("Enter your age: ")
//    person.age = readlnOrNull()?.toInt()
//
//    print("Enter your height: ")
//    person.height = readlnOrNull()?.toDouble()
//
//    print("Enter your weight: ")
//    person.weight = readlnOrNull()?.toDouble()

    println("Name ${person.name} is ${person.age} years old is ${person.height} is ${person.weight}")
    person.sayHello()

}