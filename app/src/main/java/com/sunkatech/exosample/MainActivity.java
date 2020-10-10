package com.sunkatech.exosample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.google.android.exoplayer2.util.Util;

public class MainActivity extends AppCompatActivity {
    SimpleExoPlayer video_player;
    PlayerView player_screen;
     DefaultTrackSelector track_selector;
    DefaultBandwidthMeter band_width_meter = new DefaultBandwidthMeter();

    MediaSource mediaSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

       /* player_screen = findViewById (R.id.player_screen);
        player_screen.requestFocus();

        TrackSelection.Factory video_track_selection_factory = new AdaptiveTrackSelection.Factory(band_width_meter);
        track_selector = new DefaultTrackSelector(video_track_selection_factory);
        video_player = ExoPlayerFactory.newSimpleInstance(this, track_selector);

        player_screen.setPlayer(video_player);
        video_player.setPlayWhenReady(true);

        DataSource.Factory data_source_factory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "Application Name"), new DefaultBandwidthMeter());
        Uri url = Uri.parse("file:///android_asset/kidscreativity4.mp4");
        mediaSource = new ExtractorMediaSource.Factory(data_source_factory).createMediaSource(url);

        video_player.prepare(mediaSource);*/
    }

    @Override
    protected void onStart() {
        player_screen = findViewById (R.id.player_screen);
        video_player= ExoPlayerFactory.newSimpleInstance(this,new DefaultTrackSelector());
        DefaultDataSourceFactory defaultDataSourceFactory= new DefaultDataSourceFactory(this, Util.getUserAgent(this,"YourApplicationName"));
        video_player.setPlayWhenReady(true);
        Uri url1 = Uri.parse("file:///android_asset/L3- T5- 005.webm");
        ExtractorMediaSource firstMediaSource=new ExtractorMediaSource.Factory(defaultDataSourceFactory).createMediaSource(url1);
        Uri url2 = Uri.parse("file:///android_asset/upperproblem2.mp4");
        ExtractorMediaSource secondMediaSource=new ExtractorMediaSource.Factory(defaultDataSourceFactory).createMediaSource(url2);
        Uri url3 = Uri.parse("file:///android_asset/upperproblem3.mp4");
        ExtractorMediaSource thirdMediaSource=new ExtractorMediaSource.Factory(defaultDataSourceFactory).createMediaSource(url3);
        Uri url4 = Uri.parse("file:///android_asset/upperproblem4.mp4");
        ExtractorMediaSource fourthMediaSource=new ExtractorMediaSource.Factory(defaultDataSourceFactory).createMediaSource(url4);
        Uri url5 = Uri.parse("file:///android_asset/upperproblem5.mp4");
        ExtractorMediaSource fifthMediaSource=new ExtractorMediaSource.Factory(defaultDataSourceFactory).createMediaSource(url5);
        Uri url6 = Uri.parse("file:///android_asset/upperproblem6.mp4");
        ExtractorMediaSource sixthMediaSource=new ExtractorMediaSource.Factory(defaultDataSourceFactory).createMediaSource(url6);
        Uri url7 = Uri.parse("file:///android_asset/upperproblem7.mp4");
        ExtractorMediaSource seventhMediaSource=new ExtractorMediaSource.Factory(defaultDataSourceFactory).createMediaSource(url7);

        ConcatenatingMediaSource mediaSource = new ConcatenatingMediaSource();
        mediaSource.addMediaSource(firstMediaSource);
        mediaSource.addMediaSource(secondMediaSource);
        mediaSource.addMediaSource(thirdMediaSource);
        mediaSource.addMediaSource(fourthMediaSource);
        mediaSource.addMediaSource(fifthMediaSource);
        mediaSource.addMediaSource(sixthMediaSource);
        mediaSource.addMediaSource(seventhMediaSource);
        video_player.prepare(mediaSource);
        player_screen.setPlayer(video_player);
        Toast.makeText(getApplicationContext(),"Player Start!", Toast.LENGTH_LONG).show();

        super.onStart();
    }

    @Override
    protected void onStop() {
        player_screen.setPlayer(null);
        video_player.release();
        video_player=null;
        Toast.makeText(getApplicationContext(),"Player Stop!", Toast.LENGTH_LONG).show();
        super.onStop();
    }




    // Shows the system bars by removing all the flags
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }



}