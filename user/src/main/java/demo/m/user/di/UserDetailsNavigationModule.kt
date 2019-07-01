package demo.m.user.di

import dagger.Module
import dagger.Provides
import demo.m.user.navigation.UserDetailsNavigationImpl
import demo.m.user_bridge.UserDetailsViewNavigation

@Module
class UserDetailsNavigationModule {

    @Provides
    fun provideUserDetailsNavigation(): UserDetailsViewNavigation = UserDetailsNavigationImpl()
}