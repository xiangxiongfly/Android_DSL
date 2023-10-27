package com.example.myapplication.html

import java.lang.StringBuilder

interface IElement {

    // 拼接HTML字符串，每个元素都需要实现
    fun render(builder: StringBuilder, indent: String): String
}