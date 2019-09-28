package demo.modulesexample.main

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import demo.m.search_bridge.SearchViewNavigation
import io.reactivex.subjects.PublishSubject

class MainActivityViewModel constructor(
    private val searchViewNavigation: SearchViewNavigation,
    private val subject: PublishSubject<MainActivityViewIntent>
) : ViewModel() {

    fun openSearchScreen() {
        subject.onNext(MainActivityViewIntent.NavigateToSearchScreen)
    }

    fun getSearchScreenIntent(context: Context): Intent =
        searchViewNavigation.getSearchIntent(context)

}