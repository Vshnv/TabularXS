package com.github.vshnv.tabularxs.model

import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.time.LocalDate

class InnerExpense(serial: Int, date: LocalDate, purchased: String, bill: Int, amount: Double) {
    // Model fields
    var serialNumber by SimpleIntegerProperty(serial)
    var date by SimpleObjectProperty(date)
    var purchasedFrom by SimpleStringProperty(purchased)
    var billNumber by SimpleIntegerProperty(bill)
    var amount by SimpleDoubleProperty(amount)

    // Property fetchers
    fun serialNumberProperty() = getProperty(InnerExpense::serialNumber)
    fun dateProperty() = getProperty(InnerExpense::date)
    fun purchasedFromProperty() = getProperty(InnerExpense::purchasedFrom)
    fun billNumberProperty() = getProperty(InnerExpense::billNumber)
    fun amountProperty() = getProperty(InnerExpense::amount)
}

class InnerExpenseModel : ItemViewModel<InnerExpense>() {
    val serialNumber = bind { item?.serialNumberProperty() }
    val date = bind { item?.dateProperty() }
    val purchasedFrom = bind { item?.purchasedFromProperty() }
    val billNumber = bind { item?.billNumberProperty() }
    val amount = bind { item?.amountProperty() }
}