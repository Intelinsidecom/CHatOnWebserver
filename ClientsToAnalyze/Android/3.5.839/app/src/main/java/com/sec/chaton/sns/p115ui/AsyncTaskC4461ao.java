package com.sec.chaton.sns.p115ui;

import android.os.AsyncTask;
import com.sec.chaton.sns.p113a.C4365b;
import com.sec.chaton.util.C4904y;
import java.util.Timer;
import p010b.C0320g;
import p010b.p012b.C0272a;

/* compiled from: TwDialog.java */
/* renamed from: com.sec.chaton.sns.ui.ao */
/* loaded from: classes.dex */
public class AsyncTaskC4461ao extends AsyncTask<String, Void, C0272a> {

    /* renamed from: a */
    final /* synthetic */ DialogC4455ai f16119a;

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        if (!this.f16119a.f16108k.isShowing()) {
            this.f16119a.f16108k.show();
        }
        if (this.f16119a.f16113p == null) {
            this.f16119a.f16113p = new Timer();
        } else {
            C4904y.m18641c("mTimer.cancel()", getClass().getSimpleName());
            this.f16119a.f16113p.cancel();
            this.f16119a.f16113p = null;
            this.f16119a.f16113p = new Timer();
        }
        this.f16119a.f16113p.schedule(new C4460an(this.f16119a, null), 30000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0272a doInBackground(String... strArr) {
        C0320g e;
        C0272a c0272aA;
        C4904y.m18641c("Called. OauthAccessTokenTask - doInBackground()", getClass().getSimpleName());
        try {
            c0272aA = this.f16119a.f16104g.mo966a(strArr[0]);
        } catch (C0320g e2) {
            e = e2;
            c0272aA = null;
        }
        try {
            this.f16119a.f16104g.mo972a(c0272aA);
        } catch (C0320g e3) {
            e = e3;
            e.printStackTrace();
            this.f16119a.f16107j.mo2272a(new C4365b(e.m1081d(), -1001, null));
            this.f16119a.m16943b();
            return c0272aA;
        }
        return c0272aA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(C0272a c0272a) {
        C4904y.m18641c("Called. OauthAccessTokenTask - onPostExecute()", getClass().getSimpleName());
        if (this.f16119a.f16113p != null) {
            this.f16119a.f16113p.cancel();
        }
        this.f16119a.f16107j.mo2273a(c0272a);
        this.f16119a.dismiss();
    }
}
