package com.sec.chaton.sns.p115ui;

import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.sns.p113a.C4365b;
import java.util.Timer;
import p021c.C0351j;
import p021c.p022a.C0326a;

/* compiled from: WeiboDialog.java */
/* renamed from: com.sec.chaton.sns.ui.bc */
/* loaded from: classes.dex */
public class AsyncTaskC4476bc extends AsyncTask<String, Void, C0326a> {

    /* renamed from: a */
    final /* synthetic */ DialogC4469aw f16161a;

    public AsyncTaskC4476bc(DialogC4469aw dialogC4469aw) {
        this.f16161a = dialogC4469aw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0326a doInBackground(String... strArr) {
        C0351j e;
        C0326a c0326aM1169b;
        DialogC4469aw.m16972b("Called. GetAccessTokenTask - doInBackground()");
        try {
            c0326aM1169b = this.f16161a.f16144h.m1169b(Uri.parse(strArr[0]).getQueryParameter("oauth_verifier"));
        } catch (C0351j e2) {
            e = e2;
            c0326aM1169b = null;
        }
        try {
            this.f16161a.f16143g.m1228a(c0326aM1169b);
        } catch (C0351j e3) {
            e = e3;
            e.printStackTrace();
            this.f16161a.f16147k.mo2272a(new C4365b(e.getMessage(), -1005, null));
            this.f16161a.dismiss();
            return c0326aM1169b;
        }
        return c0326aM1169b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(C0326a c0326a) {
        DialogC4469aw.m16972b("Called. GetAccessTokenTask - onPostExecute()");
        if (this.f16161a.f16153q != null) {
            this.f16161a.f16153q.cancel();
        }
        this.f16161a.f16147k.mo2273a(c0326a);
        this.f16161a.dismiss();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        if (!this.f16161a.f16148l.isShowing()) {
            this.f16161a.f16148l.show();
        }
        if (this.f16161a.f16153q != null) {
            DialogC4469aw.m16972b("mTimer.cancel()");
            this.f16161a.f16153q.cancel();
            this.f16161a.f16153q = null;
            this.f16161a.f16153q = new Timer();
        } else {
            this.f16161a.f16153q = new Timer();
        }
        this.f16161a.f16153q.schedule(new C4475bb(this.f16161a, null), 30000L);
    }
}
