package in.bitcode.servicesdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        mt("onCreate - MyService  " +  Thread.currentThread().getName());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mt( intent.getStringExtra(MainActivity.KEY_SONG)  + " -" + startId + "");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mt("onDestroy - MyService");
        super.onDestroy();
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
