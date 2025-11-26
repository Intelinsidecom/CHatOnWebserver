package com.sds.coolots.common.util;

import android.content.Context;
import com.sds.coolots.call.model.Destination;

/* loaded from: classes.dex */
public interface PopUpCreatorInterface {
    void authenticateFailurePPS();

    void needMoreMoney();

    void needMoreMoneyForCallActivity();

    void notifyConferenceFinish(Context context);

    void notifyDisconnect(Context context);

    void showChargeActivity(Destination destination, boolean z);

    void showMessage(String str, String str2);

    void tryBlockedNumber();

    void unableGetSipNo();

    void unableReachPPS();

    void unknownError(int i);
}
