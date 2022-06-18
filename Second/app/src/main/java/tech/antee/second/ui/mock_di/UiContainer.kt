package tech.antee.second.ui.mock_di

import tech.antee.second.data.mock_di.DataContainer.productRepository
import tech.antee.second.product_adding.impl.domain.usecases.AddProductUsecase
import tech.antee.second.product_adding.impl.ui.ProductAddingViewModel
import tech.antee.second.product_adding.impl.ui.mappers.ProductAddingModelToItemMapper
import tech.antee.second.product_details.impl.domain.GetProductUsecase
import tech.antee.second.product_details.impl.ui.ProductViewModel
import tech.antee.second.product_details.impl.ui.mappers.ProductModelToItemMapper
import tech.antee.second.product_list.impl.domain.usecases.GetProductListUsecase
import tech.antee.second.product_list.impl.ui.ProductListViewModel
import tech.antee.second.product_list.impl.ui.mappers.ProductListModelToItemMapper

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

    val productAddingModelToItemMapper: ProductAddingModelToItemMapper by lazy {
        ProductAddingModelToItemMapper()
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
            productModelToItemMapper = productAddingModelToItemMapper
        )
    }
}
