package com.sec.chaton.p027e.p029b;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1072en;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1372p;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p035io.entry.PushEncryptEntry;
import com.sec.chaton.p035io.entry.PushEntry;
import com.sec.chaton.p042k.p043a.C1600a;
import com.sec.chaton.provider.C2036a;
import com.sec.chaton.settings.downloads.C2646u;
import com.sec.chaton.util.C3158a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3189bd;
import com.sec.chaton.util.C3230e;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

/* compiled from: PushReceivedTask.java */
/* renamed from: com.sec.chaton.e.b.n */
/* loaded from: classes.dex */
public class C1423n extends AbstractC1410a {

    /* renamed from: c */
    private static final String f5275c = C1423n.class.getSimpleName();

    /* renamed from: d */
    private String f5276d;

    /* renamed from: e */
    private String f5277e;

    /* renamed from: f */
    private String f5278f;

    /* renamed from: g */
    private boolean f5279g;

    public C1423n(InterfaceC1413d interfaceC1413d, String str, boolean z, String str2, String str3, String str4) {
        super(interfaceC1413d, new Handler(Looper.getMainLooper()));
        this.f5279g = z;
        this.f5276d = str2;
        this.f5278f = str4;
        this.f5277e = str;
    }

    @Override // com.sec.chaton.p027e.p029b.AbstractC1410a
    /* renamed from: a */
    public Object mo6263a() throws NumberFormatException {
        PushEntry pushEntry;
        PushEntry pushEntry2;
        boolean zM6183a;
        String str;
        long j;
        C1600a c1600a = new C1600a(this.f5278f);
        if (C1493a.m6463a("push_message_encrypt_feature")) {
            try {
                PushEncryptEntry pushEncryptEntry = (PushEncryptEntry) c1600a.m6782a(PushEncryptEntry.class);
                if (pushEncryptEntry.f5632E != null) {
                    boolean zBooleanValue = pushEncryptEntry.f5632E.booleanValue();
                    String str2 = pushEncryptEntry.body;
                    C3250y.m11453c("E : " + zBooleanValue, f5275c);
                    if (zBooleanValue) {
                        C3250y.m11453c("decryptPushMessage with Primary Key", f5275c);
                        byte[] bArrM6271a = m6271a(str2, GlobalApplication.m6453c().m11411a());
                        if (bArrM6271a == null) {
                            C3250y.m11453c("decryptPushMessage with Expired Key", f5275c);
                            byte[] bArrM6271a2 = m6271a(str2, GlobalApplication.m6453c().m11412b());
                            if (bArrM6271a2 == null) {
                                C3250y.m11453c("decryptPushMessage Fail! ", f5275c);
                                return null;
                            }
                            bArrM6271a = bArrM6271a2;
                        }
                        str2 = new String(bArrM6271a);
                        C1072en.m5306a(str2, f5275c);
                    }
                    pushEntry = (PushEntry) new C1600a(str2).m6782a(PushEntry.class);
                } else {
                    pushEntry = (PushEntry) new C1600a(this.f5278f).m6782a(PushEntry.class);
                }
                pushEntry2 = pushEntry;
            } catch (Exception e) {
                C3250y.m11443a(e, getClass().getSimpleName());
                return null;
            }
        } else {
            try {
                pushEntry2 = (PushEntry) c1600a.m6782a(PushEntry.class);
            } catch (Exception e2) {
                C3250y.m11443a(e2, getClass().getSimpleName());
                return null;
            }
        }
        if (!TextUtils.isEmpty(pushEntry2.sessionID)) {
            pushEntry2.sessionID = C1370n.m6147k(CommonApplication.m11493l().getContentResolver(), pushEntry2.sessionID);
        }
        if (!TextUtils.isEmpty(pushEntry2.senderID)) {
            pushEntry2.senderID = C1381y.m6227h(CommonApplication.m11493l().getContentResolver(), pushEntry2.senderID);
        }
        if (!C3159aa.m10962a().m10979a("chaton_id", "").equals(pushEntry2.senderID) && !C3159aa.m10962a().m10979a("chaton_id", "").equals(pushEntry2.receiver) && !C3159aa.m10962a().m10979a("old_chaton_id", "").equals(pushEntry2.receiver)) {
            this.f5242b = false;
            return new C1424o(this, this.f5277e, this.f5279g, pushEntry2, "", 0, 0, EnumC1455w.TEXT, false, this.f5276d, true, 0L);
        }
        if (TextUtils.isEmpty(pushEntry2.senderID)) {
            this.f5242b = false;
            return new C1424o(this, this.f5277e, this.f5279g, pushEntry2, "", 0, 0, EnumC1455w.TEXT, false, this.f5276d, true, 0L);
        }
        if (pushEntry2.senderID.startsWith("0999") && !C1357af.m5998c(CommonApplication.m11493l(), pushEntry2.senderID)) {
            this.f5242b = false;
            return new C1424o(this, this.f5277e, this.f5279g, pushEntry2, "", 0, 0, EnumC1455w.TEXT, false, this.f5276d, true, 0L);
        }
        ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
        EnumC1450r enumC1450rM6339a = EnumC1450r.m6339a(pushEntry2.chatType.intValue());
        if (enumC1450rM6339a == null) {
            this.f5242b = false;
            return new C1424o(this, this.f5277e, this.f5279g, pushEntry2, "", 0, 0, EnumC1455w.TEXT, false, this.f5276d, true, 0L);
        }
        if (enumC1450rM6339a == EnumC1450r.WEB_AUTH) {
            return new C1424o(this, this.f5277e, this.f5279g, pushEntry2, "", 0, 0, EnumC1455w.TEXT, false, this.f5276d, true, 0L);
        }
        EnumC1455w enumC1455wM6174a = C1373q.m6174a(pushEntry2.message, pushEntry2.msgType.intValue());
        if (EnumC1455w.IMAGE == enumC1455wM6174a && C2646u.m9661b(pushEntry2.message)) {
            if (C3250y.f11734b) {
                C3250y.m11450b("Received anicon message.", f5275c);
            }
            enumC1455wM6174a = EnumC1455w.ANICON;
        }
        String str3 = pushEntry2.senderID;
        if (C3159aa.m10962a().m10979a("chaton_id", "").equals(pushEntry2.senderID)) {
            str3 = pushEntry2.receiver;
        }
        String strM6122a = C1370n.m6122a(contentResolver, enumC1450rM6339a, str3, pushEntry2.sessionID);
        long j2 = 0;
        boolean zBooleanValue2 = true;
        long j3 = 0;
        if (strM6122a != null) {
            zM6183a = C1373q.m6183a(contentResolver, strM6122a, enumC1455wM6174a, pushEntry2, enumC1450rM6339a);
            if (!zM6183a) {
                String str4 = pushEntry2.senderID;
                String str5 = pushEntry2.receiver;
                if (C3159aa.m10962a().m10979a("chaton_id", "").equals(pushEntry2.senderID)) {
                    pushEntry2.senderID = str5;
                    pushEntry2.receiver = str4;
                    pushEntry2.isMirror = true;
                }
                String strM6224g = C1381y.m6224g(CommonApplication.m11493l().getContentResolver(), strM6122a, pushEntry2.senderID);
                if (TextUtils.isEmpty(strM6224g)) {
                    C1381y.m6210a(contentResolver, strM6122a, pushEntry2.senderID, this.f5276d);
                    strM6224g = this.f5276d;
                } else if (strM6224g.equals(GlobalApplication.m6451b().getString(R.string.unknown)) && !TextUtils.isEmpty(this.f5276d)) {
                    C1381y.m6210a(contentResolver, strM6122a, pushEntry2.senderID, this.f5276d);
                    strM6224g = this.f5276d;
                }
                C1372p c1372pM6140d = C1370n.m6140d(contentResolver, strM6122a);
                if (c1372pM6140d == null) {
                    this.f5242b = false;
                    return new C1424o(this, this.f5277e, this.f5279g, pushEntry2, "", 0, 0, EnumC1455w.TEXT, false, this.f5276d, true, 0L);
                }
                long j4 = c1372pM6140d.f5122a;
                C1370n.m6125a(contentResolver, c1372pM6140d, enumC1450rM6339a, pushEntry2);
                zBooleanValue2 = c1372pM6140d.f5139r;
                if (TextUtils.isEmpty(pushEntry2.sessionID)) {
                    pushEntry2.sessionID = c1372pM6140d.f5130i;
                }
                pushEntry2.senderID = str4;
                pushEntry2.receiver = str5;
                j3 = c1372pM6140d.f5140s;
                str = strM6224g;
                j = j4;
            } else {
                str = this.f5276d;
                j = 0;
            }
        } else {
            strM6122a = C3189bd.m11137a();
            String str6 = pushEntry2.senderID;
            String str7 = pushEntry2.receiver;
            if (C3159aa.m10962a().m10979a("chaton_id", "").equals(pushEntry2.senderID)) {
                pushEntry2.senderID = str7;
                pushEntry2.receiver = str6;
                pushEntry2.isMirror = true;
            }
            C1381y.m6210a(contentResolver, strM6122a, pushEntry2.senderID, this.f5276d);
            String strM6224g2 = C1381y.m6224g(CommonApplication.m11493l().getContentResolver(), strM6122a, pushEntry2.senderID);
            if (TextUtils.isEmpty(strM6224g2)) {
                strM6224g2 = this.f5276d;
            }
            Uri uriM6120a = C1370n.m6120a(contentResolver, strM6122a, enumC1450rM6339a, pushEntry2);
            if (uriM6120a != null && !C2036a.m8118a(uriM6120a)) {
                j2 = Long.parseLong(C1449q.m6330a(uriM6120a));
            }
            pushEntry2.senderID = str6;
            pushEntry2.receiver = str7;
            zM6183a = C1373q.m6183a(contentResolver, strM6122a, enumC1455wM6174a, pushEntry2, enumC1450rM6339a);
            if (enumC1450rM6339a == EnumC1450r.GROUPCHAT) {
                zBooleanValue2 = C3159aa.m10962a().m10977a("Setting alert_new_groupchat", (Boolean) true).booleanValue();
                str = strM6224g2;
                j = j2;
            } else {
                zBooleanValue2 = true;
                str = strM6224g2;
                j = j2;
            }
        }
        return new C1424o(this, this.f5277e, this.f5279g, pushEntry2, strM6122a, (int) j, C1370n.m6102a(contentResolver), enumC1455wM6174a, zM6183a, str, zBooleanValue2, j3);
    }

    /* renamed from: a */
    private byte[] m6271a(String str, String str2) {
        C3158a c3158a;
        if (!TextUtils.isEmpty(str2)) {
            try {
                c3158a = new C3158a(C3158a.m10958b(str2), C3158a.m10959c(str2));
            } catch (InvalidAlgorithmParameterException e) {
                e.printStackTrace();
                c3158a = null;
            } catch (InvalidKeyException e2) {
                e2.printStackTrace();
                c3158a = null;
            }
            if (c3158a == null) {
                C3250y.m11442a("AesCipher is null", f5275c);
                return null;
            }
            C3250y.m11453c("Base64 body : " + str, f5275c);
            C3250y.m11453c("Decoded body : " + C3230e.m11353a(str), f5275c);
            return c3158a.m10961c(C3230e.m11353a(str));
        }
        C3250y.m11442a("Fail in getting a key", f5275c);
        return null;
    }
}
