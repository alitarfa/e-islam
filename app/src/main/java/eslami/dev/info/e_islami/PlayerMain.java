package eslami.dev.info.e_islami;

import android.graphics.drawable.RippleDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class PlayerMain extends AppCompatActivity implements onTimeDurationGet  {

    public static final String TAG = "MainActivity";


    private TextView mTextDebug;
    public boolean status=false;
    private PlayerAdapter mPlayerAdapter;
    public  String url;
    public int currentPos=0;
    public String name;
    private boolean mUserIsSeeking = false;
    public  SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        initializeUI();
        initializePlaybackController();
        mPlayerAdapter.initOnGetTime(this);

    }


    @Override
    protected void onStart() {
        super.onStart();
        name=getIntent().getExtras().getString("name");
        final String dir=getIntent().getExtras().getString("dir");
        url =Utils.BASE_URL+dir+"/"+name;
         mPlayerAdapter.loadMedia(url);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isChangingConfigurations() && mPlayerAdapter.isPlaying()) {
            Log.d(TAG, "onStop: don't release MediaPlayer as screen is rotating & playing");
        } else {
            mPlayerAdapter.release();
            Log.d(TAG, "onStop: release MediaPlayer");
        }
    }

    private void initializeUI() {
        final int[] s = {0};
        final ImageView mPlayButton =   findViewById(R.id.id_btn_play_pause);
         final TextView title=findViewById(R.id.id_text_title);
         final TextView id_text_all_time=findViewById(R.id.id_text_all_time);
         seekBar=findViewById(R.id.seekBar);


        mPlayButton.setOnClickListener(
                new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onClick(View view) {
                        if (!status) {
                             if (s[0] ==0){
                                 mPlayerAdapter.play(url);
                                 s[0]++;
                             }
                             if (s[0] ==1){
                                 mPlayerAdapter.resume(currentPos);
                             }
                            mPlayButton.setImageDrawable(getDrawable(R.drawable.ic_pause_circle_filled_black_24dp));
                            Log.e("Button", "play");
                            status = true;
                        } else {
                            if (status) {
                                currentPos=mPlayerAdapter.getCurrentPosition();
                                Log.e("posi",""+currentPos);
                                mPlayerAdapter.pause();
                                mPlayButton.setImageDrawable(getDrawable(R.drawable.ic_play_circle_filled_black_24dp));
                                Log.e("Button", "pause");
                                status = false;
                            }

                        }

                    }

                });


        /**
         * this for the seek bar portion
         */

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int userSelectedPosition = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromuser) {

                if (fromuser){
                    userSelectedPosition=progress;
                    Log.e("progress",""+progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mUserIsSeeking = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mUserIsSeeking = false;
                mPlayerAdapter.seekTo(userSelectedPosition*1000);
                Log.e("value",""+userSelectedPosition);
            }
        });




    }



    private void initializePlaybackController() {
        MediaPlayerHolder mMediaPlayerHolder = new MediaPlayerHolder(this);
        mPlayerAdapter = mMediaPlayerHolder;
        Log.d(TAG, "initializePlaybackController: MediaPlayerHolder progress callback set");
    }


    public void ChangesProgress(){

        seekBar.setProgress(0);

    }


    @Override
    public void onTimeGet(int time) {

    }

    @Override
    public void changePositionSeekBar(int currentValue) {
        Log.e("value",""+currentValue);
        Toast.makeText(this, ""+currentValue, Toast.LENGTH_SHORT).show();
    }
}
