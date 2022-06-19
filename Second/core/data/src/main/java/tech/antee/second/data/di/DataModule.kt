package tech.antee.second.data.di

import dagger.Binds
import dagger.Module
import tech.antee.second.data.repository.ProductRepositoryImpl
import tech.antee.second.domain.repositories.ProductRepository
import javax.inject.Singleton

@Module(
    includes = [MappersModule::class, DataSourcesModule::class]
)
interface DataModule {

    @Binds
    @Singleton
    fun productRepository(impl: ProductRepositoryImpl): ProductRepository
}
