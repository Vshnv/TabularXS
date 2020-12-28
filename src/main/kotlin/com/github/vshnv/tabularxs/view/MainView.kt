package com.github.vshnv.tabularxs.view

import com.github.vshnv.tabularxs.model.Advance
import com.github.vshnv.tabularxs.model.DataTableViewModel
import javafx.scene.image.Image
import tornadofx.*
import java.time.LocalDate

class MainView : View("TabularXS") {
    val pageView: PageView by inject()
    override val root = borderpane {
        // Nav bar
        left<NavigationView>()

        // Page
        center<PageView>()
    }

    init {
        val advances = listOf(
                Advance(5, LocalDate.now(), "a", 5.0),
                Advance(10, LocalDate.now(), "b",56.0)
        )
        val columns = listOf(
                "sl" to Advance::serialNumber,
                "amount" to Advance::amount,
                "date" to Advance::date,
                "purpose" to Advance::purpose
        )
        val tableViewModel = DataTableViewModel(advances, columns)
        val table = DataTableView(tableViewModel)
        pageView.page = table.root
    }

    // Defining window properties
    init {
        setWindowMinSize(1250,750)
        primaryStage.icons += Image(MainView::class.java.getResourceAsStream("/icon.png"))
    }
}