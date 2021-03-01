/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.data.PuppyModel
import com.example.androiddevchallenge.data.PuppyRepository
import com.example.androiddevchallenge.ui.common.Title
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
    ) {
        // Top Bar
        TopAppBar(
            title = {},
            elevation = 0.dp,
            backgroundColor = Color.Transparent,
            contentColor = contentColorFor(MaterialTheme.colors.background),
            navigationIcon = {
            },
            actions = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .clickable {
                            navController.navigate("settings")
                        }
                        .padding(horizontal = 16.dp)
                )
            }
        )

        Title()

        // Search
        // TODO: On focus only show the vertical list, also when focused change color to primary
        val focusManager = LocalFocusManager.current
        BasicTextField(
            value = searchTerm,
            onValueChange = updateSearchTerm,
            textStyle = MaterialTheme.typography.body2.copy(
                color = contentColorFor(MaterialTheme.colors.background)
            ),
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            cursorBrush = SolidColor(contentColorFor(MaterialTheme.colors.background)),
            decorationBox = { innerTextField ->
                Surface(
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.medium)
                        .border(BorderStroke(2.dp, MaterialTheme.colors.onBackground))
                        .padding(vertical = 8.dp, horizontal = 8.dp),
                    contentColor = contentColorFor(MaterialTheme.colors.background)
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
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    focusManager.clearFocus()
                }
            )
        )

        val selectedView = remember { mutableStateOf(0) }

        // TODO: Clean this up into an actual Toggle Item
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { selectedView.value = 0 },
                elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp),
                border = BorderStroke(2.dp, MaterialTheme.colors.primary),
                colors = if (selectedView.value == 0) ButtonDefaults.buttonColors() else ButtonDefaults.outlinedButtonColors()
            ) {
                Text(text = "All", style = MaterialTheme.typography.body1)
            }
            Button(
                onClick = { selectedView.value = 1 },
                elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp),
                border = BorderStroke(2.dp, MaterialTheme.colors.primary),
                colors = if (selectedView.value == 1) ButtonDefaults.buttonColors() else ButtonDefaults.outlinedButtonColors()
            ) {
                Text(text = "Liked", style = MaterialTheme.typography.body1)
            }
        }

        AnimatedVisibility(visible = searchTerm.text.isBlank() && selectedView.value == 0) {
            Column(modifier = Modifier.padding(vertical = 16.dp)) {
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
                        Column(
                            modifier = Modifier
                                .width(200.dp)
                                .clickable {
                                    navController.navigate("details/${puppy.id}")
                                }
                        ) {
                            CoilImage(
                                data = puppy.images.first().first,
                                modifier = Modifier
                                    .fillMaxWidth()
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
                            Description(
                                data = puppy,
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
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
            modifier = Modifier.padding(vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Is this working as expected?
            val puppyData = puppyRepository.getPuppies(searchTerm.text, selectedView.value == 1)
            // TODO: Empty state

            if (puppyData.isEmpty()) {
                // Show empty state

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    // TODO: Add image
                    Text(
                        text = if (searchTerm.text.isNotEmpty())
                            "No puppies matched your search query"
                        else
                            "You have no puppies in your Liked list",
                        style = MaterialTheme.typography.body1,
                    )
                }
            } else {
                PuppyList(navController, puppyData) { id, liked ->
                    puppyRepository.setPuppyLiked(id, liked)
                }
            }
        }
    }
}

@Composable
private fun Description(data: PuppyModel, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = data.name, style = MaterialTheme.typography.body1,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = "${data.breed} - ${data.color}",
            style = MaterialTheme.typography.body2,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = data.shelter, style = MaterialTheme.typography.body2,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
private fun PuppyList(
    navController: NavController,
    data: List<PuppyModel>,
    onLikeChanged: (String, Boolean) -> Unit = { id, liked -> }
) {
    data.forEach { puppy ->
        val isBookmarked = mutableStateOf(puppy.liked)

        Row(
            modifier = Modifier
                .clickable {
                    navController.navigate("details/${puppy.id}")
                }
                .padding(vertical = 4.dp)
                .padding(start = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            CoilImage(
                data = puppy.images.first().first,
                modifier = Modifier.size(75.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop,
                contentDescription = "",
                loading = {
                    Spacer(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colors.onBackground.copy(alpha = 0.1f))
                    )
                }
            )
            Description(
                data = puppy,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            )
            IconToggleButton(
                checked = isBookmarked.value,
                onCheckedChange = {
                    isBookmarked.value = !isBookmarked.value
                    onLikeChanged(puppy.id, isBookmarked.value)
                }
            ) {
                Icon(
                    imageVector = if (isBookmarked.value) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    tint = MaterialTheme.colors.primary,
                    contentDescription = ""
                )
            }
        }
    }
}
