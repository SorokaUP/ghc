package ru.sorokin.ghc.users.room

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
}