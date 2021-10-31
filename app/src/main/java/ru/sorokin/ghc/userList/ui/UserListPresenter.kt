package ru.sorokin.ghc.userList

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.sorokin.ghc.AndroidScreens
import ru.sorokin.ghc.model.IScreens
import ru.sorokin.ghc.userList.model.IUserItemView
import ru.sorokin.ghc.userList.model.IUserListPresenter
import ru.sorokin.ghc.userList.model.IUserListView
import ru.sorokin.ghc.userList.room.GhUser
import ru.sorokin.ghc.userList.room.GhUserRepo

class UsersPresenter(private val userRepo: GhUserRepo, private val router: Router, private val screens: IScreens): MvpPresenter<IUserListView>() {
    class UserListPresenter: IUserListPresenter {
        val users = mutableListOf<GhUser>()
        override var itemClickListener: ((IUserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: IUserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val userListPresenter = UserListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        userListPresenter.itemClickListener = {
            router.navigateTo(screens.userProfile(it.pos))
        }
    }

    fun loadData() {
        val users = userRepo.getUsers()
        userListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}