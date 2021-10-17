package com.example.xml_rss_retrofit_parser.channel

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "image", strict = false)
class Image constructor(): Serializable {
    @field:Element(name = "title")
    var title: String? = null

    @field:Element(name = "url")
    var url: String? = null

    @field:Element(name = "link")
    var link: String? = null

    override fun toString(): String {
        return "image{" +
                "name='" + title + '\'' +
                ", uri='" + url + '\'' +
                '}'
    }
}