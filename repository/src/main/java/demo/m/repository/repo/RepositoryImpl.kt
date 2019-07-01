package demo.m.search.repo

import demo.m.repo_bridge.model.RepositoryResponse
import io.reactivex.Single

class RepositoryImpl constructor(private val repoServiceApi: RepositoryApi) : Repository {

    override fun getUsersRepo(ownerName: String): Single<List<RepositoryResponse>> =
        repoServiceApi.getUserRepos(ownerName)
}