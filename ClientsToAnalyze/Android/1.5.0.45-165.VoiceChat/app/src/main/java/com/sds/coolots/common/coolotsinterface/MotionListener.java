package com.sds.coolots.common.coolotsinterface;

import android.os.Handler;

/* loaded from: classes.dex */
public interface MotionListener {
    void setHandler(Handler handler);

    void startMotionCatch();

    void stopMotionCatch();
}
