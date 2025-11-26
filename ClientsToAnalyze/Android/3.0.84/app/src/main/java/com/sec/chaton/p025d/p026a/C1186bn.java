package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.C1439g;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p035io.entry.ChatListInfoEntry;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.provider.p049a.C2037a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: GetChatListInfoTask.java */
/* renamed from: com.sec.chaton.d.a.bn */
/* loaded from: classes.dex */
public class C1186bn extends AbstractC1145a {
    public C1186bn(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            ChatListInfoEntry chatListInfoEntry = (ChatListInfoEntry) c0267d.m1354e();
            if (chatListInfoEntry == null) {
                if (C3250y.f11733a) {
                    C3250y.m11456e(" Http Result Entry was null, Can't sync chat list", getClass().getSimpleName());
                    return;
                }
                return;
            }
            int size = chatListInfoEntry.chatroominfodetail.size();
            ArrayList arrayList = new ArrayList();
            if (size < 1) {
                if (C3250y.f11733a) {
                    C3250y.m11456e(" No Chat list", getClass().getSimpleName());
                    return;
                }
                return;
            }
            if (C3159aa.m10962a().m10976a("multidevice_chatlist_sync_last_time", 0L) == chatListInfoEntry.lastupdatetime.longValue()) {
                int iIntValue = C3159aa.m10962a().m10978a("multidevice_chatlist_sync_call_count", (Integer) 0).intValue() + 1;
                if (iIntValue > 1) {
                    if (C3250y.f11733a) {
                        C3250y.m11456e("Already Synced chat list... SKIP (call count :: " + iIntValue + ")", getClass().getSimpleName());
                        return;
                    }
                    return;
                }
                C3159aa.m10962a().m10984b("multidevice_chatlist_sync_call_count", Integer.valueOf(iIntValue));
            } else {
                C3159aa.m10962a().m10984b("multidevice_chatlist_sync_call_count", (Integer) 0);
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("chat_list_sync", "sync");
            C2037a.m8123a(chatListInfoEntry);
            arrayList.add(ContentProviderOperation.newUpdate(C1439g.m6303b()).withValues(contentValues).withSelection(null, null).build());
            if (arrayList.size() > 0) {
                try {
                    C3170al.m11043a(CommonApplication.m11493l(), "com.sec.chaton.provider", (ArrayList<ContentProviderOperation>) arrayList);
                    C3159aa.m10962a().m10982a("multidevice_chatlist_sync_last_time", chatListInfoEntry.lastupdatetime);
                } catch (OperationApplicationException e) {
                    e.printStackTrace();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                arrayList.clear();
                return;
            }
            return;
        }
        if (c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
            ArrayList arrayList2 = new ArrayList();
            StringBuilder sb = new StringBuilder();
            String strM10979a = C3159aa.m10962a().m10979a("old_chaton_id", (String) null);
            if (!TextUtils.isEmpty(strM10979a)) {
                sb.append("message_sender").append(" = ?");
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("message_sender", C3159aa.m10962a().m10979a("chaton_id", (String) null));
                if (!TextUtils.isEmpty(strM10979a)) {
                    arrayList2.add(ContentProviderOperation.newUpdate(C1454v.f5393a).withValues(contentValues2).withSelection(sb.toString(), new String[]{strM10979a}).build());
                }
                if (arrayList2.size() > 0) {
                    try {
                        C3170al.m11043a(GlobalApplication.m11493l(), "com.sec.chaton.provider", (ArrayList<ContentProviderOperation>) arrayList2);
                    } catch (OperationApplicationException e3) {
                        e3.printStackTrace();
                    } catch (RemoteException e4) {
                        e4.printStackTrace();
                    }
                    arrayList2.clear();
                }
            }
        }
    }
}
