package util

import java.util.Locale

private val LOCALE_BR = Locale("pt", "BR")
fun Double.emReais():String = String.format(LOCALE_BR, "R\$ %,2f", this)