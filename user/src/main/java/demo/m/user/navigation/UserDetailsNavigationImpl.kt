package demo.m.user.navigation

import android.content.Context
import android.content.Intent
import demo.m.base.model.User
import demo.m.user.details.UserDetailsActivity
import demo.m.user_bridge.UserDetailsViewNavigation

class UserDetailsNavigationImpl: UserDetailsViewNavigation {
    override fun getIntent(context: Context, user: User): Intent = UserDetailsActivity.getIntent(context, user)
}