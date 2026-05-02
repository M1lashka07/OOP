package corporation

class ShoeCard(
    name: String,
    brand: String,
    price: Int,
    val size: Float,
) : ProductCard(name, brand, price, ProductType.SHOE) {

    override fun toString(): String {
        return super.toString() + " Size : $size"
    }
}