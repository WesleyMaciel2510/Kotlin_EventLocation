package com.example.kotlin_portfolio.components.lazyRows

import androidx.compose.foundation.Image
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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin_portfolio.R
import com.example.kotlin_portfolio.ui.theme.LightColorScheme

data class EventTypeItem(val imageRes: Int, val label: String)

val EventTypeItems = listOf(
    EventTypeItem(R.drawable.icon1, "Movies"),
    EventTypeItem(R.drawable.icon2, "Shows"),
    EventTypeItem(R.drawable.icon3, "Sports"),
    EventTypeItem(R.drawable.icon4, "Theater"),
    EventTypeItem(R.drawable.icon5, "StandUp Comedy"),
    EventTypeItem(R.drawable.icon6, "Online Events"),
    EventTypeItem(R.drawable.icon7, "Online Events"),
    EventTypeItem(R.drawable.icon8, "Online Events"),
    EventTypeItem(R.drawable.icon9, "Online Events"),
    EventTypeItem(R.drawable.icon10, "Online Events"),

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
                .background(Color(0xFF2F77bd), shape = CircleShape)
                .padding(3.dp),
            contentAlignment = Alignment.Center
        ) {
            val image: Painter = painterResource(id = item.imageRes)
            Image(
                painter = image,
                contentDescription = item.label,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
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
