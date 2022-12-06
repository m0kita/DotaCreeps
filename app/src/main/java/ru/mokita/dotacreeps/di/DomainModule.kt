package ru.mokita.dotacreeps.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.mokita.data.network.api.DotaApi
import ru.mokita.data.repository.HeroRepositoryImpl
import ru.mokita.domain.repository.HeroRepository
import ru.mokita.domain.usecase.GetHeroesUseCase

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
    @Provides
    fun provideGetHeroesUseCase(heroRepository: HeroRepository): GetHeroesUseCase =
        GetHeroesUseCase(repository = heroRepository)
}