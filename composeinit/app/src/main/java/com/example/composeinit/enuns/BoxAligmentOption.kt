package com.example.composeinit.enuns

import androidx.compose.ui.Alignment

class BoxAligmentOption (
    val label:String,
    val value: Alignment
){
    TOP_START(label="TopStart", value = Aligment.TopStar),
    TOP_CENTER(label="TopCenter", value = Aligment.TopCenter),
    TOP_END(label="TopEnd", value = Aligment.TopEnd),
    CENTER(label="Center", value = Aligment.Center),
    CENTER_STAR(label="Center", value = Aligment.Center),
    CENTER_END(label="Center", value = Aligment.Center),
    BOTON_START(label="Botton End", value = Aligment.BotonEnd),
    BOTON_CENTER(label="Botton End", value = Aligment.BotonEnd),
    BOTON_END(label="Botton End", value = Aligment.BotonEnd),
}