package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun DetailsLayout(navController: NavController, id: String?) {
    val scrollState = rememberScrollState()

    Box {
        // Images
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
                }
            }
        }

        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .statusBarsPadding()
                .navigationBarsPadding()
                .padding(vertical = 16.dp)
                .padding(top = 150.dp)
        ) {
            Text(
                text = "All",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}