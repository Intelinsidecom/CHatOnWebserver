package com.sec.chaton.p032h;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.EnumC2947t;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.common.CommonApplication;
import java.io.File;

/* compiled from: InterlockedAudio.java */
/* renamed from: com.sec.chaton.h.c */
/* loaded from: classes.dex */
public class C1500c implements InterfaceC1498a {

    /* renamed from: a */
    private Intent f5535a;

    public C1500c(Intent intent) {
        this.f5535a = intent;
    }

    @Override // com.sec.chaton.p032h.InterfaceC1498a
    /* renamed from: a */
    public EnumC2947t mo6465a() {
        this.f5535a.putExtra("callForward", true);
        this.f5535a.putExtra("content_type", EnumC1455w.AUDIO.m6364a());
        Uri uri = (Uri) this.f5535a.getExtras().get("android.intent.extra.STREAM");
        if (uri == null) {
            return EnumC2947t.HOME;
        }
        if (uri.getScheme() != null && uri.getScheme().equals("content")) {
            try {
                Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(uri, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            this.f5535a.putExtra("download_uri", Uri.fromFile(new File(cursorQuery.getString(cursorQuery.getColumnIndex("_data")))).toString());
                            EnumC2947t enumC2947t = EnumC2947t.FORWARD;
                        }
                    } finally {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (SecurityException e) {
                return EnumC2947t.HOME;
            }
        } else if (uri.getScheme() != null && uri.getScheme().equals("file")) {
            this.f5535a.putExtra("download_uri", uri.toString());
            return EnumC2947t.FORWARD;
        }
        return EnumC2947t.HOME;
    }
}
