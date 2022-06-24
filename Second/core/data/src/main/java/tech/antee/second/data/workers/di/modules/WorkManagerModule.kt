package tech.antee.second.data.workers.di.modules

import android.content.Context
import androidx.work.WorkManager
import dagger.Module
import dagger.Provides
import tech.antee.second.di.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
class WorkManagerModule {

    @Provides
    @Singleton
    fun workManager(@ApplicationContext context: Context): WorkManager = WorkManager.getInstance(context)
}
