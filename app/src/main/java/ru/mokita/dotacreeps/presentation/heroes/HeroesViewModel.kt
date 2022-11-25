package ru.mokita.dotacreeps.presentation.heroes

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.mokita.dotacreeps.data.repository.HeroRepositoryImpl
import ru.mokita.dotacreeps.domain.model.Hero
import ru.mokita.dotacreeps.domain.repository.HeroRepository

class HeroesViewModel: ViewModel() {
    private val heroRepository = HeroRepositoryImpl()

    private val _heroes = MutableStateFlow(listOf<Hero>())
    val heroes = _heroes.asStateFlow()

    init {
        viewModelScope.launch {
            _heroes.value = heroRepository.getHeroes()
            Log.d("HeroesViewModel", _heroes.value[0].name)
        }
    }


}