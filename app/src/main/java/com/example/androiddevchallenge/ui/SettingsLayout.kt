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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.ui.common.Title
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun SettingsLayout(
    navController: NavController,
    themeConfig: MutableState<Pair<Boolean, Boolean>>
) {
    val scrollState = rememberScrollState()
    val (useSystemSettings, darkMode) = themeConfig.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .verticalScroll(scrollState)
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

        Title()

        Text(
            text = "Dark mode",
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 4.dp)
        )
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = "Use system setting",
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
            Switch(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                checked = useSystemSettings,
                onCheckedChange = { isChecked ->
                    themeConfig.value = Pair(isChecked, darkMode)
                }
            )
        }
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = "Force enable dark mode",
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
            Switch(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                enabled = !useSystemSettings,
                checked = darkMode,
                onCheckedChange = { isChecked ->
                    themeConfig.value = Pair(useSystemSettings, isChecked)
                }
            )
        }

        Text(
            text = "Credits",
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 4.dp)
        )

        Text(
            text = """
                • Petfinder.ca -- source puppy data and images.
                • Katheleen (https://dribbble.com/katheleen-lmr) -- for app design inspiration; https://dribbble.com/shots/11078244-Pet-Adoption-App-Concept/attachments/2675838?mode=media
                • Jetpack Compose Samples, Owl -- https://github.com/android/compose-samples/tree/main/Owl
            """.trimIndent(),
            style = MaterialTheme.typography.body2,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
}
