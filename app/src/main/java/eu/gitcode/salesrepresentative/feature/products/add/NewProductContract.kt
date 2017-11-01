package eu.gitcode.salesrepresentative.feature.products.add

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import eu.gitcode.salesrepresentative.data.product.model.Product

interface NewProductContract {

    interface View : MvpView {
        fun loadProduct(product: Product)

        fun closeView()
    }

    interface Presenter : MvpPresenter<View> {
        fun addProduct(name: String, capacity: Float?, cost: Float?,
                       description: String?)

        fun updateProduct(productId: Long, name: String, capacity: Float?, cost: Float?,
                          description: String?)

        fun getProduct(productId: Long)
    }
}