package demo.m.search.screen

import demo.m.base.model.User

sealed class SearchActivityViewIntent {
    data class NavigateToUserScreen(val user: User) : SearchActivityViewIntent()
}