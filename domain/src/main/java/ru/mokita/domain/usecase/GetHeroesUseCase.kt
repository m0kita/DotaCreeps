package ru.mokita.domain.usecase

import ru.mokita.domain.model.Hero
import ru.mokita.domain.repository.HeroRepository

class GetHeroesUseCase(private val repository: HeroRepository) {

    suspend fun execute(): List<Hero> {
        return repository.getHeroes()
    }
}