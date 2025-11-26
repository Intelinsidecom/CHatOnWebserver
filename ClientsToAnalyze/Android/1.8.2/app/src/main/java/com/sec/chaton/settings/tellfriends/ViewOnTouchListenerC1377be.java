package com.sec.chaton.settings.tellfriends;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: TWFollowingsListActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.be */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1377be implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ TWFollowingsListActivity f5217a;

    ViewOnTouchListenerC1377be(TWFollowingsListActivity tWFollowingsListActivity) {
        this.f5217a = tWFollowingsListActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f5217a.f5032s) {
                this.f5217a.f5032s = false;
            } else if (this.f5217a.f5030q && !this.f5217a.f5038y) {
                this.f5217a.m4927b();
            }
        }
        return false;
    }
}
