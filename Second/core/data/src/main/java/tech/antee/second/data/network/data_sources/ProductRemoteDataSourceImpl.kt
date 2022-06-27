package tech.antee.second.data.network.data_sources

import tech.antee.second.data.network.models.ProductDto
import tech.antee.second.data.network.models.ProductInListDto
import tech.antee.second.data.network.retrofit.ProductService
import javax.inject.Inject

class ProductRemoteDataSourceImpl @Inject constructor(
    private val productService: ProductService
) : ProductRemoteDataSource {

    override suspend fun fetchProductList(): List<ProductInListDto> {
        return productService.getProductList()
    }

    override suspend fun fetchProductDetailsList(): List<ProductDto> {
        return productService.getProductDetailsList()
    }
}
