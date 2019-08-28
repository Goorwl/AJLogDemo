package com.goorwl.aopdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Toast;

import com.goorwl.mylog.DebugLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum = getSum(2, 3);
                Toast.makeText(MainActivity.this, "res = " + sum, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @DebugLog
    private int getSum(int a, int b) {
        SystemClock.sleep(15);
        return a + b;
    }
}
