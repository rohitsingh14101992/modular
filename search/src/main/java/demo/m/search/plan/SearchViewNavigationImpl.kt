package demo.m.search.plan

import android.content.Context
import android.content.Intent
import demo.m.search.screen.SearchActivity
import demo.m.search_bridge.SearchViewNavigation


class SearchViewNavigationImpl : SearchViewNavigation {

    override fun getSearchIntent(context: Context): Intent {
        return Intent(context, SearchActivity::class.java)
    }
}

