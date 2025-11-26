package com.sec.chaton.p062h;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.chat.EnumC1761hg;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.common.CommonApplication;
import java.io.File;

/* compiled from: InterlockedVideo.java */
/* renamed from: com.sec.chaton.h.k */
/* loaded from: classes.dex */
public class C2365k implements InterfaceC2355a {

    /* renamed from: a */
    private Intent f8395a;

    /* renamed from: a */
    public static C2365k m10321a(Intent intent) {
        return new C2365k(intent);
    }

    private C2365k(Intent intent) {
        this.f8395a = intent;
    }

    @Override // com.sec.chaton.p062h.InterfaceC2355a
    /* renamed from: a */
    public EnumC1761hg mo10310a() {
        EnumC1761hg enumC1761hg;
        this.f8395a.putExtra("callForward", true);
        this.f8395a.putExtra("content_type", EnumC2214ab.VIDEO.m10076a());
        Uri uri = (Uri) this.f8395a.getExtras().get("android.intent.extra.STREAM");
        if (uri == null) {
            return EnumC1761hg.HOME;
        }
        if (uri.getScheme() != null && uri.getScheme().equals("content")) {
            try {
                Cursor cursorQuery = CommonApplication.m18732r().getContentResolver().query(uri, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            int columnIndex = cursorQuery.getColumnIndex("_data");
                            if (columnIndex != -1) {
                                String string = cursorQuery.getString(columnIndex);
                                if (TextUtils.isEmpty(string) || !(string.startsWith("/") || string.startsWith("file://"))) {
                                    enumC1761hg = EnumC1761hg.HOME;
                                    if (cursorQuery == null) {
                                        return enumC1761hg;
                                    }
                                } else {
                                    this.f8395a.putExtra("download_uri", Uri.fromFile(new File(string)).toString());
                                    if (this.f8395a.getExtras().containsKey("android.intent.extra.TEXT")) {
                                        this.f8395a.putExtra("sub_content", this.f8395a.getExtras().getString("android.intent.extra.TEXT"));
                                    }
                                    enumC1761hg = EnumC1761hg.FORWARD;
                                    if (cursorQuery == null) {
                                        return enumC1761hg;
                                    }
                                }
                            } else {
                                enumC1761hg = EnumC1761hg.HOME;
                                if (cursorQuery == null) {
                                    return enumC1761hg;
                                }
                            }
                            return enumC1761hg;
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
            this.f8395a.putExtra("download_uri", uri.toString());
            if (this.f8395a.getExtras().containsKey("android.intent.extra.TEXT")) {
                this.f8395a.putExtra("sub_content", this.f8395a.getExtras().getString("android.intent.extra.TEXT"));
            }
            return EnumC1761hg.FORWARD;
        }
        return EnumC1761hg.HOME;
    }
}
