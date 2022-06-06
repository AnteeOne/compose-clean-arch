package tech.antee.second.data.models

sealed interface Result<T> {
    data class Error<T>(val t: Throwable) : Result<T>
    data class Success<T>(val data: T) : Result<T>
}
