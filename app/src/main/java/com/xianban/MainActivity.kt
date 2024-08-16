package com.xianban


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.xianban.pr.HorizontalProgressBar
import com.xianban.pr.Progress
import com.xianban.progress.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        findViewById<HorizontalProgressBar>(R.id.progress).setProgress(Progress(50,"#ffa668e3","#ff33ff"))
    }
}