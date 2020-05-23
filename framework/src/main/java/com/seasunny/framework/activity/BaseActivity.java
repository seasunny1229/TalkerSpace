package com.seasunny.framework.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.seasunny.framework.util.LogUtil;

public class BaseActivity extends AppCompatActivity {

    // region lifecycle

    /*
     *
     * onCreate
     * onStart
     * onRestart
     * onResume
     * onActivityResult
     * onPause
     * onStop
     * onDestroy
     *
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.lifecycle(getClass(), "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.lifecycle(getClass(), "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.lifecycle(getClass(), "onRestart");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtil.lifecycle(getClass(), "onActivityResult");
    }


    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.lifecycle(getClass(), "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.lifecycle(getClass(), "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.lifecycle(getClass(), "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.lifecycle(getClass(), "onDestroy");
    }
    // endregion

    // region permission
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        LogUtil.lifecycle(getClass(), "onRequestPermissionsResult");
    }

    // endregion

    // region functional button
    // 点击系统返回键
    @Override
    public void onBackPressed() {
        LogUtil.lifecycle(getClass(), "onBackPressed");
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        LogUtil.lifecycle(getClass(), "onSupportNavigateUp");
        return super.onSupportNavigateUp();
    }

    // endregion
}
