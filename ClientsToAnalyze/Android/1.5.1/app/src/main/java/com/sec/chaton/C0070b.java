package com.sec.chaton;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Bundle;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.IOException;

/* renamed from: com.sec.chaton.b */
/* loaded from: classes.dex */
class C0070b implements AccountManagerCallback {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f340a;

    C0070b(HomeActivity homeActivity) {
        this.f340a = homeActivity;
    }

    @Override // android.accounts.AccountManagerCallback
    public void run(AccountManagerFuture accountManagerFuture) {
        try {
            try {
                ((Bundle) accountManagerFuture.getResult()).keySet();
                ChatONLogWriter.m3508c("AddAccount was succeeded", getClass().getSimpleName());
                this.f340a.f296f = true;
            } catch (AuthenticatorException e) {
                ChatONLogWriter.m3508c("AddAccount was Failed", getClass().getSimpleName());
            } catch (OperationCanceledException e2) {
                ChatONLogWriter.m3508c("AddAccount was Canceled", getClass().getSimpleName());
                this.f340a.finish();
            }
        } catch (IOException e3) {
            ChatONLogWriter.m3508c("AddAccount was Failed", getClass().getSimpleName());
        }
    }
}
