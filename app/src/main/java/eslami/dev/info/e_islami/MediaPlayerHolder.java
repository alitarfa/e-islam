package eslami.dev.info.e_islami;

import android.content.Context;

import android.media.MediaPlayer;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public  final class MediaPlayerHolder implements PlayerAdapter {

    public static final int PLAYBACK_POSITION_REFRESH_INTERVAL_MS = 1000;

    private final Context mContext;
    private MediaPlayer mMediaPlayer;
    private String mResourceId;
    private PlaybackInfoListener mPlaybackInfoListener;
    private ScheduledExecutorService mExecutor;
    private Runnable mSeekbarPositionUpdateTask;
    public int cuurentPosition=0;
    public onTimeDurationGet onTimeDurationGet;
    public Runnable getmSeekbarPositionUpdateTask;


    public void setOnTimeDurationGet(eslami.dev.info.e_islami.onTimeDurationGet onTimeDurationGet) {
        this.onTimeDurationGet = onTimeDurationGet;
    }



    public MediaPlayerHolder(Context context) {
        mContext = context.getApplicationContext();
        initializeMediaPlayer();
    }


    private void initializeMediaPlayer() {
        if (mMediaPlayer == null) {
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                    if (mPlaybackInfoListener != null) {
                        mPlaybackInfoListener.onStateChanged(PlaybackInfoListener.State.COMPLETED);
                        mPlaybackInfoListener.onPlaybackCompleted();
                    }
                }
            });

        }
    }


    // Implements PlaybackControl.
    @Override
    public void loadMedia(String resourceId) {
        mResourceId = resourceId;

        try {

            mMediaPlayer.setDataSource(mResourceId);
        } catch (Exception e) {

        }

        try {
            mMediaPlayer.prepareAsync();
        } catch (Exception e) {

        }

        initializeProgressCallback();

    }

    @Override
    public void release() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    @Override
    public boolean isPlaying() {

        if (mMediaPlayer!=null){
            if (mMediaPlayer.isPlaying()){
                return true;
            }
        }

        return false;
    }

    @Override
    public void play(String resourceId) {


            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mMediaPlayer.start();
                }
            });

            if (mPlaybackInfoListener != null) {
                mPlaybackInfoListener.onStateChanged(PlaybackInfoListener.State.PLAYING);
            }


        /**
         * start chnage the seekbar
         */

       // sendTimeEverySec();


    }

    @Override
    public void reset() {
        if (mMediaPlayer != null) {
            mMediaPlayer.reset();
            loadMedia(mResourceId);
            if (mPlaybackInfoListener != null) {
                mPlaybackInfoListener.onStateChanged(PlaybackInfoListener.State.RESET);
            }

        }
    }

    @Override
    public void pause() {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {

            cuurentPosition=mMediaPlayer.getCurrentPosition();
            mMediaPlayer.pause();

            if (mPlaybackInfoListener != null) {
                mPlaybackInfoListener.onStateChanged(PlaybackInfoListener.State.PAUSED);
            }
        }
    }

    @Override
    public void seekTo(int position) {
        if (mMediaPlayer != null) {
            mMediaPlayer.seekTo(position);
        }
    }

    @Override
    public int getCurrentPosition() {
        if (mMediaPlayer!=null) return mMediaPlayer.getCurrentPosition();
        return 0;
    }


    @Override
    public void resume(int position) {
        if (mMediaPlayer != null) {
            mMediaPlayer.seekTo(position);
            mMediaPlayer.start();
        }
    }

    @Override
    public void getTime() {
        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mMediaPlayer.getDuration();
            }
        });

    }

    @Override
    public void initOnGetTime(PlayerMain playerMain) {
        this.onTimeDurationGet = playerMain;
    }


    @Override
    public void initializeProgressCallback() {

    }


    public void sendTimeEverySec(){

        mExecutor=Executors.newSingleThreadScheduledExecutor();
        getmSeekbarPositionUpdateTask=new Runnable() {
            @Override
            public void run() {
                onTimeDurationGet.changePositionSeekBar(mMediaPlayer.getCurrentPosition());
            }
        };

        mExecutor.scheduleAtFixedRate(mSeekbarPositionUpdateTask,
                0,
                PLAYBACK_POSITION_REFRESH_INTERVAL_MS,
                TimeUnit.MILLISECONDS);
    }

}

