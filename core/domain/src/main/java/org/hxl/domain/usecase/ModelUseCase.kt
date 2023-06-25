package org.hxl.domain.usecase

interface ModelUseCase<T> {
    suspend fun search(query: String, page: Int): List<T>

}