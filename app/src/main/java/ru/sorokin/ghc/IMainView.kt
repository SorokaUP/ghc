package ru.sorokin.ghc

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IMainView: MvpView {
    fun init()
    fun updateList()
}