package tech.antee.second.data.network.di

import dagger.Module

@Module(includes = [RetrofitModule::class, RemoteDataSourcesModule::class, RemoteDataSourcesModule::class])
interface RemoteModule
