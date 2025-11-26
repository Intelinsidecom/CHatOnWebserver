package com.sec.chaton.samsungaccount;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.sec.chaton.R;
import java.io.UnsupportedEncodingException;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.ac */
/* loaded from: classes.dex */
class C2314ac extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ MainActivity f8737a;

    C2314ac(MainActivity mainActivity) {
        this.f8737a = mainActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws Resources.NotFoundException, UnsupportedEncodingException {
        int i = intent.getExtras().getInt("which_service");
        this.f8737a.m8803t();
        if (i == 0) {
            if (this.f8737a.f8652C) {
                this.f8737a.m8795p();
                return;
            } else {
                this.f8737a.m8755b(R.string.auto_regi_checking_account);
                this.f8737a.m8773e();
                return;
            }
        }
        if (i == 2) {
            this.f8737a.f8721r.mo5479a(this.f8737a.f8678aC);
            this.f8737a.f8678aC.m11091a(1001, 30000);
        }
    }
}
