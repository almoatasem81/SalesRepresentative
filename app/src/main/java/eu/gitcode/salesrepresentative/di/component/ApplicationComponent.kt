package eu.gitcode.salesrepresentative.di.component

import dagger.Component
import eu.gitcode.salesrepresentative.di.module.ApplicationModule
import eu.gitcode.salesrepresentative.di.module.RepositoryModule
import eu.gitcode.salesrepresentative.feature.shops.add.NewShopComponent
import eu.gitcode.salesrepresentative.feature.shops.list.ShopsComponent
import javax.inject.Singleton

@Suppress("RedundantVisibilityModifier")
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, RepositoryModule::class))
public interface ApplicationComponent {
    fun plusShopsComponent(): ShopsComponent

    fun plusNewShopComponent(): NewShopComponent

}