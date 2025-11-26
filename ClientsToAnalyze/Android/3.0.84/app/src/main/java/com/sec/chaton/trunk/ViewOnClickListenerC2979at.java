package com.sec.chaton.trunk;

import android.os.Environment;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.trunk.p061c.C3020a;
import com.sec.chaton.util.C3197bl;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: TrunkFullView.java */
/* renamed from: com.sec.chaton.trunk.at */
/* loaded from: classes.dex */
class ViewOnClickListenerC2979at implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkFullView f10779a;

    ViewOnClickListenerC2979at(TrunkFullView trunkFullView) {
        this.f10779a = trunkFullView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C3197bl.m11159a() && !this.f10779a.f10562x && !this.f10779a.f10561w) {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                C3641ai.m13211a(this.f10779a.m10223h(), this.f10779a.getString(R.string.toast_sdcard_amount), 1).show();
                return;
            }
            if (C3020a.m10524a(this.f10779a.f10559u) != null) {
                if (this.f10779a.f10543e != null) {
                    this.f10779a.f10543e.mo10360a(this.f10779a.f10555q, this.f10779a.f10559u);
                }
            } else {
                int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
                if (-3 == iM6733a || -2 == iM6733a) {
                    this.f10779a.m10232l();
                } else {
                    this.f10779a.m10225i();
                }
            }
        }
    }
}
