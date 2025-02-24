package com.oussama_chatri.productivity.features.notes.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class NoteResponse(
    val title: String,
    val content: String,
    val type: String,
    val creationTime: Long,
    val editedTime: Long,
    val isPinned: Boolean
)