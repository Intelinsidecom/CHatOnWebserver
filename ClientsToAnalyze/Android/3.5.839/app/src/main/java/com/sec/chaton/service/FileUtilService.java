package com.sec.chaton.service;

import android.app.IntentService;
import android.content.Intent;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class FileUtilService extends IntentService {
    public FileUtilService() {
        super("ChatONFileUtilService");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        String action;
        C4904y.m18639b("onHandleIntent start: ", getClass().getSimpleName());
        if (intent != null && (action = intent.getAction()) != null && action.equals(C1427a.f5067e) && C4873ck.m18500a()) {
            C4904y.m18639b("deleteFilesDirectory..", getClass().getSimpleName());
            C4894o.m18604a();
        }
        C4904y.m18639b("onHandleIntent end: ", getClass().getSimpleName());
    }
}
