package com.example.app;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;


    class MediaService extends Service {
    private MediaPlayer mPlayer;


    public class MusicController extends Binder {
        public void play() {
            mPlayer.start();//开启音乐
        }
        public void pause() {
            mPlayer.pause();//暂停音乐
        }
        public long getMusicDuration() {
            return mPlayer.getDuration();//获取文件的总长度
        }
        public long getPosition() {
            return mPlayer.getCurrentPosition();//获取当前播放进度
        }
        public void setPosition (int position) {
            mPlayer.seekTo(position);//重新设定播放进度
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MusicController();
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mPlayer = MediaPlayer.create(this, R.raw.yinyue);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
    @Override
    public void onDestroy() {
        if (mPlayer.isPlaying()) {
            mPlayer.stop();
        }
        mPlayer.release();
        mPlayer = null;
        super.onDestroy();
    }
}

