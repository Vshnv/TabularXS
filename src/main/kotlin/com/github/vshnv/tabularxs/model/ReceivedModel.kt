package com.github.vshnv.tabularxs.model

import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import tornadofx.*
import java.time.LocalDate

class ReceivedModel {
    // Model fields
    var serialNumber: Int by SimpleIntegerProperty()
    var date: LocalDate by SimpleObjectProperty()
    var billNumber: Int by SimpleIntegerProperty()
    var amount: Double by SimpleDoubleProperty()

    // Property fetchers
    fun serialNumberProperty() = getProperty(ReceivedModel::serialNumber)
    fun dateProperty() = getProperty(ReceivedModel::date)
    fun billNumberProperty() = getProperty(ReceivedModel::billNumber)
    fun amountProperty() = getProperty(ReceivedModel::amount)
}

class ReceivedModelModel : ItemViewModel<ReceivedModel>() {
    val serialNumber = bind { item?.serialNumberProperty() }
    val date = bind { item?.dateProperty() }
    val billNumber = bind { item?.billNumberProperty() }
    val amount = bind { item?.amountProperty() }
}