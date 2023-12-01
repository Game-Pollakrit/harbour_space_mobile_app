package com.example.finalproject.DogApi.data.model

data class Breed(
    val breed_group: String,
    val height: Height,
    val id: Int,
    val life_span: String,
    val name: String,
    val reference_image_id: String,
    val temperament: String,
    val weight: Weight
)