package com.sec.google.android.p134a.p135a;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.Build;
import android.provider.Telephony;
import android.text.TextUtils;
import android.util.Log;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.provider.C3964v;
import com.sec.chaton.smsplugin.spam.C4012bp;
import com.sec.google.android.p134a.C5077a;
import com.sec.google.android.p134a.C5104b;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p136b.C5108d;
import com.sec.google.android.p134a.p136b.C5109e;
import com.sec.google.android.p134a.p136b.C5110f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: PluginPduPersister.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.google.android.a.a.t */
/* loaded from: classes.dex */
public class C5097t {

    /* renamed from: a */
    private static C5097t f18565a;

    /* renamed from: b */
    private static final C5108d f18566b;

    /* renamed from: c */
    private static final int[] f18567c = {129, 130, 137, 151};

    /* renamed from: d */
    private static final String[] f18568d = {"_id", "msg_box", "thread_id", "retr_txt", "sub", "ct_l", "ct_t", "m_cls", "m_id", "resp_txt", "tr_id", "ct_cls", "d_rpt", "m_type", VKApiConst.VERSION, "rr", "read_status", "rpt_a", "retr_st", "st", "date", "d_tm", "exp", "m_size", "sub_cs", "retr_txt_cs"};

    /* renamed from: e */
    private static final String[] f18569e = {"_id", "chset", "cd", "cid", "cl", "ct", "fn", "name", "text"};

    /* renamed from: f */
    private static final HashMap<Uri, Integer> f18570f = new HashMap<>();

    /* renamed from: g */
    private static final HashMap<Integer, Integer> f18571g;

    /* renamed from: h */
    private static final HashMap<Integer, Integer> f18572h;

    /* renamed from: i */
    private static final HashMap<Integer, Integer> f18573i;

    /* renamed from: j */
    private static final HashMap<Integer, Integer> f18574j;

    /* renamed from: k */
    private static final HashMap<Integer, Integer> f18575k;

    /* renamed from: l */
    private static final HashMap<Integer, String> f18576l;

    /* renamed from: m */
    private static final HashMap<Integer, String> f18577m;

    /* renamed from: n */
    private static final HashMap<Integer, String> f18578n;

    /* renamed from: o */
    private static final HashMap<Integer, String> f18579o;

    /* renamed from: p */
    private static final HashMap<Integer, String> f18580p;

    /* renamed from: q */
    private final Context f18581q;

    /* renamed from: r */
    private final ContentResolver f18582r;

    static {
        f18570f.put(Telephony.Mms.Inbox.CONTENT_URI, 1);
        f18570f.put(Telephony.Mms.Sent.CONTENT_URI, 2);
        f18570f.put(Telephony.Mms.Draft.CONTENT_URI, 3);
        f18570f.put(Telephony.Mms.Outbox.CONTENT_URI, 4);
        f18570f.put(C3964v.f14265a, 1);
        f18571g = new HashMap<>();
        f18571g.put(150, 24);
        f18571g.put(154, 25);
        f18576l = new HashMap<>();
        f18576l.put(150, "sub_cs");
        f18576l.put(154, "retr_txt_cs");
        f18572h = new HashMap<>();
        f18572h.put(154, 3);
        f18572h.put(150, 4);
        f18577m = new HashMap<>();
        f18577m.put(154, "retr_txt");
        f18577m.put(150, "sub");
        f18573i = new HashMap<>();
        f18573i.put(131, 5);
        f18573i.put(132, 6);
        f18573i.put(138, 7);
        f18573i.put(139, 8);
        f18573i.put(147, 9);
        f18573i.put(152, 10);
        f18578n = new HashMap<>();
        f18578n.put(131, "ct_l");
        f18578n.put(132, "ct_t");
        f18578n.put(138, "m_cls");
        f18578n.put(139, "m_id");
        f18578n.put(147, "resp_txt");
        f18578n.put(152, "tr_id");
        f18574j = new HashMap<>();
        f18574j.put(186, 11);
        f18574j.put(134, 12);
        f18574j.put(140, 13);
        f18574j.put(141, 14);
        f18574j.put(144, 15);
        f18574j.put(155, 16);
        f18574j.put(145, 17);
        f18574j.put(153, 18);
        f18574j.put(149, 19);
        f18579o = new HashMap<>();
        f18579o.put(186, "ct_cls");
        f18579o.put(134, "d_rpt");
        f18579o.put(140, "m_type");
        f18579o.put(141, VKApiConst.VERSION);
        f18579o.put(143, "pri");
        f18579o.put(144, "rr");
        f18579o.put(155, "read_status");
        f18579o.put(145, "rpt_a");
        f18579o.put(153, "retr_st");
        f18579o.put(149, "st");
        f18575k = new HashMap<>();
        f18575k.put(133, 20);
        f18575k.put(135, 21);
        f18575k.put(136, 22);
        f18575k.put(142, 23);
        f18580p = new HashMap<>();
        f18580p.put(133, "date");
        f18580p.put(135, "d_tm");
        f18580p.put(136, "exp");
        f18580p.put(142, "m_size");
        f18566b = C5108d.m19487b();
    }

