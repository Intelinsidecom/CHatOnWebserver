package com.sec.chaton.control.task;

import android.os.AsyncTask;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.util.ChatONFileUtil;

/* loaded from: classes.dex */
public class FileDownloadTask extends AsyncTask {

    /* renamed from: a */
    private String f1513a;

    /* renamed from: b */
    private String f1514b;

    /* renamed from: c */
    private String f1515c;

    /* renamed from: d */
    private boolean f1516d;

    /* renamed from: e */
    private String f1517e;

    /* renamed from: f */
    private long f1518f;

    /* renamed from: g */
    private ChatONContract.InBoxTable.ChatType f1519g;

    /* renamed from: h */
    private String f1520h;

    public FileDownloadTask(String str, String str2, String str3, boolean z, String str4, long j, ChatONContract.InBoxTable.ChatType chatType, String str5) {
        this.f1513a = str;
        this.f1514b = str2;
        this.f1515c = str3;
        this.f1516d = z;
        this.f1517e = str4;
        this.f1518f = j;
        this.f1519g = chatType;
        this.f1520h = str5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) {
        return ChatONFileUtil.m3480a(this.f1513a, this.f1514b, this.f1515c, this.f1516d, this.f1517e, this.f1518f, this.f1519g, this.f1520h);
    }
}
