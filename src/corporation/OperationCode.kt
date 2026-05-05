package corporation

enum class OperationCode(val title: String) {

    EXIT(title = "exit"),
    REGISTER_NEW_ITEM(title = "register new item"),
    SHOW_ALL_ITEMS(title = "show all items"),
    REMOVE_PRODUCT_CARD(title = "remove product card"),
    REGISTER_NEW_EMPLOYEE(title = "register new employee"),
    FIRE_AN_EMPLOYEE(title = "fire an employee"),
    SHOW_ALL_EMPLOYEES(title = "show all employees"),
    CHANGE_SALARY(title = "change salary"),

}