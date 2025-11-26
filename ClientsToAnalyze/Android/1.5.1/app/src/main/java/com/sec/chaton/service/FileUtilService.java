package com.sec.chaton.service;

import android.app.IntentService;
import android.content.Intent;
import com.sec.chaton.constant.ChatONConst;
import com.sec.chaton.util.ChatONFileUtil;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.StorageStateInfoUtil;

/* loaded from: classes.dex */
public class FileUtilService extends IntentService {
    public FileUtilService() {
        super("ChatONFileUtilService");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        String action;
        ChatONLogWriter.m3506b("onHandleIntent start: ", getClass().getSimpleName());
        if (intent != null && (action = intent.getAction()) != null && action.equals(ChatONConst.f1340d) && StorageStateInfoUtil.m3677a()) {
            ChatONLogWriter.m3506b("deleteFilesDirectory..", getClass().getSimpleName());
            ChatONFileUtil.m3484b();
        }
        ChatONLogWriter.m3506b("onHandleIntent end: ", getClass().getSimpleName());
    }
}
