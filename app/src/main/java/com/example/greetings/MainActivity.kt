package com.example.greetings

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.bumptech.glide.Glide


class MainActivity : ComponentActivity() {
    lateinit var textInput: EditText;
    lateinit var titleText: TextView;
    lateinit var titleTextSecond: TextView;
    lateinit var mediaPlayer: MediaPlayer;
    lateinit var playerButton: Button;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout);

        titleText = findViewById(R.id.textView);
        textInput = findViewById(R.id.editTextText);
        mediaPlayer = MediaPlayer.create(this, R.raw.kotik)
    }

    @SuppressLint("SetTextI18n")
    public fun onUpdate(view: View) {
        setContentView(R.layout.layout2)
        // Initialize playerButton in this layout
        playerButton = findViewById(R.id.music)
        playerButton.setOnClickListener { playIt() } // Set button listener here

        titleTextSecond = findViewById(R.id.textView3);
        titleTextSecond.text = "Hi " + textInput.text + "!";
        Glide.with(this)
            .asGif()
            .load(R.drawable.dancingcat) // replace with your GIF file
            .into(findViewById(R.id.imageView4))
        mediaPlayer.start();
    }

    public fun playIt() {
       if(mediaPlayer.isPlaying) {
           mediaPlayer.pause()          // Pause playback
           mediaPlayer.seekTo(0)
           playerButton.text = "Play";
       } else {
           mediaPlayer.start();
           playerButton.text = "Pause";
       }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
        mediaPlayer.release()
    }
}