package com.example.koin_study_sample.di

import com.example.koin_study_sample.data.service.NoticeService
import org.koin.dsl.module

fun appModule() = listOf(
    networkModule,
    serviceModule,
    dataSourceModule,
    repositoryModule,
    domainModule,
    viewModelModule
)

val serviceModule = module {
    single { NoticeService(httpClient = get()) }
}



