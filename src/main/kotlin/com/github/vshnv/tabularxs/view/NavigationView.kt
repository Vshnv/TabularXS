package com.github.vshnv.tabularxs.view

import com.github.vshnv.tabularxs.app.Icons
import com.github.vshnv.tabularxs.app.Styles
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView
import tornadofx.*

class NavigationView: View() {
    companion object {
        private const val NAVBAR_WIDTH = 300.0
    }

    val pageView: PageView by inject()

    override val root = vbox {
        // --- Title ---
        label("TABULAR",Icons.LOGO.iconSingleton) {
            //TODO:: addClass(Styles.centered, Styles.logo)
            setPrefSize(NAVBAR_WIDTH, 200.0)
        }
        // --- Navigation Listing ---
        listmenu(theme = "blue") {
            // Define default size
            setPrefSize(NAVBAR_WIDTH, 550.0)

            // Scale with window
            prefHeightProperty().bind(this@vbox.heightProperty())

            // Navigation options
            transitionItem(text = "Home", graphic = Icons.HOME.icon, active = true)
            transitionItem(text = "Receipts", graphic = Icons.TABLE.icon)
            transitionItem(text = "Expense", graphic = Icons.TABLE.icon)
            transitionItem(text = "Advance", graphic = Icons.TABLE.icon)
            transitionItem(text = "Debit", graphic = Icons.TABLE.icon)
            transitionItem(text = "Print", graphic = Icons.PRINT.icon)
        }
    }

    private fun ListMenu.transitionItem(text: String, graphic: FontAwesomeIconView, active: Boolean = false, selectionCallback: ListMenuItem.() -> Unit = {}) {
        item(text, graphic) {
            if (active) activeItem = this
            whenSelected {
                println("Navigation: selected $text")
                this.selectionCallback()
            }
        }
    }
}