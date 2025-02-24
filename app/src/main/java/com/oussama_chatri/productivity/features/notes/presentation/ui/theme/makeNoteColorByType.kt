package com.oussama_chatri.productivity.features.notes.presentation.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun makeNoteColorByType(type: String): Color {
    return when (type) {
        "All" -> Color.Transparent
        "Personal 💜" -> Color(0xFFDFFFDE)
        "Work 💼" -> Color(0xFFFFEFD1)
        "Creative 🎨" -> Color(0xFFF2FFDA)
        "Ideas 💡" -> Color(0xFFFAFFCA)
        "Travel ✈️" -> Color(0xFFF5E5DC)
        "Health ❤️" -> Color(0xFFBCFFBC)
        "Finance 💰" -> Color(0xFFFFFAE1)
        "Goals 🎯" -> Color(0xFFFFFE1F)
        "Study 📚" -> Color(0xFFFFF6E5)
        else -> Color.Transparent
    }
}
