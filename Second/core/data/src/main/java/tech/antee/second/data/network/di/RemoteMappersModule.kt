package tech.antee.second.data.network.di

import dagger.Module
import dagger.Provides
import tech.antee.second.data.network.mappers.ProductDetailsToListDtoMapper
import tech.antee.second.data.network.mappers.ProductDtoToModelMapper
import tech.antee.second.data.network.mappers.ProductListDtoToModelMapper
import javax.inject.Singleton

@Module
class RemoteMappersModule {

    @Provides
    @Singleton
    fun productListDtoToModelMapper(): ProductListDtoToModelMapper = ProductListDtoToModelMapper()

    @Provides
    @Singleton
    fun productDtoToModelMapper(): ProductDtoToModelMapper = ProductDtoToModelMapper()

    @Provides
    @Singleton
    fun productDetailsToListDtoMapper(): ProductDetailsToListDtoMapper = ProductDetailsToListDtoMapper()
}
