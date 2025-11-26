package com.sec.chaton.settings;

import android.os.AsyncTask;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.p016a.C0598n;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.al */
/* loaded from: classes.dex */
class AsyncTaskC1233al extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockSet f4774a;

    private AsyncTaskC1233al(ActivityPasswordLockSet activityPasswordLockSet) {
        this.f4774a = activityPasswordLockSet;
    }

    /* synthetic */ AsyncTaskC1233al(ActivityPasswordLockSet activityPasswordLockSet, RunnableC1228ag runnableC1228ag) {
        this(activityPasswordLockSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        C0598n.m2784f();
        GlobalApplication.m3261b(this.f4774a.f4535q);
        return null;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r1) {
        super.onPostExecute(r1);
    }
}
