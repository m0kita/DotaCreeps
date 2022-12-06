package ru.mokita.dotacreeps.core

import ru.mokita.dotacreeps.R

enum class AttackType(val attackType: String, val link: Int) {
    RANGE("Range", R.drawable.ic_range),
    MELEE("Melee", R.drawable.ic_melee),
}