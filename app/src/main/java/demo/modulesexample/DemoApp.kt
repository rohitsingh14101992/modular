package demo.modulesexample

import android.app.Application
import demo.m.base.ParentHost
import demo.modulesexample.di.AppComponent
import demo.modulesexample.di.DaggerAppComponent

class DemoApp : Application(), ParentHost {

    override fun <T> extractParent(): T {
        return component as T
    }


    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.create()
        component.inject(this)
    }
}