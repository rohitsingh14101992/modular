package demo.m.user.di

import dagger.Component
import dagger.Module
import dagger.Provides
import demo.m.repo_bridge.GetUserRepositoryUseCase
import demo.m.user.details.UserDetailsActivity
import demo.m.user.details.UserDetailsViewModelFactory

@Module
class UserDetailsActivityModule {

    @Provides
    internal fun provideViewModelFactory(
        getUserRepositoryUseCase: GetUserRepositoryUseCase
    ): UserDetailsViewModelFactory =
        UserDetailsViewModelFactory(getUserRepositoryUseCase)

}

@Component(
    modules = [UserDetailsActivityModule::class],
    dependencies = [UserDetailsComponentParent::class]
)
interface UserDetailsComponent {
    fun inject(userDetailsActivity: UserDetailsActivity)
}

interface UserDetailsComponentParent {
    fun getUserRepositoryUseCase(): GetUserRepositoryUseCase
}