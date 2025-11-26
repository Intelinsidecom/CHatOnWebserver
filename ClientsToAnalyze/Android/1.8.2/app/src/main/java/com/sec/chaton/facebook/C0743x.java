package com.sec.chaton.facebook;

import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;

/* compiled from: FacebookMenuActivity.java */
/* renamed from: com.sec.chaton.facebook.x */
/* loaded from: classes.dex */
class C0743x implements InterfaceC0736q {

    /* renamed from: a */
    final /* synthetic */ FacebookMenuActivity f2740a;

    C0743x(FacebookMenuActivity facebookMenuActivity) {
        this.f2740a = facebookMenuActivity;
    }

    @Override // com.sec.chaton.facebook.InterfaceC0736q
    /* renamed from: a */
    public void mo3204a(int i, boolean z) {
        this.f2740a.showDialog(0);
    }

    @Override // com.sec.chaton.facebook.InterfaceC0736q
    /* renamed from: a */
    public void mo3203a(int i, int i2, String str) {
        if (i == 0 || i == 1) {
            this.f2740a.dismissDialog(0);
        } else {
            this.f2740a.dismissDialog(1);
        }
        if (i2 == -1) {
            StringBuilder sbAppend = new StringBuilder().append("Facebook Request ").append(i).append(" Success : ");
            if (str == null) {
                str = "";
            }
            C1786r.m6061b(sbAppend.append(str).toString(), getClass().getSimpleName());
            if (i == 0 || i == 1) {
                this.f2740a.m3199a(R.string.facebook_post_completed);
                return;
            } else {
                if (i == 2) {
                    this.f2740a.finish();
                    return;
                }
                return;
            }
        }
        if (i2 == 0) {
            C1786r.m6061b("Facebook Request " + i + " Cancel", getClass().getSimpleName());
            return;
        }
        C1786r.m6061b("Facebook Request " + i + " Error(" + i2 + ") : " + str, getClass().getSimpleName());
        if (i == 0 || i == 1) {
            this.f2740a.m3199a(R.string.facebook_post_failed);
        }
        if (i == 2 && (i2 == -1002 || i2 == -1003)) {
            this.f2740a.m3199a(R.string.dev_network_error);
        }
        if (i2 == -1001) {
            this.f2740a.finish();
        }
    }
}
