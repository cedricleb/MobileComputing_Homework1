package com.codemave.mobilecomputing.data.entity

import java.util.*

data class Reminder(
    val ReminderId: Long,
    val ReminderTitle: String,
    val ReminderDate: Date?,
    val ReminderCategory: String
)
