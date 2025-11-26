package com.sec.chaton.chat.translate;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.util.C4904y;

/* compiled from: TranslateAsyncTask.java */
/* renamed from: com.sec.chaton.chat.translate.n */
/* loaded from: classes.dex */
public class RunnableC1861n implements Runnable {

    /* renamed from: a */
    private String f7074a;

    /* renamed from: b */
    private String f7075b;

    /* renamed from: c */
    private String f7076c;

    /* renamed from: d */
    private Long f7077d;

    /* renamed from: e */
    private boolean f7078e;

    /* renamed from: f */
    private String f7079f;

    public RunnableC1861n(String str, String str2, String str3, Long l, boolean z) {
        this.f7074a = str;
        this.f7075b = str2;
        this.f7076c = str3;
        this.f7077d = l;
        this.f7078e = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7079f = C1850c.m9024d().m9029a(this.f7074a, this.f7076c, this.f7075b);
        if (!TextUtils.isEmpty(this.f7079f)) {
            C2204r.m10003a(GlobalApplication.m10279a().getContentResolver(), this.f7079f, this.f7077d, this.f7076c, this.f7075b, this.f7078e);
        }
        try {
            if (TextUtils.isEmpty(this.f7079f)) {
                new Handler(Looper.getMainLooper()).post(new RunnableC1862o(this));
            }
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, "TranslateAsyncTask");
            }
        }
    }
}
