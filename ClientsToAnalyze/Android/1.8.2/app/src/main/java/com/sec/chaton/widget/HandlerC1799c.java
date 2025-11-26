package com.sec.chaton.widget;

import android.os.Handler;
import android.os.Message;

/* compiled from: PreferenceListFragment.java */
/* renamed from: com.sec.chaton.widget.c */
/* loaded from: classes.dex */
class HandlerC1799c extends Handler {

    /* renamed from: a */
    final /* synthetic */ PreferenceListFragment f6488a;

    HandlerC1799c(PreferenceListFragment preferenceListFragment) {
        this.f6488a = preferenceListFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws NoSuchMethodException, SecurityException {
        switch (message.what) {
            case 0:
                this.f6488a.m6119b();
                break;
        }
    }
}
