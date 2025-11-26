package com.sec.chaton;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import com.sec.chaton.event.C1464f;
import com.sec.chaton.event.EventDialog;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;

/* compiled from: PlusFragment.java */
/* renamed from: com.sec.chaton.ad */
/* loaded from: classes.dex */
class HandlerC0426ad extends Handler {

    /* renamed from: a */
    final /* synthetic */ PlusFragment f1479a;

    HandlerC0426ad(PlusFragment plusFragment) {
        this.f1479a = plusFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1200 && ((C0267d) message.obj).m1351b() == EnumC1587o.SUCCESS) {
            C3250y.m11453c("banner download start" + this, getClass().getSimpleName());
            this.f1479a.f711i.m6386b();
        }
        if (message.what == 2) {
            C3250y.m11453c("banner downloaded done" + this, getClass().getSimpleName());
            C1464f.m6389a(true);
            this.f1479a.f710h.notifyDataSetChanged();
            LocalBroadcastManager.getInstance(GlobalApplication.m11493l()).sendBroadcast(new Intent("more_tab_badge_update"));
            if (C1464f.m6395c()) {
                try {
                    this.f1479a.startActivity(new Intent(this.f1479a.getActivity(), (Class<?>) EventDialog.class));
                } catch (Exception e) {
                    C3250y.m11453c("Exception is occurred!" + this, getClass().getSimpleName());
                }
            }
        }
        if (message.what == 4) {
            C3250y.m11453c("banner download failed" + this, getClass().getSimpleName());
            C1464f.m6389a(false);
        }
        if (message.what == 3) {
            C1464f.m6389a(false);
        }
    }
}
