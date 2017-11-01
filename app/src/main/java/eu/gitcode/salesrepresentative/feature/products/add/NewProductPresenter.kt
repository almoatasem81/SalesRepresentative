package eu.gitcode.salesrepresentative.feature.products.add

import com.hannesdorfmann.mosby3.mvp.MvpNullObjectBasePresenter
import eu.gitcode.salesrepresentative.common.util.RxTransformers
import eu.gitcode.salesrepresentative.data.product.ProductController
import eu.gitcode.salesrepresentative.di.scope.FragmentScope
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import timber.log.Timber
import javax.inject.Inject

@FragmentScope
class NewProductPresenter @Inject constructor(val productController: ProductController)
    : MvpNullObjectBasePresenter<NewProductContract.View>(), NewProductContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
        compositeDisposable.clear()
    }

    override fun addProduct(name: String, capacity: Float?, cost: Float?,
                            description: String?) {
        compositeDisposable += productController.save(name, capacity, cost, description)
                .compose(RxTransformers.applyCompletableIoSchedulers())
                .subscribe({ view.closeView() })
    }

    override fun updateProduct(productId: Long, name: String, capacity: Float?, cost: Float?,
                               description: String?) {
        compositeDisposable += productController.update(productId, name, capacity, cost, description)
                .compose(RxTransformers.applyCompletableIoSchedulers())
                .subscribe({ view.closeView() })
    }

    override fun getProduct(productId: Long) {
        compositeDisposable += productController.get(productId)
                .compose(RxTransformers.applySingleComputationSchedulers())
                .subscribe({ product -> view.loadProduct(product) }, { t -> Timber.d(t) })
    }
}