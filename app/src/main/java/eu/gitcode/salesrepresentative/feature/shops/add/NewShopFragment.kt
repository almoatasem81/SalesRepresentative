package eu.gitcode.salesrepresentative.feature.shops.add

import android.app.Activity
import android.app.ProgressDialog
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
import kotlinx.android.synthetic.main.new_shop_fragment.*

class NewShopFragment : MvpFragment<NewShopContract.View, NewShopContract.Presenter>(),
        NewShopContract.View {
    override fun closeView() {
        setResult(Activity.RESULT_OK)
        finish()
    }

    private val component by lazy { App.getApplicationComponent(context).plusNewShopComponent() }

    private var progressDialog: ProgressDialog? = null

    override fun createPresenter(): NewShopContract.Presenter = component.getPresenter()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.new_shop_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saveBtn.setOnClickListener { onSaveBtnClicked() }
    }

    private fun onSaveBtnClicked() {
        getPresenter().addShop(shopNameEdit.string(), locationEdit.string(),
                openingHoursEdit.string())
    }
}