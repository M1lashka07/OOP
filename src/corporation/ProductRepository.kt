package corporation

import java.io.File

object ProductRepository {

    private val _products = loadAllProducts()
    val products: MutableList<ProductCard>
        get() = _products
    private val productFile = File("items.txt")

    private fun loadAllProducts(): MutableList<ProductCard> {
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

    fun saveChanges() {
        val content = StringBuilder()

        products.forEach { product ->
            when (product) {
                is FoodCard ->
                    content
                        .append("${product.name}%${product.brand}%${product.price}%${product.caloric}%${product.productType}")
                is ApplianceCard ->
                    content
                        .append("${product.name}%${product.brand}%${product.price}%${product.wattage}%${product.productType}")
                is ShoeCard ->
                    content
                        .append("${product.name}%${product.brand}%${product.price}%${product.size}%${product.productType}")
            }
        }

        productFile.writeText(content.toString())

    }

    fun saveProductCard(productCard: ProductCard) {

        products.add(productCard)

    }

    fun removeProductCard(name: String) {

        products.removeIf { it.name == name }

    }

}