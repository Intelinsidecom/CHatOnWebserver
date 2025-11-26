package com.sec.chaton.chat.notification;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.ah */
/* loaded from: classes.dex */
class C1801ah implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f6811a;

    C1801ah(ScreenNotification2 screenNotification2) {
        this.f6811a = screenNotification2;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f6811a.m8888m();
        return true;
    }
}
