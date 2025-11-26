package com.sec.chaton.settings.tellfriends;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: TellFriendsWeiboActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cg */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1406cg implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ TellFriendsWeiboActivity f5270a;

    ViewOnTouchListenerC1406cg(TellFriendsWeiboActivity tellFriendsWeiboActivity) {
        this.f5270a = tellFriendsWeiboActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f5270a.f5074t) {
                this.f5270a.f5074t = false;
            } else if (this.f5270a.f5072r && !this.f5270a.f5080z) {
                this.f5270a.m4992b();
            }
        }
        return false;
    }
}
