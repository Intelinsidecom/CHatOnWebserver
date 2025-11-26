package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.C2287g;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p065io.entry.ChatListInfoEntry;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.provider.p089a.C3035a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: GetChatListInfoTask.java */
/* renamed from: com.sec.chaton.d.a.bo */
/* loaded from: classes.dex */
public class C1942bo extends AbstractC1900a {
    public C1942bo(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            ChatListInfoEntry chatListInfoEntry = (ChatListInfoEntry) c0778b.m3110e();
            if (chatListInfoEntry == null) {
                if (C4904y.f17871a) {
                    C4904y.m18646e(" Http Result Entry was null, Can't sync chat list", getClass().getSimpleName());
                    return;
                }
                return;
            }
            int size = chatListInfoEntry.chatroominfodetail.size();
            ArrayList arrayList = new ArrayList();
            if (size < 1) {
                if (C4904y.f17871a) {
                    C4904y.m18646e(" No Chat list", getClass().getSimpleName());
                    return;
                }
                return;
            }
            if (C4809aa.m18104a().m18118a("multidevice_chatlist_sync_last_time", 0L) == chatListInfoEntry.lastupdatetime.longValue()) {
                int iIntValue = C4809aa.m18104a().m18120a("multidevice_chatlist_sync_call_count", (Integer) 0).intValue() + 1;
                if (iIntValue > 1) {
                    if (C4904y.f17871a) {
                        C4904y.m18646e("Already Synced chat list... SKIP (call count :: " + iIntValue + ")", getClass().getSimpleName());
                        return;
                    }
                    return;
                }
                C4809aa.m18104a().m18126b("multidevice_chatlist_sync_call_count", Integer.valueOf(iIntValue));
            } else {
                C4809aa.m18104a().m18126b("multidevice_chatlist_sync_call_count", (Integer) 0);
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("chat_list_sync", "sync");
            C3035a.m12462a(chatListInfoEntry);
            arrayList.add(ContentProviderOperation.newUpdate(C2287g.m10158a()).withValues(contentValues).withSelection(null, null).build());
            if (arrayList.size() > 0) {
                try {
                    C4821am.m18190a(CommonApplication.m18732r(), "com.sec.chaton.provider", (ArrayList<ContentProviderOperation>) arrayList);
                    C4809aa.m18104a().m18124a("multidevice_chatlist_sync_last_time", chatListInfoEntry.lastupdatetime);
                } catch (OperationApplicationException e) {
                    e.printStackTrace();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                arrayList.clear();
            }
            C0991aa.m6037a().m18961c(new C1015an(new String[0]));
            return;
        }
        if (c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
            ArrayList arrayList2 = new ArrayList();
            StringBuilder sb = new StringBuilder();
            String strM18121a = C4809aa.m18104a().m18121a("old_chaton_id", (String) null);
            if (!TextUtils.isEmpty(strM18121a)) {
                sb.append("message_sender").append(" = ?");
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("message_sender", C4809aa.m18104a().m18121a("chaton_id", (String) null));
                if (!TextUtils.isEmpty(strM18121a)) {
                    arrayList2.add(ContentProviderOperation.newUpdate(C2306z.f8229a).withValues(contentValues2).withSelection(sb.toString(), new String[]{strM18121a}).build());
                }
                if (arrayList2.size() > 0) {
                    try {
                        C4821am.m18190a(GlobalApplication.m18732r(), "com.sec.chaton.provider", (ArrayList<ContentProviderOperation>) arrayList2);
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
