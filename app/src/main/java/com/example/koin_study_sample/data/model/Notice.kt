package com.example.koin_study_sample.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Notice(
    var userId: Int,
    var id: Int,
    var title: String,
    var body: String
)