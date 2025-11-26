package com.sec.chaton;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Bundle;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import java.io.IOException;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.w */
/* loaded from: classes.dex */
class C3253w implements AccountManagerCallback<Bundle> {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f11741a;

    C3253w(HomeActivity homeActivity) {
        this.f11741a = homeActivity;
    }

    @Override // android.accounts.AccountManagerCallback
    public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
        try {
            accountManagerFuture.getResult().keySet();
            if (C1493a.m6463a("auto_regi_feature") && C3159aa.m10962a().m10987b("back_regi_status")) {
                C3159aa.m10962a().m10981a("back_regi_status");
            }
            if (C3250y.f11735c) {
                C3250y.m11453c("AddAccount was succeeded.", HomeActivity.f698a);
            }
            this.f11741a.startActivity(TabActivity.m1226a(this.f11741a));
        } catch (AuthenticatorException e) {
            if (C3250y.f11735c) {
                C3250y.m11453c("AddAccount was failed.", HomeActivity.f698a);
            }
        } catch (OperationCanceledException e2) {
            if (C3250y.f11735c) {
                C3250y.m11453c("AddAccount was canceled.", HomeActivity.f698a);
            }
        } catch (IOException e3) {
            if (C3250y.f11735c) {
                C3250y.m11453c("AddAccount was failed.", HomeActivity.f698a);
            }
        }
        this.f11741a.finish();
    }
}
