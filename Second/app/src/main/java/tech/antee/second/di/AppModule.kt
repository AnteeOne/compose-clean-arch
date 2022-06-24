package tech.antee.second.di

import dagger.Module
import tech.antee.second.data.di.DataModule
import tech.antee.second.navigation.di.NavigationModule
import tech.antee.second.data.workers.di.modules.ProductFetchModule

@Module(
    includes = [DataModule::class, NavigationModule::class, ProductFetchModule::class]
)
interface AppModule
