package corporation

class FoodCard(
    name: String,
    brand: String,
    price: Int,
    val caloric: Int
) : ProductCard(name, brand, price, ProductType.FOOD) {

    override fun toString(): String {
        return super.toString() + " Calories: $caloric"
    }
}