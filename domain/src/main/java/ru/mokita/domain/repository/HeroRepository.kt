package ru.mokita.domain.repository

import ru.mokita.domain.model.Hero

interface HeroRepository {
    suspend fun getHeroes(): List<Hero>
}