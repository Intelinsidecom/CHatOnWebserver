package com.sec.chaton.facebook;

import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;

/* compiled from: FacebookMenuActivity.java */
/* renamed from: com.sec.chaton.facebook.e */
/* loaded from: classes.dex */
class C0690e implements InterfaceC0698m {

    /* renamed from: a */
    final /* synthetic */ FacebookMenuActivity f2363a;

    C0690e(FacebookMenuActivity facebookMenuActivity) {
        this.f2363a = facebookMenuActivity;
    }

    @Override // com.sec.chaton.facebook.InterfaceC0698m
    /* renamed from: a */
    public void mo3067a(int i, boolean z) {
        this.f2363a.showDialog(0);
    }

    @Override // com.sec.chaton.facebook.InterfaceC0698m
    /* renamed from: a */
    public void mo3066a(int i, int i2, String str) {
        if (i == 0 || i == 1) {
            this.f2363a.dismissDialog(0);
        } else {
            this.f2363a.dismissDialog(1);
        }
        if (i2 == -1) {
            StringBuilder sbAppend = new StringBuilder().append("Facebook Request ").append(i).append(" Success : ");
            if (str == null) {
                str = "";
            }
            C1341p.m4658b(sbAppend.append(str).toString(), getClass().getSimpleName());
            if (i == 0 || i == 1) {
                this.f2363a.m3061a(R.string.facebook_post_completed);
                return;
            } else {
                if (i == 2) {
                    this.f2363a.finish();
                    return;
                }
                return;
            }
        }
        if (i2 == 0) {
            C1341p.m4658b("Facebook Request " + i + " Cancel", getClass().getSimpleName());
            return;
        }
        C1341p.m4658b("Facebook Request " + i + " Error(" + i2 + ") : " + str, getClass().getSimpleName());
        if (i == 0 || i == 1) {
            this.f2363a.m3061a(R.string.facebook_post_failed);
        }
        if (i == 2 && (i2 == -1002 || i2 == -1003)) {
            this.f2363a.m3061a(R.string.dev_network_error);
        }
        if (i2 == -1001) {
            this.f2363a.finish();
        }
    }
}
