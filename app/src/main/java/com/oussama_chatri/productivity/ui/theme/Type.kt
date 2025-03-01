package com.oussama_chatri.productivity.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.oussama_chatri.productivity.R

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_bold)),
        fontSize = 44.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_bold)),
        fontSize = 38.sp,
    ),
    displaySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        fontSize = 32.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_bold)),
        fontSize = 32.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        fontSize = 28.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        fontSize = 24.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_bold)),
        fontSize = 24.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        fontSize = 21.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        fontSize = 17.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_regular)),
        fontSize = 20.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_regular)),
        fontSize = 18.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_regular)),
        fontSize = 16.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        fontSize = 16.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        fontSize = 14.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        fontSize = 12.sp,
    )
)