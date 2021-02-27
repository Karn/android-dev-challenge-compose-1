package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun MainLayout(navController: NavController) {
    val scrollState = rememberScrollState()

    val (searchTerm, updateSearchTerm) = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(112.dp)
                .padding(horizontal = 16.dp)
        ) {
            // Top Bar
        }

        Text(
            text = "Bring home your best friend",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        OutlinedTextField(
            placeholder = { Text("Search for a puppy to adopt...") },
            value = searchTerm,
            onValueChange = updateSearchTerm,
            textStyle = MaterialTheme.typography.subtitle1,
            maxLines = 1,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
//            imeAction = ImeAction.Search,
//            onImeActionPerformed = { action, softwareController ->
//                if (action == ImeAction.Search) {
//                    softwareController.hideSoftwareKeyboard()
//                    // do something here
//                }
//            }
        )

        if (searchTerm.text.isNullOrBlank()) {
            LazyRow(
                contentPadding = PaddingValues(16.dp, 0.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items((0..6).map { "category$it" }) { item ->
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = item)
                    }
                }
            }

            Text(
                text = "For you",
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp, bottom = 4.dp)
            )
            LazyRow(
                contentPadding = PaddingValues(16.dp, 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items((0..6).map { "suggested$it" }) { item ->
                    Column(modifier = Modifier.clickable {
                        navController.navigate("details/$item")
                    }) {
                        Image(
                            modifier = Modifier
                                .width(200.dp)
                                .height(150.dp),
                            painter = painterResource(R.drawable.ic_launcher_background),
                            contentScale = ContentScale.Crop,
                            contentDescription = ""
                        )
                        Description(data = item)
                    }
                }
            }

            Text(
                text = "All",
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp, bottom = 4.dp)
            )
        }
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            (0..6).map { "puppy$it" }.forEach { item ->
                val isBookmarked = remember { mutableStateOf(false) }

                Row(
                    modifier = Modifier.clickable {
                        navController.navigate("details/$item")
                    },
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Image(
                        modifier = Modifier.size(50.dp),
                        painter = painterResource(R.drawable.ic_launcher_background),
                        contentDescription = ""
                    )
                    Description(data = item, modifier = Modifier.weight(1f))
                    IconToggleButton(
                        checked = isBookmarked.value,
                        onCheckedChange = {
                            isBookmarked.value = !isBookmarked.value
                        }) {
                        Icon(
                            imageVector = if (isBookmarked.value) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                            contentDescription = ""
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun Description(data: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = data, style = MaterialTheme.typography.h6)
        Text(text = "breed", style = MaterialTheme.typography.caption)
        Text(text = "location", style = MaterialTheme.typography.body1)
    }
}