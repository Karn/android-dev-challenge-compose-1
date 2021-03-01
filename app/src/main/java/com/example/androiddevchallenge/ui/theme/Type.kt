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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R

private val display = FontFamily(
    Font(R.font.playfair_display_bold)
)

private val regular = FontFamily(
    Font(R.font.source_sans_pro_regular),
    Font(R.font.source_sans_pro_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
private val defaultType = Typography()
val typography = Typography(
    // Display
    h3 = defaultType.h3.merge(
        TextStyle(
            fontFamily = display,
        )
    ),
    // Title
    h6 = defaultType.h6.merge(
        TextStyle(
            fontFamily = display,
            letterSpacing = 1.5.sp
        )
    ),
    // Paragraph bold
    body1 = defaultType.body1.merge(
        TextStyle(
            fontFamily = regular,
            fontWeight = FontWeight.Bold
        )
    ),
    // Paragraph
    body2 = defaultType.body2.merge(
        TextStyle(
            fontFamily = regular
        )
    ),
)
