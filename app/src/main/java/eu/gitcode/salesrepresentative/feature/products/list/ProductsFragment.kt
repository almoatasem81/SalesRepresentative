package eu.gitcode.salesrepresentative.feature.products.list

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import eu.gitcode.salesrepresentative.R
import eu.gitcode.salesrepresentative.app.App
import eu.gitcode.salesrepresentative.common.extension.startActivityForResult
import eu.gitcode.salesrepresentative.data.product.model.Product
import eu.gitcode.salesrepresentative.feature.products.add.NewProductActivity
import kotlinx.android.synthetic.main.shops_fragment.*

class ProductsFragment : MvpFragment<ProductsContract.View, ProductsContract.Presenter>(),
        ProductsContract.View, ProductViewHolder.ProductViewHolderListener {

    lateinit var adapter: ProductsAdapter

    override fun createPresenter(): ProductsContract.Presenter {
        val component = App.Factory.getApplicationComponent(context)
                .plusProductsComponent()
        component.inject(this)
        return component.getPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.shops_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addShopFloatingBtn.setOnClickListener(
                { startActivityForResult<NewProductActivity>(NewProductActivity.PRODUCT_ADDED_REQUEST_CODE) })
        setupRecyclerView()
        getPresenter().loadProducts()
    }

    override fun showProducts(products: List<Product>) {
        adapter.setProducts(products)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        getPresenter().loadProducts()
    }

    override fun onProductClicked(product: Product) {
        AlertDialog.Builder(context)
                .setTitle(product.name)
                .setMessage(String.format("%s \n%s \n%s",
                        product.capacity ?: "", product.cost ?: "", product.description))
                .setPositiveButton(getString(R.string.edit), { _, _ -> editProduct(product.id) })
                .setNeutralButton(getString(R.string.close), { _, _ -> })
                .setNegativeButton(getString(R.string.remove),
                        { _, _ -> showAreYouSureDialog(product) })
                .create().show()
    }

    private fun setupRecyclerView() {
        adapter = ProductsAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun editProduct(productId: Long) {
        NewProductActivity.startActivityIntent(
                this, productId, NewProductActivity.PRODUCT_ADDED_REQUEST_CODE)
    }

    private fun showAreYouSureDialog(product: Product) {
        AlertDialog.Builder(context)
                .setTitle(R.string.remove)
                .setMessage(R.string.are_you_sure_remove)
                .setPositiveButton(R.string.ok,
                        { _, _ -> getPresenter().removeProducts(product.id) })
                .setNegativeButton(R.string.cancel, { _, _ -> })
                .create().show()
    }
}