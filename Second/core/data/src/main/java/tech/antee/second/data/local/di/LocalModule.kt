package tech.antee.second.data.local.di

import dagger.Module

@Module(includes = [SharedPrefsModule::class, LocalDataSourcesModule::class, LocalMappersModule::class])
interface LocalModule
