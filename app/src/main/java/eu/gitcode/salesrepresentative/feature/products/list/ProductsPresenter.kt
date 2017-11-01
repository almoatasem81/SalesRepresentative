package eu.gitcode.salesrepresentative.feature.products.list

import com.hannesdorfmann.mosby3.mvp.MvpNullObjectBasePresenter
import eu.gitcode.salesrepresentative.common.util.RxTransformers
import eu.gitcode.salesrepresentative.data.product.ProductController
import eu.gitcode.salesrepresentative.di.scope.FragmentScope
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import timber.log.Timber
import javax.inject.Inject

@FragmentScope
class ProductsPresenter @Inject constructor(val productController: ProductController)
    : MvpNullObjectBasePresenter<ProductsContract.View>(), ProductsContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
        compositeDisposable.clear()
    }

    override fun loadProducts() {
        compositeDisposable += productController.getAll()
                .compose(RxTransformers.applySingleComputationSchedulers())
                .subscribe({ products -> view.showProducts(products) }, { t -> Timber.d(t) })
    }

    override fun removeProducts(productId: Long) {
        compositeDisposable += productController.remove(productId)
                .compose(RxTransformers.applyCompletableIoSchedulers())
                .subscribe({ loadProducts() }, { t -> Timber.d(t) })
    }
}