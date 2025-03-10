package com.example.koin_study_sample.di

import com.example.koin_study_sample.domain.GetNoticesUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetNoticesUseCase(noticeRepository = get()) }
}
