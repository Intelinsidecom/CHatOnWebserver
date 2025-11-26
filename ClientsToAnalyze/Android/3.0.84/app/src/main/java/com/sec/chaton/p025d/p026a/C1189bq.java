package com.sec.chaton.p025d.p026a;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p035io.entry.ChatProfileEntry;
import com.sec.chaton.p035io.entry.inner.ChatProfiles;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.File;

/* compiled from: GetChatProfileImageTitleTask.java */
/* renamed from: com.sec.chaton.d.a.bq */
/* loaded from: classes.dex */
public class C1189bq extends AbstractC1145a {

    /* renamed from: b */
    private String f4687b;

    public C1189bq(Handler handler, String str, C1580h c1580h) {
        super(handler, c1580h);
        this.f4687b = str;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3250y.m11450b("[Before request]", getClass().getSimpleName());
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        boolean z;
        C3250y.m11450b("[After request]", getClass().getSimpleName());
        if (c0267d.m1351b() == EnumC1587o.SUCCESS && c0267d.m1354e() != null) {
            ChatProfiles chatProfiles = ((ChatProfileEntry) c0267d.m1354e()).titleprofile;
            ContentValues contentValues = new ContentValues();
            String str = String.format("%s?%s=%s&%s=%s&%s=%s&%s=%s", chatProfiles.profile_url, "uid", C3159aa.m10962a().m10979a("uid", ""), "imei", C3171am.m11045a(), "size", 160, "filename", chatProfiles.profile_filename);
            Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1449q.f5381a, null, "inbox_no='" + this.f4687b + "'", null, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                if (chatProfiles.profile_url == null || chatProfiles.profile_filename == null || str.equals(cursorQuery.getString(cursorQuery.getColumnIndex("profile_url")))) {
                    z = false;
                } else {
                    EnumC1450r enumC1450rM6339a = EnumC1450r.m6339a(cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_chat_type")));
                    if (enumC1450rM6339a == EnumC1450r.GROUPCHAT) {
                        C3205bt.m11182a(CommonApplication.m11493l()).m11216a(this.f4687b, enumC1450rM6339a);
                        m5538a(chatProfiles.profile_filename);
                    }
                    if (C3250y.f11735c) {
                        C3250y.m11453c("download url: " + str, "GetChatProfileImageTitleTask");
                    }
                    contentValues.put("profile_url", str);
                    z = true;
                }
                if (!TextUtils.isEmpty(chatProfiles.title) && !chatProfiles.title.equals(cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title")))) {
                    if (C3250y.f11735c) {
                        C3250y.m11453c("title: " + chatProfiles.title, "GetChatProfileImageTitleTask");
                    }
                    contentValues.put("inbox_title", chatProfiles.title);
                    contentValues.put("inbox_title_fixed", "Y");
                    z = true;
                }
                if (z) {
                    CommonApplication.m11493l().getContentResolver().update(C1449q.f5381a, contentValues, "inbox_no='" + this.f4687b + "'", null);
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                    return;
                }
                return;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* renamed from: a */
    private void m5538a(String str) {
        File[] fileArrListFiles = CommonApplication.m11493l().getFilesDir().getAbsoluteFile().listFiles(new C1190br(this, str));
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                C3250y.m11450b("[Delete File] " + file + " : " + file.delete(), getClass().getSimpleName());
            }
        }
    }
}
