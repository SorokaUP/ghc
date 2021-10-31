package ru.sorokin.ghc.userProfile.ui

import com.github.terrakok.cicerone.Router
import moxy.MvpFacade.init
import moxy.MvpPresenter
import ru.sorokin.ghc.userList.room.GhUserRepo
import ru.sorokin.ghc.userProfile.model.IUserProfileView

class UserProfilePresenter(val userRepo: GhUserRepo, private val router: Router): MvpPresenter<IUserProfileView>() {
    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        init()
    }
}