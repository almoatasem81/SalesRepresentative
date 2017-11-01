package eu.gitcode.salesrepresentative.feature.products.list

import dagger.Subcomponent
import eu.gitcode.salesrepresentative.di.scope.FragmentScope

@FragmentScope
@Subcomponent
interface ProductsComponent {

    fun inject(fragment: ProductsFragment)

    fun getPresenter(): ProductsPresenter
}