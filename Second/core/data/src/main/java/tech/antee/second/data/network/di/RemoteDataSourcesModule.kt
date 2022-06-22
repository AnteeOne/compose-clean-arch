package tech.antee.second.data.network.di

import dagger.Binds
import dagger.Module
import tech.antee.second.data.network.data_sources.ProductRemoteDataSource
import tech.antee.second.data.network.data_sources.ProductRemoteDataSourceImpl
import javax.inject.Singleton

@Module
interface RemoteDataSourcesModule {

    @Binds
    @Singleton
    fun productRemoteDataSource(impl: ProductRemoteDataSourceImpl): ProductRemoteDataSource
}
