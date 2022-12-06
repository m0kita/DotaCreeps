package ru.mokita.domain.model

import com.squareup.moshi.Json

data class Hero(
    @Json(name = "id") val id: Int,
    @Json(name = "localized_name")val name: String,
    @Json(name = "primary_attr")val primaryAttribute: String,
    @Json(name = "attack_type")val attackType: String,
    @Json(name = "roles")val roles: List<String>,
    @Json(name = "img")val url: String,
    @Json(name = "move_speed")val basedMovementSpeed: String,
)
