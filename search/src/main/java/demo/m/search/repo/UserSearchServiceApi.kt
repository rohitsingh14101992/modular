package demo.m.search.repo

import demo.m.search_bridge.model.UserResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UserSearchServiceApi {
    @GET("search/users") // https://developer.github.com/v3/search/#search-users
    fun searchUser(@Query("q") query: String): Single<UserResult>
}