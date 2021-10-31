package ru.sorokin.ghc

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.sorokin.ghc.model.IScreens
import ru.sorokin.ghc.userList.ui.UserListFragment
import ru.sorokin.ghc.userProfile.ui.UserProfileFragment

class AndroidScreens: IScreens {
    override fun userList() = FragmentScreen { UserListFragment.newInstance() }
    override fun userProfile(id: Int) = FragmentScreen { UserProfileFragment.newInstance(id) }
}