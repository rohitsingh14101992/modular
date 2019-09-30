package demo.m.search.di

import dagger.Module
import dagger.Provides
import demo.m.search.plan.SearchViewNavigationImpl
import demo.m.search_bridge.SearchViewNavigation

@Module
class SearchNavigationModule {

    @Provides
    fun provideSearchViewNavigation(): SearchViewNavigation = SearchViewNavigationImpl()
}