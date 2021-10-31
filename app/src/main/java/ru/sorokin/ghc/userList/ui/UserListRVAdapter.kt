package ru.sorokin.ghc.userList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.sorokin.ghc.databinding.LayoutUserItemBinding
import ru.sorokin.ghc.userList.model.IUserItemView
import ru.sorokin.ghc.userList.model.IUserListPresenter

class UsersRVAdapter(private val presenter: IUserListPresenter) : RecyclerView.Adapter<UsersRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutUserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
            itemView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
    }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    inner class ViewHolder(private val binding: LayoutUserItemBinding): RecyclerView.ViewHolder(binding.root),
        IUserItemView {
        override var pos = -1

        override fun setLogin(text: String) = with(binding) {
            tvLogin.text = text
        }
    }
}