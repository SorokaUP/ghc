package ru.sorokin.ghc.userProfile.model

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IUserProfileView: MvpView {
    fun init()
    fun update()
}