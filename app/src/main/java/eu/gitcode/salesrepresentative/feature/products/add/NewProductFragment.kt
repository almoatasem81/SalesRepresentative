package eu.gitcode.salesrepresentative.feature.products.add

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import eu.gitcode.salesrepresentative.R
import eu.gitcode.salesrepresentative.app.App
import eu.gitcode.salesrepresentative.common.extension.finish
import eu.gitcode.salesrepresentative.common.extension.setResult
import eu.gitcode.salesrepresentative.common.extension.string
import eu.gitcode.salesrepresentative.data.product.model.Product
import kotlinx.android.synthetic.main.new_product_fragment.*

class NewProductFragment : MvpFragment<NewProductContract.View, NewProductContract.Presenter>(),
        NewProductContract.View {

    private val component by lazy { App.getApplicationComponent(context).plusNewProductComponent() }

    companion object {
        fun newInstance(productId: Long): NewProductFragment {
            val newProductFragment = NewProductFragment()
            val bundle = Bundle()
            bundle.putLong(NewProductActivity.PRODUCT_ID, productId)
            newProductFragment.arguments = bundle
            return newProductFragment
        }
    }

    private var editingProductId: Long? = null

    override fun createPresenter(): NewProductContract.Presenter = component.getPresenter()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.new_product_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null && arguments.containsKey(NewProductActivity.PRODUCT_ID)) {
            editingProductId = arguments.getLong(NewProductActivity.PRODUCT_ID)
            getPresenter().getProduct(editingProductId!!)
        }

        saveBtn.setOnClickListener { onSaveBtnClicked() }
    }

    override fun loadProduct(product: Product) {
        productNameEdit.setText(product.name)
        capacityEdit.setText(product.capacity?.toString())
        costEdit.setText(product.cost?.toString())
        descriptionEdit.setText(product.description)
    }

    override fun closeView() {
        setResult(Activity.RESULT_OK)
        finish()
    }

    private fun onSaveBtnClicked() {
        val capacity: Float? = try {
            capacityEdit.string().toFloat()
        } catch (e: NumberFormatException) {
            null
        }
        val cost: Float? = try {
            costEdit.string().toFloat()
        } catch (e: NumberFormatException) {
            null
        }

        if (editingProductId == null) {
            getPresenter().addProduct(productNameEdit.string(), capacity, cost,
                    descriptionEdit.string())
        } else {
            getPresenter().updateProduct(editingProductId!!, productNameEdit.string(),
                    capacity, cost, descriptionEdit.string())
        }
    }
}