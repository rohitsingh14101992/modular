package demo.modulesexample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import demo.m.base.ScreenScope
import demo.m.search.di.SearchActivityModule
import demo.m.search.screen.SearchActivity
import demo.m.user.details.UserDetailsActivity
import demo.m.user.di.UserDetailsActivityModule
import demo.modulesexample.main.MainActivity
import demo.modulesexample.main.MainActivityModule

@Module
abstract class ActivityBuilder {

    @ScreenScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ScreenScope
    @ContributesAndroidInjector(modules = [SearchActivityModule::class])
    abstract fun contributeSearchActivityModule(): SearchActivity

    @ContributesAndroidInjector(modules = [UserDetailsActivityModule::class])
    abstract fun contributeUserDetailsActivityModule(): UserDetailsActivity
}