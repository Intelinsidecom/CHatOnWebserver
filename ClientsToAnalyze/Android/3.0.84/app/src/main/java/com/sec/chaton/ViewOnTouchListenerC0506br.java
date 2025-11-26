package com.sec.chaton;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.br */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0506br implements View.OnTouchListener {

    /* renamed from: a */
    int f1644a;

    /* renamed from: b */
    final /* synthetic */ TabActivity f1645b;

    ViewOnTouchListenerC0506br(TabActivity tabActivity) {
        this.f1645b = tabActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f1645b.m1219M();
                break;
            case 1:
                this.f1645b.m1221N();
                break;
            case 2:
                this.f1645b.m1236a(motionEvent, this.f1644a);
                break;
        }
        return true;
    }
}
