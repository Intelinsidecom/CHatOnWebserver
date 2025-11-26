package com.sec.chaton.p017e.p019b;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.anicon.C0921d;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.C0662f;
import com.sec.chaton.p017e.p018a.C0665i;
import com.sec.chaton.p017e.p018a.C0670n;
import com.sec.chaton.p028io.entry.PushEntry;
import com.sec.chaton.util.C1733ap;
import com.sec.chaton.util.C1785q;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* compiled from: PushReceivedTask.java */
/* renamed from: com.sec.chaton.e.b.k */
/* loaded from: classes.dex */
public class C0684k extends AbstractC0674a {

    /* renamed from: b */
    private String f2583b;

    /* renamed from: c */
    private String f2584c;

    /* renamed from: d */
    private String f2585d;

    /* renamed from: e */
    private String f2586e;

    /* renamed from: f */
    private boolean f2587f;

    public C0684k(InterfaceC0677d interfaceC0677d, String str, boolean z, String str2, String str3, String str4) {
        super(interfaceC0677d, new Handler(Looper.getMainLooper()));
        this.f2587f = z;
        this.f2583b = str2;
        this.f2584c = str3;
        this.f2586e = str4;
        this.f2585d = str;
    }

    @Override // com.sec.chaton.p017e.p019b.AbstractC0674a
    /* renamed from: a */
    public Object mo3098a() {
        EnumC0699n enumC0699nM3046a;
        boolean z;
        boolean zM3064a;
        String str;
        try {
            PushEntry pushEntry = (PushEntry) new C1785q(this.f2586e).m6046a(PushEntry.class);
            if (!C1789u.m6075a().getString("msisdn", "").equals(pushEntry.receiver)) {
                return null;
            }
            ContentResolver contentResolver = GlobalApplication.m3260b().getContentResolver();
            EnumC0695j enumC0695jM3145a = EnumC0695j.m3145a(pushEntry.chatType.intValue());
            if (enumC0695jM3145a == null) {
                return null;
            }
            if (enumC0695jM3145a == EnumC0695j.WEB_AUTH) {
                return new C0685l(this, this.f2585d, this.f2587f, pushEntry, "", 0, 0, EnumC0699n.TEXT, false, true);
            }
            if (EnumC0699n.TEXT != EnumC0699n.m3160a(pushEntry.msgType.intValue())) {
                enumC0699nM3046a = C0665i.m3046a(pushEntry.message);
            } else {
                enumC0699nM3046a = EnumC0699n.TEXT;
            }
            EnumC0699n enumC0699n = (EnumC0699n.IMAGE == enumC0699nM3046a && C0921d.m3794b(pushEntry.message) && C1786r.f6452b) ? EnumC0699n.ANICON : enumC0699nM3046a;
            String strM3014a = C0660d.m3014a(contentResolver, enumC0695jM3145a, pushEntry.senderID, pushEntry.sessionID);
            if (strM3014a != null) {
                boolean zM3064a2 = C0665i.m3064a(contentResolver, strM3014a, enumC0699n, pushEntry, enumC0695jM3145a);
                if (zM3064a2) {
                    z = true;
                    zM3064a = zM3064a2;
                    str = strM3014a;
                } else {
                    if (!C0670n.m3083a(contentResolver, pushEntry.senderID, strM3014a)) {
                        C0670n.m3082a(contentResolver, strM3014a, pushEntry.senderID, this.f2583b);
                    }
                    C0662f c0662fM3030d = C0660d.m3030d(contentResolver, strM3014a);
                    if (c0662fM3030d == null) {
                        return null;
                    }
                    boolean z2 = c0662fM3030d.f2550q;
                    C0660d.m3017a(contentResolver, enumC0695jM3145a, pushEntry, strM3014a);
                    z = z2;
                    zM3064a = zM3064a2;
                    str = strM3014a;
                }
            } else {
                String strM5916a = C1733ap.m5916a();
                if (!C0670n.m3083a(contentResolver, pushEntry.senderID, strM5916a)) {
                    C0670n.m3082a(contentResolver, strM5916a, pushEntry.senderID, this.f2583b);
                }
                C0660d.m3012a(contentResolver, strM5916a, enumC0695jM3145a, pushEntry);
                z = true;
                zM3064a = C0665i.m3064a(contentResolver, strM5916a, enumC0699n, pushEntry, enumC0695jM3145a);
                str = strM5916a;
            }
            Cursor cursorQuery = contentResolver.query(C0694i.f2616a, null, "inbox_unread_count > 0", null, null);
            int i = 0;
            while (cursorQuery.moveToNext()) {
                i += cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_unread_count"));
            }
            cursorQuery.close();
            return new C0685l(this, this.f2585d, this.f2587f, pushEntry, str, C0660d.m3003a(contentResolver, str), i, enumC0699n, zM3064a, z);
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getSimpleName());
            return null;
        }
    }
}
