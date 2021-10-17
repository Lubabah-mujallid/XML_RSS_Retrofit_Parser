package com.example.xml_rss_retrofit_parser.channel

import com.example.xml_rss_retrofit_parser.channel.item.Item
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text
import retrofit2.http.Path
import java.io.Serializable


@Root(name = "rss", strict = false)
class Rss constructor() : Serializable {
    @field:Element(name = "channel")
    var channel: Channel? = null

    @Root(name = "channel", strict = false)
    class Channel  @JvmOverloads constructor() : Serializable {

        /*
        @field:Element(name = "title")
        var title: String? = null

        @field:Element(name = "link")
        var link: String? = ""

        @field:Element(name = "language")
        var language: String? = null

        @field:Element(name = "copyright")
        var copyright: String? = null

        @field:Element(name = "lastbuilddate")
        var lastbuilddate: String? = null

        @field:Element(name = "pubdate")
        var pubDate: String? = null

        @field:ElementList(required = false, name = "image")
        var image: Image? = null


         */
        @field:ElementList(inline = true, name = "item")
        var items: ArrayList<Item>? = null




    }

}

