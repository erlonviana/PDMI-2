package com.example.composeinit.enuns

import androidx.compose.foundation.layout.Arrangement

enum class ArrangementOption(
    val label: String,
    val value: Arrangement.Horizontal
) {
    START("Start", Arrangement.Start),
    CENTER("Center", Arrangement.Center),
    END("End", Arrangement.End),
    SPACE_BETWEEN("SpaceBetween", Arrangement.SpaceBetween),
    SPACE_EVENLY("SpaceEvenly", Arrangement.SpaceEvenly),
}