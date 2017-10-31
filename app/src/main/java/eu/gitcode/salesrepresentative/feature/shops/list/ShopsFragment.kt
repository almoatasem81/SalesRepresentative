package eu.gitcode.salesrepresentative.feature.shops.list

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
import eu.gitcode.salesrepresentative.data.shop.model.Shop
import eu.gitcode.salesrepresentative.feature.shops.add.NewShopActivity
import kotlinx.android.synthetic.main.shops_fragment.*

class ShopsFragment : MvpFragment<ShopsContract.View, ShopsContract.Presenter>(),
        ShopsContract.View, ShopViewHolder.ShopViewHolderListener {

    lateinit var adapter: ShopsAdapter

    override fun createPresenter(): ShopsContract.Presenter {
        val component = App.Factory.getApplicationComponent(context)
                .plusShopsComponent()
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
                { startActivityForResult<NewShopActivity>(NewShopActivity.SHOP_ADDED_REQUEST_CODE) })
        setupRecyclerView()
        getPresenter().loadShops()
    }

    override fun showShops(shops: List<Shop>) {
        adapter.setShops(shops)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        getPresenter().loadShops()
    }

    override fun onShopClicked(shop: Shop) {
        AlertDialog.Builder(context)
                .setTitle(shop.name)
                .setMessage(String.format("%s \n%s", shop.location, shop.openingHours))
                .setPositiveButton(getString(R.string.edit), { dialog, which -> editShop(shop.id) })
                .setNeutralButton(getString(R.string.close), { dialog, which -> })
                .setNegativeButton(getString(R.string.remove),
                        { dialog, which -> showAreYouSureDialog(shop) })
                .create().show()
    }

    private fun setupRecyclerView() {
        adapter = ShopsAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun editShop(shopId: Long) {
        NewShopActivity.startActivityIntent(
                this, shopId, NewShopActivity.SHOP_ADDED_REQUEST_CODE)
    }

    private fun showAreYouSureDialog(shop: Shop) {
        AlertDialog.Builder(context)
                .setTitle(R.string.remove)
                .setMessage(R.string.are_you_sure_remove)
                .setPositiveButton(R.string.ok,
                        { dialog, which -> getPresenter().removeShop(shop.id) })
                .setNegativeButton(R.string.cancel, { dialog, which -> })
                .create().show()
    }
}