package demo.m.repo_bridge

import demo.m.repo_bridge.model.RepositoryResponse
import io.reactivex.Single

interface GetUserRepositoryUseCase {
    fun getUserRepositoryList(ownerName: String): Single<List<RepositoryResponse>>
}