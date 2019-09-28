package demo.m.base

import android.app.Application
import android.content.Context



inline fun <reified T : Any> Context.parent(): T? {
    var ctx = this
    while (ctx !is Application) {
        ctx = ctx.applicationContext
    }
    if(ctx is ParentHost){
        return ctx.extractParent<T>()
    }
    return null
}

interface ParentHost {

    fun <T> extractParent(): T

}