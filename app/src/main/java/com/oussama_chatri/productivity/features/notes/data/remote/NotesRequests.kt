package com.oussama_chatri.productivity.features.notes.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class NoteRequest(
    val title: String,
    val content: String,
    val type: String,
    val creationTime: Long,
    val isPinned: Boolean
)

@Serializable
data class UpdatedNoteRequest(
    val title: String,
    val content: String,
    val type: String,
    val editedTime: Long,
    val isPinned: Boolean
)