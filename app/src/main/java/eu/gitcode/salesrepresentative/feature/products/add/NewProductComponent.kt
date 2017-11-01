package eu.gitcode.salesrepresentative.feature.products.add

import dagger.Subcomponent
import eu.gitcode.salesrepresentative.di.scope.FragmentScope

@FragmentScope
@Subcomponent
interface NewProductComponent {

    fun inject(fragment: NewProductFragment)

    fun getPresenter(): NewProductPresenter
}