package com.sec.chaton.chat;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.sec.chaton.chat.translate.C1850c;
import com.sec.chaton.util.C4904y;
import java.io.IOException;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.dz */
/* loaded from: classes.dex */
class AsyncTaskC1672dz extends AsyncTask<Void, Void, String> {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6223a;

    /* renamed from: b */
    private final String f6224b;

    /* renamed from: c */
    private final String f6225c;

    /* renamed from: d */
    private final String f6226d;

    /* renamed from: e */
    private final C1850c f6227e = C1850c.m9024d();

    /* renamed from: f */
    private final String f6228f = "-1";

    public AsyncTaskC1672dz(ChatFragment chatFragment, String str, String str2, String str3) {
        this.f6223a = chatFragment;
        this.f6225c = str;
        this.f6226d = str2;
        this.f6224b = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Void... voidArr) {
        C4904y.m18639b("Source Lang Code for Translator Request : " + this.f6225c, ChatFragment.f5461a);
        C4904y.m18639b("Target Lang Code for Translator Request : " + this.f6226d, ChatFragment.f5461a);
        if (isCancelled()) {
            return null;
        }
        if (!TextUtils.isEmpty(this.f6224b)) {
            return this.f6227e.m9027a(Long.valueOf(this.f6228f), this.f6224b, true, this.f6226d, this.f6225c, this.f6223a.f5750v, false);
        }
        C4904y.m18639b("Request Msg is null ", ChatFragment.f5461a);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) throws IOException {
        if (!TextUtils.isEmpty(str)) {
            this.f6223a.m7941a(this.f6224b, str, this.f6225c, this.f6226d);
        } else {
            this.f6223a.f5564bF.setText(ChatFragment.f5466dE);
        }
        this.f6223a.f5666dD = true;
        if (this.f6223a.f5636cZ) {
            this.f6223a.m8218a();
        }
    }
}
