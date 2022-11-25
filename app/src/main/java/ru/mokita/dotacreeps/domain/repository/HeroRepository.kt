package ru.mokita.dotacreeps.domain.repository

import ru.mokita.dotacreeps.domain.model.Hero

interface HeroRepository {
    suspend fun getHeroes(): List<Hero>
}