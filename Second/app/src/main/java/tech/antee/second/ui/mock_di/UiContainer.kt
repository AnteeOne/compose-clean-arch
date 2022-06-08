package tech.antee.second.ui.mock_di

import tech.antee.second.data.mock_di.DataContainer.productRepository
import tech.antee.second.domain.usecases.AddProductUsecase
import tech.antee.second.domain.usecases.GetProductListUsecase
import tech.antee.second.domain.usecases.GetProductUsecase
import tech.antee.second.ui.product.ProductViewModel
import tech.antee.second.ui.product.mappers.ProductModelToItemMapper
import tech.antee.second.ui.product_adding.ProductAddingViewModel
import tech.antee.second.ui.product_list.ProductListViewModel
import tech.antee.second.ui.product_list.mappers.ProductListModelToItemMapper

object UiContainer {

    val getProductListUsecase: GetProductListUsecase by lazy {
        GetProductListUsecase(productRepository)
    }

    val getProductUsecase: GetProductUsecase by lazy {
        GetProductUsecase(productRepository)
    }

    val addProductUsecase: AddProductUsecase by lazy {
        AddProductUsecase(productRepository)
    }

    val productModelToItemMapper: ProductModelToItemMapper by lazy {
        ProductModelToItemMapper()
    }

    val productListModelToItemMapper: ProductListModelToItemMapper by lazy {
        ProductListModelToItemMapper()
    }

    val productListViewModel: ProductListViewModel by lazy {
        ProductListViewModel(
            getProductListUsecase = getProductListUsecase,
            mapper = productListModelToItemMapper
        )
    }

    val productViewModel: ProductViewModel by lazy {
        ProductViewModel(
            getProductUsecase = getProductUsecase,
            mapper = productModelToItemMapper
        )
    }

    val productAddingViewModel: ProductAddingViewModel by lazy {
        ProductAddingViewModel(
            addProductUsecase = addProductUsecase,
            productModelToItemMapper = productModelToItemMapper
        )
    }
}
