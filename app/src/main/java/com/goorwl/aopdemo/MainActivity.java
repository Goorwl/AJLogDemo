package com.goorwl.aopdemo;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.goorwl.aopdemo.aop.CheckPermission;
import com.goorwl.mylog.DebugLog;
import com.goorwl.mylog.DoubleClick;
import com.goorwl.mylog.MyClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    public static Activity sActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sActivity = this;

        MyClick.setIntervalsTime(1000);

        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            @DoubleClick
            public void onClick(View v) {
                //                int sum = getSum(2, 3);
                //                Toast.makeText(MainActivity.this, "res = " + sum, Toast.LENGTH_SHORT).show();
                //                readPhoneState();
                Toast.makeText(MainActivity.this, "点击了一次", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onClick: xxxxxxxxxxxx");
            }
        });

        findViewById(R.id.btn_test).setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "点击了一次", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "onClick: xxxxxxxxxxxx");
        });

        findViewById(R.id.btn_test).setOnClickListener(this);
        findViewById(R.id.btn_test1).setOnClickListener(this);

        int sum = getSum(2, 3);

    }

    @CheckPermission(declarePermission = Manifest.permission.READ_PHONE_STATE)
    public void readPhoneState() {
        Log.e(TAG, "checkPhoneState: 读取权限");
    }

    @DebugLog
    private int getSum(int a, int b) {
        SystemClock.sleep(15);
        return a + b;
    }

    @Override
    @DoubleClick
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                Log.e(TAG, "onClick: xxx");
                break;
            case R.id.btn_test1:
                Log.e(TAG, "onClick: 111xxx");
                break;
        }
    }
}
