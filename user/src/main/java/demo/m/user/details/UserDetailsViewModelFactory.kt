package demo.m.user.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import demo.m.repo_bridge.GetUserRepositoryUseCase

class UserDetailsViewModelFactory constructor(val getUserRepositoryUseCase: GetUserRepositoryUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserDetailsViewModel::class.java)) {
            return UserDetailsViewModel(getUserRepositoryUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}