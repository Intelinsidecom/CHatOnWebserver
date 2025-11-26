package com.sec.chaton;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: DataPacketDialog2.java */
/* renamed from: com.sec.chaton.g */
/* loaded from: classes.dex */
class ViewOnKeyListenerC0751g implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ DataPacketDialog2 f2767a;

    ViewOnKeyListenerC0751g(DataPacketDialog2 dataPacketDialog2) {
        this.f2767a = dataPacketDialog2;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 66 || keyEvent.getAction() != 1) {
            return false;
        }
        if (this.f2767a.f210c.isChecked()) {
            this.f2767a.f210c.setChecked(false);
            return true;
        }
        this.f2767a.f210c.setChecked(true);
        return true;
    }
}
