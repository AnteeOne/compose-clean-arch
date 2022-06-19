package tech.antee.second.product_details.impl.di

import dagger.Binds
import dagger.Module
import tech.antee.second.product_details.impl.domain.GetProductUsecase
import tech.antee.second.product_details.impl.domain.GetProductUsecaseImpl

@Module
interface ProductDetailsModule {

    @Binds
    fun getProductUsecase(impl: GetProductUsecaseImpl): GetProductUsecase
}
