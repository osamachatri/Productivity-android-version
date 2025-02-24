package com.oussama_chatri.productivity.features.notes.domain

data class Note(
    val title: String,
    val content: String,
    val type: String,
    val creationTime: Long,
    val editedTime: Long,
    val isPinned: Boolean
)