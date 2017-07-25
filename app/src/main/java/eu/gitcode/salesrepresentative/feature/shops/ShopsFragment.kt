package eu.gitcode.salesrepresentative.feature.shops

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import eu.gitcode.salesrepresentative.R
import eu.gitcode.salesrepresentative.app.App

class ShopsFragment : MvpFragment<ShopsContract.View, ShopsContract.Presenter>(),
        ShopsContract.View {

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
}