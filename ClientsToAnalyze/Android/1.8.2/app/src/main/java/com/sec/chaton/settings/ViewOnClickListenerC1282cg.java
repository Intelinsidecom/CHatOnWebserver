package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C1789u;

/* compiled from: FragmentSkinChange2.java */
/* renamed from: com.sec.chaton.settings.cg */
/* loaded from: classes.dex */
class ViewOnClickListenerC1282cg implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange2 f4828a;

    ViewOnClickListenerC1282cg(FragmentSkinChange2 fragmentSkinChange2) {
        this.f4828a = fragmentSkinChange2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCancel /* 2131493037 */:
                break;
            case R.id.setSkin /* 2131493525 */:
                C1789u.m6075a().edit().putString("setting_change_skin", this.f4828a.f4672j).commit();
                C1789u.m6075a().edit().putString("setting_change_skin_type", this.f4828a.f4673k).commit();
                C1789u.m6075a().edit().putString("new_skin_filename", this.f4828a.f4656N).commit();
                C1789u.m6075a().edit().putString("setting_change_bubble_send", this.f4828a.f4674l).commit();
                C1789u.m6075a().edit().putString("setting_change_bubble_receive", this.f4828a.f4675m).commit();
                break;
            default:
                return;
        }
        this.f4828a.getActivity().finish();
    }
}
