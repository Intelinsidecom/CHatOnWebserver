package com.sec.vip.amschaton.honeycomb;

import android.content.Intent;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.AMSFileListActivity;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.bc */
/* loaded from: classes.dex */
class RunnableC1434bc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5067a;

    RunnableC1434bc(AMSPlayerActivity aMSPlayerActivity) {
        this.f5067a = aMSPlayerActivity;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        while (!AMSComposerActivity.f4935b) {
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Intent intent = new Intent(this.f5067a.m5181h(), (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2000);
        intent.putExtra("AMS_FILE_PATH", AMSActivity.f4627i);
        this.f5067a.startActivity(intent);
        this.f5067a.finish();
    }
}
