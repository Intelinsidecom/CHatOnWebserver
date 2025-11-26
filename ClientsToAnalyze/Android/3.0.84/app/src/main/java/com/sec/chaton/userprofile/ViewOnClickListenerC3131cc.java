package com.sec.chaton.userprofile;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1331i;
import com.sec.chaton.util.C3250y;

/* compiled from: SetCoverstoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.cc */
/* loaded from: classes.dex */
class ViewOnClickListenerC3131cc implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SetCoverstoryFragment f11363a;

    ViewOnClickListenerC3131cc(SetCoverstoryFragment setCoverstoryFragment) {
        this.f11363a = setCoverstoryFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C3250y.f11734b) {
            C3250y.m11450b("SetCoverstoryFragment [url] : " + this.f11363a.f11276i + ", #### [filename] : " + this.f11363a.f11277j + ", #### [id] : " + this.f11363a.f11278k, getClass().getSimpleName());
        }
        switch (view.getId()) {
            case R.id.button1 /* 2131165901 */:
                this.f11363a.f11280m.show();
                this.f11363a.f11281o = new C1331i(this.f11363a.f11285s);
                this.f11363a.f11281o.m5762b(this.f11363a.f11278k);
                this.f11363a.f11280m.show();
                break;
        }
    }
}
