package com.example.koin_study_sample.data.repository

import com.example.koin_study_sample.data.model.Notice

interface NoticeRepository {
    suspend fun getNotices(): List<Notice>
}