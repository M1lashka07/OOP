class Assistant {

    fun bringCoffee(count: Int, type: String) {

        repeat(count) {
            println("Stand up")
            println("Go to coffee machine")
            println("Make $type")
            println("Bring coffee")
        }

    }
}