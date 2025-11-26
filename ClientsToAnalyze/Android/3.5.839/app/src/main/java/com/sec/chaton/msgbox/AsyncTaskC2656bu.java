package com.sec.chaton.msgbox;

import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: MsgboxSync.java */
/* renamed from: com.sec.chaton.msgbox.bu */
/* loaded from: classes.dex */
class AsyncTaskC2656bu extends AsyncTaskC2644bi {

    /* renamed from: a */
    final /* synthetic */ ArrayList f9521a;

    /* renamed from: c */
    final /* synthetic */ C2654bs f9522c;

    AsyncTaskC2656bu(C2654bs c2654bs, ArrayList arrayList) {
        this.f9522c = c2654bs;
        this.f9521a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r3) {
        if (C4904y.f17872b) {
            C4904y.m18639b("MsgboxSMSMergingTask finished", f9495b);
        }
        this.f9522c.m11184h();
        super.onPostExecute(r3);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        if (C4904y.f17872b) {
            C4904y.m18639b("MsgboxSMSMergingTask onCancelled", f9495b);
        }
        this.f9522c.m11174a((ArrayList<String>) this.f9521a);
        super.onCancelled();
        this.f9522c.f9518i = null;
    }
}
