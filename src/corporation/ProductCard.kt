package corporation

open class ProductCard(
    val name: String,
    val brand: String,
    val price: Int,
    val productType: ProductType
) {

    override fun toString(): String {
        return "Name: $name Brand: $brand Price: $price ProductType: $productType"
    }
}