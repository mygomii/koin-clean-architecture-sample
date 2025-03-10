package com.example.koin_study_sample.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koin_study_sample.data.model.Notice
import com.example.koin_study_sample.domain.GetNoticesUseCase
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val getNoticesUseCase: GetNoticesUseCase
) : ViewModel() {
    private val _noticeList: MutableStateFlow<List<Notice>> = MutableStateFlow(emptyList())
    val noticeList: StateFlow<List<Notice>> = _noticeList.asStateFlow()

    init {
        viewModelScope.launch {
            _noticeList.value = getNoticesUseCase.invoke()
        }
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}