package com.sec.chaton;

import android.content.Intent;
import android.text.TextUtils;
import com.sec.chaton.util.C4822an;

/* compiled from: SplashActivity.java */
/* renamed from: com.sec.chaton.cm */
/* loaded from: classes.dex */
class RunnableC1884cm implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SplashActivity f7101a;

    RunnableC1884cm(SplashActivity splashActivity) {
        this.f7101a = splashActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f7101a.f2008B) {
            this.f7101a.m2990l();
            return;
        }
        String strM18236g = C4822an.m18236g();
        if (!TextUtils.isEmpty(strM18236g)) {
            strM18236g = strM18236g.toUpperCase();
        }
        Intent intent = new Intent(this.f7101a, (Class<?>) EOSPopupActivity.class);
        intent.setFlags(603979776);
        intent.putExtra("force_close", true);
        intent.putExtra("country_code", strM18236g);
        this.f7101a.startActivityForResult(intent, 100);
    }
}
