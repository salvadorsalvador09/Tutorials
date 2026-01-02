package com.example.tutorials.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PlaceToVisit(
    @StringRes val nameResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val countryResourceId: Int,
    @StringRes val weatherResourceId: Int,
    @StringRes val languageResourceId: Int,
    @StringRes val descriptionResourceId: Int
)


