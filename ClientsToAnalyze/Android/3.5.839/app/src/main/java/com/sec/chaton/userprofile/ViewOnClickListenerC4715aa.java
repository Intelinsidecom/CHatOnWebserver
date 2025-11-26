package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C4847bl;

/* compiled from: MyInfoFragment.java */
/* renamed from: com.sec.chaton.userprofile.aa */
/* loaded from: classes.dex */
class ViewOnClickListenerC4715aa implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyInfoFragment f17379a;

    ViewOnClickListenerC4715aa(MyInfoFragment myInfoFragment) {
        this.f17379a = myInfoFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            this.f17379a.startActivity(new Intent(this.f17379a.getActivity(), (Class<?>) EditNameActivity.class));
        }
    }
}
