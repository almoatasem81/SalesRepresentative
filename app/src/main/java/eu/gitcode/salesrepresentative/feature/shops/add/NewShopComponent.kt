package eu.gitcode.salesrepresentative.feature.shops.add

import dagger.Subcomponent
import eu.gitcode.salesrepresentative.di.scope.FragmentScope

@FragmentScope
@Subcomponent
interface NewShopComponent {

    fun inject(fragment: NewShopFragment)

    fun getPresenter(): NewShopPresenter
}