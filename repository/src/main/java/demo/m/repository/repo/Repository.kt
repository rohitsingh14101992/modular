package demo.m.search.repo


import demo.m.repo_bridge.model.RepositoryResponse
import io.reactivex.Single

interface Repository {
    fun getUsersRepo(ownerName: String): Single<List<RepositoryResponse>>
}