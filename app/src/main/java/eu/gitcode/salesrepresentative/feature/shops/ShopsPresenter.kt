package eu.gitcode.salesrepresentative.feature.shops

import com.hannesdorfmann.mosby3.mvp.MvpNullObjectBasePresenter
import eu.gitcode.salesrepresentative.app.scope.FragmentScope
import javax.inject.Inject

@FragmentScope
class ShopsPresenter @Inject constructor()
    : MvpNullObjectBasePresenter<ShopsContract.View>(), ShopsContract.Presenter {

}