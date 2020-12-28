package com.github.vshnv.tabularxs.view

import com.github.vshnv.tabularxs.model.Advance
import com.github.vshnv.tabularxs.model.AdvanceModel
import com.github.vshnv.tabularxs.model.DataTableViewModel
import javafx.beans.property.ReadOnlyListProperty
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.css.Styleable
import javafx.scene.control.Button
import javafx.scene.control.TableCell
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.layout.Priority
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.scene.shape.Shape
import javafx.scene.text.FontWeight
import javafx.stage.Modality
import tornadofx.*

class DataTableView<T>(viewModel: DataTableViewModel<T>, fieldInitializer: TableView<T>.() -> Unit): View() {
    companion object {
        inline operator fun <reified T> invoke(viewModel: DataTableViewModel<T>): DataTableView<T> {
            return DataTableView(viewModel, tableColumns(viewModel))
        }
    }
    override val root = tableview(viewModel.observableList) {
        columnResizePolicy = SmartResize.POLICY
        hgrow = Priority.ALWAYS
        tableButton("X") {
            style {
                btnShape = Circle(3.0)
            }
            onClick {
                delete(it)
            }
        }
        tableButton("E") {
            style {
                fontWeight = FontWeight.EXTRA_BOLD
            }
            onClick {
                edit(it)
            }
        }
        fieldInitializer()
    }

    fun delete(model: T) {
        println(model)
    }

    fun edit(model: T) {
        println(model)
    }



    private fun TableView<T>.tableButton(name: String, action: TableButton<T>.() -> Unit) {

        addColumnInternal(
                TableColumn<T, T>("").apply {
                    setCellValueFactory { param ->
                        ReadOnlyObjectWrapper(param.value)
                    }
                    setCellFactory {
                        object : TableCell<T, T>() {
                            private val tableBtn = TableButton<T>().apply(action)
                            val editButton = button(text = name).apply {
                                tableBtn.tableStyle?.let {setStyles ->
                                    style {
                                        setStyles()
                                    }
                                }
                                tableBtn.shape?.let {
                                    shape = it
                                }
                            }

                            override fun updateItem(model: T?, empty: Boolean) {
                                super.updateItem(model, empty)
                                if (model == null) {
                                    graphic = null
                                    return
                                }
                                graphic = editButton
                                tableBtn.action?.let { onClickAction ->
                                    this.editButton.setOnAction { onClickAction(model) }
                                }
                            }
                        }
                    }
                }.contentWidth()
        )
    }

    protected class TableButton<T> {
        var tableStyle: (InlineCss.() -> Unit)? = null
        var shape: Shape? = null
        var action: ((T) -> Unit)? = null

        fun style(styles: (InlineCss.() -> Unit)) {
            tableStyle = styles
        }

        fun onClick(action: (T) -> Unit) {
            this.action = action;
        }

        var InlineCss.btnShape: Shape?
            get() = this@TableButton.shape
            set(value) {
                this@TableButton.shape = value
            }
    }
}

inline fun <reified T> tableColumns(viewModel: DataTableViewModel<T>): TableView<T>.() -> Unit = {
    viewModel.columns.forEach {
        readonlyColumn(it.first, it.second)
    }
}