package com.sds.coolots.call.screenshare;

import android.app.Service;

/* loaded from: classes.dex */
public interface ScreenShareProcInterface {
    public static final int SHARE_SCREEN_MODE_LIVE_SHARE = 2;
    public static final int SHARE_SCREEN_MODE_LIVE_VIEW = 3;
    public static final int SHARE_SCREEN_MODE_SHARE = 0;
    public static final int SHARE_SCREEN_MODE_VIEW = 1;

    int getShareMode();

    void setService(Service service);

    void start(int i);

    void stop();
}
