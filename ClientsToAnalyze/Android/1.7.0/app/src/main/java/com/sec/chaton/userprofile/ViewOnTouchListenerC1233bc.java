package com.sec.chaton.userprofile;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.bc */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1233bc implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f4315a;

    ViewOnTouchListenerC1233bc(MyPageFragment myPageFragment) {
        this.f4315a = myPageFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
