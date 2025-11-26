package com.sec.chaton.userprofile;

import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.facebook.InterfaceC0736q;
import com.sec.chaton.util.C1786r;

/* compiled from: MyPageFragmentTablet.java */
/* renamed from: com.sec.chaton.userprofile.z */
/* loaded from: classes.dex */
class C1716z implements InterfaceC0736q {

    /* renamed from: a */
    final /* synthetic */ MyPageFragmentTablet f6233a;

    C1716z(MyPageFragmentTablet myPageFragmentTablet) {
        this.f6233a = myPageFragmentTablet;
    }

    @Override // com.sec.chaton.facebook.InterfaceC0736q
    /* renamed from: a */
    public void mo3204a(int i, boolean z) {
    }

    @Override // com.sec.chaton.facebook.InterfaceC0736q
    /* renamed from: a */
    public void mo3203a(int i, int i2, String str) {
        if (i2 == -1) {
            StringBuilder sbAppend = new StringBuilder().append("Facebook Request ").append(i).append(" Success : ");
            if (str == null) {
                str = "";
            }
            C1786r.m6061b(sbAppend.append(str).toString(), getClass().getSimpleName());
            if (i == 0) {
                this.f6233a.m5623b(this.f6233a.f5875N.m3221b());
                this.f6233a.f5876O.dismiss();
                return;
            }
            return;
        }
        if (i2 == 0) {
            C1786r.m6061b("Facebook Request " + i + " Cancel", getClass().getSimpleName());
            this.f6233a.f5876O.dismiss();
            return;
        }
        C1786r.m6061b("Facebook Request " + i + " Error(" + i2 + ") : " + str, getClass().getSimpleName());
        this.f6233a.f5876O.dismiss();
        if (i == 0) {
            if (i2 == -1002 || i2 == -1003) {
                Toast.makeText(this.f6233a.f5869H, R.string.toast_network_unable, 0).show();
            }
        }
    }
}
