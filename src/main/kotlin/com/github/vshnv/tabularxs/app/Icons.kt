package com.github.vshnv.tabularxs.app

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView

enum class Icons(private val iconFunc: () -> FontAwesomeIconView) {
    LOGO ({
        FontAwesomeIconView(FontAwesomeIcon.AREA_CHART).apply {
            size = "2.5em"
        }
    }),
    HOME ({
        FontAwesomeIconView(FontAwesomeIcon.HOME)
    }),
    TABLE({
        FontAwesomeIconView(FontAwesomeIcon.TABLE)
    }),
    PRINT({
        FontAwesomeIconView(FontAwesomeIcon.PRINT)
    }),
    DELETE({
        FontAwesomeIconView(FontAwesomeIcon.SHIELD)
    });

    val icon
        get() = iconFunc()
    val iconSingleton = icon
}