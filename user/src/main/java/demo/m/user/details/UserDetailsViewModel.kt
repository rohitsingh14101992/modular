package demo.m.user.details

import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import demo.m.base.model.User
import demo.m.repo_bridge.GetUserRepositoryUseCase
import demo.m.repo_bridge.model.RepositoryResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class UserDetailsViewModel constructor(val getUserRepositoryUseCase: GetUserRepositoryUseCase) :
    ViewModel() {
    val compositeDisposable = CompositeDisposable()
    var showLoader = ObservableInt(View.GONE)
    val response = ObservableField<List<RepositoryResponse>>()
    val userName = ObservableField<String>("")
    val imageUrl = ObservableField<String>("")
    val location = ObservableField<String>("")

    fun initView(user: User) {
        userName.set(user.login)
        imageUrl.set(user.avatarUrl)
        location.set(user.id.toString())
        getUserRpeo(user.login)
    }

    private fun getUserRpeo(ownerName: String) {

        val disposable = getUserRepositoryUseCase.getUserRepositoryList(ownerName)
            .doOnSubscribe {
                showLoader.set(View.VISIBLE)
            }.doFinally {
                showLoader.set(View.GONE)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                response.set(it)
            }, {
                Log.e("error", it.toString())
            }
            )

        compositeDisposable.add(disposable)

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}