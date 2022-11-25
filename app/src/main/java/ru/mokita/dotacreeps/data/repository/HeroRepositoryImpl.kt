package ru.mokita.dotacreeps.data.repository

import retrofit2.Retrofit
import ru.mokita.dotacreeps.data.network.DotaApiClient
import ru.mokita.dotacreeps.data.network.api.DotaApi
import ru.mokita.dotacreeps.domain.model.Hero
import ru.mokita.dotacreeps.domain.repository.HeroRepository

class HeroRepositoryImpl(): HeroRepository {

    private val client: DotaApi = DotaApiClient.client

    override suspend fun getHeroes(): List<Hero> {
        return client.getHeroes()
    }
}