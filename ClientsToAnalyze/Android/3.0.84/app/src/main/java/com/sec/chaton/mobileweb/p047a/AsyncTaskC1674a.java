package com.sec.chaton.mobileweb.p047a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.mobileweb.C1692s;
import com.sec.chaton.p035io.entry.specialbuddy.SpecialBuddyHandshakeEntry;
import com.sec.chaton.util.C3247v;
import com.sec.chaton.util.C3250y;

/* compiled from: MobileWebHandshakeTask.java */
/* renamed from: com.sec.chaton.mobileweb.a.a */
/* loaded from: classes.dex */
public class AsyncTaskC1674a extends AsyncTask<String, Void, Void> {

    /* renamed from: a */
    static final String f6172a = AsyncTaskC1674a.class.getSimpleName();

    /* renamed from: b */
    private SpecialBuddyHandshakeEntry f6173b;

    /* renamed from: c */
    private Handler f6174c;

    /* renamed from: d */
    private String f6175d;

    public AsyncTaskC1674a(Handler handler, String str) {
        this.f6174c = handler;
        this.f6175d = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(String... strArr) {
        C3250y.m11450b("doInBackground()", f6172a);
        try {
            this.f6173b = (SpecialBuddyHandshakeEntry) new C3247v(strArr[0]).m11432b(SpecialBuddyHandshakeEntry.class);
            C3250y.m11450b("[IN] ENTRY : " + this.f6173b, f6172a);
        } catch (Exception e) {
            C3250y.m11443a(e, f6172a);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r4) {
        C3250y.m11450b("onPostExecute()", f6172a);
        if (this.f6173b != null) {
            String strM6986a = C1692s.m6986a(this.f6173b.success.toString(), this.f6175d);
            if (this.f6174c != null) {
                Message messageObtainMessage = this.f6174c.obtainMessage();
                messageObtainMessage.obj = strM6986a;
                messageObtainMessage.sendToTarget();
                this.f6174c = null;
                C3250y.m11450b("[OUT] RESPONSE : " + strM6986a, f6172a);
            }
            super.onPostExecute(r4);
        }
    }
}
