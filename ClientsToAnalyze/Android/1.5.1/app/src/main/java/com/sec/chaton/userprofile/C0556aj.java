package com.sec.chaton.userprofile;

import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.facebook.FacebookManager;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.userprofile.aj */
/* loaded from: classes.dex */
class C0556aj implements FacebookManager.OnResultListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f3535a;

    C0556aj(UserProfileDetail userProfileDetail) {
        this.f3535a = userProfileDetail;
    }

    @Override // com.sec.chaton.facebook.FacebookManager.OnResultListener
    public void onReady(int i, boolean z) {
    }

    @Override // com.sec.chaton.facebook.FacebookManager.OnResultListener
    public void onResult(int i, int i2, String str) {
        if (i2 == -1) {
            ChatONLogWriter.m3506b("Facebook Request " + i + " Success : " + (str != null ? str : ""), getClass().getSimpleName());
            if (i == 0) {
                this.f3535a.m3358b(this.f3535a.f3391I.m2350a());
                this.f3535a.dismissDialog(0);
                return;
            }
            return;
        }
        if (i2 == 0) {
            ChatONLogWriter.m3506b("Facebook Request " + i + " Cancel", getClass().getSimpleName());
            this.f3535a.dismissDialog(0);
            return;
        }
        ChatONLogWriter.m3506b("Facebook Request " + i + " Error(" + i2 + ") : " + str, getClass().getSimpleName());
        this.f3535a.dismissDialog(0);
        if (i == 0) {
            if (i2 == -1002 || i2 == -1003) {
                Toast.makeText(this.f3535a.f3412f, C0062R.string.dev_network_error, 0).show();
            }
        }
    }
}
