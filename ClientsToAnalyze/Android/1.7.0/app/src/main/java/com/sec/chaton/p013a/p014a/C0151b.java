package com.sec.chaton.p013a.p014a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.chat.C0520a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p025d.p026a.C0631k;
import com.sec.chaton.p025d.p026a.C0634n;
import com.sec.chaton.p025d.p026a.C0636p;
import com.sec.chaton.p033io.entry.ChatMemberListEntry;
import com.sec.chaton.p033io.entry.inner.ChatMember;
import com.sec.chaton.p033io.entry.inner.ChatMembers;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;

/* compiled from: GetChatMemberListTask.java */
/* renamed from: com.sec.chaton.a.a.b */
/* loaded from: classes.dex */
public class C0151b extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private String f363a;

    public C0151b(Handler handler, C0503j c0503j, String str) {
        super(handler, c0503j);
        this.f363a = str;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb, java.lang.Runnable
    public void run() {
        ArrayList arrayListM2869c = C0631k.m2869c(GlobalApplication.m3100a().getContentResolver(), this.f363a);
        if (arrayListM2869c == null || arrayListM2869c.size() == 0) {
            this.f367d = new Message();
            C0259g c0259g = new C0259g(this.f366c);
            c0259g.m923a(EnumC0518y.ERROR);
            this.f367d.what = this.f366c.m2534g();
            if (this.f368e != null) {
                this.f367d.obj = c0259g;
                this.f368e.sendMessage(this.f367d);
                return;
            }
            return;
        }
        super.run();
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        return null;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) throws RemoteException, OperationApplicationException {
        if (c0259g.m928b() == EnumC0518y.SUCCESS) {
            ChatMembers chatMembers = ((ChatMemberListEntry) c0259g.m932d()).members;
            ContentResolver contentResolver = GlobalApplication.m3100a().getContentResolver();
            String str = null;
            C0636p c0636pM2913c = C0634n.m2913c(contentResolver, this.f363a);
            if (c0636pM2913c != null) {
                boolean z = chatMembers.members.size() > 0;
                String string = C1323bs.m4575a().getString("msisdn", "");
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                for (ChatMember chatMember : chatMembers.members) {
                    if (!string.equals(chatMember.MSISDN)) {
                        if (chatMember.MSISDN.equals(c0636pM2913c.f2208k)) {
                            str = chatMember.name;
                        }
                        arrayList.add(C0631k.m2865b(this.f363a, chatMember.MSISDN, chatMember.name));
                        C1341p.m4660c("MSISDN : " + chatMember.MSISDN + ", NAME : " + chatMember.name, getClass().getSimpleName());
                    }
                }
                try {
                    if (arrayList.size() > 0) {
                        contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
                    }
                } catch (Exception e) {
                    C1341p.m4651a(e.getMessage(), getClass().getSimpleName());
                    z = false;
                }
                if (z) {
                    c0636pM2913c.f2214q = Long.parseLong(chatMembers.timestamp);
                    C1341p.m4660c("TimeStamp : " + chatMembers.timestamp, getClass().getSimpleName());
                    if (str != null) {
                        String[] strArrSplit = c0636pM2913c.f2202e.split(";");
                        if (strArrSplit.length == 4) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(strArrSplit[0]).append(";").append(strArrSplit[1]).append(";").append(strArrSplit[2]).append(";").append(C0520a.m2713a(str));
                            c0636pM2913c.f2202e = sb.toString();
                        }
                    }
                    C1341p.m4660c("InBoxDatabaseHelper.updateInBox", getClass().getSimpleName());
                    C0634n.m2891a(contentResolver, this.f363a, c0636pM2913c);
                }
            }
        }
    }
}
