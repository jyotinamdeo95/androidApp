package com.example.manu.myvideoapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    AudioManager audioManager;
    public void playMe(View view){
        mediaPlayer.start();
    }
    public void pauseMe(View view)
    {
        mediaPlayer.pause();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         mediaPlayer = MediaPlayer.create(this,R.raw.demoringtone);

         //getting context from audio service
         audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int myMaxVolume=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int myCurrentVolume=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);


        //Setting context value to seekbar
        SeekBar volumeRocker=(SeekBar)findViewById(R.id.seekBar);
        volumeRocker.setMax(myMaxVolume);
        volumeRocker.setProgress(myCurrentVolume);

        //set on change listener
        volumeRocker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




    }
}
