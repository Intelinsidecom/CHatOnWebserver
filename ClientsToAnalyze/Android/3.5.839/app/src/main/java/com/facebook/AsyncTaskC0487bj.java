package com.facebook;

import android.content.Context;
import android.os.AsyncTask;
import com.facebook.p032b.C0476s;

/* compiled from: Session.java */
/* renamed from: com.facebook.bj */
/* loaded from: classes.dex */
class AsyncTaskC0487bj extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ C0478ba f1203a;

    /* renamed from: b */
    private final String f1204b;

    /* renamed from: c */
    private final Context f1205c;

    public AsyncTaskC0487bj(C0478ba c0478ba, String str, Context context) {
        this.f1203a = c0478ba;
        this.f1204b = str;
        this.f1205c = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        try {
            C0498bu.m1809a(this.f1205c, this.f1204b);
            return null;
        } catch (Exception e) {
            C0476s.m1715a("Facebook-publish", e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r4) {
        synchronized (this.f1203a) {
            this.f1203a.f1180o = null;
        }
    }
}
