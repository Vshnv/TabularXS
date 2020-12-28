package com.github.vshnv.tabularxs.app

import javafx.scene.text.Font
import tornadofx.*

enum class Fonts(private val path: String, private val size: Double) {
    BALSAMIG_SANS("/fonts/BalsamiqSans-Regular.ttf", 30.0);

    val font
        get() = loadFont(path, size)
    val fontSingleton = font
}