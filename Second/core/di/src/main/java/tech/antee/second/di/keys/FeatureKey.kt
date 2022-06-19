package tech.antee.second.di.keys

import dagger.MapKey
import tech.antee.second.compose_features.Feature
import kotlin.reflect.KClass

@MapKey
annotation class FeatureKey(val value: KClass<out Feature>)
