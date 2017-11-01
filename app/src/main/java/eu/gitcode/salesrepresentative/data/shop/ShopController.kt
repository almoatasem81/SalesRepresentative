package eu.gitcode.salesrepresentative.data.shop

import eu.gitcode.salesrepresentative.data.shop.model.Shop
import eu.gitcode.salesrepresentative.data.shop.model.Shop_
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShopController @Inject constructor(private val boxStore: BoxStore) {

    fun getAll(): Single<List<Shop>> {
        val query = boxStore.boxFor(Shop::class).query().order(Shop_.name).build()
        return Single.just(query.find())
    }

    fun get(shopId: Long): Single<Shop> {
        return Single.just(boxStore.boxFor(Shop::class).get(shopId))
    }

    fun save(shopName: String, location: String?, openingHours: String?): Completable {
        val shop = Shop(name = shopName, location = location, openingHours = openingHours)
        return Completable.fromAction { boxStore.boxFor(Shop::class).put(shop) }
    }

    fun update(shopId: Long, shopName: String, location: String?, openingHours: String?)
            : Completable {
        val shop = Shop(id = shopId, name = shopName, location = location,
                openingHours = openingHours)
        return Completable.fromAction { boxStore.boxFor(Shop::class).put(shop) }
    }

    fun remove(shopId: Long): Completable {
        return Completable.fromAction { boxStore.boxFor(Shop::class).remove(shopId) }
    }
}