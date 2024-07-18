package com.example.kotlin_portfolio.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme
import com.example.kotlin_portfolio.ui.theme.LightColorScheme
import com.example.kotlin_portfolio.utils.AllEvents
import com.example.kotlin_portfolio.utils.AllEventsItem

@Composable
fun ColumnEvents(
    title: String,
    start: Int,
    end: Int
) {
    Column(
        modifier = Modifier.padding(start = 20.dp, top = 30.dp)
    ) {
        androidx.compose.material.Text(
            text = title,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = LightColorScheme.outline,
            ),
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 5.dp)
                .align(Alignment.Start)
        )
        Spacer(
            modifier = Modifier
                .width(330.dp)
                .height(1.dp)
                .background(color = Color.LightGray)
                .padding(end = 20.dp,)
        )

        //use subList to set the first and the last item
        Column(
            modifier = Modifier.padding(top = 20.dp)
        ){
            AllEvents.subList(start, end).forEach { event ->
                ColumnEventsItemView(item = event)
            }
        }
    }
}

@Composable
fun ColumnEventsItemView(item: AllEventsItem) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .padding(vertical = 20.dp, horizontal = 20.dp)
            .fillMaxWidth()
    ) {
        val image: Painter = painterResource(id = item.imageRes)
        Image(
            painter = image,
            contentDescription = item.title,
            modifier = Modifier
                .width(300.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Column(
            modifier = Modifier
                .padding(top = 10.dp, start = 1.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = item.title,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                ),
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .widthIn(max = 300.dp)
            )
            Text(
                text = item.local,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                ),
                modifier = Modifier
                    .widthIn(max = 300.dp)
                    .padding(bottom = 5.dp)
            )
            Text(
                text = "Date: ${item.eventDate}",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFC96908),
                ),
                modifier = Modifier
                    .widthIn(max = 300.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewColumnEvents() {
    Kotlin_PortfolioTheme {
        ColumnEvents(
            title = "Upcoming Events",
            start = 0,
            end = 5
        )
    }
}