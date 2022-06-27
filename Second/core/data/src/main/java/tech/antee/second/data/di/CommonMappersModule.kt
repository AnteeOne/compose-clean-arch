package tech.antee.second.data.di

import dagger.Module
import dagger.Provides
import tech.antee.second.data.mappers.ProductDtoToEntityMapper
import tech.antee.second.data.mappers.ProductListDtoToEntityMapper
import javax.inject.Singleton

@Module
class CommonMappersModule {

    @Provides
    @Singleton
    fun productListDtoToEntityMapper(): ProductListDtoToEntityMapper = ProductListDtoToEntityMapper()

    @Provides
    @Singleton
    fun productDtoToEntityMapper(): ProductDtoToEntityMapper = ProductDtoToEntityMapper()
}
