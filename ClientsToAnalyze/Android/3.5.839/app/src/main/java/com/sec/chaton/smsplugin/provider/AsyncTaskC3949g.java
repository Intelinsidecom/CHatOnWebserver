package com.sec.chaton.smsplugin.provider;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.Telephony;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.smsplugin.p111h.C3896s;
import com.sec.common.CommonApplication;
import com.sec.google.android.p134a.p136b.C5108d;

/* compiled from: DeleteInboxTask.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.provider.g */
/* loaded from: classes.dex */
public class AsyncTaskC3949g extends AsyncTask<Long, Integer, Integer> {

    /* renamed from: a */
    private static final String f14230a = AsyncTaskC3949g.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(Long... lArr) {
        ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
        if (lArr.length < 1) {
            C3896s.m15041a("Invalid parameter", f14230a);
            return 0;
        }
        int iDelete = 0;
        for (int i = 0; i < lArr.length; i++) {
            Uri uriWithAppendedId = ContentUris.withAppendedId(Telephony.Threads.CONTENT_URI, lArr[i].longValue());
            C5108d.m19487b().mo19484b(uriWithAppendedId);
            iDelete = contentResolver.delete(uriWithAppendedId, null, null);
            contentResolver.delete(C2299s.f8209a, "inbox_no = " + lArr[i], null);
        }
        contentResolver.notifyChange(C2299s.f8209a, null);
        return Integer.valueOf(iDelete);
    }
}
