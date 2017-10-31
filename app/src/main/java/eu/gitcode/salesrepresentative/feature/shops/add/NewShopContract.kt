package eu.gitcode.salesrepresentative.feature.shops.add

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface NewShopContract {

    interface View : MvpView {
        fun closeView()
    }

    interface Presenter : MvpPresenter<View> {
        fun addShop(name: String, location: String?, openingHours: String?)
    }
}