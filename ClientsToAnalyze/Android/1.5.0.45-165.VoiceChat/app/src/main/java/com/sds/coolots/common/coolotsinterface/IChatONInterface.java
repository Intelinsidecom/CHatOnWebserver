package com.sds.coolots.common.coolotsinterface;

/* loaded from: classes.dex */
public interface IChatONInterface {
    public static final int SHARE_VIEW_END = 2;
    public static final int SHARE_VIEW_PAUSE = 3;
    public static final int SHARE_VIEW_RESTART = 4;
    public static final int SHARE_VIEW_START = 1;

    void sendBroadcastCallMemberChange();

    void sendBroadcastCallStateChange(int i);

    void sendBroadcastCreateAccountResult(Boolean bool);

    void sendBroadcastCreateAccountResult(Boolean bool, int i);

    void sendBroadcastRemoveAccountResult(Boolean bool);

    void sendBroadcastServicePolicyInfo(boolean z, boolean z2);

    void sendBroadcastShareViewInfo(int i);

    void sendBroadcastUgradeNewApk(String str, int i, String[] strArr);
}
