package com.example.petspital.data.network

import android.util.Log
import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "rfcOpenApi")
data class XmlResponse(
    @Element
    val header: Header?,
    @Element
    val body: Body?
) {

}

@Xml(name = "header")
data class Header(
    @PropertyElement
    val resultCode: Int?,
    @PropertyElement
    val resultMsg: String?,
)

@Xml(name = "body")
data class Body(
    @Element
    val data: List<Items>?,
    @PropertyElement
    val numOfRows: Int?,
    @PropertyElement
    val pageNo: Int?,
    @PropertyElement
    val totalCount: Int?,
)

@Xml(name = "data")
data class Items(
    @Element(name = "list")
    val item: List<Item>?
)

@Xml(name = "list")
data class Item(
    @PropertyElement(name = "address") var address: String?,
    @PropertyElement(name = "appDate") var appDate: String?,
    @PropertyElement(name = "entId") var entId: String?,
    @PropertyElement(name = "gugun") var gugun: String?,
    @PropertyElement(name = "tel") var tel: String?,
    @PropertyElement(name = "title") var title: String?,
) {
    constructor() : this(null, null, null, null, null, null)
}