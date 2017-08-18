package com.lulu.shearplate;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button startFloatWindow = (Button) findViewById(R.id.start_float_window);
        startFloatWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (Settings.canDrawOverlays(MainActivity.this)) {
                        Intent intent = new Intent(MainActivity.this, FloatWindowService.class);
                        startService(intent);
                        finish();
                    } else {
                        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                        startActivity(intent);
                    }
                } else {
                    Intent intent = new Intent(MainActivity.this, FloatWindowService.class);
                    startService(intent);
                    finish();
                }
            }
        });
    }
}
