package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.sec.chaton.event.NewFeature;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3159aa;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.an */
/* loaded from: classes.dex */
class C0436an extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1498a;

    C0436an(TabActivity tabActivity) {
        this.f1498a = tabActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int iIntValue = C3159aa.m10962a().m10978a("new_feature_count", (Integer) 0).intValue();
        Intent intent2 = new Intent(GlobalApplication.m11493l(), (Class<?>) NewFeature.class);
        if (!TextUtils.isEmpty(C3159aa.m10962a().m10979a("new_feature_url_list", "")) && iIntValue > 0) {
            this.f1498a.startActivity(intent2);
        }
    }
}
