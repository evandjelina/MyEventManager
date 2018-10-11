package com.example.mem.myeventmanager;

import android.app.Activity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;


/**
 * Created by Djina on 30.3.2016.
 */
public class AddActivity extends Activity{



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("rtsp://r5---sn-4g57knl6.googlevideo.com/Cj0LENy73wIaNAmyH1fWEr3v1hMYDSANFC3FJmhXMOCoAUIASARg2brB8ZW9h7RXigELV19aMGVsOElKeUUM/7A459B49B319C09C39BBEF82AA112272075C14ED.70ABDCC39BF99F7045162C472E5EF377FA3151C3/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();



    }




}
