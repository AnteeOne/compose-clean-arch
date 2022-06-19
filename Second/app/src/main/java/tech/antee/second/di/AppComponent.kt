package tech.antee.second.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import tech.antee.second.App
import tech.antee.second.di.qualifiers.ApplicationContext
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class]
)
interface AppComponent : AppProvider {

    fun inject(app: App)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @ApplicationContext
            context: Context
        ): AppComponent
    }
}
