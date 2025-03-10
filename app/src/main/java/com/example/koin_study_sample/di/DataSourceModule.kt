package com.example.koin_study_sample.di

import com.example.koin_study_sample.data.datasource.NoticeDataSource
import com.example.koin_study_sample.data.datasource.NoticeDataSourceImpl
import com.example.koin_study_sample.data.model.Notice
import org.koin.dsl.module

val dataSourceModule = module {
    single<NoticeDataSource> { NoticeDataSourceImpl(noticeService = get()) }
}