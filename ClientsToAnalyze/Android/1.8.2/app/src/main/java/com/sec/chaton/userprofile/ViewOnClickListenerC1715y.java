package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.facebook.FacebookMenuActivity;

/* compiled from: MyPageFragmentTablet.java */
/* renamed from: com.sec.chaton.userprofile.y */
/* loaded from: classes.dex */
class ViewOnClickListenerC1715y implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragmentTablet f6232a;

    ViewOnClickListenerC1715y(MyPageFragmentTablet myPageFragmentTablet) {
        this.f6232a = myPageFragmentTablet;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.f6232a.f5875N.m3224c()) {
            if (!this.f6232a.f5876O.isShowing()) {
                this.f6232a.f5876O.show();
                this.f6232a.f5875N.m3217a(0);
                return;
            }
            return;
        }
        this.f6232a.startActivity(new Intent(this.f6232a.getActivity(), (Class<?>) FacebookMenuActivity.class));
    }
}
