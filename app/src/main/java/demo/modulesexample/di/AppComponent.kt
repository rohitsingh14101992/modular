package demo.modulesexample.di

import dagger.Component
import dagger.android.AndroidInjector
import demo.m.search.di.SearchActivityComponentParent
import demo.m.user.di.UserDetailsComponentParent
import demo.modulesexample.DemoApp
import demo.modulesexample.main.MainActivityComponentParent
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class]
)
interface AppComponent : AndroidInjector<DemoApp>, MainActivityComponentParent,
    UserDetailsComponentParent, SearchActivityComponentParent