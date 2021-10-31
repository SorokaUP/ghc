package ru.sorokin.ghc

import moxy.MvpPresenter
import ru.sorokin.ghc.room.GhUser
import ru.sorokin.ghc.room.GhUserRepo

class MainPresenter(private val usersRepo: GhUserRepo): MvpPresenter<IMainView>() {
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

    private fun loadData() {
        val users = usersRepo.getUsers()
        userListPresenter.users.addAll(users)
        viewState.updateList()
    }
}