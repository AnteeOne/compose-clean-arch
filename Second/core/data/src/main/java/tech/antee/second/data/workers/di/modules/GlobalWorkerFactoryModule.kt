package tech.antee.second.data.workers.di.modules

import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import dagger.Module
import dagger.Provides
import tech.antee.second.data.workers.di.factory.GlobalWorkerFactory
import tech.antee.second.data.workers.di.factory.ProductWorkerFactory

@Module
class GlobalWorkerFactoryModule {

    @Provides
    fun bindWorkersFactory(workerFactories: Map<Class<out ListenableWorker>, @JvmSuppressWildcards ProductWorkerFactory>): WorkerFactory =
        GlobalWorkerFactory(workerFactories)
}
