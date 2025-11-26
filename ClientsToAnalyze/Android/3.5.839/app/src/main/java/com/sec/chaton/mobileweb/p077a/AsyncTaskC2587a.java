package com.sec.chaton.mobileweb.p077a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.mobileweb.C2602p;
import com.sec.chaton.p065io.entry.specialbuddy.SpecialBuddyHandshakeEntry;
import com.sec.chaton.util.C4901v;
import com.sec.chaton.util.C4904y;

/* compiled from: MobileWebHandshakeTask.java */
/* renamed from: com.sec.chaton.mobileweb.a.a */
/* loaded from: classes.dex */
public class AsyncTaskC2587a extends AsyncTask<String, Void, Integer> {

    /* renamed from: a */
    static final String f9232a = AsyncTaskC2587a.class.getSimpleName();

    /* renamed from: b */
    private SpecialBuddyHandshakeEntry f9233b;

    /* renamed from: c */
    private Handler f9234c;

    /* renamed from: d */
    private String f9235d;

    /* renamed from: a */
    public static AsyncTaskC2587a m10995a(Handler handler, String str) {
        return new AsyncTaskC2587a(handler, str);
    }

    private AsyncTaskC2587a(Handler handler, String str) {
        this.f9234c = handler;
        this.f9235d = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(String... strArr) {
        C4904y.m18639b("doInBackground()", f9232a);
        try {
            this.f9233b = (SpecialBuddyHandshakeEntry) new C4901v(strArr[0]).m18628b(SpecialBuddyHandshakeEntry.class);
            C4904y.m18639b("[IN] ENTRY : " + this.f9233b, f9232a);
            return -1;
        } catch (Exception e) {
            C4904y.m18635a(e, f9232a);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        C4904y.m18639b("onPostExecute()", f9232a);
        if (this.f9233b != null) {
            String strM11016b = C2602p.m11016b(this.f9233b.success.toString(), this.f9235d);
            if (this.f9234c != null) {
                Message messageObtainMessage = this.f9234c.obtainMessage();
                messageObtainMessage.obj = strM11016b;
                messageObtainMessage.what = 0;
                messageObtainMessage.sendToTarget();
                this.f9234c = null;
            }
            super.onPostExecute(num);
        }
    }
}
