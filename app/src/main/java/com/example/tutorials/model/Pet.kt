package com.example.tutorials.model

import androidx.annotation.DrawableRes

data class Pet (
                val id: Int,
    @DrawableRes val foto: Int,
                val especie: Especie,
                val genero: Genero,
                val nombre: String,
                val edad: Int,
                val caracter: Caracter,
                val esterilizado: Boolean)

enum class Genero {
    MACHO,
    HEMBRA
}

enum class Caracter{
    TRANQUILO,
    JUGUETON,
    AGRESIVO
}

enum class Especie{
    PERRO,
    GATO,
    CONEJO
}