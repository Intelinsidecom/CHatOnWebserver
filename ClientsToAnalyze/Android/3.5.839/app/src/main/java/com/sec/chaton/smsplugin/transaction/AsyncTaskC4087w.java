package com.sec.chaton.smsplugin.transaction;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.google.android.p134a.p135a.C5082e;

/* compiled from: PushReceiver.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.w */
/* loaded from: classes.dex */
public class AsyncTaskC4087w extends AsyncTask<Intent, Void, C4086v> {

    /* renamed from: a */
    final /* synthetic */ PushReceiver f14717a;

    /* renamed from: b */
    private final Context f14718b;

    public AsyncTaskC4087w(PushReceiver pushReceiver, Context context) {
        this.f14717a = pushReceiver;
        this.f14718b = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0412  */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sec.chaton.smsplugin.transaction.C4086v doInBackground(android.content.Intent... r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1086
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.transaction.AsyncTaskC4087w.doInBackground(android.content.Intent[]):com.sec.chaton.smsplugin.transaction.v");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(C4086v c4086v) {
        if (c4086v != null && c4086v.f14715h == 130) {
            super.onPostExecute(c4086v);
        }
    }

    /* renamed from: a */
    private C3782a m15699a(C5082e c5082e) {
        C3782a c3782aM14204a;
        if (c5082e == null) {
            return null;
        }
        String strM19308c = c5082e.m19308c();
        if (TextUtils.isEmpty(strM19308c) || (c3782aM14204a = C3782a.m14204a(strM19308c, true)) == null || strM19308c.equals(c3782aM14204a.m14262d())) {
            return null;
        }
        c3782aM14204a.m14258b(strM19308c);
        c3782aM14204a.m14261c();
        return c3782aM14204a;
    }
}
