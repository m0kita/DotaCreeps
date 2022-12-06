package ru.mokita.dotacreeps.presentation.heroes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.mokita.data.repository.HeroRepositoryImpl
import ru.mokita.domain.model.Hero
import ru.mokita.domain.repository.HeroRepository
import ru.mokita.domain.usecase.GetHeroesUseCase
import javax.inject.Inject

@HiltViewModel
class HeroesViewModel @Inject constructor(
    private val getHeroesUseCase: GetHeroesUseCase
): ViewModel() {

    private val _heroes = MutableStateFlow(listOf<Hero>())
    val heroes = _heroes.asStateFlow()

    init {
        viewModelScope.launch {
            _heroes.value = getHeroesUseCase.execute()
        }
    }


}