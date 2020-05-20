package com.seasunny.framework.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.seasunny.framework.util.LogUtil;

public class BaseFragment extends Fragment {

   // region lifecycle

   /*
   *
   * onAttach
   * onCreate
   * onCreateView
   * onActivityCreated
   * onStart
   * onResume
   * onPause
   * onStop
   * onDestroyView
   * onDestroy
   * onDetach
   *
   */

   // 在片段与 Activity 关联之后调用
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        LogUtil.lifecycle(getClass(), "onAttach");
    }

    // 在创建片段的时候调用
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.lifecycle(getClass(), "onCreate");
    }

    // 当为片段创建布局的时间调用，必须返回片段的根布局。如果片段未提供 UI，可以返回 null
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUtil.lifecycle(getClass(), "onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    // 告诉片段 Activity 的 onCreate() 方法已经完成
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.lifecycle(getClass(), "onActivityCreated");
    }

    // 当片段的视图对用户可见时调用
    @Override
    public void onStart() {
        super.onStart();
        LogUtil.lifecycle(getClass(), "onStart");
    }

    // 当 Activity 进入到 Resumed 状态的时候，也就意味着活动开始运行了，此时调用本方法
    @Override
    public void onResume() {
        super.onResume();
        LogUtil.lifecycle(getClass(), "onResume");
    }

    // 当 Activity 暂停的时候，调用该方法。
    // 系统将此方法作为用户离开片段的第一个信号（但并不总是意味着此片段会被销毁）进行调用。
    // 通常应该在此方法内确认在当前用户会话结束后仍然有效的任何更改（因为用户可能不会返回）
    @Override
    public void onPause() {
        super.onPause();
        LogUtil.lifecycle(getClass(), "onPause");
    }

    // 当 Activity 停止的时候调用
    @Override
    public void onStop() {
        super.onStop();
        LogUtil.lifecycle(getClass(), "onStop");
    }

    // 调用本方法以允许片段释放用于视图的资源
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.lifecycle(getClass(), "onDestroyView");
    }

    // 在片段销毁之前调用，以允许片段进行最好的清理工作
    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.lifecycle(getClass(), "onDestroy");
    }

    // 当片段与 Activity 解除关联的时候调用
    @Override
    public void onDetach() {
        super.onDetach();
        LogUtil.lifecycle(getClass(), "onDetach");
    }

    // endregion
}
