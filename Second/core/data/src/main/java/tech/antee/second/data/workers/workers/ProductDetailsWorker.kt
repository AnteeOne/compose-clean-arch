package tech.antee.second.data.workers.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import tech.antee.second.domain.models.EmptySuccess
import tech.antee.second.data.workers.di.factory.ProductWorkerFactory
import tech.antee.second.data.workers.domain.usecases.FetchProductDetailsUsecase
import javax.inject.Inject

class ProductDetailsWorker(
    context: Context,
    workerParameters: WorkerParameters,
    private val fetchProductDetailsUsecase: FetchProductDetailsUsecase
) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result =
        when (fetchProductDetailsUsecase()) {
            is EmptySuccess -> Result.success()
            else -> Result.failure()
        }

    class Factory @Inject constructor(
        private val fetchProductDetailsUsecase: FetchProductDetailsUsecase
    ) : ProductWorkerFactory {

        override fun create(appContext: Context, params: WorkerParameters): CoroutineWorker =
            ProductDetailsWorker(appContext, params, fetchProductDetailsUsecase)
    }
}
