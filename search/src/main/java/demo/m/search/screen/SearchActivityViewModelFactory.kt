package demo.m.search.screen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import demo.m.search.repo.UserSearchRepository
import demo.m.user_bridge.UserDetailsViewNavigation
import io.reactivex.subjects.PublishSubject

class SearchActivityViewModelFactory constructor(
    val repository: UserSearchRepository,
    val subjectViewIntent:
    PublishSubject<SearchActivityViewIntent>,
    val userDetailsViewNavigation: UserDetailsViewNavigation
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchUserViewModel::class.java)) {
            return SearchUserViewModel(
                repository,
                subjectViewIntent,
                userDetailsViewNavigation
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}