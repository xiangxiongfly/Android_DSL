package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import com.example.myapplication.html.html
import java.io.FileOutputStream
import java.io.OutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webView: WebView = findViewById(R.id.webView)

        val htmlStr = getHtmlStr()
        Log.e("TAG", htmlStr)
        webView.loadData(htmlStr, "text/html", "UTF-8")
    }

    private fun getHtmlStr(): String {
        return html {
            head {
                title {
                    "hello Kotlin"
                }
            }
            body {
                h1 {
                    "hello world DSL"
                }
                p {
                    "--------------------------"
                }
                img(
                    src = "https://img-home.csdnimg.cn/images/20201124032511.png",
                    alt = "hello DSL"
                )
                p {
                    "=========================="
                }
                a(href = "https://blog.csdn.net/qq_14876133") {
                    "Kotlin"
                }
            }
        }()
    }
}