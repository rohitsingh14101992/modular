package demo.m.user_bridge

import android.content.Context
import android.content.Intent
import demo.m.base.model.User

interface UserDetailsViewNavigation {
    fun getIntent(context: Context, user: User): Intent
}