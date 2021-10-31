package ru.sorokin.ghc.userList.room

class GhUserRepo {
    private val repos = listOf(
        GhUser("SorokaUP"),
        GhUser("XXX"),
        GhUser("Andrey"),
        GhUser("Oleg")
    )

    fun getUsers(): List<GhUser> {
        return repos
    }

    fun getUserByLogin(login: String): GhUser? {
        for (user in repos) {
            if (user.login == login)
                return user
        }
        return null
    }

    fun getUserByPos(pos: Int): GhUser? {
        if (pos < 0 || pos >= repos.size)
            return null

        return repos[pos]
    }
}