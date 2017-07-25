package eu.gitcode.salesrepresentative.feature.shops

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import eu.gitcode.salesrepresentative.R
import eu.gitcode.salesrepresentative.app.App
import eu.gitcode.salesrepresentative.model.Shop
import kotlinx.android.synthetic.main.shops_fragment.*

class ShopsFragment : MvpFragment<ShopsContract.View, ShopsContract.Presenter>(),
        ShopsContract.View {

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
        setupRecyclerView()
        getPresenter().loadShops()
    }

    override fun showShops(shops: List<Shop>) {
        adapter.setShops(shops)
    }

    private fun setupRecyclerView() {
        adapter = ShopsAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }
}