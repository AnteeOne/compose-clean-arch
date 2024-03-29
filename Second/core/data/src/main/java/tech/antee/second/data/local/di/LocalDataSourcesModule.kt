package tech.antee.second.data.local.di

import dagger.Binds
import dagger.Module
import tech.antee.second.data.local.data_sources.ProductLocalDataSource
import tech.antee.second.data.local.data_sources.ProductLocalDataSourceImpl
import tech.antee.second.data.local.data_sources.ShopCartDataSource
import tech.antee.second.data.local.data_sources.ShopCartDataSourceImpl
import javax.inject.Singleton

@Module
interface LocalDataSourcesModule {

    @Binds
    @Singleton
    fun productLocalDataSource(impl: ProductLocalDataSourceImpl): ProductLocalDataSource

    @Binds
    @Singleton
    fun shopCartDataSource(impl: ShopCartDataSourceImpl): ShopCartDataSource
}
