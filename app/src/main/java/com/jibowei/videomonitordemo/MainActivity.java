package com.jibowei.videomonitordemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.Toast;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private String path;
    private VideoView mVideoView;
    private VideoView mVideoView2;

    private String path1 = "rtmp://192.168.1.103:1935/myapp/video1";
    private String path2 = "rtmp://192.168.1.103:1936/myapp/video2";
    private String path3 = "rtmp://192.168.1.103:1937/myapp/video3";
    private String path4 = "rtmp://192.168.1.103:1938/myapp/video4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        if (!LibsChecker.checkVitamioLibs(this))
            return;
        setContentView(R.layout.activity_main);

        TableRow tableRow1 = (TableRow) findViewById(R.id.camera1);
        TableRow tableRow2 = (TableRow) findViewById(R.id.camera2);
        TableRow tableRow3 = (TableRow) findViewById(R.id.camera3);
        TableRow tableRow4 = (TableRow) findViewById(R.id.camera4);

        tableRow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                intent.putExtra("path", path1);
                startActivity(intent);
            }
        });

        tableRow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                intent.putExtra("path", path2);
                startActivity(intent);
            }
        });
        tableRow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                intent.putExtra("path", path3);
                startActivity(intent);
            }
        });
        tableRow4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                intent.putExtra("path", path4);
                startActivity(intent);
            }
        });

        initialVideo();

    }

    public void initialVideo() {


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                mVideoView = (VideoView) findViewById(R.id.videoView1);
//            /*options = new HashMap<>();
//            options.put("rtmp_playpath", "");
//            options.put("rtmp_swfurl", "");
//            options.put("rtmp_live", "1");
//            options.put("rtmp_pageurl", "");*/
//                mVideoView.setVideoPath(path1);
//                //mVideoView.setVideoURI(Uri.parse(path), options);
////        mVideoView.setVideoLayout(VideoView.VIDEO_LAYOUT_ORIGIN, 0);
////                mVideoView.setMediaController(new MediaController(this));
//                mVideoView.requestFocus();
//
//                mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                    @Override
//                    public void onPrepared(MediaPlayer mediaPlayer) {
//                        mediaPlayer.setPlaybackSpeed(1.0f);
//                    }
//                });
//                mVideoView.start();
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                mVideoView2 = (VideoView) findViewById(R.id.videoView2);
//            /*options = new HashMap<>();
//            options.put("rtmp_playpath", "");
//            options.put("rtmp_swfurl", "");
//            options.put("rtmp_live", "1");
//            options.put("rtmp_pageurl", "");*/
//                mVideoView2.setVideoPath(path2);
//                //mVideoView.setVideoURI(Uri.parse(path), options);
////                mVideoView2.setMediaController(new MediaController(this));
//                mVideoView2.requestFocus();
//
//                mVideoView2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                    @Override
//                    public void onPrepared(MediaPlayer mediaPlayer) {
//                        mediaPlayer.setPlaybackSpeed(1.0f);
//                    }
//                });
//                mVideoView2.start();
//            }
//        }).start();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                final RelativeLayout layout = (RelativeLayout) getLayoutInflater().inflate(R.layout.edit, null);
                final EditText text1 = (EditText) layout.findViewById(R.id.text1);
                final EditText text2 = (EditText) layout.findViewById(R.id.text2);
                final EditText text3 = (EditText) layout.findViewById(R.id.text3);
                final EditText text4 = (EditText) layout.findViewById(R.id.text4);

                text1.setHint(path1);
                text2.setHint(path2);
                text3.setHint(path3);
                text4.setHint(path4);

                new AlertDialog.Builder(this).setTitle("设置路径").setIcon(
                        android.R.drawable.ic_dialog_info).setView(layout).setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String ipText1 = text1.getText().toString().trim();
                                String ipText2 = text2.getText().toString().trim();
                                String ipText3 = text3.getText().toString().trim();
                                String ipText4 = text4.getText().toString().trim();

                                if(!ipText1.equals("")) {
                                    path1 = ipText1;
                                }
                                if(!ipText2.equals("")) {
                                    path2 = ipText2;
                                }
                                if(!ipText3.equals("")) {
                                    path3 = ipText3;
                                }
                                if(!ipText4.equals("")) {
                                    path4 = ipText4;
                                }

                                        mVideoView.setVideoLayout(VideoView.VIDEO_LAYOUT_ORIGIN, 0);

                                Toast.makeText(getApplicationContext(), path1 + path2 + path3 + path4,
                                        Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("取消", null).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
    }
}
