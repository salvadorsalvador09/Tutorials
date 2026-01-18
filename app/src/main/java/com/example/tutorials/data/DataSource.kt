package com.example.tutorials.data

import com.example.tutorials.R
import com.example.tutorials.model.Caracter
import com.example.tutorials.model.Especie
import com.example.tutorials.model.Genero
import com.example.tutorials.model.Pet

class DataSource {
    fun loadPets(): List<Pet>{
        return listOf(
            Pet(1,R.drawable.perro1, Especie.PERRO, Genero.MACHO, "Scar", 13, Caracter.JUGUETON, false),
            Pet(2,R.drawable.gato1, Especie.GATO, Genero.HEMBRA, "Boni", 5, Caracter.TRANQUILO, true),
            Pet(3,R.drawable.conejo1,Especie.CONEJO, Genero.MACHO, "Wilson", 13, Caracter.AGRESIVO, false),
            Pet(4,R.drawable.perro2,Especie.PERRO, Genero.HEMBRA, "Kika", 10, Caracter.JUGUETON, true),
            Pet(5,R.drawable.gato2,Especie.GATO, Genero.MACHO, "Wimbo", 9, Caracter.TRANQUILO, false),
            Pet(6,R.drawable.conejo2,Especie.CONEJO, Genero.HEMBRA, "Loba", 7, Caracter.AGRESIVO, true),
            Pet(7,R.drawable.gato1, Especie.GATO, Genero.HEMBRA, "Boni", 5, Caracter.TRANQUILO, true),
            Pet(8,R.drawable.conejo1,Especie.CONEJO, Genero.MACHO, "Wilson", 13, Caracter.AGRESIVO, false),
            Pet(9,R.drawable.perro2,Especie.PERRO, Genero.HEMBRA, "Kika", 10, Caracter.JUGUETON, true),
        )
    }
}