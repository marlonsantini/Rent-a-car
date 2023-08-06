package fingerfire.com.aluguecarro.model

import androidx.annotation.DrawableRes

data class Car(
    val brand: String,
    val model: String,
    val rating: Double,
    val rentalPrice: String,
    @DrawableRes val imageResId: Int
)