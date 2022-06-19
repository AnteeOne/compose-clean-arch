package tech.antee.second.di.keys

import dagger.MapKey
import tech.antee.second.di.dependencies.Dependencies
import kotlin.reflect.KClass

@MapKey
annotation class DependenciesKey(val value: KClass<out Dependencies>)
