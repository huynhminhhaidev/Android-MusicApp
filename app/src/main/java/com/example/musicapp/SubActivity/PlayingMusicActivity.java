//package com.example.musicapp.SubActivity;
//
//import android.app.Activity;
//import android.content.BroadcastReceiver;
//import android.content.ComponentName;
//import android.content.Context;
//import android.content.Intent;
//import android.content.ServiceConnection;
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.IBinder;
//import android.util.Log;
//import android.view.MotionEvent;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.SeekBar;
//import android.widget.TextView;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.musicapp.Model.Song;
//import com.example.musicapp.R;
//import com.example.musicapp.Service.MusicPlayerService;
//
//import java.text.SimpleDateFormat;
//import java.util.List;
//
//public class PlayingMusicActivity extends AppCompatActivity {
//    public static List<Song> listSongPlaying;
//    private Intent serviceIntent;
//    private Handler handler = new Handler();
//    private static final String TAG = "MyTAG";
//    private TextView tvName,tvTimePre,tvTimePost;
//    private ImageView ivPlay, ivStop, ivNext, ivPre;
//    private SeekBar seekBar;
//    private MusicPlayerService mMusicPlayerService;
//    private MediaPlayer mediaPlayer;
//    private boolean mBound = false;
//    private ServiceConnection mServiceCon = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder iBinder) {
////            MusicPlayerService.MyServiceBinder myServiceBinder = (MusicPlayerService.MyServiceBinder) iBinder;
////            mMusicPlayerService = myServiceBinder.getService();
////            mMusicPlayerService.play();
////            startPlayProgressUpdate();
////            mBound = true;
//            Log.e("TAG", "onServiceConnected");
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            mBound = false;
//            Log.e("TAG", "onServiceDisconnected");
//        }
//    };
//    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            String songName = intent.getStringExtra("message_key");
//            Log.d(TAG, "onReceive: Thread name:"+Thread.currentThread().getName());
//        }
//    };
//
//
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_playingmusic);
//        seekBar = findViewById(R.id.seekBar1);
//        tvName = findViewById(R.id.tvNamePlaying);
//        ivPlay = findViewById(R.id.ivPlay);
//        ivNext = findViewById(R.id.ivNext);
//        ivStop = findViewById(R.id.ivStop);
//        ivPre = findViewById(R.id.ivPre);
//        tvTimePost = findViewById(R.id.tvTimePost);
//        tvTimePre = findViewById(R.id.tvTimePre);
//
//        serviceIntent = new Intent(getApplicationContext(),MusicPlayerService.class);
//        bindService(serviceIntent,mServiceCon,BIND_AUTO_CREATE);
//        if(mediaPlayer!=null){
//            mediaPlayer.release();
//        }
//        seekBar.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                updateSeekBarChange(v);
//                return false;
//
//            }
//        });
////        serviceIntent = new Intent(getApplicationContext(),MusicService.class);
////        if(mediaPlayer != null) {
////            mediaPlayer.release();
////        }
////        ivPlay.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////                if(v.getId() == R.id.ivPlay){
////                    startService(new Intent(getApplicationContext(),MusicService.class));
////
////                    ivPlay.setImageResource(R.drawable.btn_pause);
////                }
////            }
////        });
////        ivStop.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                stopService(new Intent(getApplicationContext(),MusicService.class));
////            }
////        });
////
////    }
//        ivPlay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(mBound){
//                    if(mMusicPlayerService.isPlaying()){
//                        mMusicPlayerService.pause();
//                        ivPlay.setImageResource(R.drawable.btn_play);
//                    }
//                    else {
//                        mMusicPlayerService.play();
//                        ivPlay.setImageResource(R.drawable.btn_pause);
//                        int time = mMusicPlayerService.getDuration();
//                        setTimerPlay();
//                    }
//                }
//            }
//        });
//        ivStop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(mBound){
//                    if(mMusicPlayerService.isPlaying()){
//                        ivPlay.setImageResource(R.drawable.btn_pause);
//                        mMusicPlayerService.seekPosition(0);
//                        startPlayProgressUpdate();
//                    }
//                    else {
//                        ivPlay.setImageResource(R.drawable.btn_play);
//                        mMusicPlayerService.seekPosition(0);
//                        mMusicPlayerService.pause();
//                        startPlayProgressUpdate();
//                    }
//                }
//            }
//        });
//
//    }
//    private void setTimerPlay(){
//        seekBar.setMax(mMusicPlayerService.getDuration());
//        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
//        tvTimePost.setText(dateFormat.format(mMusicPlayerService.getDuration()));
//        tvTimePre.setText(dateFormat.format(mMusicPlayerService.getCurrentPosition()));
//    }
//    private void updateSeekBarChange(View v){
//        if(mMusicPlayerService.isPlaying()){
//            SeekBar sb = (SeekBar) v;
//            Log.e("TAG",sb.getProgress()+"/"+mMusicPlayerService.getDuration());
//            mMusicPlayerService.seekPosition(sb.getProgress());
//        }
//    }
//    private void startPlayProgressUpdate(){
//        seekBar.setProgress(mMusicPlayerService.getCurrentPosition());
//        if(mMusicPlayerService.isPlaying()){
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    startPlayProgressUpdate();
//                    setTimerPlay();
//                }
//            };
//            handler.postDelayed(runnable,1000);
//        }
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        handler.removeCallbacksAndMessages(null);
//    }
//}
