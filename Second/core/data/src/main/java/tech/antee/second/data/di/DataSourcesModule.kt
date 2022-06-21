package tech.antee.second.data.di

import dagger.Binds
import dagger.Module
import tech.antee.second.data.data_sources.ProductRemoteDataSource
import tech.antee.second.data.data_sources.ProductRemoteDataSourceImpl
import javax.inject.Singleton

@Module
interface DataSourcesModule {

    @Binds
    @Singleton
    fun productRemoteDataSource(impl: ProductRemoteDataSourceImpl): ProductRemoteDataSource
}
