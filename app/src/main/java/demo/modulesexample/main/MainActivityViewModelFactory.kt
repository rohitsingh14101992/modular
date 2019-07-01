package demo.modulesexample.main


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import demo.m.search_bridge.SearchViewNavigation
import io.reactivex.subjects.PublishSubject

class MainActivityViewModelFactory constructor(val searchViewNavigation: SearchViewNavigation, val subjectViewIntent: PublishSubject<MainActivityViewIntent>) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(searchViewNavigation, subjectViewIntent) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}