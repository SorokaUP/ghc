package ru.sorokin.ghc.users.model

import ru.sorokin.ghc.model.IItemView

interface IUserItemView: IItemView {
    fun setLogin(text: String)
}