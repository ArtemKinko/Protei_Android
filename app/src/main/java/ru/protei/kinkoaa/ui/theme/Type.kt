package ru.protei.kinkoaa.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.protei.kinkoaa.R


val marckScriptFamily = FontFamily(
        Font(R.font.marckscript_regular, FontWeight.Normal)
)
// Set of Material typography styles to start with
val Typography = Typography(
        bodyMedium = TextStyle(
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
        ),
        titleLarge = TextStyle(
                fontFamily = marckScriptFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 40.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.sp
        ),
        titleMedium = TextStyle(
                fontFamily = marckScriptFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 30.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.sp
        ),
        titleSmall = TextStyle(
                fontFamily = marckScriptFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.sp
        )
)