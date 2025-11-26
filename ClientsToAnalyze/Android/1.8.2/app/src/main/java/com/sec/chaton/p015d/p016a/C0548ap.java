package com.sec.chaton.p015d.p016a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.chat.C0493bg;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.C0662f;
import com.sec.chaton.p017e.p018a.C0670n;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.ChatMemberListEntry;
import com.sec.chaton.p028io.entry.inner.ChatMember;
import com.sec.chaton.p028io.entry.inner.ChatMembers;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.util.ArrayList;

/* compiled from: GetChatMemberListTask.java */
/* renamed from: com.sec.chaton.d.a.ap */
/* loaded from: classes.dex */
public class C0548ap extends AbstractRunnableC0532a {

    /* renamed from: d */
    private String f2224d;

    public C0548ap(Handler handler, C0798h c0798h, String str) {
        super(handler, c0798h);
        this.f2224d = str;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a, java.lang.Runnable
    public void run() {
        ArrayList arrayListM3081a = C0670n.m3081a(GlobalApplication.m3260b().getContentResolver(), this.f2224d, (String[]) null);
        if (arrayListM3081a == null || arrayListM3081a.size() == 0) {
            this.f2160b = new Message();
            C0101b c0101b = new C0101b(this.f2159a);
            c0101b.m659a(EnumC0803m.ERROR);
            this.f2160b.what = this.f2159a.m3399g();
            if (this.f2161c != null) {
                this.f2160b.obj = c0101b;
                this.f2161c.sendMessage(this.f2160b);
                return;
            }
            return;
        }
        super.run();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) throws RemoteException, OperationApplicationException {
        if (c0101b.m665b() == EnumC0803m.SUCCESS) {
            ChatMembers chatMembers = ((ChatMemberListEntry) c0101b.m671d()).members;
            ContentResolver contentResolver = GlobalApplication.m3260b().getContentResolver();
            String str = null;
            C0662f c0662fM3030d = C0660d.m3030d(contentResolver, this.f2224d);
            if (c0662fM3030d != null) {
                boolean z = chatMembers.members.size() > 0;
                String string = C1789u.m6075a().getString("msisdn", "");
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                for (ChatMember chatMember : chatMembers.members) {
                    if (!string.equals(chatMember.MSISDN)) {
                        if (chatMember.MSISDN.equals(c0662fM3030d.f2543j)) {
                            str = chatMember.name;
                        }
                        arrayList.add(C0670n.m3079a(this.f2224d, chatMember.MSISDN, chatMember.name));
                        C1786r.m6063c("MSISDN : " + chatMember.MSISDN + ", NAME : " + chatMember.name, getClass().getSimpleName());
                    }
                }
                try {
                    if (arrayList.size() > 0) {
                        contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
                    }
                } catch (Exception e) {
                    C1786r.m6054a(e.getMessage(), getClass().getSimpleName());
                    z = false;
                }
                if (z) {
                    c0662fM3030d.f2549p = Long.parseLong(chatMembers.timestamp);
                    C1786r.m6063c("TimeStamp : " + chatMembers.timestamp, getClass().getSimpleName());
                    if (str != null) {
                        String[] strArrSplit = c0662fM3030d.f2537d.split(";");
                        if (strArrSplit.length == 4) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(strArrSplit[0]).append(";").append(strArrSplit[1]).append(";").append(strArrSplit[2]).append(";").append(C0493bg.m2684a(str));
                            c0662fM3030d.f2537d = sb.toString();
                        }
                    }
                    C1786r.m6063c("InBoxDatabaseHelper.updateInBox", getClass().getSimpleName());
                    C0660d.m3005a(contentResolver, this.f2224d, c0662fM3030d);
                }
            }
        }
    }
}
