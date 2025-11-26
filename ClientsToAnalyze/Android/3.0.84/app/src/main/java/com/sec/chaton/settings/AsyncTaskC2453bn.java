package com.sec.chaton.settings;

import android.os.AsyncTask;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.p026a.C1156ak;
import com.sec.chaton.util.C3159aa;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.bn */
/* loaded from: classes.dex */
class AsyncTaskC2453bn extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockSet f9313a;

    private AsyncTaskC2453bn(ActivityPasswordLockSet activityPasswordLockSet) {
        this.f9313a = activityPasswordLockSet;
    }

    /* synthetic */ AsyncTaskC2453bn(ActivityPasswordLockSet activityPasswordLockSet, DialogInterfaceOnClickListenerC2445bf dialogInterfaceOnClickListenerC2445bf) {
        this(activityPasswordLockSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        int iM5507a = C1156ak.m5507a(false);
        if (iM5507a == 0) {
            C3159aa.m10963a("delete_account", (Boolean) true);
            GlobalApplication.m6449a(this.f9313a.f9046u);
            return null;
        }
        this.f9313a.f9026a.sendEmptyMessage(iM5507a);
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
