package tech.antee.second.product_list.impl.di

import dagger.Binds
import dagger.Module
import tech.antee.second.product_list.impl.domain.usecases.GetProductListUsecase
import tech.antee.second.product_list.impl.domain.usecases.GetProductListUsecaseImpl

@Module
interface ProductListModule {

    @Binds
    fun getProductListUsecase(impl: GetProductListUsecaseImpl): GetProductListUsecase
}
