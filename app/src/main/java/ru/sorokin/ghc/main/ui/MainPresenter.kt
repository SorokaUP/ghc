package ru.sorokin.ghc.main.ui

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.sorokin.ghc.model.IMainView
import ru.sorokin.ghc.model.IScreens

class MainPresenter(val router: Router, val screens: IScreens): MvpPresenter<IMainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.userList())
    }

    fun backClicked() {
        router.exit()
    }
}