package com.sec.chaton.userprofile;

import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.facebook.InterfaceC0736q;
import com.sec.chaton.util.C1786r;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.cc */
/* loaded from: classes.dex */
class C1680cc implements InterfaceC0736q {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f6177a;

    C1680cc(UserProfileDetail userProfileDetail) {
        this.f6177a = userProfileDetail;
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
                this.f6177a.dismissDialog(0);
                return;
            }
            return;
        }
        if (i2 == 0) {
            C1786r.m6061b("Facebook Request " + i + " Cancel", getClass().getSimpleName());
            this.f6177a.dismissDialog(0);
            return;
        }
        C1786r.m6061b("Facebook Request " + i + " Error(" + i2 + ") : " + str, getClass().getSimpleName());
        this.f6177a.dismissDialog(0);
        if (i == 0) {
            if (i2 == -1002 || i2 == -1003) {
                if (this.f6177a.f6055al == null) {
                    this.f6177a.f6055al = Toast.makeText(this.f6177a, R.string.toast_network_unable, 0);
                }
                this.f6177a.f6055al.show();
            }
        }
    }
}
