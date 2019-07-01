package demo.m.user.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import demo.m.repo_bridge.model.RepositoryResponse
import demo.m.user.R

class RepoListAdapter :
    RecyclerView.Adapter<RepoListAdapter.RepoViewHolder>() {
    private var items: MutableList<RepositoryResponse> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        return RepoViewHolder(view)
    }

    fun setRepos(list: List<RepositoryResponse>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.updateView(items[position])
    }

    class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var nameTv = itemView.findViewById<TextView>(R.id.list_repo_name_tv)
        var starsTv = itemView.findViewById<TextView>(R.id.repo_stars_tv)

        fun updateView(repositoryResponse: RepositoryResponse) {
            with(repositoryResponse) {
                nameTv.text = name
                starsTv.text = starsCount.toString()
            }
        }
    }

}
