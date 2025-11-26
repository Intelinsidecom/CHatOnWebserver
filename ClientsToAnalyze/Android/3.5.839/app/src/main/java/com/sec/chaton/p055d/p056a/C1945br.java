package com.sec.chaton.p055d.p056a;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p065io.entry.ChatProfileEntry;
import com.sec.chaton.p065io.entry.inner.ChatProfiles;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: GetChatProfileImageTitleTask.java */
/* renamed from: com.sec.chaton.d.a.br */
/* loaded from: classes.dex */
public class C1945br extends AbstractC1900a {

    /* renamed from: b */
    private String f7240b;

    public C1945br(String str, C2454e c2454e) {
        super(c2454e);
        this.f7240b = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4904y.m18639b("[Before request]", getClass().getSimpleName());
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws Throwable {
        Cursor cursorQuery;
        boolean z;
        C4904y.m18639b("[After request]", getClass().getSimpleName());
        if (c0778b.m3107b() == EnumC2464o.SUCCESS && c0778b.m3110e() != null) {
            ChatProfiles chatProfiles = ((ChatProfileEntry) c0778b.m3110e()).titleprofile;
            ContentValues contentValues = new ContentValues();
            String str = String.format("%s?%s=%s&%s=%s&%s=%s&%s=%s", chatProfiles.profile_url, "uid", C4809aa.m18104a().m18121a("uid", ""), "imei", C4822an.m18228d(), "size", 160, "filename", chatProfiles.profile_filename);
            try {
                cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2299s.f8209a, null, "inbox_no='" + this.f7240b + "'", null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.moveToFirst();
                            if (chatProfiles.profile_url == null || chatProfiles.profile_filename == null || str.equals(cursorQuery.getString(cursorQuery.getColumnIndex("profile_url")))) {
                                z = false;
                            } else {
                                EnumC2300t enumC2300tM10207a = EnumC2300t.m10207a(cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_chat_type")));
                                if (enumC2300tM10207a == EnumC2300t.GROUPCHAT || enumC2300tM10207a == EnumC2300t.BROADCAST2) {
                                    C2496n.m10793f(CommonApplication.m18732r(), this.f7240b).get();
                                }
                                if (C4904y.f17873c) {
                                    C4904y.m18641c("download url: " + str, "GetChatProfileImageTitleTask");
                                }
                                contentValues.put("profile_url", str);
                                z = true;
                            }
                            if (!TextUtils.isEmpty(chatProfiles.title) && !chatProfiles.title.equals(cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title")))) {
                                if (C4904y.f17873c) {
                                    C4904y.m18641c("title: " + chatProfiles.title, "GetChatProfileImageTitleTask");
                                }
                                contentValues.put("inbox_title", chatProfiles.title);
                                contentValues.put("inbox_title_fixed", "Y");
                                z = true;
                            }
                            if (z) {
                                CommonApplication.m18732r().getContentResolver().update(C2299s.f8209a, contentValues, "inbox_no='" + this.f7240b + "'", null);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th2) {
                th = th2;
                cursorQuery = null;
            }
        }
    }
}
