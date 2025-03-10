package com.example.koin_study_sample.data.service

import com.example.koin_study_sample.data.model.Notice
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class NoticeService(
    private val httpClient: HttpClient
) {
    suspend fun getNotices(): List<Notice> {
        return httpClient.get("https://jsonplaceholder.typicode.com/posts").body() as List<Notice>
    }

}