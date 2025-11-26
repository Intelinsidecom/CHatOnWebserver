package com.sec.chaton.msgbox;

import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.smsplugin.provider.AsyncTaskC3950h;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: MsgboxSync.java */
/* renamed from: com.sec.chaton.msgbox.bt */
/* loaded from: classes.dex */
class AsyncTaskC2655bt extends AsyncTaskC3950h {

    /* renamed from: a */
    final /* synthetic */ C2654bs f9520a;

    AsyncTaskC2655bt(C2654bs c2654bs) {
        this.f9520a = c2654bs;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        C4904y.m18639b("FullSyncTask : onPreExecute()", C2654bs.f9510a);
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        if (numArr[0].intValue() == 30) {
            this.f9520a.m11184h();
        }
        super.onProgressUpdate(numArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r4) {
        C4904y.m18639b("FullSyncTask : onPostExecute()", C2654bs.f9510a);
        this.f9520a.f9514d = 1;
        C1813b.m8906b().m8934b(C1813b.f6835d);
        if (C2349a.m10301a("sms_feature")) {
            this.f9520a.m11174a((ArrayList<String>) null);
        } else {
            this.f9520a.m11184h();
        }
        super.onPostExecute(r4);
        this.f9520a.f9515e = null;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        C4904y.m18639b("FullSyncTask : onCancelled()", C2654bs.f9510a);
        this.f9520a.m11184h();
        this.f9520a.m11183g();
        super.onCancelled();
        this.f9520a.f9515e = null;
    }
}
