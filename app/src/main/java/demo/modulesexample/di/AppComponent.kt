package demo.modulesexample.di

import dagger.Component
import dagger.android.AndroidInjector
import demo.modulesexample.DemoApp
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class])
interface AppComponent : AndroidInjector<DemoApp> {
    @Component.Builder
    abstract  class Builder : AndroidInjector.Builder<DemoApp>()

}