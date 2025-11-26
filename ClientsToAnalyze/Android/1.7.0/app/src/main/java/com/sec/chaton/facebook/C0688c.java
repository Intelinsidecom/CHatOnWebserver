package com.sec.chaton.facebook;

import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;

/* compiled from: FacebookInvitationCardWriteActivity.java */
/* renamed from: com.sec.chaton.facebook.c */
/* loaded from: classes.dex */
class C0688c implements InterfaceC0698m {

    /* renamed from: a */
    final /* synthetic */ FacebookInvitationCardWriteActivity f2362a;

    C0688c(FacebookInvitationCardWriteActivity facebookInvitationCardWriteActivity) {
        this.f2362a = facebookInvitationCardWriteActivity;
    }

    @Override // com.sec.chaton.facebook.InterfaceC0698m
    /* renamed from: a */
    public void mo3067a(int i, boolean z) {
        this.f2362a.showDialog(0);
    }

    @Override // com.sec.chaton.facebook.InterfaceC0698m
    /* renamed from: a */
    public void mo3066a(int i, int i2, String str) {
        this.f2362a.dismissDialog(0);
        if (i2 == -1) {
            StringBuilder sbAppend = new StringBuilder().append("Facebook Request Invitation ").append(i).append(" Success : ");
            if (str == null) {
                str = "";
            }
            C1341p.m4658b(sbAppend.append(str).toString(), getClass().getSimpleName());
            this.f2362a.m3056a(R.string.facebook_post_completed);
            this.f2362a.finish();
            return;
        }
        if (i2 == 0) {
            C1341p.m4658b("Facebook Request Invitation " + i + " Cancel", getClass().getSimpleName());
            return;
        }
        C1341p.m4658b("Facebook Request Invitation " + i + " Error(" + i2 + ") : " + str, getClass().getSimpleName());
        this.f2362a.m3056a(R.string.facebook_post_failed);
        if (i2 == -1001) {
            this.f2362a.finish();
        }
    }
}
