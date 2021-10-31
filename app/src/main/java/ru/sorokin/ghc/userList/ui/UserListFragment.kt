package ru.sorokin.ghc.userList.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.sorokin.ghc.AndroidScreens
import ru.sorokin.ghc.App
import ru.sorokin.ghc.model.IBackButtonListener
import ru.sorokin.ghc.databinding.FragmentUserListBinding
import ru.sorokin.ghc.userList.room.GhUserRepo
import ru.sorokin.ghc.userList.model.IUserListView
import ru.sorokin.ghc.userList.UsersPresenter
import ru.sorokin.ghc.userList.UsersRVAdapter

class UserListFragment: MvpAppCompatFragment(), IUserListView, IBackButtonListener {
    companion object {
        fun newInstance() = UserListFragment()
    }

    private var binding: FragmentUserListBinding? = null
    private val presenter by moxyPresenter { UsersPresenter(GhUserRepo(), App.instance.router, AndroidScreens()) }
    private var adapter: UsersRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        FragmentUserListBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun init() {
        binding?.rvUsers?.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.userListPresenter)
        binding?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}