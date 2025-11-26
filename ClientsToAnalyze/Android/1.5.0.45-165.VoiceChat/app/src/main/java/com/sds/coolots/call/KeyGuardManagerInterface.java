package com.sds.coolots.call;

/* loaded from: classes.dex */
public interface KeyGuardManagerInterface {
    void disableKeyguardLock();

    void reenableKeyguardLock();

    void updateKeyguardLock(boolean z);

    void updateKeyguardPolicy(boolean z);
}
