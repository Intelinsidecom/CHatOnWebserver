package com.sec.vip.amschaton;

import android.os.AsyncTask;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.vip.amschaton.v */
/* loaded from: classes.dex */
class AsyncTaskC0719v extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ AMSFileListActivity f4353a;

    private AsyncTaskC0719v(AMSFileListActivity aMSFileListActivity) {
        this.f4353a = aMSFileListActivity;
    }

    /* synthetic */ AsyncTaskC0719v(AMSFileListActivity aMSFileListActivity, C0662bi c0662bi) {
        this(aMSFileListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long doInBackground(String... strArr) {
        if (!AMSFileManager.m3931a().m3944a(this.f4353a.getAssets(), AMSActivity.f3809f, AMSActivity.f3810g)) {
            ChatONLogWriter.m3499a("AMS file loading has failed!", getClass().getSimpleName());
        }
        this.f4353a.f3951t.sendEmptyMessage(0);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Long l) {
        this.f4353a.m3930p();
        super.onPostExecute(l);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f4353a.m3929o();
        super.onPreExecute();
    }
}
