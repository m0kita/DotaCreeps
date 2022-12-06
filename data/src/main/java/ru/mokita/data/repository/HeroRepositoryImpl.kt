package ru.mokita.data.repository

import ru.mokita.data.network.api.DotaApi
import ru.mokita.domain.model.Hero
import ru.mokita.domain.repository.HeroRepository

class HeroRepositoryImpl(private val client: DotaApi) : HeroRepository {

    override suspend fun getHeroes(): List<Hero> {
        return client.getHeroes()
    }


}