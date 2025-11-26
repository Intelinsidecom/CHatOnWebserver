package com.sec.chaton.settings;

import android.os.AsyncTask;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1058ba;
import com.sec.chaton.p055d.p056a.C1907ag;
import com.sec.chaton.util.C4809aa;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.cm */
/* loaded from: classes.dex */
class AsyncTaskC3549cm extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockSet f13038a;

    private AsyncTaskC3549cm(ActivityPasswordLockSet activityPasswordLockSet) {
        this.f13038a = activityPasswordLockSet;
    }

    /* synthetic */ AsyncTaskC3549cm(ActivityPasswordLockSet activityPasswordLockSet, DialogInterfaceOnClickListenerC3541ce dialogInterfaceOnClickListenerC3541ce) {
        this(activityPasswordLockSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) throws InterruptedException {
        int iM9089a = C1907ag.m9089a(false);
        if (iM9089a == 0) {
            C4809aa.m18105a("delete_account", (Boolean) true);
            C0991aa.m6037a().m18962d(new C1058ba());
            return null;
        }
        this.f13038a.f12588a.sendEmptyMessage(iM9089a);
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
