package eu.gitcode.salesrepresentative.feature.shops.add

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import eu.gitcode.salesrepresentative.data.shop.model.Shop

interface NewShopContract {

    interface View : MvpView {
        fun loadShop(shop: Shop)

        fun closeView()
    }

    interface Presenter : MvpPresenter<View> {
        fun addShop(name: String, location: String?, openingHours: String?)

        fun updateShop(shopId: Long, name: String, location: String?, openingHours: String?)

        fun getShop(shopId: Long)
    }
}