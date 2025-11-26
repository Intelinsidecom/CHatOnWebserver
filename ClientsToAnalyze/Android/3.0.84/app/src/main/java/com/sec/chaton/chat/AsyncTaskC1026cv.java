package com.sec.chaton.chat;

import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.util.C3162ad;
import com.sec.common.CommonApplication;
import com.sec.common.util.p070a.C3332a;
import java.io.File;
import java.io.IOException;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cv */
/* loaded from: classes.dex */
class AsyncTaskC1026cv extends AsyncTask<String, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4112a;

    AsyncTaskC1026cv(ChatFragment chatFragment) {
        this.f4112a = chatFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(String... strArr) {
        File file = new File(this.f4112a.f3675cu, this.f4112a.f3673cs + ".png");
        try {
            C3332a.m11750a().m11753a(strArr[0], file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        this.f4112a.f3674ct = C3162ad.m10999a(CommonApplication.m11493l(), Uri.fromFile(file), 66, 44);
        if (this.f4112a.f3674ct != null) {
            this.f4112a.f3674ct.setDensity(160);
            this.f4112a.f3527aC.m5284a(this.f4112a.f3674ct);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r2) {
        super.onPostExecute(r2);
        this.f4112a.f3526aB.invalidateViews();
    }
}
