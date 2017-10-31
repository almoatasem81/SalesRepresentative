package eu.gitcode.salesrepresentative.feature.shops.list

import dagger.Subcomponent
import eu.gitcode.salesrepresentative.di.scope.FragmentScope

@FragmentScope
@Subcomponent
interface ShopsComponent {

    fun inject(fragment: ShopsFragment)

    fun getPresenter(): ShopsPresenter
}