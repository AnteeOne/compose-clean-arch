package tech.antee.second.product_details.impl.di

import dagger.Component
import tech.antee.second.di.scopes.FeatureScope
import tech.antee.second.product_details.impl.ui.ProductViewModel

@FeatureScope
@Component(
    modules = [ProductDetailsModule::class],
    dependencies = [ProductDetailsDependencies::class]
)
interface ProductDetailsComponent {

    val viewModel: ProductViewModel

    @Component.Factory
    interface Factory {
        fun create(deps: ProductDetailsDependencies): ProductDetailsComponent
    }
}
