package demo.m.search.screen

import android.content.Context
import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import demo.m.base.toObservable
import demo.m.search.repo.UserSearchRepository
import demo.m.base.model.User
import demo.m.search_bridge.model.UserResult
import demo.m.user_bridge.UserDetailsViewNavigation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class SearchUserViewModel constructor(val repository: UserSearchRepository, val subjectViewIntent: PublishSubject<SearchActivityViewIntent>,
                                      val userDetailsViewNavigation: UserDetailsViewNavigation) :  ViewModel() {
    var keyword = ObservableField<String>("")
    private val keywordEmitter: BehaviorSubject<String> = BehaviorSubject.create()
    val compositeDisposable = CompositeDisposable()
    var showLoader = ObservableInt(View.GONE)
    private val MINIMUM_SEARCH_CHARACTER_LENGTH = 3
    private val START_SEARCH_DELAY = 3L
    val response = ObservableField<UserResult>()
    val showLoaderSubject = PublishSubject.create<Boolean>()
    val clickListener = object : ItemClickListener {
        override fun onClick(user: User) {
            subjectViewIntent.onNext(SearchActivityViewIntent.NavigateToUserScreen(user))
        }
    }

    fun getUserDetailsNavigation(context: Context, user: User) = userDetailsViewNavigation.getIntent(context, user)

    init {
        compositeDisposable.add(keyword.toObservable()
            .doOnNext {
                keyword.get()?.let {
                    keywordEmitter.onNext(it)
                }

            }.subscribe())
        compositeDisposable.add(showLoaderSubject
            .observeOn(AndroidSchedulers.mainThread())
           .subscribe{
               showLoader.set(if (it) View.VISIBLE else View.GONE)
           })
        subscribeSearchKeyword()
    }



    private fun subscribeSearchKeyword() {

           val disposable =  keywordEmitter
                .filter { it.isNotBlank() && it.length >= MINIMUM_SEARCH_CHARACTER_LENGTH }
                .debounce(START_SEARCH_DELAY, TimeUnit.SECONDS)
                .distinctUntilChanged()
                .switchMapSingle {
                    showLoaderSubject.onNext(true)
                    repository.getUsers(it)
                }
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    showLoaderSubject.onNext(false)
                    response.set(it)
                }, {
                    showLoaderSubject.onNext(false)
                    Log.e("error", it.toString())
                })
        compositeDisposable.add(disposable)

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}