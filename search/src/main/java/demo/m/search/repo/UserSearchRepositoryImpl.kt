package demo.m.search.repo

import demo.m.search_bridge.model.UserResult
import io.reactivex.Single
import retrofit2.Retrofit

class UserSearchRepositoryImpl constructor(private val userSearchServiceApi: UserSearchServiceApi) : UserSearchRepository {

    override fun getUsers(userName: String): Single<UserResult> = userSearchServiceApi.searchUser(userName)
}