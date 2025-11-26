package com.sec.chaton.facebook;

import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;

/* compiled from: FacebookInvitationCardWriteActivity.java */
/* renamed from: com.sec.chaton.facebook.c */
/* loaded from: classes.dex */
class C0722c implements InterfaceC0736q {

    /* renamed from: a */
    final /* synthetic */ FacebookInvitationCardWriteActivity f2698a;

    C0722c(FacebookInvitationCardWriteActivity facebookInvitationCardWriteActivity) {
        this.f2698a = facebookInvitationCardWriteActivity;
    }

    @Override // com.sec.chaton.facebook.InterfaceC0736q
    /* renamed from: a */
    public void mo3204a(int i, boolean z) {
        if (!this.f2698a.isFinishing()) {
            this.f2698a.showDialog(0);
        }
    }

    @Override // com.sec.chaton.facebook.InterfaceC0736q
    /* renamed from: a */
    public void mo3203a(int i, int i2, String str) {
        if (!this.f2698a.isFinishing()) {
            this.f2698a.removeDialog(0);
            if (i2 == -1) {
                StringBuilder sbAppend = new StringBuilder().append("Facebook Request Invitation ").append(i).append(" Success : ");
                if (str == null) {
                    str = "";
                }
                C1786r.m6061b(sbAppend.append(str).toString(), getClass().getSimpleName());
                this.f2698a.m3193a(R.string.facebook_post_completed);
                this.f2698a.finish();
                return;
            }
            if (i2 == 0) {
                C1786r.m6061b("Facebook Request Invitation " + i + " Cancel", getClass().getSimpleName());
                return;
            }
            C1786r.m6061b("Facebook Request Invitation " + i + " Error(" + i2 + ") : " + str, getClass().getSimpleName());
            this.f2698a.m3192a();
            if (i2 == -1001) {
                this.f2698a.finish();
            }
        }
    }
}
