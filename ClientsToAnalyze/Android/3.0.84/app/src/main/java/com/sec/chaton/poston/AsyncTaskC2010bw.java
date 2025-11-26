package com.sec.chaton.poston;

import android.os.AsyncTask;
import com.sec.chaton.multimedia.multisend.PreviewData;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p037j.p040c.C1561g;
import com.sec.chaton.p037j.p040c.RunnableC1563i;
import com.sec.chaton.util.C3250y;
import java.io.File;
import java.util.ArrayList;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bw */
/* loaded from: classes.dex */
class AsyncTaskC2010bw extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f7724a;

    /* renamed from: b */
    private ArrayList<PreviewData> f7725b;

    /* renamed from: c */
    private EnumC1455w f7726c;

    /* renamed from: d */
    private RunnableC1563i f7727d;

    AsyncTaskC2010bw(PostONWriteFragment postONWriteFragment, ArrayList<PreviewData> arrayList, EnumC1455w enumC1455w) {
        this.f7724a = postONWriteFragment;
        this.f7725b = arrayList;
        this.f7726c = enumC1455w;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f7724a.f7577C = this.f7724a.m8000d();
        this.f7724a.f7577C.m11483a(0);
        this.f7724a.f7577C.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) throws Throwable {
        File file;
        for (int i = 0; i < this.f7725b.size(); i++) {
            this.f7724a.m7987a(this.f7725b.get(i));
        }
        for (int i2 = 0; i2 < this.f7725b.size(); i2++) {
            try {
                if (this.f7725b.get(i2).m7752d() == null) {
                    file = new File(this.f7725b.get(i2).m7746a());
                } else {
                    file = new File(this.f7725b.get(i2).m7752d());
                }
                this.f7727d = C1561g.m6628a().m6630a(this.f7724a.f7608ai, file, this.f7726c, this.f7724a.f7607ah);
            } catch (Exception e) {
                C3250y.m11443a(e, getClass().getSimpleName());
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r2) {
        super.onPostExecute(r2);
        if (!this.f7724a.f7592R.isEmpty()) {
            this.f7724a.f7592R.clear();
        }
    }

    /* renamed from: a */
    public void m8036a() {
        if (this.f7727d != null) {
            C1561g.m6628a().m6634a(this.f7727d);
        }
    }
}
