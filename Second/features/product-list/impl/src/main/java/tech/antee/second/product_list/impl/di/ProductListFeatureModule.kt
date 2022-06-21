package tech.antee.second.product_list.impl.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import tech.antee.second.compose_features.Feature
import tech.antee.second.di.keys.FeatureKey
import tech.antee.second.product_list.ProductListFeature
import tech.antee.second.product_list.impl.ProductListFeatureImpl
import javax.inject.Singleton

@Module
interface ProductListFeatureModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureKey(ProductListFeature::class)
    fun productListFeature(feature: ProductListFeatureImpl): Feature
}
