package com.sec.chaton.service;

import android.app.IntentService;
import android.content.Intent;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class FileUtilService extends IntentService {
    public FileUtilService() {
        super("ChatONFileUtilService");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        String action;
        C3250y.m11450b("onHandleIntent start: ", getClass().getSimpleName());
        if (intent != null && (action = intent.getAction()) != null && action.equals(C0816a.f3114c) && C3223ck.m11327a()) {
            C3250y.m11450b("deleteFilesDirectory..", getClass().getSimpleName());
            C3243r.m11417a();
        }
        C3250y.m11450b("onHandleIntent end: ", getClass().getSimpleName());
    }
}
