package com.seasunny.talkerspace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.seasunny.push.manager.PushModuleManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PushModuleManager.getInstance().init(this);
    }
}
