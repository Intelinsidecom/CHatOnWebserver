package com.sec.chaton.p062h;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.chat.EnumC1761hg;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.common.CommonApplication;
import java.io.File;

/* compiled from: InterlockedAudio.java */
/* renamed from: com.sec.chaton.h.c */
/* loaded from: classes.dex */
public class C2357c implements InterfaceC2355a {

    /* renamed from: a */
    private Intent f8388a;

    /* renamed from: a */
    public static C2357c m10312a(Intent intent) {
        return new C2357c(intent);
    }

    private C2357c(Intent intent) {
        this.f8388a = intent;
    }

    @Override // com.sec.chaton.p062h.InterfaceC2355a
    /* renamed from: a */
    public EnumC1761hg mo10310a() {
        this.f8388a.putExtra("callForward", true);
        this.f8388a.putExtra("content_type", EnumC2214ab.AUDIO.m10076a());
        Uri uri = (Uri) this.f8388a.getExtras().get("android.intent.extra.STREAM");
        if (uri == null) {
            return EnumC1761hg.HOME;
        }
        if (uri.getScheme() != null && uri.getScheme().equals("content")) {
            try {
                Cursor cursorQuery = CommonApplication.m18732r().getContentResolver().query(uri, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            this.f8388a.putExtra("download_uri", Uri.fromFile(new File(cursorQuery.getString(cursorQuery.getColumnIndex("_data")))).toString());
                            EnumC1761hg enumC1761hg = EnumC1761hg.FORWARD;
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
                return EnumC1761hg.HOME;
            }
        } else if (uri.getScheme() != null && uri.getScheme().equals("file")) {
            this.f8388a.putExtra("download_uri", uri.toString());
            return EnumC1761hg.FORWARD;
        }
        return EnumC1761hg.HOME;
    }
}
