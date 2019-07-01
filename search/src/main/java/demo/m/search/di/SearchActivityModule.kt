package demo.m.search.di

import dagger.Module
import dagger.Provides
import demo.m.base.ScreenScope
import demo.m.search.repo.UserSearchRepository
import demo.m.search.repo.UserSearchRepositoryImpl
import demo.m.search.repo.UserSearchServiceApi
import demo.m.search.screen.SearchActivityViewIntent
import demo.m.search.screen.SearchActivityViewModelFactory
import demo.m.user_bridge.UserDetailsViewNavigation
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import retrofit2.Retrofit

@Module
class SearchActivityModule {

    @Provides
    fun provideUserSearchApi(retrofit: Retrofit) : UserSearchServiceApi =
        retrofit.create(UserSearchServiceApi::class.java)

    @Provides
    fun providesUserSearchRepository(userSearchServiceApi: UserSearchServiceApi) :
            UserSearchRepository = UserSearchRepositoryImpl(userSearchServiceApi)

    @ScreenScope
    @Provides
    internal
    fun providesViewIntentSubject(): PublishSubject<SearchActivityViewIntent> = PublishSubject.create()

    @Provides
    internal
    fun providesViewIntentObservable(subject: PublishSubject<SearchActivityViewIntent>)
            : Observable<SearchActivityViewIntent> = subject.hide()

    @Provides
    internal fun provideViewModelFactory(
        repository: UserSearchRepository,
        subject: PublishSubject<SearchActivityViewIntent>,
        userDetailsViewNavigation: UserDetailsViewNavigation
    ): SearchActivityViewModelFactory =
        SearchActivityViewModelFactory(repository, subject, userDetailsViewNavigation)

}