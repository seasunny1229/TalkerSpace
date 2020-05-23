package com.seasunny.framework.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.seasunny.framework.util.LogUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseAppFragment extends BaseFragment {

    private Unbinder mUnbinder;

    private View mRoot;

    // region config
    protected abstract int getLayoutResId();


    // endregion


    // region lifecycle

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUtil.lifecycle(getClass(), "onCreateView");
        if(mRoot == null){
            mRoot = inflater.inflate(getLayoutResId(), container, false);
            mUnbinder = ButterKnife.bind(this, mRoot);
        }
        return mRoot;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    // endregion


    // region functional button
    public boolean onBackPressed(){
        return false;
    }

    // endregion

}
