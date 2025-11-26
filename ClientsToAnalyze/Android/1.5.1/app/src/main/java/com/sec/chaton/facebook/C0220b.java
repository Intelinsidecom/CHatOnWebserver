package com.sec.chaton.facebook;

import com.sec.chaton.C0062R;
import com.sec.chaton.facebook.FacebookManager;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.facebook.b */
/* loaded from: classes.dex */
class C0220b implements FacebookManager.OnResultListener {

    /* renamed from: a */
    final /* synthetic */ FacebookMenuActivity f1848a;

    C0220b(FacebookMenuActivity facebookMenuActivity) {
        this.f1848a = facebookMenuActivity;
    }

    @Override // com.sec.chaton.facebook.FacebookManager.OnResultListener
    public void onReady(int i, boolean z) {
        this.f1848a.showDialog(0);
    }

    @Override // com.sec.chaton.facebook.FacebookManager.OnResultListener
    public void onResult(int i, int i2, String str) {
        if (i == 0 || i == 1) {
            this.f1848a.dismissDialog(0);
        } else {
            this.f1848a.dismissDialog(1);
        }
        if (i2 == -1) {
            ChatONLogWriter.m3506b("Facebook Request " + i + " Success : " + (str != null ? str : ""), getClass().getSimpleName());
            if (i == 0 || i == 1) {
                this.f1848a.m2358a(C0062R.string.facebook_post_completed);
                return;
            } else {
                if (i == 2) {
                    this.f1848a.finish();
                    return;
                }
                return;
            }
        }
        if (i2 == 0) {
            ChatONLogWriter.m3506b("Facebook Request " + i + " Cancel", getClass().getSimpleName());
            return;
        }
        ChatONLogWriter.m3506b("Facebook Request " + i + " Error(" + i2 + ") : " + str, getClass().getSimpleName());
        if (i == 0 || i == 1) {
            this.f1848a.m2358a(C0062R.string.facebook_post_failed);
        }
        if (i == 2 && (i2 == -1002 || i2 == -1003)) {
            this.f1848a.m2358a(C0062R.string.dev_network_error);
        }
        if (i2 == -1001) {
            this.f1848a.finish();
        }
    }
}
