package com.sec.chaton;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Bundle;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import java.io.IOException;

/* compiled from: SplashActivity.java */
/* renamed from: com.sec.chaton.co */
/* loaded from: classes.dex */
class C1886co implements AccountManagerCallback<Bundle> {

    /* renamed from: a */
    final /* synthetic */ SplashActivity f7103a;

    C1886co(SplashActivity splashActivity) {
        this.f7103a = splashActivity;
    }

    @Override // android.accounts.AccountManagerCallback
    public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
        try {
            accountManagerFuture.getResult().keySet();
            if (C2349a.m10301a("auto_regi_feature") && C4809aa.m18104a().m18129b("back_regi_status")) {
                C4809aa.m18104a().m18123a("back_regi_status");
            }
            if (C4904y.f17873c) {
                C4904y.m18641c("AddAccount was succeeded.", SplashActivity.f2006p);
            }
            this.f7103a.startActivity(TabActivity.m3014a(this.f7103a));
        } catch (AuthenticatorException e) {
            if (C4904y.f17873c) {
                C4904y.m18641c("AddAccount was failed.", SplashActivity.f2006p);
            }
        } catch (OperationCanceledException e2) {
            if (C4904y.f17873c) {
                C4904y.m18641c("AddAccount was canceled.", SplashActivity.f2006p);
            }
        } catch (IOException e3) {
            if (C4904y.f17873c) {
                C4904y.m18641c("AddAccount was failed.", SplashActivity.f2006p);
            }
        }
        this.f7103a.finish();
    }
}
