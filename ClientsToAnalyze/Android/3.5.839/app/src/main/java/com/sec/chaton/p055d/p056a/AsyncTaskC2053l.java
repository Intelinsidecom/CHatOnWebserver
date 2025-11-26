package com.sec.chaton.p055d.p056a;

import android.os.AsyncTask;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.util.C4904y;

/* compiled from: AnswerBackTask.java */
/* renamed from: com.sec.chaton.d.a.l */
/* loaded from: classes.dex */
class AsyncTaskC2053l extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ C2052k f7509a;

    public AsyncTaskC2053l(C2052k c2052k) {
        this.f7509a = c2052k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        C4904y.m18641c("ReadAck : online status, so delete offline status message", getClass().getSimpleName());
        try {
            this.f7509a.f7507i.delete(C2306z.f8229a, "message_inbox_no=? AND message_sender=?", new String[]{this.f7509a.f7508j, "push_connectivity"});
            return null;
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, getClass().getSimpleName());
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r1) {
    }
}
