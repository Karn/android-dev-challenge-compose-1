package com.example.androiddevchallenge.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.data.PuppyModel
import com.example.androiddevchallenge.data.PuppyRepository
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainLayout(navController: NavController, puppyRepository: PuppyRepository) {
    val scrollState = rememberScrollState()

    val (searchTerm, updateSearchTerm) = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
            .verticalScroll(scrollState)
            .padding(vertical = 16.dp)
    ) {
        // Top Bar
        Text(
            text = "Rescue",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = "Bring home your best friend",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        // Search
        // TODO: On focus only show the vertical list
        BasicTextField(
            value = searchTerm,
            onValueChange = updateSearchTerm,
            textStyle = MaterialTheme.typography.body2,
            // maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            decorationBox = { innerTextField ->
                Surface(
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.medium)
                        .border(BorderStroke(2.dp, MaterialTheme.colors.onBackground))
                        .padding(vertical = 8.dp, horizontal = 8.dp)
                ) {
                    Row {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "",
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                        )
                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .weight(1f)
                                .padding(horizontal = 8.dp)
                        ) {
                            innerTextField()
                        }
                    }
                }
            },
//            imeAction = ImeAction.Search,
//            onImeActionPerformed = { action, softwareController ->
//                if (action == ImeAction.Search) {
//                    softwareController.hideSoftwareKeyboard()
//                    // do something here
//                }
//            }
        )

        val selectedView = remember { mutableStateOf(0) }

        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = { selectedView.value = 0 }) {
                Text(text = "All", style = MaterialTheme.typography.body1)
            }
            Button(onClick = { selectedView.value = 1 }) {
                Text(text = "Liked", style = MaterialTheme.typography.body1)
            }
        }

        AnimatedVisibility(visible = searchTerm.text.isBlank() && selectedView.value == 0) {
            Column {
                Text(
                    text = "New comers",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                )
                LazyRow(
                    contentPadding = PaddingValues(16.dp, 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Filter to most recent 5
                    items(puppyRepository.getSuggestedPuppies()) { puppy ->
                        Column(modifier = Modifier.clickable {
                            navController.navigate("details/${puppy.id}")
                        }) {
                            CoilImage(
                                data = puppy.images.first(),
                                modifier = Modifier
                                    .width(200.dp)
                                    .height(150.dp)
                                    .clip(MaterialTheme.shapes.medium),
                                contentScale = ContentScale.Crop,
                                contentDescription = "",
                                fadeIn = true,
                                loading = {
                                    Spacer(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(MaterialTheme.colors.surface)
                                    )
                                }
                            )
                            Description(data = puppy)
                            // TODO: Add the like button
                        }
                    }
                }
            }
        }

        Text(
            text = if (selectedView.value == 0) "All" else "Liked",
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 4.dp)
        )
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            puppyRepository.getPuppies(searchTerm.text).forEach { puppy ->
                val isBookmarked = remember { mutableStateOf(false) }

                Row(
                    modifier = Modifier.clickable {
                        navController.navigate("details/${puppy.id}")
                    },
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CoilImage(
                        data = puppy.images.first(),
                        modifier = Modifier.size(75.dp)
                            .clip(MaterialTheme.shapes.medium),
                        contentScale = ContentScale.Crop,
                        contentDescription = "",
                        fadeIn = true,
                        loading = {
                            Spacer(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(MaterialTheme.colors.surface)
                            )
                        }
                    )
                    Description(data = puppy, modifier = Modifier.weight(1f))
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
private fun Description(data: PuppyModel, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = data.name, style = MaterialTheme.typography.body1)
        Text(text = data.breed, style = MaterialTheme.typography.body2)
        Text(text = data.shelter, style = MaterialTheme.typography.body2)
    }
}