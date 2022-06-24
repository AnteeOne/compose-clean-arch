package tech.antee.second.data.workers.di.modules

import dagger.Binds
import dagger.Module
import tech.antee.second.data.workers.domain.usecases.FetchProductDetailsUsecase
import tech.antee.second.data.workers.domain.usecases.FetchProductDetailsUsecaseImpl
import tech.antee.second.data.workers.domain.usecases.FetchProductInListUsecase
import tech.antee.second.data.workers.domain.usecases.FetchProductInListUsecaseImpl

@Module
interface FetchUsecasesModule {

    @Binds
    fun fetchProductDetailsUsecase(impl: FetchProductDetailsUsecaseImpl): FetchProductDetailsUsecase

    @Binds
    fun fetchProductInListUsecase(impl: FetchProductInListUsecaseImpl): FetchProductInListUsecase
}