    private C5097t(Context context) {
        this.f18581q = context;
        this.f18582r = context.getContentResolver();
    }

    /* renamed from: a */
    public static C5097t m19426a(Context context) {
        if (f18565a == null || !context.equals(f18565a.f18581q)) {
            f18565a = new C5097t(context);
        }
        return f18565a;
    }

    /* renamed from: a */
    private void m19432a(Cursor cursor, int i, C5093p c5093p, int i2) {
        C5082e c5082e;
        String string = cursor.getString(i);
        if (string != null && string.length() > 0) {
            int i3 = cursor.getInt(f18571g.get(Integer.valueOf(i2)).intValue());
            if (Build.VERSION.SDK_INT >= 19) {
                c5093p.m19371a(new C5082e(i3, m19436a(string)), i2);
                return;
            }
            Log.v("PluginPduPersister", "setEncodedStringValueToHeaders() : mapColumn is : " + i2);
            if (i2 == 150) {
                c5082e = new C5082e(i3, string);
            } else {
                c5082e = new C5082e(i3, m19436a(string));
            }
            c5093p.m19371a(c5082e, i2);
        }
    }

    /* renamed from: b */
    private void m19439b(Cursor cursor, int i, C5093p c5093p, int i2) {
        String string = cursor.getString(i);
        if (string != null) {
            c5093p.m19372a(m19436a(string), i2);
        }
    }

    /* renamed from: c */
    private void m19441c(Cursor cursor, int i, C5093p c5093p, int i2) throws C5104b {
        if (!cursor.isNull(i)) {
            c5093p.m19369a(cursor.getInt(i), i2);
        }
    }

    /* renamed from: d */
    private void m19442d(Cursor cursor, int i, C5093p c5093p, int i2) {
        if (!cursor.isNull(i)) {
            c5093p.m19370a(cursor.getLong(i), i2);
        }
    }

