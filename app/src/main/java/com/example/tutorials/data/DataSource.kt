package com.example.tutorials.data

import com.example.tutorials.model.PlaceToVisit
import com.example.tutorials.R

class DataSource {
    fun loadPlaces(): List<PlaceToVisit> {
        return listOf<PlaceToVisit>(
            PlaceToVisit(R.string.place1, R.drawable.image1, R.string.country_mx,
                R.string.weather_tempered, R.string.lenguage_es,R.string.description1),
            PlaceToVisit(R.string.place2, R.drawable.image2, R.string.country_mx,
                R.string.weather_hot, R.string.lenguage_es,R.string.description2),
            PlaceToVisit(R.string.place3, R.drawable.image3, R.string.country_th,
                R.string.weather_hot, R.string.lenguage_th,R.string.description3),
            PlaceToVisit(R.string.place4, R.drawable.image4, R.string.country_th,
                R.string.weather_hot, R.string.lenguage_th,R.string.description4),
            PlaceToVisit(R.string.place5, R.drawable.image5, R.string.country_uk,
                R.string.weather_cold, R.string.lenguage_en,R.string.description5),
            PlaceToVisit(R.string.place6, R.drawable.image6, R.string.country_uk,
                R.string.weather_cold, R.string.lenguage_en,R.string.description6),
            PlaceToVisit(R.string.place7, R.drawable.image7, R.string.country_jp,
                R.string.weather_cold, R.string.lenguage_jp,R.string.description7),
            PlaceToVisit(R.string.place8, R.drawable.image8, R.string.country_jp,
                R.string.weather_cold, R.string.lenguage_jp,R.string.description8),
            PlaceToVisit(R.string.place9, R.drawable.image9, R.string.country_pe,
                R.string.weather_tempered, R.string.lenguage_es,R.string.description9),
            PlaceToVisit(R.string.place10, R.drawable.image10, R.string.country_pe,
                R.string.weather_tempered, R.string.lenguage_es,R.string.description10)

        )
    }
}