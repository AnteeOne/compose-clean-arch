package tech.antee.second.data.workers

import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import tech.antee.second.data.workers.workers.ProductDetailsWorker
import tech.antee.second.data.workers.workers.ProductInListWorker
import javax.inject.Inject

class ProductFetchStarterImpl @Inject constructor(
    private val workManager: WorkManager
) : ProductFetchStarter {

    private val tag = "product_fetch_worker"

    override fun start() {
        val productInListRequest = OneTimeWorkRequest.Builder(ProductInListWorker::class.java).addTag(tag).build()
        val productDetailsRequest = OneTimeWorkRequest.Builder(ProductDetailsWorker::class.java).addTag(tag).build()
        workManager.beginWith(productInListRequest).then(productDetailsRequest).enqueue()
    }

    override fun stop() {
        workManager.cancelAllWorkByTag(tag)
    }
}
