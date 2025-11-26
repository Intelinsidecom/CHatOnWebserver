package com.facebook;

import android.content.Context;
import android.os.AsyncTask;
import com.facebook.p008b.C0105s;

/* compiled from: Session.java */
/* renamed from: com.facebook.bj */
/* loaded from: classes.dex */
class AsyncTaskC0116bj extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ C0107ba f234a;

    /* renamed from: b */
    private final String f235b;

    /* renamed from: c */
    private final Context f236c;

    public AsyncTaskC0116bj(C0107ba c0107ba, String str, Context context) {
        this.f234a = c0107ba;
        this.f235b = str;
        this.f236c = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        try {
            C0127bu.m366a(this.f236c, this.f235b);
            return null;
        } catch (Exception e) {
            C0105s.m271a("Facebook-publish", e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r4) {
        synchronized (this.f234a) {
            this.f234a.f211o = null;
        }
    }
}
