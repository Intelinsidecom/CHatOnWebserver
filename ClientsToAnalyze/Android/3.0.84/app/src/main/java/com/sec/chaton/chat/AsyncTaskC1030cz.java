package com.sec.chaton.chat;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.chat.p024b.C0952c;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cz */
/* loaded from: classes.dex */
class AsyncTaskC1030cz extends AsyncTask<C1070el, Void, String> {

    /* renamed from: a */
    C1070el f4118a;

    /* renamed from: b */
    String f4119b;

    /* renamed from: c */
    String f4120c;

    /* renamed from: d */
    C0952c f4121d;

    /* renamed from: e */
    final /* synthetic */ ChatFragment f4122e;

    public AsyncTaskC1030cz(ChatFragment chatFragment, C0952c c0952c, String str, String str2) {
        this.f4122e = chatFragment;
        this.f4119b = str;
        this.f4120c = str2;
        this.f4121d = c0952c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(C1070el... c1070elArr) {
        this.f4118a = c1070elArr[0];
        return this.f4121d.m5147a(Long.valueOf(this.f4118a.f4272b), this.f4118a.f4271az, true, this.f4119b, this.f4120c, this.f4122e.f3703r, this.f4118a.f4244aF ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        if (this.f4122e.f3682da != null && this.f4122e.f3682da.isShowing()) {
            this.f4122e.f3682da.dismiss();
        }
        if (str != null && !TextUtils.isEmpty(str)) {
            this.f4118a.f4245aG = str;
        } else {
            C3641ai.m13210a(CommonApplication.m11493l(), R.string.failed_to_translate, 0).show();
        }
    }
}
