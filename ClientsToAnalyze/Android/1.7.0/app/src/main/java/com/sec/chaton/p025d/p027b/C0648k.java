package com.sec.chaton.p025d.p027b;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C0671x;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0631k;
import com.sec.chaton.p025d.p026a.C0634n;
import com.sec.chaton.p025d.p026a.C0635o;
import com.sec.chaton.p025d.p026a.C0636p;
import com.sec.chaton.p033io.entry.PushEntry;
import com.sec.chaton.provider.C0849a;
import com.sec.chaton.provider.EnumC0850b;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1339n;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1351z;

/* compiled from: PushReceivedTask.java */
/* renamed from: com.sec.chaton.d.b.k */
/* loaded from: classes.dex */
public class C0648k extends AbstractC0647j {

    /* renamed from: a */
    private String f2251a;

    /* renamed from: b */
    private String f2252b;

    /* renamed from: c */
    private String f2253c;

    /* renamed from: e */
    private String f2254e;

    /* renamed from: f */
    private boolean f2255f;

    public C0648k(InterfaceC0641d interfaceC0641d, String str, boolean z, String str2, String str3, String str4) {
        super(interfaceC0641d, new Handler(Looper.getMainLooper()));
        this.f2255f = z;
        this.f2251a = str2;
        this.f2252b = str3;
        this.f2254e = str4;
        this.f2253c = str;
    }

    @Override // com.sec.chaton.p025d.p027b.AbstractC0647j
    /* renamed from: a */
    public Object mo2950a() throws NumberFormatException {
        EnumC0651d enumC0651dM2931a;
        String str;
        long j;
        boolean zM2939a;
        String str2;
        try {
            PushEntry pushEntry = (PushEntry) new C1339n(this.f2254e).m4643a(PushEntry.class);
            if (!C1323bs.m4575a().getString("msisdn", "").equals(pushEntry.receiver)) {
                return null;
            }
            ContentResolver contentResolver = GlobalApplication.m3100a().getContentResolver();
            EnumC0665r enumC0665rM3011a = EnumC0665r.m3011a(pushEntry.chatType.intValue());
            if (enumC0665rM3011a == null) {
                return null;
            }
            if (enumC0665rM3011a == EnumC0665r.WEB_AUTH) {
                return new C0639b(this, this.f2253c, this.f2255f, pushEntry, "", 0, 0, EnumC0651d.TEXT, false, this.f2251a, true);
            }
            if (EnumC0651d.TEXT != EnumC0651d.m2976a(pushEntry.msgType.intValue())) {
                enumC0651dM2931a = C0635o.m2931a(pushEntry.message);
            } else {
                enumC0651dM2931a = EnumC0651d.TEXT;
            }
            String strM2901a = C0634n.m2901a(contentResolver, enumC0665rM3011a, pushEntry.senderID, pushEntry.sessionID);
            long j2 = 0;
            boolean z = true;
            if (strM2901a != null) {
                boolean zM2939a2 = C0635o.m2939a(contentResolver, strM2901a, enumC0651dM2931a, pushEntry, enumC0665rM3011a);
                if (!zM2939a2) {
                    String strM2875g = C0631k.m2875g(GlobalApplication.m3100a().getContentResolver(), strM2901a, pushEntry.senderID);
                    if (TextUtils.isEmpty(strM2875g)) {
                        C0631k.m2863a(contentResolver, strM2901a, pushEntry.senderID, this.f2251a);
                        strM2875g = this.f2251a;
                    }
                    C0636p c0636pM2913c = C0634n.m2913c(contentResolver, strM2901a);
                    if (c0636pM2913c == null) {
                        return null;
                    }
                    long j3 = c0636pM2913c.f2198a;
                    C0634n.m2904a(contentResolver, c0636pM2913c, enumC0665rM3011a, pushEntry);
                    z = c0636pM2913c.f2215r;
                    if (TextUtils.isEmpty(pushEntry.sessionID)) {
                        pushEntry.sessionID = c0636pM2913c.f2206i;
                    }
                    str = strM2875g;
                    j = j3;
                    zM2939a = zM2939a2;
                    str2 = strM2901a;
                } else {
                    str = this.f2251a;
                    j = 0;
                    zM2939a = zM2939a2;
                    str2 = strM2901a;
                }
            } else {
                String strM4716a = C1351z.m4716a();
                String strM2875g2 = C0631k.m2875g(GlobalApplication.m3100a().getContentResolver(), strM4716a, pushEntry.senderID);
                if (TextUtils.isEmpty(strM2875g2)) {
                    C0631k.m2863a(contentResolver, strM4716a, pushEntry.senderID, this.f2251a);
                    strM2875g2 = this.f2251a;
                }
                Uri uriM2899a = C0634n.m2899a(contentResolver, strM4716a, enumC0665rM3011a, pushEntry);
                if (uriM2899a != null) {
                    if (!C0849a.m3432a(uriM2899a)) {
                        j2 = Long.parseLong(C0671x.m3039a(uriM2899a));
                    } else {
                        EnumC0850b enumC0850bM3433b = C0849a.m3433b(uriM2899a);
                        if (enumC0850bM3433b == EnumC0850b.FULL || enumC0850bM3433b == EnumC0850b.CONSTRAINT || enumC0850bM3433b == EnumC0850b.DISK_IO || enumC0850bM3433b == EnumC0850b.NORMAL) {
                        }
                    }
                }
                str = strM2875g2;
                j = j2;
                zM2939a = C0635o.m2939a(contentResolver, strM4716a, enumC0651dM2931a, pushEntry, enumC0665rM3011a);
                str2 = strM4716a;
            }
            Cursor cursorQuery = contentResolver.query(C0671x.f2315a, null, "inbox_unread_count > 0", null, null);
            int i = 0;
            while (cursorQuery.moveToNext()) {
                i += cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_unread_count"));
            }
            cursorQuery.close();
            return new C0639b(this, this.f2253c, this.f2255f, pushEntry, str2, (int) j, i, enumC0651dM2931a, zM2939a, str, z);
        } catch (Exception e) {
            C1341p.m4653a(e, getClass().getSimpleName());
            return null;
        }
    }
}
