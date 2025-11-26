package com.sec.vip.amschaton.honeycomb;

import android.content.Intent;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.AMSFileListActivity;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.au */
/* loaded from: classes.dex */
class RunnableC1913au implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f7049a;

    RunnableC1913au(AMSPlayerActivity aMSPlayerActivity) {
        this.f7049a = aMSPlayerActivity;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        while (!AMSComposerActivity.f6911m) {
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Intent intent = new Intent(this.f7049a.m6739h(), (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2000);
        intent.putExtra("AMS_FILE_PATH", AMSActivity.f6614g);
        this.f7049a.startActivity(intent);
        this.f7049a.finish();
    }
}
