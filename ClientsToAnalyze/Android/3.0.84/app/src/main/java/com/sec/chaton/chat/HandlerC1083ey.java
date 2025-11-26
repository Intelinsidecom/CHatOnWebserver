package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: EditChatTitleDialog.java */
/* renamed from: com.sec.chaton.chat.ey */
/* loaded from: classes.dex */
class HandlerC1083ey extends Handler {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1082ex f4345a;

    HandlerC1083ey(AlertDialogC1082ex alertDialogC1082ex) {
        this.f4345a = alertDialogC1082ex;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (GlobalApplication.m6447a().getApplicationContext() != null) {
            switch (message.what) {
                case 806:
                    C0267d c0267d = (C0267d) message.obj;
                    if (this.f4345a.f4334b.isShowing()) {
                        this.f4345a.f4334b.dismiss();
                    }
                    if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                        this.f4345a.m5354b();
                        this.f4345a.dismiss();
                        break;
                    } else {
                        AbstractC3271a.m11494a(this.f4345a.f4339g).mo11495a(R.string.ams_attention_title).mo11506b(R.string.toast_setting_profile_update_failed).mo11511b(true).mo11515d(R.string.dialog_ok, null).mo11512b();
                        break;
                    }
                    break;
            }
        }
    }
}
