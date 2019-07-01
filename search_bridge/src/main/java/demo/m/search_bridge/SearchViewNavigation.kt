package demo.m.search_bridge

import android.content.Context
import android.content.Intent

interface SearchViewNavigation {
    fun getSearchIntent(context: Context): Intent
}