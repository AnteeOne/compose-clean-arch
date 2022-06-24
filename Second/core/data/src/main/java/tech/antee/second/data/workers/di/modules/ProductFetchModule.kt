package tech.antee.second.data.workers.di.modules

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import tech.antee.second.data.workers.ProductFetchStarter
import tech.antee.second.data.workers.ProductFetchStarterImpl
import tech.antee.second.data.workers.di.factory.ProductWorkerFactory
import tech.antee.second.data.workers.di.keys.WorkerKey
import tech.antee.second.data.workers.workers.ProductDetailsWorker
import tech.antee.second.data.workers.workers.ProductInListWorker

@Module(includes = [GlobalWorkerFactoryModule::class, FetchUsecasesModule::class, WorkManagerModule::class])
interface ProductFetchModule {

    @Binds
    fun bindProductFetchStarter(impl: ProductFetchStarterImpl): ProductFetchStarter

    @Binds
    @IntoMap
    @WorkerKey(ProductInListWorker::class)
    fun bindProductInListWorkerFactory(impl: ProductInListWorker.Factory): ProductWorkerFactory

    @Binds
    @IntoMap
    @WorkerKey(ProductDetailsWorker::class)
    fun bindProductDetailsWorkerFactory(impl: ProductDetailsWorker.Factory): ProductWorkerFactory
}
