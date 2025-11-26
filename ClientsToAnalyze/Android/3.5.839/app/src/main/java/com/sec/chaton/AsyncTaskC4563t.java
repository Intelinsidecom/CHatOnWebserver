package com.sec.chaton;

import android.content.ContentResolver;
import android.content.Context;
import android.os.AsyncTask;
import android.text.SpannableStringBuilder;
import android.text.util.Linkify;
import com.sec.chaton.chat.C1735gh;
import com.sec.chaton.p057e.C2268bn;
import com.sec.chaton.p057e.p058a.C2196j;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ApplicationInitializeTask.java */
/* renamed from: com.sec.chaton.t */
/* loaded from: classes.dex */
public class AsyncTaskC4563t extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    private final String f16437a = AsyncTaskC4563t.class.getSimpleName();

    /* renamed from: b */
    private List<InterfaceC4693u> f16438b = new ArrayList();

    /* renamed from: a */
    public void m17262a(InterfaceC4693u interfaceC4693u) {
        this.f16438b.add(interfaceC4693u);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        try {
            Context contextM18732r = CommonApplication.m18732r();
            ContentResolver contentResolver = contextM18732r.getContentResolver();
            C2268bn.m10126a(contextM18732r).getWritableDatabase();
            C2204r.m9997a(contentResolver);
            C2196j.m9899b();
            C4821am.m18189a(contextM18732r, "com.sec.chaton.provider2", C2196j.m9896a());
            C4809aa.m18104a().m18123a("primary_translation_address");
            C4809aa.m18104a().m18123a("secondary_translation_address");
            C1735gh.m8613a();
            return null;
        } catch (Throwable th) {
            if (C4904y.f17875e) {
                C4904y.m18635a(th, this.f16437a);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r3) {
        super.onPostExecute(r3);
        Iterator<InterfaceC4693u> it = this.f16438b.iterator();
        while (it.hasNext()) {
            it.next().mo2991a();
        }
        Linkify.addLinks(new SpannableStringBuilder(), 15);
    }
}
