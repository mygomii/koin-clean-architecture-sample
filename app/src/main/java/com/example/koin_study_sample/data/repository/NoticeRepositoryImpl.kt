package com.example.koin_study_sample.data.repository

import com.example.koin_study_sample.data.datasource.NoticeDataSource
import com.example.koin_study_sample.data.model.Notice

class NoticeRepositoryImpl(
    private val noticeDataSource: NoticeDataSource
) : NoticeRepository {
    override suspend fun getNotices(): List<Notice> {
        return noticeDataSource.getNotices()
    }
}