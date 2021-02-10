package in.bitcode.servicesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mBtnStartService, mBtnStopService;
    private Button mBtnStartMainActivity;
    private EditText mEdtSong;

    public static final String KEY_SONG = "song";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mt("onCreate MainActivity");

        init();

        mBtnStartService.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, MyService.class);
                        intent.putExtra(KEY_SONG, mEdtSong.getText().toString());
                        startService(intent);
                    }
                }
        );

        mBtnStopService.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, MyService.class);
                        stopService(intent);
                    }
                }
        );

        mBtnStartMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.putExtra(KEY_SONG, mEdtSong.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        mt(intent.getStringExtra(KEY_SONG) + " MainActivity");
    }

    private void init() {
        mBtnStartService = findViewById(R.id.btnStartService);
        mBtnStopService = findViewById(R.id.btnStopService);
        mBtnStartMainActivity = findViewById(R.id.btnStartMainActivity);
        mEdtSong = findViewById(R.id.edtSong);
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        mt("onDestroy MainActivity");
        super.onDestroy();
    }
}