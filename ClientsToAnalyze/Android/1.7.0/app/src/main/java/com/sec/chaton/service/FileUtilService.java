package com.sec.chaton.service;

import android.app.IntentService;
import android.content.Intent;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.util.C1324bt;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class FileUtilService extends IntentService {
    public FileUtilService() {
        super("ChatONFileUtilService");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        String action;
        C1341p.m4658b("onHandleIntent start: ", getClass().getSimpleName());
        if (intent != null && (action = intent.getAction()) != null && action.equals(C0684a.f2333d) && C1327bw.m4595a()) {
            C1341p.m4658b("deleteFilesDirectory..", getClass().getSimpleName());
            C1324bt.m4586b();
        }
        C1341p.m4658b("onHandleIntent end: ", getClass().getSimpleName());
    }
}
