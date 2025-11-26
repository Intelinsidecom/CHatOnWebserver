package com.sec.chaton.userprofile;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.aw */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1226aw implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f4305a;

    ViewOnTouchListenerC1226aw(MyPageFragment myPageFragment) {
        this.f4305a = myPageFragment;
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
