package com.example.koin_study_sample.di

import com.example.koin_study_sample.data.repository.NoticeRepository
import com.example.koin_study_sample.data.repository.NoticeRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<NoticeRepository> { NoticeRepositoryImpl(noticeDataSource = get()) }
}