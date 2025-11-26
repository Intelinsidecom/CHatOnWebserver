package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.C1457y;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1372p;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.ChatMemberListEntry;
import com.sec.chaton.p035io.entry.inner.ChatMember;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GetChatMemberListTask.java */
/* renamed from: com.sec.chaton.d.a.bo */
/* loaded from: classes.dex */
public class C1187bo extends AbstractC1145a {

    /* renamed from: b */
    private String f4686b;

    public C1187bo(Handler handler, C1580h c1580h, String str) {
        super(handler, c1580h);
        this.f4686b = str;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        ArrayList<String> arrayListM6221e = C1381y.m6221e(CommonApplication.m11493l().getContentResolver(), this.f4686b);
        if (arrayListM6221e == null || arrayListM6221e.size() == 0) {
            m11680p();
            return null;
        }
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws Throwable {
        Cursor cursorQuery;
        if (c0267d.m1351b() != EnumC1587o.SUCCESS) {
            if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                C1533b.m6522a("01000006", "1004", c0267d);
                return;
            }
            return;
        }
        ChatMemberListEntry chatMemberListEntry = (ChatMemberListEntry) c0267d.m1354e();
        if (chatMemberListEntry.members == null) {
            C3250y.m11453c("chatListEntry.members is null", getClass().getSimpleName());
            return;
        }
        List<ChatMember> list = chatMemberListEntry.members.memberList;
        ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
        String str = null;
        C1372p c1372pM6140d = C1370n.m6140d(contentResolver, this.f4686b);
        if (c1372pM6140d != null) {
            boolean z = list.size() > 0;
            String strM10979a = C3159aa.m10962a().m10979a("chaton_id", "");
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            for (ChatMember chatMember : list) {
                if (!strM10979a.equals(chatMember.userid)) {
                    if (chatMember.userid.equals(c1372pM6140d.f5132k)) {
                        str = chatMember.name;
                    }
                    arrayList.add(C1381y.m6208a(chatMember.userid, chatMember.name, TextUtils.isEmpty(chatMember.countrycode) ? "NO_SEARCH" : chatMember.countrycode, chatMember.isauthuser.booleanValue(), -1));
                    C3250y.m11453c("CHATON NUMBER : " + chatMember.userid + ", NAME : " + chatMember.name + ", CountryCode : " + chatMember.countrycode + ", isAuthUser : " + chatMember.isauthuser, getClass().getSimpleName());
                }
            }
            try {
                if (arrayList.size() > 0) {
                    contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
                }
            } catch (Exception e) {
                C3250y.m11442a(e.getMessage(), getClass().getSimpleName());
                z = false;
            }
            if (z) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("inbox_last_timestamp", chatMemberListEntry.members.timestamp);
                C3250y.m11453c("TimeStamp : " + chatMemberListEntry.members.timestamp, getClass().getSimpleName());
                if (!TextUtils.isEmpty(str)) {
                    String[] strArrSplit = c1372pM6140d.f5126e.split(Config.KEYVALUE_SPLIT);
                    if (strArrSplit.length == 4) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(strArrSplit[0]).append(Config.KEYVALUE_SPLIT).append(strArrSplit[1]).append(Config.KEYVALUE_SPLIT).append(strArrSplit[2]).append(Config.KEYVALUE_SPLIT).append(C1075eq.m5318a(str));
                        contentValues.put("inbox_last_message", sb.toString());
                    }
                }
                C3250y.m11453c("InBoxDatabaseHelper.updateInBox", getClass().getSimpleName());
                if ("N".equals(c1372pM6140d.f5133l)) {
                    try {
                        cursorQuery = contentResolver.query(C1457y.m6367a(this.f4686b), null, null, null, null);
                        try {
                            StringBuilder sb2 = new StringBuilder();
                            while (cursorQuery.moveToNext()) {
                                sb2.append(cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name"))).append(", ");
                            }
                            contentValues.put("inbox_title", sb2.toString().substring(0, r2.length() - 2));
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
                contentResolver.update(C1449q.f5381a, contentValues, "inbox_no=?", new String[]{this.f4686b});
            }
        }
    }
}
