package com.example.androiddevchallenge.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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

    val puppy = puppyRepository.getPuppy(id)

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
            .verticalScroll(scrollState)
    ) {
        // Images
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(puppy.images) { url ->
                CoilImage(
                    data = url,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
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

        Description(data = puppy, modifier = Modifier.padding(horizontal = 16.dp))

        Row {
            // Scrollable description of key details
        }

        Text(
            text = "${if (puppy.gender.equals("male", true)) "His" else "Her"} Story",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 4.dp)
        )
        Text(
            text = "Loerum ipsum",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Composable
private fun Description(data: PuppyModel, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = data.name, style = MaterialTheme.typography.h6)
        Text(text = data.breed, style = MaterialTheme.typography.caption)
        Text(text = data.shelter, style = MaterialTheme.typography.body1)
    }
}