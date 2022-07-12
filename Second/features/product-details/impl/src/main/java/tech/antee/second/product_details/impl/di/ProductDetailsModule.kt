package tech.antee.second.product_details.impl.di

import dagger.Binds
import dagger.Module
import tech.antee.second.product_details.impl.domain.*

@Module
interface ProductDetailsModule {

    @Binds
    fun getProductUsecase(impl: GetProductUsecaseImpl): GetProductUsecase

    @Binds
    fun addProductToCartUsecase(impl: AddProductToCartUsecaseImpl): AddProductToCartUsecase

    @Binds
    fun removeProductFromCartUsecase(impl: RemoveProductFromCartUsecaseImpl): RemoveProductFromCartUsecase
}
