package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.ff */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0402ff implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyActivity f1561a;

    ViewOnTouchListenerC0402ff(SpecialBuddyActivity specialBuddyActivity) {
        this.f1561a = specialBuddyActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f1561a.getString(R.string.special_buddy_button_see_more));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
