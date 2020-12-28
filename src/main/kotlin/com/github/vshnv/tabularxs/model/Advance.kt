package com.github.vshnv.tabularxs.model

import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.time.LocalDate

class Advance(serial: Int, date: LocalDate, purpose: String, amount: Double) {
    // Model fields
    var serialNumber by SimpleIntegerProperty(serial)
    var date by SimpleObjectProperty(date)
    var purpose by SimpleStringProperty(purpose)
    var amount by SimpleDoubleProperty(amount)

    // Property fetchers
    fun serialNumberProperty() = getProperty(Advance::serialNumber)
    fun dateProperty() = getProperty(Advance::date)
    fun purposeProperty() = getProperty(Advance::purpose)
    fun amountProperty() = getProperty(Advance::amount)
}

class AdvanceModel : ItemViewModel<Advance>() {
    val serialNumber = bind { item?.serialNumberProperty() }
    val date = bind { item?.dateProperty() }
    val purpose = bind { item?.purposeProperty() }
    val amount = bind { item?.amountProperty() }
}


