package tech.antee.second.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

internal val SFDisplayFontFamily = FontFamily(
    Font(
        resId = R.font.sf_pro_display_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.sf_pro_display_regularitalic,
        weight = FontWeight.Normal,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.sf_pro_display_bold,
        weight = FontWeight.Bold
    ),
    Font(
        resId = R.font.sf_pro_display_heavy,
        weight = FontWeight.ExtraBold
    ),
    Font(
        resId = R.font.sf_pro_display_medium,
        weight = FontWeight.Medium
    ),
    Font(
        resId = R.font.sf_pro_display_mediumitalic,
        weight = FontWeight.Medium,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.sf_pro_display_semibold,
        weight = FontWeight.SemiBold
    ),
    Font(
        resId = R.font.sf_pro_display_semibolditalic,
        weight = FontWeight.SemiBold,
        style = FontStyle.Italic
    ),
)

internal val SFTextFontFamily = FontFamily(
    Font(
        resId = R.font.sf_pro_text_bold,
        weight = FontWeight.Bold
    ),
    Font(
        resId = R.font.sf_pro_text_heavyitalic,
        weight = FontWeight.ExtraBold,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.sf_pro_text_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.sf_pro_text_italic,
        weight = FontWeight.Normal,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.sf_pro_text_medium,
        weight = FontWeight.Medium,
    ),
    Font(
        resId = R.font.sf_pro_text_mediumitalic,
        weight = FontWeight.Medium,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.sf_pro_text_semibold,
        weight = FontWeight.SemiBold
    ),
    Font(
        resId = R.font.sf_pro_text_semibolditalic,
        weight = FontWeight.SemiBold,
        style = FontStyle.Italic
    )
)

internal val SecondTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = SFDisplayFontFamily,
        fontSize = TextSize.display1,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    displayMedium = TextStyle(
        fontFamily = SFDisplayFontFamily,
        fontSize = TextSize.display2,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    displaySmall = TextStyle(
        fontFamily = SFDisplayFontFamily,
        fontSize = TextSize.display3,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    headlineLarge = TextStyle(
        fontFamily = SFDisplayFontFamily,
        fontSize = TextSize.headline1,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    headlineMedium = TextStyle(
        fontFamily = SFDisplayFontFamily,
        fontSize = TextSize.headline2,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    headlineSmall = TextStyle(
        fontFamily = SFDisplayFontFamily,
        fontSize = TextSize.headline3,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
    ),
    titleLarge = TextStyle(
        fontFamily = SFTextFontFamily,
        fontSize = TextSize.title1,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    titleMedium = TextStyle(
        fontFamily = SFTextFontFamily,
        fontSize = TextSize.title2,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    titleSmall = TextStyle(
        fontFamily = SFTextFontFamily,
        fontSize = TextSize.title3,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    bodyLarge = TextStyle(
        fontFamily = SFTextFontFamily,
        fontSize = TextSize.body1,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    bodyMedium = TextStyle(
        fontFamily = SFTextFontFamily,
        fontSize = TextSize.body2,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    bodySmall = TextStyle(
        fontFamily = SFTextFontFamily,
        fontSize = TextSize.body3,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    labelLarge = TextStyle(
        fontFamily = SFTextFontFamily,
        fontSize = TextSize.label1,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    labelMedium = TextStyle(
        fontFamily = SFTextFontFamily,
        fontSize = TextSize.label2,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    labelSmall = TextStyle(
        fontFamily = SFTextFontFamily,
        fontSize = TextSize.label3,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    )
)

internal object TextSize {
    val display1 = 60.sp
    val display2 = 48.sp
    val display3 = 34.sp

    // Figma Title
    val headline1 = 28.sp
    val headline2 = 22.sp
    val headline3 = 20.sp

    // Figma Headline
    val title1 = 17.sp
    val title2 = 16.sp
    val title3 = 15.sp

    // Figma Body
    val body1 = 17.sp
    val body2 = 17.sp
    val body3 = 13.sp

    // Figma Captions
    val label1 = 12.sp
    val label2 = 11.sp
    val label3 = 10.sp
}
