package com.coolots.chaton.call.controller;

import com.coolots.chaton.call.model.VideoShareViewRestoreData;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class VideoShareViewController implements DisposeInterface {
    private static final String CLASSNAME = "[VideoShareViewController]";
    private static final int SHARE_VIEW_CAMERA_VISIBLE_FRONT = 444;
    private static final int SHARE_VIEW_CAMERA_VISIBLE_REAR = 666;
    public static final int SHARE_VIEW_TYPE_NONE = 0;
    public static final int SHARE_VIEW_TYPE_PICTURE = 1;
    public static final int SHARE_VIEW_TYPE_VIDEO = 2;
    private VideoShareViewRestoreData mBackupData;
    private boolean mHidemeFlag;
    private boolean mIsActive = false;
    private boolean mIsFullScreen = false;
    private boolean mIsStarter = false;
    private int mShareViewSwitchCameraState = 444;
    private int mType;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public void start(boolean isConference, boolean isStater, int type, boolean isHideme) {
        logI("start()");
        this.mIsActive = true;
        this.mIsFullScreen = false;
        this.mShareViewSwitchCameraState = 444;
        this.mIsStarter = isStater;
        this.mType = type;
        this.mHidemeFlag = isHideme;
    }

    public void stop() {
        logI("stop()");
        this.mIsActive = false;
        this.mIsFullScreen = false;
        this.mShareViewSwitchCameraState = 444;
        this.mIsStarter = false;
        this.mType = 0;
        this.mHidemeFlag = false;
    }

    public void setBackupData(VideoShareViewRestoreData data) {
        this.mBackupData = data;
    }

    public VideoShareViewRestoreData getBackupData() {
        return this.mBackupData;
    }

    public boolean isActive() {
        return this.mIsActive;
    }

    public boolean isFullScreen() {
        return this.mIsFullScreen;
    }

    public boolean isStarter() {
        return this.mIsStarter;
    }

    public int isFrontCamera() {
        return this.mShareViewSwitchCameraState;
    }

    public int getType() {
        return this.mType;
    }

    public boolean getHidemeFlag() {
        return this.mHidemeFlag;
    }

    public void setActive(boolean active) {
        this.mIsActive = active;
    }

    public void setFullScreen(boolean full) {
        this.mIsFullScreen = full;
    }

    public void setStarter(boolean starter) {
        this.mIsStarter = starter;
    }

    public void setFrontCamera(int isFront) {
        this.mShareViewSwitchCameraState = isFront;
    }

    public void setType(int type) {
        this.mType = type;
    }

    public void setHidemeFlag(boolean isHideme) {
        this.mHidemeFlag = isHideme;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mBackupData != null) {
            this.mBackupData.dispose();
            this.mBackupData = null;
        }
    }
}
