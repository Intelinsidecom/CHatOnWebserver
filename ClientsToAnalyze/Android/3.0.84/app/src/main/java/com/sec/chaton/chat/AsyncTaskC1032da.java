package com.sec.chaton.chat;

import android.os.AsyncTask;
import com.sec.chaton.multimedia.multisend.PreviewData;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.da */
/* loaded from: classes.dex */
class AsyncTaskC1032da extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    List<File> f4124a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f4125b;

    private AsyncTaskC1032da(ChatFragment chatFragment) {
        this.f4125b = chatFragment;
        this.f4124a = new ArrayList();
    }

    /* synthetic */ AsyncTaskC1032da(ChatFragment chatFragment, C1004c c1004c) {
        this(chatFragment);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f4125b.m5021v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) throws Throwable {
        String strM7752d;
        Iterator it = this.f4125b.f3671cq.iterator();
        while (it.hasNext()) {
            PreviewData previewData = (PreviewData) it.next();
            if (previewData.m7752d() == null) {
                strM7752d = previewData.m7746a();
            } else {
                strM7752d = previewData.m7752d();
            }
            File fileM4738a = this.f4125b.m4738a(strM7752d, false, true);
            if (fileM4738a != null) {
                this.f4124a.add(fileM4738a);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r5) throws InterruptedException {
        super.onPostExecute(r5);
        if (this.f4124a != null) {
            Iterator<File> it = this.f4124a.iterator();
            while (it.hasNext()) {
                this.f4125b.m4874b(it.next());
                try {
                    Thread.sleep(10L, 0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        this.f4125b.m5022w();
        if (this.f4124a != null) {
            this.f4124a.clear();
        }
    }
}
