package eslami.dev.info.e_islami;

public interface PlayerAdapter {

    void loadMedia(String resourceId);

    void release();

    boolean isPlaying();

    void play(String resourceId);

    void reset();

    void pause();

    void initializeProgressCallback();

    void seekTo(int position);

    int getCurrentPosition();

    void resume(int position);

    void getTime();

    void initOnGetTime(PlayerMain playerMain);


}
