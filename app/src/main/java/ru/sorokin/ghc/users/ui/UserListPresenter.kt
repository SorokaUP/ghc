package ru.sorokin.ghc.users

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.sorokin.ghc.users.model.IUserItemView
import ru.sorokin.ghc.users.model.IUserListPresenter
import ru.sorokin.ghc.users.model.IUserListView
import ru.sorokin.ghc.users.room.GhUser
import ru.sorokin.ghc.users.room.GhUserRepo

class UsersPresenter(private val userRepo: GhUserRepo, private val router: Router): MvpPresenter<IUserListView>() {
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
            //TODO: переход на экран пользователя
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