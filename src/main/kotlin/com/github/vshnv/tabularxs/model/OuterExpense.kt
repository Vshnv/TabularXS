package com.github.vshnv.tabularxs.model

import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.time.LocalDate

class OuterExpense(serial: Int, date: LocalDate, receiptNumber: Int, customerName: String, purchased: String, bill: Int, amount: Double) {
    // Model fields
    var serialNumber by SimpleIntegerProperty(serial)
    var date by SimpleObjectProperty(date)
    var receiptNumber by SimpleIntegerProperty(receiptNumber)
    var customerName by SimpleStringProperty(customerName)
    var purchasedFrom by SimpleStringProperty(purchased)
    var billNumber by SimpleIntegerProperty(bill)
    var amount by SimpleDoubleProperty(amount)

    // Property fetchers
    fun serialNumberProperty() = getProperty(OuterExpense::serialNumber)
    fun dateProperty() = getProperty(OuterExpense::date)
    fun receiptNumberProperty() = getProperty(OuterExpense::receiptNumber)
    fun customerNameProperty() = getProperty(OuterExpense::customerName)
    fun purchasdFromProperty() = getProperty(OuterExpense::purchasedFrom)
    fun billNumberProperty() = getProperty(OuterExpense::billNumber)
    fun amountProperty() = getProperty(OuterExpense::amount)
}

class OuterExpenseModel : ItemViewModel<OuterExpense>() {
    val serialNumber = bind { item?.serialNumberProperty() }
    val date = bind { item?.dateProperty() }
    val receiptNumberbind = bind { item?.receiptNumberProperty() }
    val customerName = bind { item?.customerNameProperty() }
    val purchasedFrom = bind { item?.purchasdFromProperty() }
    val billNumber = bind { item?.billNumberProperty() }
    val amount = bind { item?.amountProperty() }
}
