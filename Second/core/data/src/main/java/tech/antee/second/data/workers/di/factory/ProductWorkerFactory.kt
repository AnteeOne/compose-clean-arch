package tech.antee.second.data.workers.di.factory

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import tech.antee.second.di.qualifiers.ApplicationContext

interface ProductWorkerFactory {
    fun create(@ApplicationContext appContext: Context, params: WorkerParameters): ListenableWorker
}
