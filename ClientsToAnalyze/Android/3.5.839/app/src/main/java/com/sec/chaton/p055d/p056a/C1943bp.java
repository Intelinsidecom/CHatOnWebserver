package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.C2220ah;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2201o;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.ChatMemberListEntry;
import com.sec.chaton.p065io.entry.inner.ChatMember;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GetChatMemberListTask.java */
/* renamed from: com.sec.chaton.d.a.bp */
/* loaded from: classes.dex */
public class C1943bp extends AbstractC1900a {

    /* renamed from: b */
    private final String f7237b;

    /* renamed from: c */
    private String f7238c;

    /* renamed from: d */
    private boolean f7239d;

    public C1943bp(C2454e c2454e, String str, boolean z) {
        super(c2454e);
        this.f7237b = "GetChatMemberListTask";
        this.f7239d = false;
        this.f7238c = str;
        this.f7239d = z;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        ArrayList<String> arrayListM9694e;
        if (!this.f7239d && ((arrayListM9694e = C2176ab.m9694e(CommonApplication.m18732r().getContentResolver(), this.f7238c)) == null || arrayListM9694e.size() == 0)) {
            m18922l();
        }
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws Throwable {
        int size;
        Cursor cursorQuery;
        if (c0778b.m3107b() != EnumC2464o.SUCCESS) {
            C2404a.m10430a("01000006", "1004", c0778b);
            return;
        }
        ChatMemberListEntry chatMemberListEntry = (ChatMemberListEntry) c0778b.m3110e();
        if (chatMemberListEntry.members == null) {
            C4904y.m18641c("chatListEntry.members is null", "GetChatMemberListTask");
            return;
        }
        List<ChatMember> list = chatMemberListEntry.members.memberList;
        ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
        String str = null;
        C2201o c2201oM9951e = C2198l.m9951e(contentResolver, this.f7238c);
        if (c2201oM9951e != null) {
            boolean z = list.size() > 0;
            String strM18121a = C4809aa.m18104a().m18121a("chaton_id", "");
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            for (ChatMember chatMember : list) {
                if (!strM18121a.equals(chatMember.userid)) {
                    String str2 = chatMember.userid.equals(c2201oM9951e.f7848k) ? chatMember.name : str;
                    String str3 = TextUtils.isEmpty(chatMember.countrycode) ? "NO_SEARCH" : chatMember.countrycode;
                    int i = 0;
                    if (chatMember.webonly != null && chatMember.webonly.booleanValue()) {
                        i = 1;
                    }
                    if (this.f7239d) {
                        arrayList.add(C2176ab.m9673a(this.f7238c, chatMember.userid, chatMember.name, str3, chatMember.isauthuser.booleanValue(), -1, i));
                    } else {
                        arrayList.add(C2176ab.m9674a(chatMember.userid, chatMember.name, str3, chatMember.isauthuser.booleanValue(), -1, i));
                    }
                    C4904y.m18641c("CHATON NUMBER : " + chatMember.userid + ", NAME : " + chatMember.name + ", CountryCode : " + chatMember.countrycode + ", isAuthUser : " + chatMember.isauthuser + ", accountInfo : " + i, "GetChatMemberListTask");
                    str = str2;
                }
            }
            try {
                if (arrayList.size() > 0) {
                    contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
                }
                if (this.f7239d) {
                    C2198l.m9943c(contentResolver, this.f7238c, 11);
                }
                C4904y.m18641c("mIsForceInsert : " + this.f7239d, "GetChatMemberListTask");
            } catch (Exception e) {
                C4904y.m18634a(e.getMessage(), "GetChatMemberListTask");
                z = false;
            }
            if (z) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("inbox_last_timestamp", chatMemberListEntry.members.timestamp);
                C4904y.m18641c("TimeStamp : " + chatMemberListEntry.members.timestamp, "GetChatMemberListTask");
                if (!TextUtils.isEmpty(str) && !C2190d.m9846i(contentResolver, c2201oM9951e.f7848k)) {
                    String[] strArrSplit = c2201oM9951e.f7842e.split(Config.KEYVALUE_SPLIT);
                    if (strArrSplit.length == 4) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(strArrSplit[0]).append(Config.KEYVALUE_SPLIT).append(strArrSplit[1]).append(Config.KEYVALUE_SPLIT).append(strArrSplit[2]).append(Config.KEYVALUE_SPLIT).append(C1736gi.m8632a(str));
                        contentValues.put("inbox_last_message", sb.toString());
                    }
                }
                if ("N".equals(c2201oM9951e.f7849l)) {
                    try {
                        cursorQuery = contentResolver.query(C2220ah.m10086a(this.f7238c), null, null, null, null);
                        try {
                            StringBuilder sb2 = new StringBuilder();
                            while (cursorQuery.moveToNext()) {
                                sb2.append(cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name"))).append(", ");
                            }
                            contentValues.put("inbox_title", sb2.toString().substring(0, r1.length() - 2));
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursorQuery = null;
                    }
                }
                if (this.f7239d && list != null && list.size() - 1 > 0 && size != c2201oM9951e.f7845h) {
                    contentValues.put("inbox_participants", Integer.valueOf(size));
                }
                C4904y.m18641c("InBoxDatabaseHelper.updateInBox", "GetChatMemberListTask");
                contentResolver.update(C2299s.f8209a, contentValues, "inbox_no=?", new String[]{this.f7238c});
            }
            C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7238c}));
        }
    }
}
