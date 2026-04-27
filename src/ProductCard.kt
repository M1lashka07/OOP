class ProductCard(
    private val name: String,
    private val brand: String,
    private val size: Double,
    private val price: Int
) {

    fun printInfo() {
        println("Name: $name \nBrand: $brand\nSize: $size \nPrice: $price")
    }

}