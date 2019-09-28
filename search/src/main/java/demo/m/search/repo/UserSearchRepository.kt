package demo.m.search.repo

import demo.m.search_bridge.model.UserResult
import io.reactivex.Single

interface UserSearchRepository {
    fun getUsers(userName: String): Single<UserResult>
}