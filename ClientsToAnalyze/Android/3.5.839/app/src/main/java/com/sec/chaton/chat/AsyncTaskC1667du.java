package com.sec.chaton.chat;

import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.util.C4812ad;
import com.sec.common.CommonApplication;
import com.sec.common.util.p133a.C5017a;
import java.io.File;
import java.io.IOException;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.du */
/* loaded from: classes.dex */
class AsyncTaskC1667du extends AsyncTask<String, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6216a;

    AsyncTaskC1667du(ChatFragment chatFragment) {
        this.f6216a = chatFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(String... strArr) {
        File file = new File(this.f6216a.f5628cR, this.f6216a.f5626cP + ".png");
        try {
            C5017a.m19064a().m19067a(strArr[0], file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        this.f6216a.f5627cQ = C4812ad.m18144a(CommonApplication.m18732r(), Uri.fromFile(file), 66, 44);
        if (this.f6216a.f5627cQ != null) {
            this.f6216a.f5627cQ.setDensity(160);
            this.f6216a.f5528aU.m8559a(this.f6216a.f5627cQ);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r2) {
        super.onPostExecute(r2);
        this.f6216a.f5527aT.invalidateViews();
    }
}
