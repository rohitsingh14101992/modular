package demo.m.search_bridge.model

import demo.m.base.model.User

data class UserResult(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<User>
)