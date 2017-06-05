package com.jsonaop;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jsonaop.annotation.BehaviorTrace;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @BehaviorTrace("摇一摇")
    public void mShake(View btn){
        SystemClock.sleep(new Random().nextInt(500));
        Log.d(TAG, "摇一摇功能被使用");
    }

    @BehaviorTrace(value = "发送语音")
    public void mAudio(View btn){
         SystemClock.sleep(new Random().nextInt(500));
         Log.d(TAG, "语音消息功能被使用");
    }
    public void mVideo(View btn){
        long begin = System.currentTimeMillis();
        {
            SystemClock.sleep(new Random().nextInt(500));
            Log.d(TAG, "视频通话功能被使用");
        }
        long duration = System.currentTimeMillis() - begin;
        Log.d(TAG, "视频通话功能被使用，耗时：" + duration);

    }
}
