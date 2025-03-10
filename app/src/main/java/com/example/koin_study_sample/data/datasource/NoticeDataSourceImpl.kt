package com.example.koin_study_sample.data.datasource

import com.example.koin_study_sample.data.model.Notice
import com.example.koin_study_sample.data.service.NoticeService

class NoticeDataSourceImpl(
    private val noticeService: NoticeService
): NoticeDataSource {
    override suspend fun getNotices(): List<Notice> {
        return noticeService.getNotices()
    }

}