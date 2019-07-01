package demo.m.search.repo

import demo.m.repo_bridge.model.RepositoryResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RepositoryApi {
    @GET("users/{owner}/repos")
    fun getUserRepos(@Path("owner") owner: String): Single<List<RepositoryResponse>>
}