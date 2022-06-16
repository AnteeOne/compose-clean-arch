package tech.antee.second.compose_features

typealias Destinations = Map<Class<out Feature>, @JvmSuppressWildcards Feature>

inline fun <reified T : Feature> Destinations.find(): T =
    findOrNull() ?: error("Unable to find '${T::class.java}' destination.")

inline fun <reified T : Feature> Destinations.findOrNull(): T? =
    this[T::class.java] as? T
