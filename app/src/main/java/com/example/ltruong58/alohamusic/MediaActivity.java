package com.example.ltruong58.alohamusic;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


public class MediaActivity extends AppCompatActivity {
    private VideoView hulaVideoView;
    private Button ukuleleButton;
    private Button ipuButton;
    private Button hulaButton;

    private MediaPlayer ukeleleMP;
    private MediaPlayer ipuMP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        ukuleleButton = (Button) findViewById(R.id.ukuleleButton);
        ipuButton = (Button) findViewById(R.id.ipuButton);
        hulaButton = (Button) findViewById(R.id.hulaButton);

        hulaVideoView = (VideoView) findViewById(R.id.hulaVideoView);
        hulaVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName()+ "/" + R.raw.hula));
        hulaVideoView.setMediaController(new MediaController(this));

        ukeleleMP = MediaPlayer.create(this, R.raw.ukulele);
        ipuMP = MediaPlayer.create(this, R.raw.ipu);


    }

    public void playMedia(View view) {
        switch (view.getId()){
            case R.id.ukuleleButton:
                if(ukeleleMP.isPlaying()){
                    ukeleleMP.pause();
                    ukuleleButton.setText(R.string.ukulele_button_play_text);
                    // Show other 2 buttons
                    ipuButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);

                }
                else
                {
                    ukeleleMP.start();
                    ukuleleButton.setText(R.string.ukulele_button_pause_text);
                    // Hide other 2 buttons
                    ipuButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);


                }
                break;
            case R.id.ipuButton:
                if(ipuMP.isPlaying()){
                    ipuMP.pause();
                    ipuButton.setText(R.string.ipu_button_play_text);
                    // Show other 2 buttons
                    ukuleleButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);

                }
                else
                {
                    ipuMP.start();
                    ipuButton.setText(R.string.ipu_button_pause_text);
                    // Hide other 2 buttons
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);


                }
                break;
            
            case R.id.hulaButton:
                if(hulaVideoView.isPlaying()){
                    hulaVideoView.pause();
                    hulaButton.setText(R.string.hula_button_watch_text);
                    // Show other 2 buttons
                    ukuleleButton.setVisibility(View.VISIBLE);
                    ipuButton.setVisibility(View.VISIBLE);

                }
                else
                {
                    hulaVideoView.start();
                    hulaButton.setText(R.string.hula_button_pause_text);
                    // Hide other 2 buttons
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    ipuButton.setVisibility(View.INVISIBLE);


                }
                break;
        }
    }
}
