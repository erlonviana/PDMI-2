package com.example.composeinit.enuns

import androidx.compose.ui.Alignment

enum class RowAligmentOption(
    val label:String,
    val value: Alignment.Vertical
){
    TOP("Top", Alignment.Top),
    CENTER("Center", Alignment.CenterVertically),
    BOTTOM("Bottom", Alignment.Bottom)
}