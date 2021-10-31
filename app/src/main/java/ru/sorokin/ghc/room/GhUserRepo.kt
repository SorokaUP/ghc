package ru.sorokin.ghc.room

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