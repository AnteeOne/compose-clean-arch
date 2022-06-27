package tech.antee.second.data.local.di

import dagger.Module
import dagger.Provides
import tech.antee.second.data.local.mappers.ProductDetailsToListEntityMapper
import tech.antee.second.data.local.mappers.ProductEntityToModelMapper
import tech.antee.second.data.local.mappers.ProductListEntityToModelMapper
import javax.inject.Singleton

@Module
class LocalMappersModule {

    @Provides
    @Singleton
    fun productListEntityToModelMapper(): ProductListEntityToModelMapper = ProductListEntityToModelMapper()

    @Provides
    @Singleton
    fun productEntityToModelMapper(): ProductEntityToModelMapper = ProductEntityToModelMapper()

    @Provides
    @Singleton
    fun productDetailsToListEntityMapper(): ProductDetailsToListEntityMapper = ProductDetailsToListEntityMapper()
}
