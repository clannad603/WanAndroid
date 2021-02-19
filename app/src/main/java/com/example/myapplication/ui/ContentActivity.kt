package com.example.myapplication.ui


import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.util.Log
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityContentBinding
import com.example.myapplication.ui.base.BaseActivity
import com.example.myapplication.ui.base.BaseViewModel
import com.tencent.smtt.sdk.WebChromeClient
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient
import kotlinx.android.synthetic.main.activity_content.*

class ContentActivity : BaseActivity<BaseViewModel,ActivityContentBinding>() {

    companion object {
        const val URL = "url"
    }

     override fun initData() {
         intent?.extras?.getString(URL).let {
             webView.loadUrl(it)
         }
     }

     override fun initListener() {
         v.toolbar.setNavigationOnClickListener {
             super.onBackPressed()
         }
     }

     override fun initView() {
         initWebView()
     }

     override fun initVM() {
     }
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun initWebView() {
        this.resources
            .getDrawable(R.drawable.color_progressbar).also { progressBar.progressDrawable = it }
        webView.run {
            webViewClient = object : WebViewClient() {

                override fun onPageStarted(p0: WebView?, p1: String?, p2: Bitmap?) {
                    super.onPageStarted(p0, p1, p2)
                    progressBar.visibility = View.VISIBLE
                }

                override fun onPageFinished(p0: WebView?, p1: String?) {
                    super.onPageFinished(p0, p1)
                    progressBar.visibility = View.GONE
                }
            }
            webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(p0: WebView?, p1: Int) {
                    super.onProgressChanged(p0, p1)
                    progressBar.progress = p1
                    Log.e("browser", p1.toString())
                }

                override fun onReceivedTitle(p0: WebView?, p1: String?) {
                    super.onReceivedTitle(p0, p1)
                    p1?.let { v.toolbar.title = p1 }
                }

            }
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) webView.goBack()
        else super.onBackPressed()
    }
 }