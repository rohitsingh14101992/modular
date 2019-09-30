package demo.modulesexample.main

import dagger.Component
import dagger.Module
import dagger.Provides
import demo.m.base.ScreenScope
import demo.m.search_bridge.SearchViewNavigation
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject


@Module
class MainActivityModule {

    @ScreenScope
    @Provides
    internal
    fun providesViewIntentSubject(): PublishSubject<MainActivityViewIntent> =
        PublishSubject.create()

    @Provides
    internal
    fun providesViewIntentObservable(subject: PublishSubject<MainActivityViewIntent>)
            : Observable<MainActivityViewIntent> = subject.hide()

    @Provides
    internal fun provideViewModelFactory(
        searchViewNavigation: SearchViewNavigation,
        subject: PublishSubject<MainActivityViewIntent>
    ): MainActivityViewModelFactory =
        MainActivityViewModelFactory(searchViewNavigation, subject)
}


@ScreenScope
@Component(
    dependencies = [MainActivityComponentParent::class],
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {
    fun inject(activity: MainActivity)
}

interface MainActivityComponentParent {
    fun searchViewNavigation(): SearchViewNavigation
}
