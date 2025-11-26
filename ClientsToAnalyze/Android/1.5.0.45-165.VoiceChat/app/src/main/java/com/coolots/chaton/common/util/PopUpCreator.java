package com.coolots.chaton.common.util;

import android.content.Context;
import android.content.Intent;
import com.coolots.chaton.common.view.InformationActivity;
import com.coolots.chaton.common.view.LogSenderActivity;
import com.coolots.sso.util.ChatONInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;

/* loaded from: classes.dex */
public class PopUpCreator implements ChatOnPopupCreatorInterface {
    @Override // com.sds.coolots.common.util.PopUpCreatorInterface
    public void unableGetSipNo() {
    }

    @Override // com.sds.coolots.common.util.PopUpCreatorInterface
    public void unableReachPPS() {
    }

    @Override // com.sds.coolots.common.util.PopUpCreatorInterface
    public void needMoreMoney() {
    }

    @Override // com.sds.coolots.common.util.PopUpCreatorInterface
    public void tryBlockedNumber() {
    }

    @Override // com.sds.coolots.common.util.PopUpCreatorInterface
    public void authenticateFailurePPS() {
    }

    @Override // com.sds.coolots.common.util.PopUpCreatorInterface
    public void unknownError(int errorCode) {
    }

    @Override // com.sds.coolots.common.util.PopUpCreatorInterface
    public void needMoreMoneyForCallActivity() {
    }

    @Override // com.sds.coolots.common.util.PopUpCreatorInterface
    public void notifyConferenceFinish(Context context) {
    }

    @Override // com.sds.coolots.common.util.PopUpCreatorInterface
    public void notifyDisconnect(Context context) {
    }

    @Override // com.sds.coolots.common.util.PopUpCreatorInterface
    public void showChargeActivity(Destination destination, boolean useVideo) {
    }

    @Override // com.sds.coolots.common.util.PopUpCreatorInterface
    public void showMessage(String title, String message) {
    }

    @Override // com.coolots.chaton.common.util.ChatOnPopupCreatorInterface
    public Intent getInformationActivity() {
        return new Intent(MainApplication.mContext, (Class<?>) InformationActivity.class);
    }

    @Override // com.coolots.chaton.common.util.ChatOnPopupCreatorInterface
    public Intent getSendLogActivity() {
        Intent sIntent = new Intent();
        sIntent.setClass(MainApplication.mContext, LogSenderActivity.class);
        sIntent.setFlags(268435456);
        sIntent.addFlags(8388608);
        return sIntent;
    }

    @Override // com.coolots.chaton.common.util.ChatOnPopupCreatorInterface
    public Intent getSettingActivity() {
        Intent sIntent = new Intent(ChatONInterface.USER_SETTING_ACTION_NAME);
        sIntent.setFlags(268435456);
        sIntent.addFlags(8388608);
        return sIntent;
    }
}
