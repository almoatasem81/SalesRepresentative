package eu.gitcode.salesrepresentative.feature.shops

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface ShopsContract {

    interface View : MvpView {

    }

    interface Presenter : MvpPresenter<View> {

    }
}