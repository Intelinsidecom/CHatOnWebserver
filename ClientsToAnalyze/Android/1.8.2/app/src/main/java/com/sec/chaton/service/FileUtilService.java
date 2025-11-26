package com.sec.chaton.service;

import android.app.IntentService;
import android.content.Intent;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1783o;
import com.sec.chaton.util.C1786r;

/* loaded from: classes.dex */
public class FileUtilService extends IntentService {
    public FileUtilService() {
        super("ChatONFileUtilService");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        String action;
        C1786r.m6061b("onHandleIntent start: ", getClass().getSimpleName());
        if (intent != null && (action = intent.getAction()) != null && action.equals(C0452a.f1725d) && C1767bw.m6002a()) {
            C1786r.m6061b("deleteFilesDirectory..", getClass().getSimpleName());
            C1783o.m6037b();
        }
        C1786r.m6061b("onHandleIntent end: ", getClass().getSimpleName());
    }
}