    /* renamed from: a */
    private Integer m19427a(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i));
    }

    /* renamed from: b */
    private byte[] m19440b(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return m19436a(cursor.getString(i));
    }

    /* renamed from: a */
    private C5094q[] m19437a(long j, boolean z) {
        InputStream inputStream = null;
        Cursor cursorM19497a = z ? C5110f.m19497a(this.f18581q, this.f18582r, Uri.parse("content://" + C4012bp.f14467c + "/" + j + "/spampart"), f18569e, null, null, null) : C5110f.m19497a(this.f18581q, this.f18582r, Uri.parse("content://mms/" + j + "/part"), f18569e, null, null, null);
        if (cursorM19497a != null) {
            try {
                if (cursorM19497a.getCount() != 0) {
                    C5094q[] c5094qArr = new C5094q[cursorM19497a.getCount()];
                    int i = 0;
                    while (cursorM19497a.moveToNext()) {
                        C5094q c5094q = new C5094q();
                        Integer numM19427a = m19427a(cursorM19497a, 1);
                        if (numM19427a != null) {
                            c5094q.m19379a(numM19427a.intValue());
                        }
                        byte[] bArrM19440b = m19440b(cursorM19497a, 2);
                        if (bArrM19440b != null) {
                            c5094q.m19388d(bArrM19440b);
                        }
                        byte[] bArrM19440b2 = m19440b(cursorM19497a, 3);
                        if (bArrM19440b2 != null) {
                            c5094q.m19384b(bArrM19440b2);
                        }
                        byte[] bArrM19440b3 = m19440b(cursorM19497a, 4);
                        if (bArrM19440b3 != null) {
                            c5094q.m19385c(bArrM19440b3);
                        }
                        byte[] bArrM19440b4 = m19440b(cursorM19497a, 5);
                        if (bArrM19440b4 == null) {
                            throw new C5111c("Content-Type must be set.");
                        }
                        c5094q.m19389e(bArrM19440b4);
                        byte[] bArrM19440b5 = m19440b(cursorM19497a, 6);
                        if (bArrM19440b5 != null) {
                            c5094q.m19395h(bArrM19440b5);
                        }
                        byte[] bArrM19440b6 = m19440b(cursorM19497a, 7);
                        if (bArrM19440b6 != null) {
                            c5094q.m19393g(bArrM19440b6);
                        }
                        long j2 = cursorM19497a.getLong(0);
                        Uri uri = z ? Uri.parse("content://" + C4012bp.f14467c + "/spampart/" + j2) : Uri.parse("content://mms/part/" + j2);
                        c5094q.m19380a(uri);
                        String strM19428a = m19428a(bArrM19440b4);
                        if (!C5077a.m19288b(strM19428a) && !C5077a.m19290c(strM19428a) && !C5077a.m19291d(strM19428a)) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            if ("text/plain".equals(strM19428a) || "application/smil".equals(strM19428a) || "text/html".equals(strM19428a)) {
                                String string = cursorM19497a.getString(8);
                                if (string == null) {
                                    string = "";
                                }
                                byte[] bArrM19307b = new C5082e(string).m19307b();
                                byteArrayOutputStream.write(bArrM19307b, 0, bArrM19307b.length);
                            } else {
                                try {
                                    try {
                                        InputStream inputStreamOpenInputStream = this.f18582r.openInputStream(uri);
                                        try {
                                            byte[] bArr = new byte[256];
                                            for (int i2 = inputStreamOpenInputStream.read(bArr); i2 >= 0; i2 = inputStreamOpenInputStream.read(bArr)) {
                                                byteArrayOutputStream.write(bArr, 0, i2);
                                            }
                                            if (inputStreamOpenInputStream != null) {
                                                try {
                                                    inputStreamOpenInputStream.close();
                                                } catch (IOException e) {
                                                    Log.e("PluginPduPersister", "Failed to close stream", e);
                                                }
                                            }
                                        } catch (IOException e2) {
                                            e = e2;
                                            inputStream = inputStreamOpenInputStream;
                                            Log.e("PluginPduPersister", "Failed to load part data", e);
                                            cursorM19497a.close();
                                            throw new C5111c(e);
                                        } catch (Throwable th) {
                                            th = th;
                                            inputStream = inputStreamOpenInputStream;
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e3) {
                                                    Log.e("PluginPduPersister", "Failed to close stream", e3);
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (IOException e4) {
                                        e = e4;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                            c5094q.m19381a(byteArrayOutputStream.toByteArray());
                        }
                        c5094qArr[i] = c5094q;
                        i++;
                    }
                    if (cursorM19497a != null) {
                        cursorM19497a.close();
                    }
                    return c5094qArr;
                }
            } finally {
                if (cursorM19497a != null) {
                    cursorM19497a.close();
                }
            }
        }
    }

    /* renamed from: a */
    private void m19431a(long j, C5093p c5093p, boolean z) {
        Cursor cursorM19497a;
        if (z) {
            cursorM19497a = C5110f.m19497a(this.f18581q, this.f18582r, Uri.parse("content://" + C4012bp.f14467c + "/" + j + "/spamaddr"), new String[]{"address", "charset", "type"}, null, null, null);
        } else {
            cursorM19497a = C5110f.m19497a(this.f18581q, this.f18582r, Uri.parse("content://mms/" + j + "/addr"), new String[]{"address", "charset", "type"}, null, null, null);
        }
        if (cursorM19497a != null) {
            while (cursorM19497a.moveToNext()) {
                try {
                    String string = cursorM19497a.getString(0);
                    if (!TextUtils.isEmpty(string)) {
                        int i = cursorM19497a.getInt(2);
                        switch (i) {
                            case 129:
                            case 130:
                            case 151:
                                c5093p.m19374b(new C5082e(cursorM19497a.getInt(1), m19436a(string)), i);
                                break;
                            case 137:
                                c5093p.m19371a(new C5082e(cursorM19497a.getInt(1), m19436a(string)), i);
                                break;
                            default:
                                Log.e("PluginPduPersister", "Unknown address type: " + i);
                                break;
                        }
                    }
                } finally {
                    cursorM19497a.close();
                }
            }
        }
    }

    /* renamed from: a */
    public C5095r m19449a(Uri uri) throws C5111c {
        C5094q[] c5094qArrM19437a;
        C5095r c5100w;
        C5109e c5109eA = f18566b.m19481a((C5108d) uri);
        if (c5109eA != null) {
            return c5109eA.m19492a();
        }
        Cursor cursorM19497a = C5110f.m19497a(this.f18581q, this.f18582r, uri, f18568d, null, null, null);
        C5093p c5093p = new C5093p();
        long id = ContentUris.parseId(uri);
        if (cursorM19497a != null) {
            try {
                if (cursorM19497a.getCount() == 1 && cursorM19497a.moveToFirst()) {
                    int i = cursorM19497a.getInt(1);
                    long j = cursorM19497a.getLong(2);
                    for (Map.Entry<Integer, Integer> entry : f18572h.entrySet()) {
                        m19432a(cursorM19497a, entry.getValue().intValue(), c5093p, entry.getKey().intValue());
                    }
                    for (Map.Entry<Integer, Integer> entry2 : f18573i.entrySet()) {
                        m19439b(cursorM19497a, entry2.getValue().intValue(), c5093p, entry2.getKey().intValue());
                    }
                    for (Map.Entry<Integer, Integer> entry3 : f18574j.entrySet()) {
                        m19441c(cursorM19497a, entry3.getValue().intValue(), c5093p, entry3.getKey().intValue());
                    }
                    for (Map.Entry<Integer, Integer> entry4 : f18575k.entrySet()) {
                        m19442d(cursorM19497a, entry4.getValue().intValue(), c5093p, entry4.getKey().intValue());
                    }
                    if (id == -1) {
                        throw new C5111c("Error! ID of the message: -1.");
                    }
                    String authority = uri.getAuthority();
                    boolean z = authority != null && authority.equals(C4012bp.f14467c);
                    m19431a(id, c5093p, z);
                    int iM19368a = c5093p.m19368a(140);
                    C5086i c5086i = new C5086i();
                    if ((iM19368a == 132 || iM19368a == 128) && (c5094qArrM19437a = m19437a(id, z)) != null) {
                        for (C5094q c5094q : c5094qArrM19437a) {
                            c5086i.m19332a(c5094q);
                        }
                    }
                    Log.w("PluginPduPersister", "###msgType : " + iM19368a);
                    switch (iM19368a) {
                        case 128:
                            c5100w = new C5103z(c5093p, c5086i);
                            break;
                        case 129:
                        case 137:
                        case 138:
                        case 139:
                        case 140:
                        case 141:
                        case 142:
                        case 143:
                        case 144:
                        case 145:
                        case 146:
                        case 147:
                        case 148:
                        case 149:
                        case 150:
                        case 151:
                            throw new C5111c("Unsupported PDU type: " + Integer.toHexString(iM19368a));
                        case 130:
                            c5100w = new C5084g(c5093p);
                            break;
                        case 131:
                            c5100w = new C5085h(c5093p);
                            break;
                        case 132:
                            c5100w = new C5101x(c5093p, c5086i);
                            break;
                        case 133:
                            c5100w = new C5078a(c5093p);
                            break;
                        case 134:
                            c5100w = new C5081d(c5093p);
                            break;
                        case 135:
                            c5100w = new C5100w(c5093p);
                            break;
                        case 136:
                            c5100w = new C5099v(c5093p);
                            break;
                        default:
                            throw new C5111c("Unrecognized PDU type: " + Integer.toHexString(iM19368a));
                    }
                    f18566b.mo19483a(uri, new C5109e(c5100w, i, j));
                    return c5100w;
                }
            } finally {
                if (cursorM19497a != null) {
                    cursorM19497a.close();
                }
            }
        }
        throw new C5111c("Bad uri: " + uri);
    }

    /* renamed from: a */
    private void m19429a(long j, int i, C5082e[] c5082eArr) {
        m19430a(j, i, c5082eArr, false);
    }

    /* renamed from: a */
    private void m19430a(long j, int i, C5082e[] c5082eArr, boolean z) {
        Uri uri;
        ContentValues contentValues = new ContentValues(3);
        for (C5082e c5082e : c5082eArr) {
            contentValues.clear();
            contentValues.put("address", m19428a(c5082e.m19307b()));
            contentValues.put("charset", Integer.valueOf(c5082e.m19304a()));
            contentValues.put("type", Integer.valueOf(i));
            if (z) {
                uri = Uri.parse("content://" + C4012bp.f14467c + "/" + j + "/spamaddr");
            } else {
                uri = Uri.parse("content://mms/" + j + "/addr");
            }
            C5110f.m19498a(this.f18581q, this.f18582r, uri, contentValues);
        }
    }

    /* renamed from: a */
    public Uri m19445a(C5094q c5094q, long j) {
        return m19446a(c5094q, j, false);
    }

    /* renamed from: a */
    public Uri m19446a(C5094q c5094q, long j, boolean z) throws Throwable {
        Uri uri;
        if (z) {
            uri = Uri.parse("content://" + C4012bp.f14467c + "/" + j + "/spampart");
        } else {
            uri = Uri.parse("content://mms/" + j + "/part");
        }
        ContentValues contentValues = new ContentValues(8);
        int iM19387d = c5094q.m19387d();
        if (iM19387d != 0) {
            contentValues.put("chset", Integer.valueOf(iM19387d));
        }
        if (c5094q.m19394g() != null) {
            String strM19428a = m19428a(c5094q.m19394g());
            String str = "image/jpg".equals(strM19428a) ? "image/jpeg" : strM19428a;
            contentValues.put("ct", str);
            if ("application/smil".equals(str)) {
                contentValues.put("seq", (Integer) (-1));
            }
            if (c5094q.m19398j() != null) {
                contentValues.put("fn", new String(c5094q.m19398j()));
            }
            if (c5094q.m19397i() != null) {
                contentValues.put("name", new String(c5094q.m19397i()));
            }
            if (c5094q.m19392f() != null) {
                contentValues.put("cd", m19428a(c5094q.m19392f()));
            }
            if (c5094q.m19386c() != null) {
                contentValues.put("cid", m19428a(c5094q.m19386c()));
            }
            if (c5094q.m19390e() != null) {
                contentValues.put("cl", m19428a(c5094q.m19390e()));
            }
            Uri uriM19498a = C5110f.m19498a(this.f18581q, this.f18582r, uri, contentValues);
            if (uriM19498a == null) {
                throw new C5111c("Failed to persist part, return null.");
            }
            m19435a(c5094q, uriM19498a, str, z);
            c5094q.m19380a(uriM19498a);
            return uriM19498a;
        }
        throw new C5111c("MIME type of the part must be set.");
    }

    /* renamed from: a */
    private void m19434a(C5094q c5094q, Uri uri, String str) throws Throwable {
        m19435a(c5094q, uri, str, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:78:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.InputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.InputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.StringBuilder] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m19435a(com.sec.google.android.p134a.p135a.C5094q r8, android.net.Uri r9, java.lang.String r10, boolean r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.google.android.p134a.p135a.C5097t.m19435a(com.sec.google.android.a.a.q, android.net.Uri, java.lang.String, boolean):void");
    }

    /* renamed from: b */
    private void m19438b(long j, int i, C5082e[] c5082eArr) {
        C5110f.m19496a(this.f18581q, this.f18582r, Uri.parse("content://mms/" + j + "/addr"), "type=" + i, null);
        m19429a(j, i, c5082eArr);
    }

    /* renamed from: a */
    public void m19451a(Uri uri, C5103z c5103z) {
        C5082e[] c5082eArrM19377d;
        f18566b.mo19484b(uri);
        ContentValues contentValues = new ContentValues(10);
        byte[] bArrM19473f = c5103z.m19473f();
        if (bArrM19473f != null) {
            contentValues.put("ct_t", m19428a(bArrM19473f));
        }
        long jD = c5103z.m19316d();
        if (jD != -1) {
            contentValues.put("date", Long.valueOf(jD));
        }
        int iM19474i = c5103z.m19474i();
        if (iM19474i != 0) {
            contentValues.put("d_rpt", Integer.valueOf(iM19474i));
        }
        long jM19480o = c5103z.m19480o();
        if (jM19480o != -1) {
            contentValues.put("d_tm", Long.valueOf(jM19480o));
        }
        long jM19475j = c5103z.m19475j();
        if (jM19475j != -1) {
            contentValues.put("exp", Long.valueOf(jM19475j));
        }
        byte[] bArrM19477l = c5103z.m19477l();
        if (bArrM19477l != null) {
            contentValues.put("m_cls", m19428a(bArrM19477l));
        }
        int iC = c5103z.m19315c();
        if (iC != 0) {
            contentValues.put("pri", Integer.valueOf(iC));
        }
        int iM19478m = c5103z.m19478m();
        if (iM19478m != 0) {
            contentValues.put("rr", Integer.valueOf(iM19478m));
        }
        byte[] bArrM19479n = c5103z.m19479n();
        if (bArrM19479n != null) {
            contentValues.put("tr_id", m19428a(bArrM19479n));
        }
        C5082e c5082eB = c5103z.mo19314b();
        if (c5082eB != null) {
            contentValues.put("sub", new C5082e(c5082eB.m19307b()).m19308c());
            contentValues.put("sub_cs", Integer.valueOf(c5082eB.m19304a()));
        } else {
            contentValues.put("sub", "");
        }
        long jM19476k = c5103z.m19476k();
        if (jM19476k > 0) {
            contentValues.put("m_size", Long.valueOf(jM19476k));
        }
        C5093p c5093pG = c5103z.m19402g();
        HashSet hashSet = new HashSet();
        for (int i : f18567c) {
            C5082e[] c5082eArr = null;
            if (i == 137) {
                C5082e c5082eM19376c = c5093pG.m19376c(i);
                if (c5082eM19376c != null) {
                    c5082eArr = new C5082e[]{c5082eM19376c};
                }
                c5082eArrM19377d = c5082eArr;
            } else {
                c5082eArrM19377d = c5093pG.m19377d(i);
            }
            if (c5082eArrM19377d != null) {
                m19438b(ContentUris.parseId(uri), i, c5082eArrM19377d);
                if (i == 151) {
                    for (C5082e c5082e : c5082eArrM19377d) {
                        if (c5082e != null) {
                            hashSet.add(c5082e.m19308c());
                        }
                    }
                }
            }
        }
        contentValues.put("thread_id", Long.valueOf(Telephony.Threads.getOrCreateThreadId(this.f18581q, hashSet)));
        if (c5103z.mo19317e() != -1) {
        }
        C5110f.m19495a(this.f18581q, this.f18582r, uri, contentValues, null, null);
    }

    /* renamed from: a */
    private void m19433a(Uri uri, C5094q c5094q) throws Throwable {
        ContentValues contentValues = new ContentValues(7);
        int iM19387d = c5094q.m19387d();
        if (iM19387d != 0) {
            contentValues.put("chset", Integer.valueOf(iM19387d));
        }
        if (c5094q.m19394g() != null) {
            String strM19428a = m19428a(c5094q.m19394g());
            contentValues.put("ct", strM19428a);
            if (c5094q.m19398j() != null) {
                contentValues.put("fn", new String(c5094q.m19398j()));
            }
            if (c5094q.m19397i() != null) {
                contentValues.put("name", new String(c5094q.m19397i()));
            }
            if (c5094q.m19392f() != null) {
                contentValues.put("cd", m19428a(c5094q.m19392f()));
            }
            if (c5094q.m19386c() != null) {
                contentValues.put("cid", m19428a(c5094q.m19386c()));
            }
            if (c5094q.m19390e() != null) {
                contentValues.put("cl", m19428a(c5094q.m19390e()));
            }
            C5110f.m19495a(this.f18581q, this.f18582r, uri, contentValues, null, null);
            if (c5094q.m19382a() != null || uri != c5094q.m19383b()) {
                m19434a(c5094q, uri, strM19428a);
                return;
            }
            return;
        }
        throw new C5111c("MIME type of the part must be set.");
    }

    /* renamed from: a */
    public void m19450a(Uri uri, C5086i c5086i) {
        C5109e c5109eA = f18566b.m19481a((C5108d) uri);
        if (c5109eA != null) {
            ((C5083f) c5109eA.m19492a()).m19312a(c5086i);
        }
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        int iM19333b = c5086i.m19333b();
        StringBuilder sbAppend = new StringBuilder().append('(');
        for (int i = 0; i < iM19333b; i++) {
            C5094q c5094qM19328a = c5086i.m19328a(i);
            Uri uriM19383b = c5094qM19328a.m19383b();
            if (uriM19383b == null || uriM19383b.getAuthority() == null || !uriM19383b.getAuthority().startsWith("mms")) {
                arrayList.add(c5094qM19328a);
            } else {
                map.put(uriM19383b, c5094qM19328a);
                if (sbAppend.length() > 1) {
                    sbAppend.append(" AND ");
                }
                sbAppend.append("_id");
                sbAppend.append("!=");
                DatabaseUtils.appendEscapedSQLString(sbAppend, uriM19383b.getLastPathSegment());
            }
        }
        sbAppend.append(')');
        long id = ContentUris.parseId(uri);
        C5110f.m19496a(this.f18581q, this.f18582r, Uri.parse(Telephony.Mms.CONTENT_URI + "/" + id + "/part"), sbAppend.length() > 2 ? sbAppend.toString() : null, null);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m19445a((C5094q) it.next(), id);
        }
        for (Map.Entry entry : map.entrySet()) {
            m19433a((Uri) entry.getKey(), (C5094q) entry.getValue());
        }
    }

    /* renamed from: a */
    public Uri m19447a(C5095r c5095r, Uri uri) {
        return m19448a(c5095r, uri, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:95:0x02e2  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.net.Uri m19448a(com.sec.google.android.p134a.p135a.C5095r r15, android.net.Uri r16, boolean r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 756
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.google.android.p134a.p135a.C5097t.m19448a(com.sec.google.android.a.a.r, android.net.Uri, boolean):android.net.Uri");
    }

    /* renamed from: a */
    public Uri m19444a(Uri uri, Uri uri2) {
        long id = ContentUris.parseId(uri);
        if (id == -1) {
            throw new C5111c("Error! ID of the message: -1.");
        }
        Integer num = f18570f.get(uri2);
        if (num == null) {
            throw new C5111c("Bad destination, must be one of content://mms/inbox, content://mms/sent, content://mms/drafts, content://mms/outbox, content://mms/temp.");
        }
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("msg_box", num);
        C5110f.m19495a(this.f18581q, this.f18582r, uri, contentValues, null, null);
        return ContentUris.withAppendedId(uri2, id);
    }

    /* renamed from: a */
    public static String m19428a(byte[] bArr) {
        try {
            return new String(bArr, "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            Log.e("PluginPduPersister", "ISO_8859_1 must be supported!", e);
            return "";
        }
    }

    /* renamed from: a */
    public static byte[] m19436a(String str) {
        try {
            return str.getBytes("iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            Log.e("PluginPduPersister", "ISO_8859_1 must be supported!", e);
            return new byte[0];
        }
    }

    /* renamed from: a */
    public Cursor m19443a(long j) {
        Uri.Builder builderBuildUpon = Telephony.MmsSms.PendingMessages.CONTENT_URI.buildUpon();
        builderBuildUpon.appendQueryParameter("protocol", "mms");
        return C5110f.m19497a(this.f18581q, this.f18582r, builderBuildUpon.build(), null, C3847e.m14652aC() ? "err_type < ? AND due_time <= ? AND err_type >= " + String.valueOf(0) : "err_type < ? AND due_time <= ?", new String[]{String.valueOf(10), String.valueOf(j)}, "due_time");
    }
}
