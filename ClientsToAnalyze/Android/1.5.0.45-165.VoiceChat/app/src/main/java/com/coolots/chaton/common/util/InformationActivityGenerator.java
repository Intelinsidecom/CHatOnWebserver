package com.coolots.chaton.common.util;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import com.coolots.chaton.common.view.InformationActivity;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.coolotsinterface.IInformationActivityGenerator;
import com.sds.coolots.common.coolotsinterface.InformationActivityGeneratorInterface;
import com.sds.coolots.common.util.Log;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class InformationActivityGenerator implements InformationActivityGeneratorInterface, InformationConstantData {
    private static Date mLastBusyPopupTime;
    private ActivityManager activityManager = null;
    private IInformationActivityGenerator mClickListener;

    private void logE(String message) {
        Log.m2958e("[InformationActivityGenerator]" + message);
    }

    private void logI(String message) {
        Log.m2963i("[InformationActivityGenerator]" + message);
    }

    @Override // com.sds.coolots.common.coolotsinterface.InformationActivityGeneratorInterface
    public void setClickListener(IInformationActivityGenerator clickListener) {
        logI("setClickListener()");
        if (clickListener != null) {
            logI(clickListener.toString());
        }
        this.mClickListener = clickListener;
    }

    @Override // com.sds.coolots.common.coolotsinterface.InformationActivityGeneratorInterface
    public IInformationActivityGenerator getClickListener() {
        logI("getClickListener()");
        if (this.mClickListener != null) {
            logI(this.mClickListener.toString());
        }
        return this.mClickListener;
    }

    public static Date getLastPopupStartDate() {
        return mLastBusyPopupTime;
    }

    @Override // com.sds.coolots.common.coolotsinterface.InformationActivityGeneratorInterface
    public void showInformationActivityForNetworkError() {
        if (MainApplication.mPhoneManager.getClientType() != 2) {
            Intent intent = ((ChatOnPopupCreatorInterface) MainApplication.mPopupCreator).getInformationActivity();
            intent.addFlags(268435456);
            intent.addFlags(536870912);
            intent.addFlags(8388608);
            Bundle informBundle = new Bundle();
            informBundle.putInt(InformationConstantData.INFORMATION_POPUP_EXTRAS_KEY, 20);
            intent.putExtras(informBundle);
            MainApplication.mContext.startActivity(intent);
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.InformationActivityGeneratorInterface
    public void showInformationActivityForChangeToP2P() {
        if (MainApplication.mPhoneManager.getClientType() != 2) {
            Intent intent = ((ChatOnPopupCreatorInterface) MainApplication.mPopupCreator).getInformationActivity();
            intent.addFlags(268435456);
            intent.addFlags(536870912);
            intent.addFlags(8388608);
            Bundle informBundle = new Bundle();
            informBundle.putInt(InformationConstantData.INFORMATION_POPUP_EXTRAS_KEY, 21);
            intent.putExtras(informBundle);
            MainApplication.mContext.startActivity(intent);
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.InformationActivityGeneratorInterface
    public void showInformationActivityForCallEnd() {
        if (MainApplication.mPhoneManager.getClientType() != 2) {
            Intent intent = ((ChatOnPopupCreatorInterface) MainApplication.mPopupCreator).getInformationActivity();
            intent.addFlags(268435456);
            intent.addFlags(536870912);
            intent.addFlags(8388608);
            Bundle informBundle = new Bundle();
            informBundle.putInt(InformationConstantData.INFORMATION_POPUP_EXTRAS_KEY, 29);
            intent.putExtras(informBundle);
            MainApplication.mContext.startActivity(intent);
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.InformationActivityGeneratorInterface
    public void showInformationActivity(int action) {
        if (MainApplication.mPhoneManager.getClientType() != 2) {
            Intent intent = ((ChatOnPopupCreatorInterface) MainApplication.mPopupCreator).getInformationActivity();
            intent.addFlags(268435456);
            intent.addFlags(536870912);
            intent.addFlags(8388608);
            Bundle informBundle = new Bundle();
            informBundle.putInt(InformationConstantData.INFORMATION_POPUP_EXTRAS_KEY, action);
            intent.putExtras(informBundle);
            MainApplication.mContext.startActivity(intent);
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.InformationActivityGeneratorInterface
    public void showInformationActivityForAddBuddy(String receiver) {
        if (MainApplication.mPhoneManager.getClientType() != 2) {
            Intent intent = ((ChatOnPopupCreatorInterface) MainApplication.mPopupCreator).getInformationActivity();
            intent.addFlags(268435456);
            intent.addFlags(536870912);
            intent.addFlags(8388608);
            Bundle informBundle = new Bundle();
            informBundle.putString(InformationConstantData.INFORMATION_POPUP_INFORM_KEY, receiver);
            informBundle.putInt(InformationConstantData.INFORMATION_POPUP_EXTRAS_KEY, 12);
            intent.putExtras(informBundle);
            MainApplication.mContext.startActivity(intent);
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.InformationActivityGeneratorInterface
    public void showInformationActivityForReceiverCallStateBusy() {
        if (MainApplication.mPhoneManager.getClientType() != 2) {
            Intent intent = ((ChatOnPopupCreatorInterface) MainApplication.mPopupCreator).getInformationActivity();
            intent.addFlags(268435456);
            intent.addFlags(536870912);
            intent.addFlags(8388608);
            Bundle informBundle = new Bundle();
            informBundle.putInt(InformationConstantData.INFORMATION_POPUP_EXTRAS_KEY, 13);
            intent.putExtras(informBundle);
            MainApplication.mContext.startActivity(intent);
            mLastBusyPopupTime = new Date();
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.InformationActivityGeneratorInterface
    public void showInformationActivityForCriticalUpdate() {
        if (MainApplication.mPhoneManager.getClientType() != 2) {
            Log.m2954d("showInformationActivityForCriticalUpdate()");
            Intent intent = ((ChatOnPopupCreatorInterface) MainApplication.mPopupCreator).getInformationActivity();
            intent.addFlags(268435456);
            intent.addFlags(536870912);
            intent.addFlags(8388608);
            Bundle informBundle = new Bundle();
            informBundle.putInt(InformationConstantData.INFORMATION_POPUP_EXTRAS_KEY, 24);
            intent.putExtras(informBundle);
            MainApplication.mContext.startActivity(intent);
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.InformationActivityGeneratorInterface
    public void changeDialogInformationActivity(int reason) throws SecurityException {
        if (MainApplication.mPhoneManager.getClientType() != 2) {
            logI("changeDialogInformationActivity: " + reason);
            if (this.activityManager == null) {
                this.activityManager = (ActivityManager) MainApplication.mContext.getSystemService("activity");
            }
            List<ActivityManager.RunningTaskInfo> info = this.activityManager.getRunningTasks(7);
            for (ActivityManager.RunningTaskInfo runningTaskInfo : info) {
                logI("top activity class name: " + runningTaskInfo.topActivity.getClassName());
                if (runningTaskInfo.topActivity.getClassName().equals(InformationActivity.CLASSNAME_INFORMATIONACTIVITY)) {
                    logI("Information activity is top");
                    Intent intent = new Intent();
                    intent.setAction(InformationConstantData.BR_INFORMATION_CHANGE_DIALOG);
                    Bundle extras = new Bundle();
                    extras.putInt(InformationConstantData.INFORMATION_POPUP_EXTRAS_KEY, reason);
                    intent.putExtras(extras);
                    MainApplication.mContext.sendBroadcast(intent);
                    return;
                }
            }
            viewInformationActivity(reason);
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.InformationActivityGeneratorInterface
    public void finishDialogInformationActivity() throws SecurityException {
        if (MainApplication.mPhoneManager.getClientType() != 2) {
            logI("finishDialogInformationActivity");
            if (this.activityManager == null) {
                this.activityManager = (ActivityManager) MainApplication.mContext.getSystemService("activity");
            }
            List<ActivityManager.RunningTaskInfo> info = this.activityManager.getRunningTasks(7);
            for (ActivityManager.RunningTaskInfo runningTaskInfo : info) {
                logI("top activity class name: " + runningTaskInfo.topActivity.getClassName());
                if (runningTaskInfo.topActivity.getClassName().equals(InformationActivity.CLASSNAME_INFORMATIONACTIVITY)) {
                    logI("Information activity is top");
                    Intent intent = new Intent();
                    intent.setAction(InformationConstantData.BR_INFORMATION_CHANGE_DIALOG);
                    Bundle extras = new Bundle();
                    extras.putBoolean(InformationConstantData.INFORMATION_POPUP_FINISH_EXTRAS_KEY, true);
                    intent.putExtras(extras);
                    MainApplication.mContext.sendBroadcast(intent);
                    return;
                }
            }
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.InformationActivityGeneratorInterface
    public void viewInformationActivity(int reason) {
        if (MainApplication.mPhoneManager.getClientType() != 2) {
            Intent intent = ((ChatOnPopupCreatorInterface) MainApplication.mPopupCreator).getInformationActivity();
            intent.addFlags(268435456);
            intent.addFlags(536870912);
            intent.addFlags(8388608);
            intent.addFlags(65536);
            Bundle informBundle = new Bundle();
            informBundle.putInt(InformationConstantData.INFORMATION_POPUP_EXTRAS_KEY, reason);
            intent.putExtras(informBundle);
            MainApplication.mContext.startActivity(intent);
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.InformationActivityGeneratorInterface
    public void viewInformationActivity(int reason, boolean isVideo) {
        if (MainApplication.mPhoneManager.getClientType() != 2) {
            Intent intent = ((ChatOnPopupCreatorInterface) MainApplication.mPopupCreator).getInformationActivity();
            intent.addFlags(268435456);
            intent.addFlags(536870912);
            intent.addFlags(8388608);
            intent.addFlags(65536);
            Bundle informBundle = new Bundle();
            informBundle.putInt(InformationConstantData.INFORMATION_POPUP_EXTRAS_KEY, reason);
            informBundle.putBoolean(InformationConstantData.INFORMATION_POPUP_EXTRAS_IS_VIDEO, isVideo);
            intent.putExtras(informBundle);
            MainApplication.mContext.startActivity(intent);
        }
    }
}
