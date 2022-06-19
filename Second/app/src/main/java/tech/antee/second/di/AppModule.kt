package tech.antee.second.di

import dagger.Module
import tech.antee.second.data.di.DataModule

@Module(
    includes = [DataModule::class, NavigationModule::class]
)
interface AppModule
