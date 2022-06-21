package tech.antee.second.di

import dagger.Module
import tech.antee.second.data.di.DataModule
import tech.antee.second.navigation.di.NavigationModule

@Module(
    includes = [DataModule::class, NavigationModule::class]
)
interface AppModule
