package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.util.C1323bs;

/* compiled from: FragmentSkinChange2.java */
/* renamed from: com.sec.chaton.settings.n */
/* loaded from: classes.dex */
class ViewOnClickListenerC1082n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange2 f3726a;

    ViewOnClickListenerC1082n(FragmentSkinChange2 fragmentSkinChange2) {
        this.f3726a = fragmentSkinChange2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1323bs.m4575a().edit().putString("setting_change_skin", this.f3726a.f3545j).commit();
        C1323bs.m4575a().edit().putString("setting_change_bubble_send", this.f3726a.f3546k).commit();
        C1323bs.m4575a().edit().putString("setting_change_bubble_receive", this.f3726a.f3547l).commit();
        this.f3726a.getActivity().finish();
    }
}
