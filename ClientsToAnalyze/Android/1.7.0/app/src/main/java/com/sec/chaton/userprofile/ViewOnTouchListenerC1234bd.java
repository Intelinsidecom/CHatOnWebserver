package com.sec.chaton.userprofile;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.bd */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1234bd implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f4316a;

    ViewOnTouchListenerC1234bd(MyPageFragment myPageFragment) {
        this.f4316a = myPageFragment;
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
