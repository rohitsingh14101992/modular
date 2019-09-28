package demo.m.user.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import demo.m.base.model.User
import demo.m.base.parent
import demo.m.user.R
import demo.m.user.di.DaggerUserDetailsComponent
import javax.inject.Inject

class UserDetailsActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: UserDetailsViewModelFactory
    lateinit var viewModel: UserDetailsViewModel
    private lateinit var binding: demo.m.user.databinding.ActivityUserDetailsBinding

    companion object {
        val PARAM_USER_KEY = "param_user"
        fun getIntent(context: Context, user: User): Intent =
            Intent(context, UserDetailsActivity::class.java).apply {
                putExtra(PARAM_USER_KEY, user)
                putExtra("int", 111)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpDI()
        initDataBinding()
        binding.repositoryRv.layoutManager = LinearLayoutManager(this)
        binding.repositoryRv.adapter = RepoListAdapter()
    }

    private fun setUpDI() {
        DaggerUserDetailsComponent.builder().userDetailsComponentParent(parent()).build()
            .inject(this)
    }


    private fun initDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_details)
        binding.setLifecycleOwner(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[UserDetailsViewModel::class.java]
        binding.vm = viewModel
        viewModel.initView(intent.getParcelableExtra(PARAM_USER_KEY))
    }

}
