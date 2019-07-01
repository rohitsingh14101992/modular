package demo.m.search.screen

import androidx.databinding.BindingAdapter
import demo.m.search_bridge.model.UserResult

@BindingAdapter("bind:response")
fun bindListAdapter(reyclerView: androidx.recyclerview.widget.RecyclerView, response: UserResult?) {
    if (response != null) {
        (reyclerView.adapter as UserListAdapter).apply {
            response.let {
                this.setUsers(it.items)
            }
        }
    }

}