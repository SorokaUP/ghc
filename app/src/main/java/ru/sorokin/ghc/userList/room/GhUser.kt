package ru.sorokin.ghc.userList.room

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GhUser(
    val login: String
) : Parcelable