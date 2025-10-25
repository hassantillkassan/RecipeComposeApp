package com.example.recipecomposeapp.core.ui.navigation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recipecomposeapp.R

@Composable
fun BottomNavigation(
    onCategoriesClick: () -> Unit,
    onFavoriteClick: () -> Unit,
) {
    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(Modifier.navigationBarsPadding()) {
            Row(
                modifier = Modifier
                    .height(52.dp)
                    .fillMaxWidth()
                    .padding(16.dp, 8.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                ButtonNavItem(
                    onClick = onCategoriesClick,
                    text = "Категории",
                    containerColor = MaterialTheme.colorScheme.primary
                )
                ButtonNavItem(
                    onClick = onFavoriteClick,
                    text = "Избранное",
                    containerColor = MaterialTheme.colorScheme.secondary,
                    iconRes = R.drawable.ic_heart
                )
            }
        }
    }
}

@Composable
private fun RowScope.ButtonNavItem(
    onClick: () -> Unit,
    text: String,
    containerColor: Color,
    @DrawableRes iconRes: Int? = null
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(36.dp)
            .weight(1f),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = containerColor)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = text.uppercase(),
                style = MaterialTheme.typography.titleMedium,
            )
            if (iconRes != null) {
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = text,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}