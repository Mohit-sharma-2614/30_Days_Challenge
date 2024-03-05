package com.example.mymusic

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Check and request internet permission if not granted
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.INTERNET),
                PERMISSION_REQUEST_INTERNET
            )
        } else {
            initializeMediaPlayer()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val playPauseButton = findViewById<ImageView>(R.id.imgPlay)
        playPauseButton.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
                playPauseButton.setImageResource(R.drawable.baseline_pause_black_36)
            } else {
                mediaPlayer.pause()
                playPauseButton.setImageResource(R.drawable.baseline_play_arrow_black_24dp)
            }
        }
    }

    private fun initializeMediaPlayer() {
        mediaPlayer = MediaPlayer()
        val songLink = "http://peridot.streamguys.com:7150/Mirchi"
        mediaPlayer.apply {
            setDataSource(songLink)
            prepareAsync()
            setOnPreparedListener {
                start()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_INTERNET) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initializeMediaPlayer()
            } else {
                // Permission denied, handle accordingly
            }
        }
    }

    companion object {
        private const val PERMISSION_REQUEST_INTERNET = 101
    }
}
