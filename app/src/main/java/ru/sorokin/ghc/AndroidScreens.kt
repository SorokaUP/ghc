package ru.sorokin.ghc

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.sorokin.ghc.model.IScreens
import ru.sorokin.ghc.users.ui.UserListFragment

class AndroidScreens: IScreens {
    override fun userList() = FragmentScreen { UserListFragment.newInstance() }
}