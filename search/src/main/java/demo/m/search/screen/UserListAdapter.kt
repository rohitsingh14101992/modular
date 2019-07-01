package demo.m.search.screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import demo.m.search.R
import demo.m.base.model.User

class UserListAdapter constructor(val itemClickListener: ItemClickListener):
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {
    var items: MutableList<User> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    fun setUsers(list: List<User>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.updateView(items[position])
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(items[position])
        }
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var nameTv = itemView.findViewById<TextView>(R.id.userName_tv)
        var avatar = itemView.findViewById<ImageView>(R.id.avatar_iv)

        fun updateView(user: User) {
            with(user) {
                nameTv.text = login
                avatar.context.let {
                    Glide.with(it).load(avatarUrl).into(avatar)
                }
            }
        }
    }

}

interface ItemClickListener {
    fun onClick(user: User)
}