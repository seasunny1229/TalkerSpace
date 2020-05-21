package com.seasunny.talkerspace.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.seasunny.framework.activity.BaseActivity;
import com.seasunny.framework.activity.BaseAppActivity;
import com.seasunny.talkerspace.R;

public class MainActivity extends BaseAppActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
