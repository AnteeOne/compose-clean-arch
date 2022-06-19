package tech.antee.second.data.di

import dagger.Module
import dagger.Provides
import tech.antee.second.data.mappers.ProductDetailsToListDtoMapper
import tech.antee.second.data.mappers.ProductDtoToModelMapper
import tech.antee.second.data.mappers.ProductListDtoToModelMapper
import javax.inject.Singleton

@Module
class MappersModule {

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
