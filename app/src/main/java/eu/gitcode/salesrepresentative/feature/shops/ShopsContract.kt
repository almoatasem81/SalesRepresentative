package eu.gitcode.salesrepresentative.feature.shops

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import eu.gitcode.salesrepresentative.model.Shop

interface ShopsContract {

    interface View : MvpView {
        fun showShops(shops: List<Shop>)
    }

    interface Presenter : MvpPresenter<View> {
        fun loadShops()
    }
}