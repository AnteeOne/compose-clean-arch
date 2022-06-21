package tech.antee.second.product_adding.impl.di

import dagger.Binds
import dagger.Module
import tech.antee.second.product_adding.impl.domain.usecases.AddProductUsecase
import tech.antee.second.product_adding.impl.domain.usecases.AddProductUsecaseImpl

@Module
interface ProductAddingModule {

    @Binds
    fun addProductUsecase(impl: AddProductUsecaseImpl): AddProductUsecase
}
