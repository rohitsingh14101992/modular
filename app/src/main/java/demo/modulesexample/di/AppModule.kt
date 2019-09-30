package demo.modulesexample.di

import dagger.Module
import demo.m.repository.di.GetUserRepositoryModule
import demo.m.search.di.SearchNavigationModule
import demo.m.user.di.UserDetailsNavigationModule

@Module(
    includes = [NetworkModule::class, SearchNavigationModule::class,
        UserDetailsNavigationModule::class, GetUserRepositoryModule::class]
)
class AppModule