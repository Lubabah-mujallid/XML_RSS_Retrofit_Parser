package com.example.xml_rss_retrofit_parser.channel.item

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text
import retrofit2.http.Path
import java.io.Serializable

@Root(name = "item", strict = false)
class Item @JvmOverloads constructor(
    @field:Element(name = "title")
    @param:Element(name = "title")
    var title: String? = null): Serializable{}

/*
@Element(name = "pubdate")
    //@param:Element(name = "pubdate")
    var pubdate: String? = null

    @field:Element(name = "link")
    @param:Element(name = "link")
    @Path("com.example.xml_rss_retrofit_parser.channel.item.link")
    //@Text(required=true)
    var link: String? = null,

    @field:Element(name = "description")
    //@param:Element(name = "description")
    //@Text(required = false)
    //@Path("rss/channel/item/description")
    val description: String? = null

    @field:Element(name = "guid")
    @param:Element(name = "guid")
    val guid: String? = null,


 */

    /*
    @field:Element(name = "dc:creator")
    @param:Element(name = "dc:creator")
    val dccreator: String? = null,

    @field:Element(name = "pubdate")
    @param:Element(name = "pubdate")
    val pubdate: String? = null,


     */
    /*
    @field:ElementList(inline = true, name = "category")
    @param:Element(name = "category")
    val category: ArrayList<String>? = null,



    @field:Element(name = "media:credit")
    @param:Element(name = "media:credit")
    val mediacredit: String? = null

     */

