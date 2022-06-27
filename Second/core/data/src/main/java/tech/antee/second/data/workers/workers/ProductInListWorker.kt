package tech.antee.second.data.workers.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import tech.antee.second.domain.models.EmptySuccess
import tech.antee.second.data.workers.di.factory.ProductWorkerFactory
import tech.antee.second.data.workers.domain.usecases.FetchProductInListUsecase
import javax.inject.Inject

class ProductInListWorker(
    context: Context,
    workerParameters: WorkerParameters,
    private val fetchProductInListUsecase: FetchProductInListUsecase
) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result =
        when (fetchProductInListUsecase()) {
            is EmptySuccess -> Result.success()
            else -> Result.failure()
        }

    class Factory @Inject constructor(
        private val fetchProductInListUsecase: FetchProductInListUsecase
    ) : ProductWorkerFactory {

        override fun create(appContext: Context, params: WorkerParameters): CoroutineWorker =
            ProductInListWorker(appContext, params, fetchProductInListUsecase)
    }
}
