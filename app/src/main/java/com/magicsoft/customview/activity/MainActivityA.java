package com.magicsoft.customview.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.magicsoft.customview.R;
import com.magicsoft.customview.utils.SuUtil;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: MainActivityA.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/8 16:55
 * @Changes (from 2017/12/8)
 * -----------------------------------------------------------------
 * 2017/12/8 : Create MainActivityA.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class MainActivityA extends AppCompatActivity {

    public static final String TAG = "MMM";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_a);


        Log.e(TAG, "onCreate: A***" );


        ApplicationInfo applicationInfo =
                getApplicationInfo();

        Log.e("MMM",
                "$$$$$"+applicationInfo.className + "\n" +
                applicationInfo.dataDir+"\n" +
                applicationInfo.permission + "\n"
                + applicationInfo.packageName + "\n"
                + applicationInfo.processName + "\n"
                + applicationInfo.taskAffinity + "\n");



    }



    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e(TAG, "onNewIntent: A***");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: A***" );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: A***" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: A**" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: A***" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: A***" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: A***" );
    }

    public void mainA(View view) {
        startActivity(new Intent(this,MainActivityA.class));
    }

    public void kill(View view) {
        //android.os.Process.killProcess(Process.myPid());//杀死自己
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.killBackgroundProcesses("com.panda.sharedmall");


        //activityManager.forceStopPackage(mPackages[i]);
//        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//
//        activityManager.restartPackage("com.magicsoft.customview");

//        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//        Log.e(TAG, "kill: "+getPackageName() );
//        manager.restartPackage(getPackageName());
        SuUtil.kill("com.panda.sharedmall");

       /* ActivityManager mActivityManager = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
        Method method = null;
        try {
            method = Class.forName("android.app.ActivityManager").getMethod("forceStopPackage", String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            method.invoke(mActivityManager, "com.panda.sharedmall");  //packageName是需要强制停止的应用程序包名
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/

       //forceStopAPK("com.panda.sharedmall");

    }


    private void forceStopAPK(String pkgName){
        Process sh = null;
        DataOutputStream os = null;
        try {
            sh = Runtime.getRuntime().exec("su");
            os = new DataOutputStream(sh.getOutputStream());
            final String Command = "am force-stop "+pkgName+ "\n";
            os.writeBytes(Command);
            os.flush();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            sh.waitFor();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
