package eu.gitcode.salesrepresentative.app

import android.app.Application
import android.content.Context
import eu.gitcode.salesrepresentative.BuildConfig
import eu.gitcode.salesrepresentative.di.component.ApplicationComponent
import eu.gitcode.salesrepresentative.di.component.DaggerApplicationComponent
import eu.gitcode.salesrepresentative.di.module.ApplicationModule
import timber.log.Timber

class App : Application() {

    private val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    init {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object Factory {
        fun getApplicationComponent(context: Context): ApplicationComponent =
                (context.applicationContext as App).applicationComponent
    }
}