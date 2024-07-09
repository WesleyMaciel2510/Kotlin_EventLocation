package com.example.kotlin_portfolio.components.lazyRows

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin_portfolio.ui.theme.LightColorScheme

// Define a data class for each item
data class EventTypeItem(val icon: ImageVector, val label: String)

val EventTypeItems = listOf(
    EventTypeItem(Icons.Default.Build, "Movies"),
    EventTypeItem(Icons.Default.AddCircle, "Shows"),
    EventTypeItem(Icons.Default.ShoppingCart, "Sports"),
    EventTypeItem(Icons.Default.Star, "Theater"),
    EventTypeItem(Icons.Default.DateRange, "StandUp Comedy"),
    EventTypeItem(Icons.Default.Lock, "Online Events"),
)

@Composable
fun EventTypeLazyRow(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = LightColorScheme.background)
    ) {
        Text(
            text = "Go for it, life is now!",
            style = TextStyle(
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = LightColorScheme.outline,
            ),
            modifier = Modifier.padding(vertical = 20.dp, horizontal = 15.dp)
        )
        LazyRow(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(EventTypeItems.size) { index ->
                EventTypeItemView(EventTypeItems[index])
            }
        }
    }
}

@Composable
fun EventTypeItemView(item: EventTypeItem) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(horizontal = 15.dp)
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(Color.White)
                .graphicsLayer {
                    this.shadowElevation = 8.dp.toPx()
                    shape = CircleShape
                    clip = true
                }
                .border(1.dp, Color(0xFF494A52), CircleShape)
                .background(Color(0xFF2F77bd), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.label,
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )
        }
        Text(
            text = item.label,
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(top = 8.dp)
                .widthIn(max = 80.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLazyRow() {
    EventTypeLazyRow()
}
