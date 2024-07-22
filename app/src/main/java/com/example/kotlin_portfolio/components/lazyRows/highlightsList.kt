package com.example.kotlin_portfolio.components.lazyRows

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_portfolio.ui.theme.LightColorScheme
import com.example.kotlin_portfolio.utils.AllEvents
import com.example.kotlin_portfolio.utils.AllEventsItem
import com.example.kotlin_portfolio.utils.serializeEvent

@Composable
fun HighLightLazyRow(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = LightColorScheme.background)
            .padding(15.dp)
    ) {
        Text(
            text = "Highlight Events",
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
        LazyRow(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(AllEvents.subList(11, 20)) { item ->
                HighLightItemView(item, navController)
            }
        }
    }
}

@Composable
fun HighLightItemView(item: AllEventsItem, navController: NavController) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .padding(end = 10.dp)
            .clickable {
                val eventJson = serializeEvent(item)

                Log.d("Item", "@ ITEM CLICKED")
                Log.d("Item", "@ ITEM = $item")
                Log.d("Item", "@ EVENT JSON = $eventJson")

                navController.navigate("eventItem/$eventJson")
            }
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
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = item.title,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                ),
                modifier = Modifier.
                padding(bottom = 8.dp),
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = item.local,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                ),
                modifier = Modifier.padding(bottom = 4.dp),
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "Date: ${item.eventDate}",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFC96908),
                ),
                modifier = Modifier,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHighLightLazyRow() {
    val navController = rememberNavController()
    HighLightLazyRow(navController = navController)
}
