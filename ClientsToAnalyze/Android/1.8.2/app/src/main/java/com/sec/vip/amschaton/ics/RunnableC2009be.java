package com.sec.vip.amschaton.ics;

import android.content.Intent;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.AMSFileListActivity;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.be */
/* loaded from: classes.dex */
class RunnableC2009be implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f7291a;

    RunnableC2009be(AMSPlayerActivity aMSPlayerActivity) {
        this.f7291a = aMSPlayerActivity;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        while (!AMSComposerActivity.f7139m) {
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Intent intent = new Intent(this.f7291a.m7063h(), (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2000);
        intent.putExtra("AMS_FILE_PATH", AMSActivity.f6614g);
        this.f7291a.startActivity(intent);
        this.f7291a.finish();
    }
}
