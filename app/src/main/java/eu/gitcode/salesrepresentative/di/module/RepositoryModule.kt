package eu.gitcode.salesrepresentative.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import eu.gitcode.salesrepresentative.data.product.model.MyObjectBox
import io.objectbox.BoxStore
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    internal fun provideObjectBox(context: Context): BoxStore {
        return MyObjectBox.builder().androidContext(context).build()
    }
}