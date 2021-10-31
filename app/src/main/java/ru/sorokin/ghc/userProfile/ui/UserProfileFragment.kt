package ru.sorokin.ghc.userProfile.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.sorokin.ghc.App
import ru.sorokin.ghc.R
import ru.sorokin.ghc.databinding.FragmentUserListBinding
import ru.sorokin.ghc.databinding.FragmentUserProfileBinding
import ru.sorokin.ghc.model.IBackButtonListener
import ru.sorokin.ghc.userList.UsersPresenter
import ru.sorokin.ghc.userList.UsersRVAdapter
import ru.sorokin.ghc.userList.model.IUserListView
import ru.sorokin.ghc.userList.room.GhUser
import ru.sorokin.ghc.userList.room.GhUserRepo
import ru.sorokin.ghc.userList.ui.UserListFragment
import ru.sorokin.ghc.userProfile.model.IUserProfileView

class UserProfileFragment(id: Int) : MvpAppCompatFragment(), IUserProfileView, IBackButtonListener {
    companion object {
        fun newInstance(id: Int): UserProfileFragment {
            ID = id
            return UserProfileFragment(id)
        }

        private var ID: Int = -1
        private var user: GhUser? = null
    }

    private var binding: FragmentUserProfileBinding? = null
    private val presenter by moxyPresenter { UserProfilePresenter(GhUserRepo(), App.instance.router) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserProfileBinding.inflate(inflater, container, false)
        init()
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun init() {
        getUser()
        update()
    }

    override fun update() {

        binding?.tvLogin?.text = user?.login
    }

    private fun getUser() {
        user = presenter.userRepo.getUserByPos(ID)
    }

    override fun backPressed() = presenter.backPressed()
}