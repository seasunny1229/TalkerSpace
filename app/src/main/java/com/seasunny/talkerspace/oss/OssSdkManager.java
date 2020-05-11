package com.seasunny.talkerspace.oss;

import android.content.Context;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSAuthCredentialsProvider;
import com.alibaba.sdk.android.oss.model.GetObjectRequest;
import com.alibaba.sdk.android.oss.model.GetObjectResult;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.seasunny.framework.util.LogUtil;

public class OssSdkManager {
    private static final String STS_INFO_URL = "http://192.168.1.3:8080/sts/getsts";
    private static final String OSS_ENDPOINT = "http://oss-cn-shanghai.aliyuncs.com";


    private static OssSdkManager sInstance;


    public static OssSdkManager getInstance(){
        if(sInstance == null){
            sInstance = new OssSdkManager();
        }
        return sInstance;
    }

    public void init(Context context){

        OSSAuthCredentialsProvider authCredentialsProvider = new OSSAuthCredentialsProvider(STS_INFO_URL);

        ClientConfiguration conf = new ClientConfiguration();
        conf.setConnectionTimeout(15 * 1000); // 连接超时，默认15秒
        conf.setSocketTimeout(15 * 1000); // socket超时，默认15秒
        conf.setMaxConcurrentRequest(5); // 最大并发请求书，默认5个
        conf.setMaxErrorRetry(2); // 失败后最大重试次数，默认2次
        OSSClient oss = new OSSClient(context, OSS_ENDPOINT, authCredentialsProvider,conf);

//        PutObjectRequest putObjectRequest = new PutObjectRequest("seasunny1229-training","training/exercise.txt","hello world".getBytes());
//        oss.asyncPutObject(putObjectRequest, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
//            @Override
//            public void onSuccess(PutObjectRequest request, PutObjectResult result) {
//                LogUtil.d(OssSdkManager.class, "UploadSuccess");
//            }
//
//            @Override
//            public void onFailure(PutObjectRequest request, ClientException clientException, ServiceException serviceException) {
//                LogUtil.e(OssSdkManager.class, "fail to upload");
//            }
//        });

        GetObjectRequest getObjectRequest = new GetObjectRequest("seasunny1229-training", "training/IMG_4206.jpg");
        oss.asyncGetObject(getObjectRequest, new OSSCompletedCallback<GetObjectRequest, GetObjectResult>() {
            @Override
            public void onSuccess(GetObjectRequest request, GetObjectResult result) {
                LogUtil.d(OssSdkManager.class, "Download success");
            }

            @Override
            public void onFailure(GetObjectRequest request, ClientException clientException, ServiceException serviceException) {
                LogUtil.e(OssSdkManager.class, "fail to download");
            }
        });

    }



}
