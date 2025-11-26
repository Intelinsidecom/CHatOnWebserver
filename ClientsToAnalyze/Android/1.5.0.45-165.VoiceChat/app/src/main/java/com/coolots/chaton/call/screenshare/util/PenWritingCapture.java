package com.coolots.chaton.call.screenshare.util;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.ShareScreenInterface;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.FileUtil;
import com.sds.coolots.common.util.Log;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class PenWritingCapture {
    private static final String CLASSNAME = "[PenWritingCapture]";
    private String captureFileExt = ".jpg";
    private Destination mDestination;
    private ShareScreenInterface mShareScreenInterface;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public PenWritingCapture() {
        logI("PenWritingCapture is Loaded");
        this.mShareScreenInterface = MainApplication.mPhoneManager.getShareScreenManager();
        this.mDestination = this.mShareScreenInterface.getCurrentCallDestination();
    }

    public void ScreenCapture() {
        String fullName = getFileName();
        logI("file Path = " + fullName);
        this.mShareScreenInterface.captureShareScreenImage(this.mDestination, fullName);
        try {
            MainApplication.mContext.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
        } catch (Throwable t) {
            t.printStackTrace();
        }
        logI("PenWritingCapture is Completed by Service ");
    }

    public int ScreenOtherCapture() {
        String fullName = getFileName();
        logI("captureShareScreenOtherIamge file Path = " + fullName);
        int result = this.mShareScreenInterface.captureShareScreenOtherIamge(this.mDestination, fullName);
        try {
            MainApplication.mContext.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
        } catch (Throwable t) {
            t.printStackTrace();
        }
        if (result < 0) {
            logI("ShareScreen PenWritingCapture - captureShareScreenOtherIamge : fail ");
        } else {
            logI("ShareScreen PenWritingCapture - captureShareScreenOtherIamge : pass ");
        }
        logI("PenWritingCapture is Completed by Activity ");
        return result;
    }

    private String getFileName() {
        File saveFolder = new File(FileUtil.VIDEO_SAVE_PATH);
        if (!saveFolder.exists()) {
            saveFolder.mkdirs();
        }
        if (saveFolder != null) {
        }
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String mFileName = String.valueOf(FileUtil.VIDEO_SAVE_PATH) + File.separator + FileUtil.RECORDING_SHARE_SCREEN_PREFIX + "_" + df.format(now) + this.captureFileExt;
        return mFileName;
    }
}
