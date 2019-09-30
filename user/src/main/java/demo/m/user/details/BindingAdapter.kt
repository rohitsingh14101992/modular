package demo.m.user.details

import androidx.databinding.BindingAdapter
import demo.m.repo_bridge.model.RepositoryResponse

@BindingAdapter("bind:response")
fun bindListAdapter(
    reyclerView: androidx.recyclerview.widget.RecyclerView,
    response: List<RepositoryResponse>?
) {
    if (response != null) {
        (reyclerView.adapter as RepoListAdapter).apply {
            response.let {
                this.setRepos(it)
            }
        }
    }

}