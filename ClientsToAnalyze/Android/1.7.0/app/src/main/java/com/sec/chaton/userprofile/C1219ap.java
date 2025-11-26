package com.sec.chaton.userprofile;

import com.sec.chaton.R;
import com.sec.chaton.facebook.InterfaceC0698m;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.ap */
/* loaded from: classes.dex */
class C1219ap implements InterfaceC0698m {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f4296a;

    C1219ap(UserProfileDetail userProfileDetail) {
        this.f4296a = userProfileDetail;
    }

    @Override // com.sec.chaton.facebook.InterfaceC0698m
    /* renamed from: a */
    public void mo3067a(int i, boolean z) {
    }

    @Override // com.sec.chaton.facebook.InterfaceC0698m
    /* renamed from: a */
    public void mo3066a(int i, int i2, String str) {
        if (i2 == -1) {
            StringBuilder sbAppend = new StringBuilder().append("Facebook Request ").append(i).append(" Success : ");
            if (str == null) {
                str = "";
            }
            C1341p.m4658b(sbAppend.append(str).toString(), getClass().getSimpleName());
            if (i == 0) {
                this.f4296a.m4378a(this.f4296a.f4257z.m3080a());
                this.f4296a.dismissDialog(0);
                return;
            }
            return;
        }
        if (i2 == 0) {
            C1341p.m4658b("Facebook Request " + i + " Cancel", getClass().getSimpleName());
            this.f4296a.dismissDialog(0);
            return;
        }
        C1341p.m4658b("Facebook Request " + i + " Error(" + i2 + ") : " + str, getClass().getSimpleName());
        this.f4296a.dismissDialog(0);
        if (i == 0) {
            if (i2 == -1002 || i2 == -1003) {
                if (this.f4296a.f4229K == null) {
                    this.f4296a.f4229K = C1619g.m5888a(this.f4296a, R.string.popup_no_network_connection, 0);
                }
                this.f4296a.f4229K.show();
            }
        }
    }
}
