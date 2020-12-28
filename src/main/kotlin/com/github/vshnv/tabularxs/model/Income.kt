package com.github.vshnv.tabularxs.model

import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.time.LocalDate


class Income(serial: Int, date: LocalDate, receipt: Int, customer: String, amount: Double) {
    // Model fields
    var serialNumber by SimpleIntegerProperty(serial)
    var date by SimpleObjectProperty(date)
    var receiptNumber by SimpleIntegerProperty(receipt)
    var customerName by SimpleStringProperty(customer)
    var amount by SimpleDoubleProperty(amount)

    // Property fetchers
    fun serialNumberProperty() = getProperty(Income::serialNumber)
    fun dateProperty() = getProperty(Income::date)
    fun receiptNumberProperty() = getProperty(Income::receiptNumber)
    fun customerNameProperty() = getProperty(Income::customerName)
    fun amountProperty() = getProperty(Income::amount)
}

class IncomeModel : ItemViewModel<Income>() {
    val serialNumber = bind { item?.serialNumberProperty() }
    val date = bind { item?.dateProperty() }
    val receiptNumber = bind { item?.receiptNumberProperty() }
    val customerName = bind { item?.customerNameProperty() }
    val amount = bind { item?.amountProperty() }
}