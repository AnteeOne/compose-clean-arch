package tech.antee.second

import android.app.Application
import androidx.work.Configuration
import androidx.work.WorkManager
import androidx.work.WorkerFactory
import tech.antee.second.di.AppProvider
import tech.antee.second.di.DaggerAppComponent
import javax.inject.Inject

class App : Application() {

    lateinit var appProvider: AppProvider

    @Inject
    lateinit var workerFactory: WorkerFactory

    override fun onCreate() {
        super.onCreate()
        appProvider = DaggerAppComponent.factory().create(this).apply {
            inject(this@App)
        }
        WorkManager.initialize(this, Configuration.Builder().setWorkerFactory(workerFactory).build())
    }
}

val Application.appProvider: AppProvider
    get() = (this as App).appProvider
