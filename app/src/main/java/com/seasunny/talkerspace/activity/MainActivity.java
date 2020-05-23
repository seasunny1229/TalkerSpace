package com.seasunny.talkerspace.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.seasunny.framework.activity.BaseAppActivity;
import com.seasunny.framework.util.LogUtil;
import com.seasunny.talkerspace.R;

import butterknife.BindView;

public class MainActivity extends BaseAppActivity {

    @BindView(R.id.navigation)
    BottomNavigationView mNavigation;

    @BindView(R.id.txt_title)
    TextView textView;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                LogUtil.lifecycle(MainActivity.class, menuItem.getTitle().toString());
                return true;
            }
        });
    }

}
