package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.html.html
import java.io.FileOutputStream
import java.io.OutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val htmlStr = getHtmlStr()
        Log.e("TAG", htmlStr)
        viewBinding.webView.loadData(htmlStr, "text/html", "UTF-8")
        viewBinding.btnTwo.setOnClickListener {
            startActivity(Intent(this, TwoActivity::class.java))
        }
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