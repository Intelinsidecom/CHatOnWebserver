package com.sec.chaton.samsungaccount;

import android.content.res.Resources;
import com.sec.chaton.R;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4859bx;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.j */
/* loaded from: classes.dex */
class C3390j implements InterfaceC3377cb {

    /* renamed from: a */
    final /* synthetic */ AbstractMultiDeviceActivity f12351a;

    C3390j(AbstractMultiDeviceActivity abstractMultiDeviceActivity) {
        this.f12351a = abstractMultiDeviceActivity;
    }

    @Override // com.sec.chaton.samsungaccount.InterfaceC3377cb
    /* renamed from: a */
    public void mo13213a(String str) throws Resources.NotFoundException {
        this.f12351a.m13086a(this.f12351a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12351a.f12130V, this.f12351a.f12131W);
        if (this.f12351a.f12163q) {
            C4859bx.m18384a(str, this.f12351a.f12118J, true);
            this.f12351a.m13112g(false);
            return;
        }
        C4859bx.m18384a(str, this.f12351a.f12118J, false);
        if (this.f12351a.f12166t || !C4859bx.m18387a(C4809aa.m18104a().m18121a("temp_account_country_code", ""), this.f12351a)) {
            this.f12351a.f12120L.m9552a();
        } else {
            this.f12351a.m13148q();
        }
    }
}
