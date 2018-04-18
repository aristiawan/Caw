package aristiawan.gmail.com.pertemuantujuh;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mBatteryLevelText;
    private ProgressBar mBatteryLevelProgress;
    private BroadcastReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBatteryLevelText = (TextView) findViewById(R.id.t2);
        mBatteryLevelProgress = (ProgressBar) findViewById(R.id.pB3);
        mReceiver = new BatteryBroadcastReceiver();
    }
    public void playAudio (View view) {
        Intent objectIntent = new Intent(this, PlayAudio.class);
        startService(objectIntent);
    }
    public void stopAudio (View view){
        Intent object = new Intent(this, PlayAudio.class);
        stopService(object);
    }

    @Override
    protected void onStart() {
        registerReceiver(mReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(mReceiver);
        super.onStop();
    }
private class BatteryBroadcastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);

        mBatteryLevelText.setText(getString(R.string.battery_level) + " " + level);
        mBatteryLevelProgress.setProgress(level);
    }
}
}

