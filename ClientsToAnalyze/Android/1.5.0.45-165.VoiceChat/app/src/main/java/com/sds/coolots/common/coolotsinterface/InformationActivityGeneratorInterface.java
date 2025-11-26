package com.sds.coolots.common.coolotsinterface;

/* loaded from: classes.dex */
public interface InformationActivityGeneratorInterface {
    void changeDialogInformationActivity(int i);

    void finishDialogInformationActivity();

    IInformationActivityGenerator getClickListener();

    void setClickListener(IInformationActivityGenerator iInformationActivityGenerator);

    void showInformationActivity(int i);

    void showInformationActivityForAddBuddy(String str);

    void showInformationActivityForCallEnd();

    void showInformationActivityForChangeToP2P();

    void showInformationActivityForCriticalUpdate();

    void showInformationActivityForNetworkError();

    void showInformationActivityForReceiverCallStateBusy();

    void viewInformationActivity(int i);

    void viewInformationActivity(int i, boolean z);
}
