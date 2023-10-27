package com.example.myapplication.html

import java.lang.StringBuilder

fun html(block: Html.() -> Unit): Html {
    val html = Html()
    html.block()
    return html
}

// <html>标签
class Html() : BaseElement("html") {
    fun head(block: Head.() -> Unit): Head {
        val head = Head()
        head.block()
        addElement(head)
        return head
    }

    fun body(block: Body.() -> Unit): Body {
        val body = Body()
        body.block()
        addElement(body)
        return body
    }
}

// <head>标签
class Head : BaseElement("head") {
    fun title(block: () -> String): Title {
        val content = block()
        val title = Title(content)
        addElement(title)
        return title
    }
}

// <title>标签
class Title(content: String) : BaseElement("title", content)

// <body>标签
class Body : BaseElement("body") {
    fun h1(block: () -> String): H1 {
        val content = block()
        val h1 = H1(content)
        addElement(h1)
        return h1
    }

    fun p(block: () -> String): P {
        val content = block()
        val p = P(content)
        addElement(p)
        return p
    }

    fun a(href: String = "", block: () -> String): A {
        val content = block()
        val a = A(content).apply {
            this.href = href
        }
        addElement(a)
        return a
    }

    fun img(src: String = "", alt: String = ""): Img {
        val img = Img().apply {
            this.src = src
            this.alt = alt
        }
        addElement(img)
        return img
    }
}

// <h1>标签
class H1(content: String) : BaseElement("h1", content)

// <p>标签
class P(content: String) : BaseElement("p", content)

// <a>标签
class A(content: String) : BaseElement("a", content) {
    var href: String
        get() = attributes["href"]!!
        set(value) {
            attributes["href"] = value
        }
}

// <img>标签
class Img : BaseElement("img") {
    var src: String
        get() = attributes["src"]!!
        set(value) {
            attributes["src"] = value
        }

    var alt: String
        get() = attributes["alt"]!!
        set(value) {
            attributes["alt"] = value
        }

    override fun render(builder: StringBuilder, indent: String): String {
        return builder.append("$indent<$tagName")
            .append(renderAttributes())
            .append(" />\n")
            .toString()
    }
}

