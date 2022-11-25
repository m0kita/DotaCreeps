package ru.mokita.dotacreeps.data.network.api

import retrofit2.http.GET
import ru.mokita.dotacreeps.domain.model.Hero

interface DotaApi {
    @GET("/api/heroStats")
    suspend fun getHeroes(): List<Hero>
}