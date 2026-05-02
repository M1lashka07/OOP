package corporation

class ApplianceCard(
    name: String,
    brand: String,
    price: Int,
    val wattage: Int
) : ProductCard(name, brand, price, ProductType.APPLIANCE) {

    override fun toString(): String {
        return super.toString() + " Wattage: $wattage"
    }
}