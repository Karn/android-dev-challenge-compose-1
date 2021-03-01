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

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.Pets
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.data.PuppyModel
import com.example.androiddevchallenge.data.PuppyRepository
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun DetailsLayout(navController: NavController, puppyRepository: PuppyRepository, id: String?) {
    if (id.isNullOrBlank()) {
        // Empty state
        Spacer(modifier = Modifier)
        return
    }

    val context = LocalContext.current
    val puppy = puppyRepository.getPuppy(id)

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        TopAppBar(
            title = {},
            elevation = 0.dp,
            backgroundColor = Color.Transparent,
            contentColor = contentColorFor(MaterialTheme.colors.background),
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "",
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .clickable {
                            navController.navigateUp()
                        }
                        .padding(horizontal = 16.dp)
                )
            }
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(scrollState)
        ) {
            // Images
            // TODO: weird scrolling behaviour is causing the list to jump
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                items(puppy.images) { (url, x, y) ->
                    CoilImage(
                        data = url,
                        modifier = Modifier
                            .fillMaxWidth()
                            .defaultMinSize(
                                minWidth = 250.dp
                            )
                            .height(250.dp)
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
                }
            }

            val isBookmarked = mutableStateOf(puppy.liked)

            Row(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp)
            ) {
                Description(
                    data = puppy,
                    modifier = Modifier
                        .weight(1f)
                )
                IconToggleButton(
                    checked = isBookmarked.value,
                    onCheckedChange = {
                        isBookmarked.value = !isBookmarked.value
                        puppyRepository.setPuppyLiked(puppy.id, isBookmarked.value)
                    }
                ) {
                    Icon(
                        imageVector = if (isBookmarked.value) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        tint = MaterialTheme.colors.primary,
                        contentDescription = ""
                    )
                }
            }

            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Scrollable description of key details
                AttributeItem(
                    label = "Gender",
                    value = puppy.gender
                )
                AttributeItem(
                    label = "Age",
                    value = puppy.age
                )
                AttributeItem(
                    label = "Weight",
                    value = puppy.weight
                )
            }

            Text(
                text = "Characteristics",
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp, bottom = 4.dp)
            )
            Text(
                text = puppy.characteristics,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(horizontal = 16.dp).padding(bottom = 8.dp)
            )

            Text(
                text = "Health",
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp, bottom = 4.dp)
            )
            Text(
                text = puppy.health,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(horizontal = 16.dp).padding(bottom = 8.dp)
            )

            Text(
                text = "${if (puppy.gender.equals("male", true)) "His" else "Her"} Story",
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp, bottom = 4.dp)
            )
            Text(
                text = puppy.bio,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(horizontal = 16.dp).padding(bottom = 32.dp)
            )
        }

        Surface(
            color = MaterialTheme.colors.secondary,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(puppy.link))
                    context.startActivity(browserIntent)
                }
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Text(
                    text = "Learn more about ${puppy.name}",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Composable
private fun Description(data: PuppyModel, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = data.name, style = MaterialTheme.typography.h6,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Row {
            Icon(
                imageVector = Icons.Default.Pets,
                contentDescription = "",
                tint = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .size(12.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = "${data.breed} - ${data.color}",
                style = MaterialTheme.typography.body2,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
        Row {
            Icon(
                imageVector = Icons.Default.House,
                contentDescription = "",
                tint = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .size(12.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = data.shelter,
                style = MaterialTheme.typography.body2,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Composable
private fun RowScope.AttributeItem(
    label: String,
    value: String
) {
    Column(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .border(
                BorderStroke(
                    2.dp,
                    MaterialTheme.colors.onBackground.copy(alpha = 0.1f)
                )
            )
            .weight(1f)
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = label,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}
