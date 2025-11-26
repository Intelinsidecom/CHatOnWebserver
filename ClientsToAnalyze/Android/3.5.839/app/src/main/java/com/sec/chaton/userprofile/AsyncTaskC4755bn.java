package com.sec.chaton.userprofile;

import android.os.AsyncTask;
import android.os.Handler;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p067j.p070c.C2438e;
import com.sec.chaton.util.C4904y;
import java.io.File;

/* compiled from: MyPageManager.java */
/* renamed from: com.sec.chaton.userprofile.bn */
/* loaded from: classes.dex */
public class AsyncTaskC4755bn extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    File f17433a;

    /* renamed from: b */
    Handler f17434b;

    AsyncTaskC4755bn(File file, Handler handler) {
        this.f17433a = file;
        this.f17434b = handler;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        if (C4904y.f17872b) {
            C4904y.m18639b("[CoverStory] doInBackground()", C4754bm.f17418a);
        }
        C2438e.m10572a().m10574a(this.f17434b, this.f17433a, EnumC2214ab.IMAGE, null);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r3) {
        super.onPostExecute(r3);
        if (C4904y.f17872b) {
            C4904y.m18639b("[CoverStory] onPostExecute()", C4754bm.f17418a);
        }
    }
}
