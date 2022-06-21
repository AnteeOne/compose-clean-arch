package tech.antee.second.data.extensions

class NotFoundProductException(guid: String) : IllegalStateException(guid)

fun productNotFoundError(guid: String): Nothing = throw NotFoundProductException(guid)
