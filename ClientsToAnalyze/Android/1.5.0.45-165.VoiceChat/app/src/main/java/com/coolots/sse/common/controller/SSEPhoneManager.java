package com.coolots.sse.common.controller;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.coolots.chaton.buddy.BuddyManager;
import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.common.view.ConfigActivity;
import com.coolots.chaton.profile.ProfileManager;
import com.coolots.chaton.profile.ProfileManagerInterface;
import com.coolots.chaton.service.CoolotsService;
import com.coolots.sse.join.SSEJoinManager;
import com.coolots.sse.presence.SSEPresenceManager;
import com.sds.coolots.common.controller.PhoneManager;
import java.util.List;

/* loaded from: classes.dex */
public abstract class SSEPhoneManager extends PhoneManager {
    public static final int AREA_EXTERNAL = 1;
    public static final int AREA_INTERNAL = 0;
    public static int mStageAreaCode = 0;
    protected ProfileManagerInterface mProfileManager = null;

    public static int getStageAreaCode() {
        return mStageAreaCode;
    }

    public SSEPhoneManager() {
        mSupportTcp = false;
        this.mIsConfTest = false;
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    protected void setVersion() {
        this.mVersion = 5;
        super.setVersion();
    }

    protected void initProfileManager() {
        if (this.mProfileManager == null) {
            this.mProfileManager = new ProfileManager();
        }
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    public boolean isConfTest() {
        return this.mIsConfTest;
    }

    public ProfileManagerInterface getProfileManager() {
        return this.mProfileManager;
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    public void init() {
        super.init();
        initProfileManager();
        initPresenceManager();
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    protected void initContactManager() {
        if (this.mContactManager == null) {
            this.mContactManager = new BuddyManager();
        }
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    protected void initPushManager() {
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    protected void initJoinManager() {
        if (this.mJoinManager == null) {
            this.mJoinManager = new SSEJoinManager();
        }
    }

    @Override // com.sds.coolots.common.controller.PhoneManager
    protected void initDataUsageManager() {
    }

    public BuddyManagerInterface getChatOnContactManager() {
        return (BuddyManagerInterface) this.mContactManager;
    }

    protected void initPresenceManager() {
        if (this.mPresenceManager == null) {
            this.mPresenceManager = new SSEPresenceManager();
        }
    }

    public static boolean startCoolotsService(Context context, boolean forceStart) {
        if (isCoolotsServiceRunning(context)) {
            return true;
        }
        if (!forceStart && (ConfigActivity.getProfileUserID() == null || ConfigActivity.getProfileUserID().equals(""))) {
            return true;
        }
        ComponentName compname = context.startService(new Intent(context, (Class<?>) CoolotsService.class));
        return compname != null;
    }

    public static void stopCoolotsService(Context context) {
        if (isCoolotsServiceRunning(context)) {
            Intent intent = new Intent(context.getApplicationContext(), (Class<?>) CoolotsService.class);
            context.stopService(intent);
        }
    }

    public static boolean isCoolotsServiceRunning(Context context) throws SecurityException {
        boolean bServiceRunning = false;
        ActivityManager activity = (ActivityManager) context.getSystemService("activity");
        List<ActivityManager.RunningServiceInfo> serviceInfo = activity.getRunningServices(10000);
        int i = 0;
        while (true) {
            if (i >= serviceInfo.size()) {
                break;
            }
            ActivityManager.RunningServiceInfo info = serviceInfo.get(i);
            if (!info.service.getClassName().equals(CoolotsService.class.getName())) {
                i++;
            } else {
                bServiceRunning = info.started;
                break;
            }
        }
        return bServiceRunning;
    }
}
