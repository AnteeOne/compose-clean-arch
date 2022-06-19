package tech.antee.second.di.dependencies

import android.app.Application

interface DependenciesHolder {
    val dependenciesMap: DependenciesMap
}

inline fun <reified D : Dependencies> Application.findDependencies(): D {
    val holder = this as? DependenciesHolder
        ?: error("Application must implement ${DependenciesHolder::class.simpleName} interface")
    val dependenciesClass = D::class.java
    return holder.dependenciesMap[dependenciesClass] as? D
        ?: error("No $dependenciesClass in Application: ${dependenciesMap.keys.map { it::class.simpleName }.joinToString()}")
}
