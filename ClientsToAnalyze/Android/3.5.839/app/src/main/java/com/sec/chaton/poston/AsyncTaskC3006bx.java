package com.sec.chaton.poston;

import android.os.AsyncTask;
import com.sec.chaton.multimedia.multisend.PreviewData;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p067j.p070c.C2438e;
import com.sec.chaton.p067j.p070c.RunnableC2440g;
import com.sec.chaton.util.C4904y;
import java.io.File;
import java.util.ArrayList;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bx */
/* loaded from: classes.dex */
class AsyncTaskC3006bx extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f11120a;

    /* renamed from: b */
    private ArrayList<PreviewData> f11121b;

    /* renamed from: c */
    private EnumC2214ab f11122c;

    /* renamed from: d */
    private RunnableC2440g f11123d;

    AsyncTaskC3006bx(PostONWriteFragment postONWriteFragment, ArrayList<PreviewData> arrayList, EnumC2214ab enumC2214ab) {
        this.f11120a = postONWriteFragment;
        this.f11121b = arrayList;
        this.f11122c = enumC2214ab;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f11120a.f10973E = this.f11120a.m12312c();
        this.f11120a.f10973E.m18719a(0);
        this.f11120a.f10973E.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) throws Throwable {
        File file;
        for (int i = 0; i < this.f11121b.size(); i++) {
            this.f11120a.m12300a(this.f11121b.get(i));
        }
        for (int i2 = 0; i2 < this.f11121b.size(); i2++) {
            try {
                if (this.f11121b.get(i2).m11982d() == null) {
                    file = new File(this.f11121b.get(i2).m11976a());
                } else {
                    file = new File(this.f11121b.get(i2).m11982d());
                }
                this.f11123d = C2438e.m10572a().m10574a(this.f11120a.f11005al, file, this.f11122c, this.f11120a.f11004ak);
            } catch (Exception e) {
                C4904y.m18635a(e, getClass().getSimpleName());
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r2) {
        super.onPostExecute(r2);
        if (!this.f11120a.f10988T.isEmpty()) {
            this.f11120a.f10988T.clear();
        }
    }

    /* renamed from: a */
    public void m12356a() {
        if (this.f11123d != null) {
            C2438e.m10572a().m10578a(this.f11123d);
        }
    }
}
