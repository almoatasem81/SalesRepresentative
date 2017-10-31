package eu.gitcode.salesrepresentative.feature.shops.add

import com.hannesdorfmann.mosby3.mvp.MvpNullObjectBasePresenter
import eu.gitcode.salesrepresentative.common.util.RxTransformers
import eu.gitcode.salesrepresentative.data.shop.ShopController
import eu.gitcode.salesrepresentative.di.scope.FragmentScope
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import javax.inject.Inject

@FragmentScope
class NewShopPresenter @Inject constructor(val shopController: ShopController)
    : MvpNullObjectBasePresenter<NewShopContract.View>(), NewShopContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
        compositeDisposable.clear()
    }

    override fun addShop(name: String, location: String?, openingHours: String?) {
        compositeDisposable += shopController.saveShop(name, location, openingHours)
                .compose(RxTransformers.applyCompletableIoSchedulers())
                .subscribe({ view.closeView() })
    }
}