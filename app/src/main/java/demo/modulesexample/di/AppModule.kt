package demo.modulesexample.di

import dagger.Module
import dagger.android.AndroidInjectionModule
import demo.m.repository.di.GetUserRepositoryModule
import demo.m.search.di.SearchNavigationModule
import demo.m.user.di.UserDetailsNavigationModule

@Module(includes = [AndroidInjectionModule::class, NetworkModule::class, SearchNavigationModule::class,
    ActivityBuilder::class, UserDetailsNavigationModule::class, GetUserRepositoryModule::class])
class AppModule {

}