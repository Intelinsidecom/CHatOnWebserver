package com.sec.chaton.buddy.dialog;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.spp.push.dlc.api.IDlcApi;

/* compiled from: BuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.i */
/* loaded from: classes.dex */
class HandlerC1231i extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyDialog f4731a;

    HandlerC1231i(BuddyDialog buddyDialog) {
        this.f4731a = buddyDialog;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (C3847e.m14651aB()) {
            switch (message.what) {
                case IDlcApi.RC_NOT_PERMITTED /* -4 */:
                    if (message.arg1 == 33947648) {
                        this.f4731a.m7136A();
                        this.f4731a.m7145E();
                        break;
                    } else if (message.arg1 == 34013184) {
                        this.f4731a.m7136A();
                        this.f4731a.m7146F();
                        break;
                    }
                    break;
                case IDlcApi.RC_APPLICATION_BLOCKED /* -3 */:
                    if (message.arg1 == 33947648) {
                        this.f4731a.m7136A();
                        this.f4731a.m7145E();
                        break;
                    } else if (message.arg1 == 34013184) {
                        this.f4731a.m7136A();
                        this.f4731a.m7146F();
                        break;
                    }
                    break;
                case 0:
                    if (message.arg1 == 33947648) {
                        this.f4731a.m7136A();
                        this.f4731a.m7145E();
                        break;
                    } else if (message.arg1 == 34013184) {
                        this.f4731a.m7136A();
                        this.f4731a.m7146F();
                        break;
                    }
                    break;
            }
        }
    }
}
