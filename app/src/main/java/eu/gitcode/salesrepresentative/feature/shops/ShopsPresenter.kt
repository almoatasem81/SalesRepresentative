package eu.gitcode.salesrepresentative.feature.shops

import com.hannesdorfmann.mosby3.mvp.MvpNullObjectBasePresenter
import eu.gitcode.salesrepresentative.di.scope.FragmentScope
import eu.gitcode.salesrepresentative.model.Shop
import javax.inject.Inject

@FragmentScope
class ShopsPresenter @Inject constructor()
    : MvpNullObjectBasePresenter<ShopsContract.View>(), ShopsContract.Presenter {

    override fun loadShops() {
        view.showShops(listOf(Shop(name = "sklep", address = "Białystok", openingTime = "12-16")))
    }
}