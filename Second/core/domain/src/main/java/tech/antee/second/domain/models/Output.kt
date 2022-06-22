package tech.antee.second.domain.models

sealed interface Output<T> {
    data class Error<T>(val t: Throwable) : Output<T>
    data class Success<T>(val data: T) : Output<T>
}

typealias EmptyOutput = Output<Unit>

object EmptySuccess : Output<Unit>
