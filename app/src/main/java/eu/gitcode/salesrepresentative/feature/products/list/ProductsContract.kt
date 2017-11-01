package eu.gitcode.salesrepresentative.feature.products.list

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import eu.gitcode.salesrepresentative.data.product.model.Product

interface ProductsContract {

    interface View : MvpView {
        fun showProducts(products: List<Product>)
    }

    interface Presenter : MvpPresenter<View> {
        fun loadProducts()

        fun removeProducts(productId: Long)
    }
}