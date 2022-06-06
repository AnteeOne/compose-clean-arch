package tech.antee.second.data.mock_di

import tech.antee.second.data.data_sources.ProductRemoteDataSource
import tech.antee.second.data.data_sources.ProductRemoteDataSourceImpl
import tech.antee.second.data.mappers.ProductDtoToModelMapper
import tech.antee.second.data.mappers.ProductListDtoToModelMapper
import tech.antee.second.data.repository.ProductRepositoryImpl
import tech.antee.second.domain.repository.ProductRepository

object DataContainer {

    val productListDtoToModelMapper: ProductListDtoToModelMapper by lazy { ProductListDtoToModelMapper() }

    val productDtoToModelMapper: ProductDtoToModelMapper by lazy { ProductDtoToModelMapper() }

    val remoteProductDataSource: ProductRemoteDataSource by lazy { ProductRemoteDataSourceImpl() }

    val productRepository: ProductRepository by lazy {
        ProductRepositoryImpl(
            remoteProductDataSource = remoteProductDataSource,
            productListDtoToModelMapper = productListDtoToModelMapper,
            productDtoToModelMapper = productDtoToModelMapper
        )
    }
}
