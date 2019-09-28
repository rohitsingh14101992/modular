package demo.modulesexample

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import demo.m.base.ParentHost
import demo.modulesexample.di.AppComponent
import demo.modulesexample.di.DaggerAppComponent
import javax.inject.Inject

class DemoApp : Application(), HasActivityInjector, ParentHost {

    override fun <T> extractParent(): T {
        return component as T
    }

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.create()
        component.inject(this)
    }
}