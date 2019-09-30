package demo.m.repository

import demo.m.repo_bridge.GetUserRepositoryUseCase
import demo.m.repo_bridge.model.RepositoryResponse
import demo.m.search.repo.Repository
import io.reactivex.Single

class GetUserRepositoryUseCaseImpl constructor(private val repository: Repository) :
    GetUserRepositoryUseCase {

    override fun getUserRepositoryList(ownerName: String): Single<List<RepositoryResponse>> =
        repository.getUsersRepo(ownerName)
}