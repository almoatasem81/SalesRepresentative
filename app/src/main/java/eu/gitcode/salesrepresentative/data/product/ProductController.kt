package eu.gitcode.salesrepresentative.data.product

import eu.gitcode.salesrepresentative.data.product.model.Product
import eu.gitcode.salesrepresentative.data.product.model.Product_
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductController @Inject constructor(private val boxStore: BoxStore) {

    fun getAll(): Single<List<Product>> {
        val query = boxStore.boxFor(Product::class).query().order(Product_.name).build()
        return Single.just(query.find())
    }

    fun get(productId: Long): Single<Product> {
        return Single.just(boxStore.boxFor(Product::class).get(productId))
    }

    fun save(productName: String, capacity: Float?, cost: Float?, description: String?): Completable {
        val product = Product(name = productName, capacity = capacity, cost = cost,
                description = description)
        return Completable.fromAction { boxStore.boxFor(Product::class).put(product) }
    }

    fun update(productId: Long, productName: String, capacity: Float?, cost: Float?,
               description: String?): Completable {
        val product = Product(id = productId, name = productName, capacity = capacity,
                cost = cost, description = description)
        return Completable.fromAction { boxStore.boxFor(Product::class).put(product) }
    }

    fun remove(productId: Long): Completable {
        return Completable.fromAction { boxStore.boxFor(Product::class).remove(productId) }
    }
}