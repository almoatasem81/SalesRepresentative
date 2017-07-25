package eu.gitcode.salesrepresentative.app

import dagger.Component
import eu.gitcode.salesrepresentative.feature.shops.ShopsComponent
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun plusShopsComponent(): ShopsComponent
}