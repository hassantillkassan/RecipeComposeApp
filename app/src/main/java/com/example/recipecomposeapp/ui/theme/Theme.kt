package com.example.recipecomposeapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val RecipesAppDarkColorScheme = darkColorScheme(
    primary = DarkThemeColors.PrimaryColorDark,
    secondary = DarkThemeColors.AccentColorDark,
    tertiary = DarkThemeColors.AccentBlueDark,

    background = DarkThemeColors.BackgroundColorDark,
    surface = DarkThemeColors.SurfaceColorDark,
    surfaceVariant = Color(0xFF2C2C2E),

    onPrimary = Color(0xFF303030),
    onSecondary = Color(0xFF303030),
    onBackground = DarkThemeColors.TextPrimaryColorDark,
    onSurface = DarkThemeColors.TextPrimaryColorDark,
    onSurfaceVariant = DarkThemeColors.TextSecondaryColorDark,

    outline = Color(0xFF424242),
)

private val RecipesAppLightColorScheme = lightColorScheme(
    primary = LightThemeColors.PrimaryColor,
    secondary = LightThemeColors.AccentColor,
    tertiary = LightThemeColors.AccentBlue,

    background = LightThemeColors.BackgroundColor,
    surface = LightThemeColors.SurfaceColor,
    surfaceVariant = LightThemeColors.SurfaceVariantColor,

    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = LightThemeColors.TextPrimaryColor,
    onSurface = LightThemeColors.TextPrimaryColor,
    onSurfaceVariant = LightThemeColors.TextSecondaryColor,

    outline = LightThemeColors.DividerColor,
)

@Composable
fun RecipesAppTheme (
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> RecipesAppDarkColorScheme
        else -> RecipesAppLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = recipesAppTypography,
        content = content
    )
}

@Preview(name = "RecipesAppDarkColorScheme", showBackground = true)
@Composable
fun DarkThemePreview() {
    RecipesAppTheme(darkTheme = true) {
        Surface {
            Text(
                text = "Sample text",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}