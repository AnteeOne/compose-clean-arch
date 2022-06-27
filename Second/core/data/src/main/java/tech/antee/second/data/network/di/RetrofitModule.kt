package tech.antee.second.data.network.di

import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.antee.second.data.network.retrofit.NetworkConfig
import tech.antee.second.data.network.retrofit.ProductService
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun productsService(retrofit: Retrofit): ProductService = retrofit.create(ProductService::class.java)

    @Provides
    @Singleton
    fun retrofit(converterFactory: Converter.Factory): Retrofit = Retrofit.Builder()
        .baseUrl(NetworkConfig.API_URL)
        .addConverterFactory(converterFactory)
        .build()

    @Provides
    @Singleton
    fun converterFactory(): Converter.Factory = GsonConverterFactory.create()
}
