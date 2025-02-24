package com.oussama_chatri.productivity.features.notes.presentation.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.oussama_chatri.productivity.R

data class NotesTypography(
    val SelectedItem: TextStyle,
    val UnselectedItem: TextStyle,
    val CardTitle: TextStyle,
    val CardContent: TextStyle,
    val CardType: TextStyle,
    val NotFound: TextStyle,
)

val notesTypography = NotesTypography(
    SelectedItem = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.poppins_medium))
    ),
    UnselectedItem = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.poppins_medium))
    ),
    CardType = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.poppins_medium))
    ),
    CardContent = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.poppins_medium))
    ),
    CardTitle = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.poppins_medium))
    ),
    NotFound = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.poppins_medium))
    )
)