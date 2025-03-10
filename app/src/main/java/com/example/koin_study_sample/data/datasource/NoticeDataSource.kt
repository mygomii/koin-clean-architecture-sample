package com.example.koin_study_sample.data.datasource

import com.example.koin_study_sample.data.model.Notice

interface NoticeDataSource {
    suspend fun getNotices(): List<Notice>
}