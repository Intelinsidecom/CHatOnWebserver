package com.sec.chaton.p032h;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.EnumC2947t;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.common.CommonApplication;
import java.io.File;

/* compiled from: InterlockedVideo.java */
/* renamed from: com.sec.chaton.h.l */
/* loaded from: classes.dex */
public class C1509l implements InterfaceC1498a {

    /* renamed from: a */
    private Intent f5544a;

    public C1509l(Intent intent) {
        this.f5544a = intent;
    }

    @Override // com.sec.chaton.p032h.InterfaceC1498a
    /* renamed from: a */
    public EnumC2947t mo6465a() {
        EnumC2947t enumC2947t;
        this.f5544a.putExtra("callForward", true);
        this.f5544a.putExtra("content_type", EnumC1455w.VIDEO.m6364a());
        Uri uri = (Uri) this.f5544a.getExtras().get("android.intent.extra.STREAM");
        if (uri == null) {
            return EnumC2947t.HOME;
        }
        if (uri.getScheme() != null && uri.getScheme().equals("content")) {
            try {
                Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(uri, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            int columnIndex = cursorQuery.getColumnIndex("_data");
                            if (columnIndex != -1) {
                                String string = cursorQuery.getString(columnIndex);
                                if (TextUtils.isEmpty(string) || !(string.startsWith("/") || string.startsWith("file://"))) {
                                    enumC2947t = EnumC2947t.HOME;
                                    if (cursorQuery == null) {
                                        return enumC2947t;
                                    }
                                } else {
                                    this.f5544a.putExtra("download_uri", Uri.fromFile(new File(string)).toString());
                                    if (this.f5544a.getExtras().containsKey("android.intent.extra.TEXT")) {
                                        this.f5544a.putExtra("sub_content", this.f5544a.getExtras().getString("android.intent.extra.TEXT"));
                                    }
                                    enumC2947t = EnumC2947t.FORWARD;
                                    if (cursorQuery == null) {
                                        return enumC2947t;
                                    }
                                }
                            } else {
                                enumC2947t = EnumC2947t.HOME;
                                if (cursorQuery == null) {
                                    return enumC2947t;
                                }
                            }
                            return enumC2947t;
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
            this.f5544a.putExtra("download_uri", uri.toString());
            if (this.f5544a.getExtras().containsKey("android.intent.extra.TEXT")) {
                this.f5544a.putExtra("sub_content", this.f5544a.getExtras().getString("android.intent.extra.TEXT"));
            }
            return EnumC2947t.FORWARD;
        }
        return EnumC2947t.HOME;
    }
}
