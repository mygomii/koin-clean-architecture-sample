package com.example.koin_study_sample.di

import com.example.koin_study_sample.presentation.MainViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { MainViewModel(getNoticesUseCase = get()) }
}
