package com.sds.coolots.common.view;

import android.os.Message;

/* loaded from: classes.dex */
public interface MainActivityInterface {
    void hideCallProgressDialog();

    void sendHandlerMessage(int i, int i2);

    void sendHandlerMessage(Message message);

    void showCallFailPopup();

    void showCallProgressDialog();
}
