package com.sec.chaton.smsplugin.p112ui;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: EditSlideDurationActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.x */
/* loaded from: classes.dex */
class ViewOnKeyListenerC4360x implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ EditSlideDurationActivity f15807a;

    ViewOnKeyListenerC4360x(EditSlideDurationActivity editSlideDurationActivity) {
        this.f15807a = editSlideDurationActivity;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (i) {
                case 23:
                    this.f15807a.m15770a();
                default:
                    return false;
            }
        }
        return false;
    }
}
