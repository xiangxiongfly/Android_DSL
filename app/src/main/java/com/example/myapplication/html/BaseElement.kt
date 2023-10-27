package com.example.myapplication.html

import java.lang.StringBuilder

/**
 * 需要传入标签名和内容
 * 每个元素都有标签名，如：<p>hello</p>、<img />
 */
open class BaseElement(val tagName: String, val content: String = "") : IElement {

    private val children = mutableListOf<BaseElement>() //元素内的所有子元素
    private val _attributes = mutableMapOf<String, String>() //元素的属性名和属性值
    protected val attributes get() = _attributes

    protected fun addElement(element: BaseElement) {
        this.children.add(element)
    }

    protected fun renderAttributes(): String {
        val builder = StringBuilder()
        if (attributes.isNotEmpty()) {
            for ((attrName, attrValue) in attributes) {
                builder.append(""" $attrName="$attrValue"""")
            }
        }
        return builder.toString()
    }

    override fun render(builder: StringBuilder, indent: String): String {
        builder.append("$indent<$tagName")
        builder.append(renderAttributes())
        builder.append(">\n")
        if (content.isNotBlank()) {
            builder.append("    $indent$content\n")
        }
        children.forEach {
            it.render(builder, "    $indent")
        }
        builder.append("$indent</$tagName>\n")
        return builder.toString()
    }

    operator fun invoke(): String {
        val builder = StringBuilder()
        return render(builder, "")
    }
}
