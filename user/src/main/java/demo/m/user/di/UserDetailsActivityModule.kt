package demo.m.user.di

import dagger.Module
import dagger.Provides
import demo.m.repo_bridge.GetUserRepositoryUseCase
import demo.m.user.details.UserDetailsViewModelFactory

@Module
class UserDetailsActivityModule {

    @Provides
    internal fun provideViewModelFactory(
        getUserRepositoryUseCase: GetUserRepositoryUseCase
    ): UserDetailsViewModelFactory =
        UserDetailsViewModelFactory(getUserRepositoryUseCase)

}