package com.sec.chaton.chat.notification;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.q */
/* loaded from: classes.dex */
class C1121q implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f4531a;

    C1121q(ScreenNotification2 screenNotification2) {
        this.f4531a = screenNotification2;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f4531a.m5427e();
        return true;
    }
}
