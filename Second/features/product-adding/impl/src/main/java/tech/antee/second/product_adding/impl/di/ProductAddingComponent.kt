package tech.antee.second.product_adding.impl.di

import dagger.Component
import tech.antee.second.di.scopes.FeatureScope
import tech.antee.second.product_adding.impl.ui.ProductAddingViewModel

@FeatureScope
@Component(
    modules = [ProductAddingModule::class],
    dependencies = [ProductAddingDependencies::class]
)
interface ProductAddingComponent {

    val viewModel: ProductAddingViewModel

    @Component.Factory
    interface Factory {
        fun create(deps: ProductAddingDependencies): ProductAddingComponent
    }
}
