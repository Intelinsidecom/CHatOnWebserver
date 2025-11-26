package com.sec.chaton.p028e;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.EnumC0250am;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.EnumC0651d;
import java.io.File;

/* compiled from: InterlockedAudio.java */
/* renamed from: com.sec.chaton.e.d */
/* loaded from: classes.dex */
public class C0677d implements InterfaceC0679f {

    /* renamed from: a */
    private Intent f2325a;

    public C0677d(Intent intent) {
        this.f2325a = intent;
    }

    @Override // com.sec.chaton.p028e.InterfaceC0679f
    /* renamed from: a */
    public EnumC0250am mo3045a() {
        this.f2325a.putExtra("callForward", true);
        this.f2325a.putExtra("content_type", EnumC0651d.AUDIO.m2978a());
        Uri uri = (Uri) this.f2325a.getExtras().get("android.intent.extra.STREAM");
        if (uri == null) {
            return EnumC0250am.HOME;
        }
        if (uri.getScheme() != null && uri.getScheme().equals("content")) {
            try {
                Cursor cursorQuery = GlobalApplication.m3100a().getContentResolver().query(uri, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            this.f2325a.putExtra("download_uri", Uri.fromFile(new File(cursorQuery.getString(cursorQuery.getColumnIndex("_data")))).toString());
                            EnumC0250am enumC0250am = EnumC0250am.FORWARD;
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
                return EnumC0250am.HOME;
            }
        } else if (uri.getScheme() != null && uri.getScheme().equals("file")) {
            this.f2325a.putExtra("download_uri", uri.toString());
            return EnumC0250am.FORWARD;
        }
        return EnumC0250am.HOME;
    }
}
