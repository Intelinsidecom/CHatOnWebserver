package com.sec.chaton.chat;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.chat.translate.C1850c;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ea */
/* loaded from: classes.dex */
class AsyncTaskC1674ea extends AsyncTask<C1729gb, Void, String> {

    /* renamed from: a */
    C1729gb f6230a;

    /* renamed from: b */
    String f6231b;

    /* renamed from: c */
    String f6232c;

    /* renamed from: d */
    C1850c f6233d;

    /* renamed from: e */
    final /* synthetic */ ChatFragment f6234e;

    public AsyncTaskC1674ea(ChatFragment chatFragment, C1850c c1850c, String str, String str2) {
        this.f6234e = chatFragment;
        this.f6231b = str;
        this.f6232c = str2;
        this.f6233d = c1850c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(C1729gb... c1729gbArr) {
        this.f6230a = c1729gbArr[0];
        return this.f6233d.m9027a(Long.valueOf(this.f6230a.f6457b), this.f6230a.f6422aM, true, this.f6231b, this.f6232c, this.f6234e.f5750v, this.f6230a.f6428aS ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        if (this.f6234e.f5664dB != null && this.f6234e.f5664dB.isShowing()) {
            this.f6234e.f5664dB.dismiss();
        }
        if (str != null && !TextUtils.isEmpty(str)) {
            this.f6230a.f6429aT = str;
        } else {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.failed_to_translate, 0).show();
        }
    }
}
