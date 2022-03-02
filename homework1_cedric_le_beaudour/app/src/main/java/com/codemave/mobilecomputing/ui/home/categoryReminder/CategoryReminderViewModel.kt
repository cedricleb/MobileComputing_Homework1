package com.codemave.mobilecomputing.ui.home.categoryReminder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codemave.mobilecomputing.data.entity.Reminder
import java.util.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CategoryReminderViewModel : ViewModel() {
    private val _state = MutableStateFlow(CategoryReminderViewState())

    val state: StateFlow<CategoryReminderViewState>
        get() = _state

    init {
        val list = mutableListOf<Reminder>()
        for (x in 1..20) {
            list.add(
                Reminder(
                    ReminderId = x.toLong(),
                    ReminderTitle = "$x reminder",
                    ReminderCategory = "hobbies",
                    ReminderDate = Date()
                )
            )
        }

        viewModelScope.launch {
            _state.value = CategoryReminderViewState(
                reminders = list
            )
        }
    }
}

data class CategoryReminderViewState(
    val reminders: List<Reminder> = emptyList()
)