package com.github.vshnv.tabularxs.view

import javafx.scene.Node
import tornadofx.*


class PageView: View("PageContainer") {
    override val root = borderpane()

    var page: Node?
        get() = root.center
        set(value) {
            root.center = value
        }
}