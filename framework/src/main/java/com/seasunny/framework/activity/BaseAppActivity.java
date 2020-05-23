package com.seasunny.framework.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.seasunny.framework.fragment.BaseAppFragment;

import java.util.List;

import butterknife.ButterKnife;

public abstract class BaseAppActivity extends BaseActivity {


    // region config
    protected abstract int getLayoutResID();

    // endregion


    // region lifecycle
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        ButterKnife.bind(this);
    }

    // endregion


    // region functional button

    @Override
    public void onBackPressed() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        for(Fragment fragment : fragments){
            if(fragment instanceof BaseAppFragment && ((BaseAppFragment) fragment).onBackPressed()){
                return;
            }
        }
        super.onBackPressed();
    }

    // endregion

}
