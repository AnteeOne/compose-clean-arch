package tech.antee.second.data.local.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import tech.antee.second.data.local.shared_preferences.SharedPrefsConfig.PREF_FILE_NAME
import tech.antee.second.di.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
class SharedPrefsModule {

    @Provides
    @Singleton
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
    }
}
