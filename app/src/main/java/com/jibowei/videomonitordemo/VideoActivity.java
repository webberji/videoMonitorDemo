package com.jibowei.videomonitordemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.HashMap;
import java.util.Map;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by jibowei on 16/4/12.
 */
public class VideoActivity extends Activity {

    private VideoView mVideoView;
    private MediaController mediaController;
    private ImageView playImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_layout);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout);
        int width = relativeLayout.getLayoutParams().width;
        int height = relativeLayout.getLayoutParams().height;
//
//        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
//        System.out.println(layoutParams.height);
//
//        int a = layoutParams.height = (int) (0.66 * (double) width);
//        System.out.println(width);
//        System.out.println("aaa" +  a);
//        relativeLayout.setLayoutParams(layoutParams);
//
//        System.out.println(layoutParams.width);
//        System.out.println(layoutParams.height);

        playImage = (ImageView) findViewById(R.id.play);
        playImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playImage.setVisibility(View.INVISIBLE);
                init();
            }
        });

    }

    private void init() {
        mVideoView = (VideoView) findViewById(R.id.videoView);

        Intent intent = getIntent();
        String path = intent.getStringExtra("path");
//         Map options = new HashMap<>();
//            options.put("rtmp_playpath", "");
//            options.put("rtmp_swfurl", "");
//            options.put("rtmp_live", "1");
//            options.put("rtmp_pageurl", "");
//        path = Environment.getDataDirectory().getPath()+ "/1.mp4";
        System.out.println(path);

        mVideoView.setVideoPath(path);
//        mVideoView.setVideoPath(path);
//                //mVideoView.setVideoURI(Uri.parse(path), options);
//        mVideoView.setVideoLayout(VideoView.VIDEO_LAYOUT_ORIGIN, 0);
//        mediaController.setFileName("摄像头1");
//        mVideoView.setMediaController(mediaController);


        mVideoView.setVideoLayout(VideoView.VIDEO_LAYOUT_SCALE, 0);
        mVideoView.requestFocus();
//
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setPlaybackSpeed(1.0f);
            }
        });
        mVideoView.start();

        System.out.println(mVideoView.getVideoWidth());
        System.out.println(mVideoView.getVideoHeight());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
