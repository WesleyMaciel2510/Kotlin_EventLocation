
import androidx.annotation.OptIn
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme
import com.example.kotlin_portfolio.ui.theme.LightColorScheme

@Composable
fun SearchHeaderBar(
    modifier: Modifier = Modifier,
    searchText: TextFieldValue,
    onSearchTextChanged: (TextFieldValue) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = LightColorScheme.outline)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .border(
                width = 2.dp,
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = { /* Handle search icon click */ },
                modifier = Modifier.padding(start = 12.dp, end = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.White
                )
            }

            // Input text field with placeholder
            BasicTextField(
                value = searchText,
                onValueChange = { onSearchTextChanged(it) },
                singleLine = true,
                textStyle = MaterialTheme.typography.body1,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 12.dp),
                decorationBox = { innerTextField ->
                    Box(contentAlignment = Alignment.CenterStart) {
                        if (searchText.text.isEmpty()) {
                            Text(
                                text = "Events and Places",
                                style = MaterialTheme.typography.body1.copy(color = Color.White.copy(alpha = 0.6f)),
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }
                        innerTextField()
                    }
                }
            )
        }
    }
}

@OptIn(UnstableApi::class)
@Preview(showBackground = true)
@Composable
fun PreviewSearchBar() {
    Kotlin_PortfolioTheme {
        val searchText = remember { mutableStateOf(TextFieldValue("")) }
        SearchHeaderBar(
            searchText = searchText.value,
            onSearchTextChanged = { newText ->
                searchText.value = newText
                // Logging the typed text to Logcat
                Log.d("SearchHeaderBar", "Typed text: ${newText.text}")
            }
        )
    }
}

