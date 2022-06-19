package tech.antee.second.product_list.impl.di

import dagger.Component
import tech.antee.second.di.scopes.FeatureScope
import tech.antee.second.product_list.impl.ui.ProductListViewModel

@FeatureScope
@Component(
    modules = [ProductListModule::class],
    dependencies = [ProductListDependencies::class]
)
interface ProductListComponent {

    val viewModel: ProductListViewModel

    @Component.Factory
    interface Factory {
        fun create(deps: ProductListDependencies): ProductListComponent
    }
}
