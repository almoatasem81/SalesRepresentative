package eu.gitcode.salesrepresentative.di.component

import dagger.Component
import eu.gitcode.salesrepresentative.di.module.ApplicationModule
import eu.gitcode.salesrepresentative.feature.shops.ShopsComponent
import javax.inject.Singleton

@Suppress("RedundantVisibilityModifier")
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
public interface ApplicationComponent {
    fun plusShopsComponent(): ShopsComponent
}