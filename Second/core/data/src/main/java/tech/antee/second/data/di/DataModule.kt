package tech.antee.second.data.di

import dagger.Binds
import dagger.Module
import tech.antee.second.data.local.di.LocalModule
import tech.antee.second.data.network.di.RemoteModule
import tech.antee.second.data.repository.ProductRepositoryImpl
import tech.antee.second.domain.repositories.ProductRepository
import javax.inject.Singleton

@Module(
    includes = [RemoteModule::class, LocalModule::class, CommonMappersModule::class]
)
interface DataModule {

    @Binds
    @Singleton
    fun productRepository(impl: ProductRepositoryImpl): ProductRepository
}
