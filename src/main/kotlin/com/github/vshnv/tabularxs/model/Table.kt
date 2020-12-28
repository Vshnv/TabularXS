package com.github.vshnv.tabularxs.model

import javafx.beans.property.ReadOnlyListProperty
import tornadofx.*
import kotlin.reflect.KProperty1


class DataTableViewModel<T>(val list: List<T>, val columns: List<Pair<String, KProperty1<T,*>>>) {
    val observableList = list.asObservable()
}