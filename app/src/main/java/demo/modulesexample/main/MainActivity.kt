package demo.modulesexample.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import demo.modulesexample.R
import demo.modulesexample.databinding.ActivityMainBinding
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var viewModelFactory : MainActivityViewModelFactory
    @Inject lateinit var viewIntentObservable: Observable<MainActivityViewIntent>
    private lateinit var binding : ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        initDataBinding()
        subscribeToViewIntent()
    }

    private fun subscribeToViewIntent() {
        compositeDisposable.add(
            viewIntentObservable.subscribe { 
                when(it) {
                    is MainActivityViewIntent.NavigateToSearchScreen -> {
                        startActivity(viewModel.getSearchScreenIntent(this))
                    }
                }
            }
        )
    }

    private fun initDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[MainActivityViewModel::class.java]
        binding.viewModel = viewModel
    }
}
