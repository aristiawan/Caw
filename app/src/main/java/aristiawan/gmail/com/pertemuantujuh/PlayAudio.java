package aristiawan.gmail.com.pertemuantujuh;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by aristiawan on 18/04/18.
 */

public class PlayAudio extends Service {
    MediaPlayer objectPlayer;

    public void onCreate(){
    super.onCreate();
    objectPlayer=MediaPlayer.create(this, R.raw.lagu);
}
public  int onStartCommand(Intent intent, int flags, int startId){
        objectPlayer.start();
        if (objectPlayer.isLooping()!=true){
            Log.d("TAG", "error paly");
        }
        return 1;
}
public void onStop(){
    objectPlayer.stop();
    objectPlayer.release();
}

public void onPause(){
        objectPlayer.stop();
        objectPlayer.release();
    }

    public void onDestroy(){
        objectPlayer.stop();
        objectPlayer.release();
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
