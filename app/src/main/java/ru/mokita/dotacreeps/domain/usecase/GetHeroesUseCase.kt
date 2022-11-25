package ru.mokita.dotacreeps.domain.usecase

import ru.mokita.dotacreeps.domain.model.Hero
import ru.mokita.dotacreeps.domain.repository.HeroRepository

class GetHeroesUseCase(private val repository: HeroRepository) {

    suspend fun execute(): List<Hero> {
        return repository.getHeroes()
    }
}