package com.sec.chaton.trunk;

import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import com.sec.chaton.R;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.trunk.p061c.C3020a;
import com.sec.chaton.trunk.p061c.EnumC3026g;
import com.sec.chaton.util.C3197bl;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.bk */
/* loaded from: classes.dex */
class ViewOnClickListenerC3003bk implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f10849a;

    ViewOnClickListenerC3003bk(TrunkItemView trunkItemView) {
        this.f10849a = trunkItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C3197bl.m11159a() && !this.f10849a.f10579N && !this.f10849a.f10578M) {
            if (this.f10849a.f10605b != null) {
                this.f10849a.f10606c = (EditText) this.f10849a.f10608e.findViewById(R.id.trunkCommentEdit);
                if (this.f10849a.f10606c != null) {
                    this.f10849a.f10605b.hideSoftInputFromWindow(this.f10849a.f10606c.getWindowToken(), 0);
                }
            }
            if (this.f10849a.f10572G == EnumC3026g.IMAGE || this.f10849a.f10572G == EnumC3026g.AMS) {
                if (this.f10849a.f10609f != null) {
                    this.f10849a.f10609f.mo10202a(this.f10849a.f10572G, this.f10849a.f10573H);
                    return;
                }
                return;
            }
            if (this.f10849a.f10572G == EnumC3026g.VIDEO) {
                if (!"mounted".equals(Environment.getExternalStorageState())) {
                    C3641ai.m13211a(this.f10849a.f10608e, this.f10849a.getString(R.string.toast_sdcard_amount), 1).show();
                    return;
                }
                if (C3020a.m10524a(this.f10849a.f10573H) != null) {
                    if (this.f10849a.f10609f != null) {
                        this.f10849a.f10609f.mo10206b(this.f10849a.f10573H);
                    }
                } else {
                    int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
                    if (-3 == iM6733a || -2 == iM6733a) {
                        this.f10849a.m10264a(EnumC3010br.Nonetwork);
                    } else {
                        this.f10849a.m10290j();
                    }
                }
            }
        }
    }
}
