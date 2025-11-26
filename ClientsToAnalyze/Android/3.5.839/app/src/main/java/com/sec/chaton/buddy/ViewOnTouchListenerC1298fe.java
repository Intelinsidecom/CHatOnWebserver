package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.fe */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1298fe implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyInfoFragment f4834a;

    ViewOnTouchListenerC1298fe(BuddyInfoFragment buddyInfoFragment) {
        this.f4834a = buddyInfoFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f4834a.getString(R.string.media_contact));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
