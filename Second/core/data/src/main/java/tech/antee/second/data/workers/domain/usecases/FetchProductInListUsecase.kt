package tech.antee.second.data.workers.domain.usecases

import tech.antee.second.domain.models.EmptyOutput

interface FetchProductInListUsecase { // TODO: separate to another module

    suspend operator fun invoke(): EmptyOutput
}
