package com.seasunny.talkerspace.getui.service;

import android.content.Context;

import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.seasunny.framework.util.LogUtil;

public class GetuiIntentService extends GTIntentService {

    @Override
    public void onReceiveServicePid(Context context, int i) {
        LogUtil.d(getClass(), "receive service pid");
    }

    // 接收 cid
    @Override
    public void onReceiveClientId(Context context, String s) {
        LogUtil.d(getClass(), "receive client id -> " + "clientid = " + s);
    }

    // 处理透传消息
    @Override
    public void onReceiveMessageData(Context context, GTTransmitMessage gtTransmitMessage) {
        LogUtil.d(getClass(), "receive message data");

        String appid = gtTransmitMessage.getAppid();
        String taskid = gtTransmitMessage.getTaskId();
        String messageid = gtTransmitMessage.getMessageId();
        byte[] payload = gtTransmitMessage.getPayload();
        String pkg = gtTransmitMessage.getPkgName();
        String cid = gtTransmitMessage.getClientId();

        LogUtil.d(getClass(),
                "\nonReceiveMessageData -> "
                + "\nappid = " + appid
                + "\ntaskid = " + taskid
                + "\nmessageid = " + messageid
                + "\npkg = " + pkg
                + "\ncid = " + cid);

        if (payload == null) {
            LogUtil.d(getClass(), "receiver payload = null");
        } else {
            String data = new String(payload);
            LogUtil.d(getClass(), "receiver payload = " + data);
        }
    }

    // cid 离线上线通知
    @Override
    public void onReceiveOnlineState(Context context, boolean b) {
        LogUtil.d(getClass(), "receive online state");
    }

    // 各种事件处理回执
    @Override
    public void onReceiveCommandResult(Context context, GTCmdMessage gtCmdMessage) {
        LogUtil.d(getClass(), "receive command result");
    }

    // 通知到达，只有个推通道下发的通知会回调此方法
    @Override
    public void onNotificationMessageArrived(Context context, GTNotificationMessage gtNotificationMessage) {
        LogUtil.d(getClass(), "notification message arrived");
    }

    // 通知点击，只有个推通道下发的通知会回调此方法
    @Override
    public void onNotificationMessageClicked(Context context, GTNotificationMessage gtNotificationMessage) {
        LogUtil.d(getClass(), "notification message clicked");
    }
}
