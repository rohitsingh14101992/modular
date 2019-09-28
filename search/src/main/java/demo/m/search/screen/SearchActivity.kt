package demo.m.search.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import demo.m.base.parent
import demo.m.search.R
import demo.m.search.databinding.SearchViewBinding
import demo.m.search.di.DaggerSearchActivityComponent
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SearchActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: SearchActivityViewModelFactory
    @Inject
    lateinit var viewIntentObservable: Observable<SearchActivityViewIntent>
    lateinit var viewModel: SearchUserViewModel
    private lateinit var binding: SearchViewBinding
    private val compositeDisposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpDI()
        initDataBinding()
        binding.searchUserRv.layoutManager = LinearLayoutManager(this)
        binding.searchUserRv.adapter = UserListAdapter(viewModel.clickListener)
        subscribeToViewIntent()
    }

    private fun subscribeToViewIntent() {
        compositeDisposable.add(
            viewIntentObservable.subscribe {
                when (it) {
                    is SearchActivityViewIntent.NavigateToUserScreen ->
                        startActivity(viewModel.getUserDetailsNavigation(this, it.user))
                }
            }
        )
    }

    private fun initDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.search_view)
        binding.setLifecycleOwner(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[SearchUserViewModel::class.java]
        binding.vm = viewModel
    }

    private fun setUpDI() {
        DaggerSearchActivityComponent.builder().searchActivityComponentParent(parent()).build()
            .inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
