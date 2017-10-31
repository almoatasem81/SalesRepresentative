package eu.gitcode.salesrepresentative.feature.shops.list

import com.hannesdorfmann.mosby3.mvp.MvpNullObjectBasePresenter
import eu.gitcode.salesrepresentative.common.util.RxTransformers
import eu.gitcode.salesrepresentative.data.shop.ShopController
import eu.gitcode.salesrepresentative.di.scope.FragmentScope
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import timber.log.Timber
import javax.inject.Inject

@FragmentScope
class ShopsPresenter @Inject constructor(val shopController: ShopController)
    : MvpNullObjectBasePresenter<ShopsContract.View>(), ShopsContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
        compositeDisposable.clear()
    }

    override fun loadShops() {
        compositeDisposable += shopController.getShops()
                .compose(RxTransformers.applySingleComputationSchedulers())
                .subscribe({ shops -> view.showShops(shops) }, { t -> Timber.d(t) })
    }

    override fun removeShop(shopId: Long) {
        compositeDisposable += shopController.removeShop(shopId)
                .compose(RxTransformers.applyCompletableIoSchedulers())
                .subscribe({ loadShops() }, { t -> Timber.d(t) })
    }
}