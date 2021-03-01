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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.PuppyRepository
import com.example.androiddevchallenge.ui.DetailsLayout
import com.example.androiddevchallenge.ui.MainLayout
import com.example.androiddevchallenge.ui.SettingsLayout
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This app draws behind the system bars, so we want to handle fitting system windows
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            ProvideWindowInsets {
                val themeConfig = remember { mutableStateOf(Pair(true, false)) }
                val (useSystemSettings, darkMode) = themeConfig.value

                MyTheme(if (useSystemSettings) isSystemInDarkTheme() else darkMode) {
                    MyApp(themeConfig)
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(themeConfig: MutableState<Pair<Boolean, Boolean>>) {
    val navController = rememberNavController()
    val puppyRepository = PuppyRepository()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        NavHost(navController, startDestination = "overview") {
            // The main view
            composable("overview") {
                MainLayout(navController, puppyRepository)
            }

            // The details
            composable(
                "details/{puppyId}",
                arguments = listOf(navArgument("puppyId") { type = NavType.StringType })
            ) { backstackEntry ->
                DetailsLayout(
                    navController,
                    puppyRepository,
                    backstackEntry.arguments?.getString("puppyId")
                )
            }

            // Settings
            composable("settings") {
                SettingsLayout(navController, themeConfig)
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp(mutableStateOf(Pair(false, false)))
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp(mutableStateOf(Pair(false, true)))
    }
}
