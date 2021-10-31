package ru.sorokin.ghc.users.model

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IUserListView: MvpView {
    fun init()
    fun updateList()
}