package com.example.kotlin_portfolio.components.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin_portfolio.ui.theme.LightColorScheme

@Composable
fun TabComponent(
    contentActive: @Composable () -> Unit,
    contentClosed: @Composable () -> Unit,
) {
    var selectedTab by remember { mutableStateOf("Active") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
        ) {
            TabItem(
                title = "Active",
                isSelected = selectedTab == "Active",
                onClick = { selectedTab = "Active" },
                modifier = Modifier.weight(1f)
            )
            TabItem(
                title = "Closed",
                isSelected = selectedTab == "Closed",
                onClick = { selectedTab = "Closed" },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (selectedTab == "Active") {
            contentActive()
        } else {
            contentClosed()
        }
    }
}

@Composable
fun TabItem(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(
                if (isSelected) LightColorScheme.background else Color.White,
            )
            .clickable { onClick() }
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            color = if (isSelected) LightColorScheme.primary else Color.Black,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(3.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
                .height(3.dp)
                .background(if (isSelected) LightColorScheme.primary else Color.Transparent)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TabComponentPreview() {
    TabComponent(
        contentActive = {
            Text(text = "Active Content", color = Color.Black, modifier = Modifier.padding(16.dp))
        },
        contentClosed = {
            Text(text = "Closed Content", color = Color.Black, modifier = Modifier.padding(16.dp))
        }
    )
}

