package eu.gitcode.salesrepresentative.feature.shops.add

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
import eu.gitcode.salesrepresentative.data.shop.model.Shop
import kotlinx.android.synthetic.main.new_shop_fragment.*

class NewShopFragment : MvpFragment<NewShopContract.View, NewShopContract.Presenter>(),
        NewShopContract.View {

    private val component by lazy { App.getApplicationComponent(context).plusNewShopComponent() }

    companion object {
        fun newInstance(shopId: Long): NewShopFragment {
            val newShopFragment = NewShopFragment()
            val bundle = Bundle()
            bundle.putLong(NewShopActivity.SHOP_ID, shopId)
            newShopFragment.arguments = bundle
            return newShopFragment
        }
    }

    private var editingShopId: Long? = null

    override fun createPresenter(): NewShopContract.Presenter = component.getPresenter()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.new_shop_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null && arguments.containsKey(NewShopActivity.SHOP_ID)) {
            editingShopId = arguments.getLong(NewShopActivity.SHOP_ID)
            getPresenter().getShop(editingShopId!!)
        }

        saveBtn.setOnClickListener { onSaveBtnClicked() }
    }

    override fun loadShop(shop: Shop) {
        shopNameEdit.setText(shop.name)
        locationEdit.setText(shop.location)
        openingHoursEdit.setText(shop.openingHours)
    }

    override fun closeView() {
        setResult(Activity.RESULT_OK)
        finish()
    }

    private fun onSaveBtnClicked() {
        if (editingShopId == null) {
            getPresenter().addShop(shopNameEdit.string(), locationEdit.string(),
                    openingHoursEdit.string())
        } else {
            getPresenter().updateShop(editingShopId!!, shopNameEdit.string(), locationEdit.string(),
                    openingHoursEdit.string())
        }
    }
}