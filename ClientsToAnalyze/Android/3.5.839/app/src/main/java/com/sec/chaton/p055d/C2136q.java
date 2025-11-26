package com.sec.chaton.p055d;

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C2684ab;
import com.sec.chaton.msgsend.EnumC2706n;
import com.sec.chaton.p055d.p056a.C1998dq;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p065io.entry.ApplinkMsgEntry;
import com.sec.chaton.p067j.p070c.C2438e;
import com.sec.chaton.p067j.p070c.RunnableC2440g;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.chaton.specialbuddy.C4542g;
import com.sec.chaton.util.C4843bh;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import org.json.JSONException;

/* compiled from: LiveChatMessageControl.java */
/* renamed from: com.sec.chaton.d.q */
/* loaded from: classes.dex */
public class C2136q extends AbstractC2070ac {

    /* renamed from: a */
    private static final String f7739a = C2136q.class.getSimpleName();

    /* renamed from: b */
    private static HashMap<String, C2136q> f7740b = new HashMap<>();

    /* renamed from: h */
    private static HandlerThread f7741h = null;

    /* renamed from: j */
    private static Handler f7742j = new HandlerC2138s(m9584b().getLooper());

    /* renamed from: i */
    private Handler f7743i;

    /* renamed from: a */
    public static synchronized C2136q m9582a(String str, EnumC2300t enumC2300t) {
        C2136q c2136q;
        if (!f7740b.containsKey(str)) {
            c2136q = new C2136q(str, enumC2300t);
            f7740b.put(str, c2136q);
        } else {
            c2136q = f7740b.get(str);
            c2136q.f7551c = str;
            c2136q.f7553e = str;
            c2136q.f7552d = enumC2300t;
        }
        return c2136q;
    }

    /* renamed from: a */
    public static void m9583a() {
        if (f7741h == null) {
            f7741h = new HandlerThread(f7739a);
            f7741h.start();
        } else if (!f7741h.isAlive()) {
            f7741h.start();
        }
    }

    /* renamed from: b */
    public static HandlerThread m9584b() {
        m9583a();
        return f7741h;
    }

    public C2136q(String str, EnumC2300t enumC2300t) {
        super(str, enumC2300t);
        this.f7743i = new HandlerC2137r(this, m9584b().getLooper());
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public boolean mo9245a(long j, String str, String str2, String str3, EnumC2214ab enumC2214ab, String str4, int i, String[] strArr) {
        File file;
        String str5;
        String strNextToken = "";
        String str6 = this.f7551c;
        if (enumC2214ab == EnumC2214ab.TEXT || enumC2214ab == EnumC2214ab.GEO || enumC2214ab == EnumC2214ab.ANICON || enumC2214ab == EnumC2214ab.POLL || enumC2214ab == EnumC2214ab.APPLINK || enumC2214ab == EnumC2214ab.LIVERECOMMEND || enumC2214ab == EnumC2214ab.LIVESHARE || enumC2214ab == EnumC2214ab.LIVECONTENTS) {
            file = null;
            str5 = "";
        } else {
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            File file2 = new File(Uri.parse(str3).getPath());
            StringTokenizer stringTokenizer = new StringTokenizer(str3, ".");
            while (stringTokenizer.hasMoreTokens()) {
                strNextToken = stringTokenizer.nextToken();
            }
            file = file2;
            str5 = "." + strNextToken.toUpperCase();
        }
        if (enumC2214ab == EnumC2214ab.TEXT || enumC2214ab == EnumC2214ab.LIVERECOMMEND || enumC2214ab == EnumC2214ab.LIVESHARE || enumC2214ab == EnumC2214ab.LIVECONTENTS) {
            m9214a(j, str6, enumC2214ab, this.f7552d, (String) null, strArr, str, false);
        } else if (enumC2214ab == EnumC2214ab.GEO) {
            m9206a(j, this.f7552d, (String) null, strArr, false, str);
        } else if (enumC2214ab == EnumC2214ab.ANICON) {
            String[] strArr2 = new String[0];
            String[] strArrSplit = str.split("\n");
            String strM13781c = C3460d.m13781c(strArrSplit[2]);
            if (strArrSplit.length > 6 && "mixed".equals(strArrSplit[0])) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 6; i2 < strArrSplit.length; i2++) {
                    stringBuffer.append(strArrSplit[i2] + "\n");
                }
                m9269c(j, this.f7552d, null, strArr, false, strM13781c, -1L, stringBuffer.toString().substring(0, stringBuffer.length() - 1));
            } else {
                m9269c(j, this.f7552d, null, strArr, false, strM13781c, -1L, null);
            }
        } else if (enumC2214ab == EnumC2214ab.APPLINK) {
            m9254b(j, this.f7552d, (String) null, strArr, str);
        } else if (enumC2214ab == EnumC2214ab.POLL) {
            m9204a(j, this.f7552d, (String) null, strArr, str);
        } else {
            boolean z = false;
            if (i == 1 && C1998dq.m9146a(str)) {
                z = true;
            }
            if (z) {
                m9202a(j, this.f7552d, str, (String) null, strArr, false, str4, str5, enumC2214ab);
            } else {
                if (file == null) {
                    return false;
                }
                String strSubstring = null;
                if (str != null) {
                    String[] strArrSplit2 = str.split("\n");
                    if (strArrSplit2.length > 6) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        for (int i3 = 6; i3 < strArrSplit2.length; i3++) {
                            stringBuffer2.append(strArrSplit2[i3] + "\n");
                        }
                        strSubstring = stringBuffer2.toString().substring(0, stringBuffer2.length() - 1);
                    }
                }
                m9212a(j, file, (String) null, enumC2214ab, this.f7552d, (String) null, strArr, false, str4, strSubstring);
            }
        }
        return true;
    }

    /* renamed from: a */
    public long m9586a(long j, EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, File file, String str3, String str4, EnumC2214ab enumC2214ab, String str5, EnumC2706n enumC2706n) {
        C1998dq c1998dq = new C1998dq(null, this.f7551c, j, str3, enumC2214ab, enumC2300t, str, strArr, str4, z, str2, str5, enumC2706n);
        c1998dq.m9148e();
        return m9585a(j, enumC2214ab, strArr[0], c1998dq.m9147d(), this.f7551c);
    }

    /* renamed from: a */
    public long m9585a(long j, EnumC2214ab enumC2214ab, String str, String str2, String str3) {
        return C2140u.m9589b(this.f7743i, str3, enumC2214ab, str, str2, j);
    }

    /* renamed from: a */
    private long m9581a(long j, File file, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, String str3, String str4, String str5, EnumC2706n enumC2706n) {
        C2438e.m10572a().m10575a(f7742j, null, file, j, this.f7551c, enumC2300t, enumC2214ab, str, strArr, str3, true, str4, str5, enumC2706n);
        return j;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9221a(EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, long j, EnumC2706n enumC2706n) {
        if (strArr == null || strArr.length <= 0) {
            return -1L;
        }
        String str4 = strArr[0];
        String str5 = !TextUtils.isEmpty(str3) ? str3 : str2;
        C4904y.m18639b("requestSendMessage", getClass().getSimpleName());
        long jM18322a = C4843bh.m18322a();
        C2204r.m10016a(GlobalApplication.m18732r().getContentResolver(), String.valueOf(jM18322a), this.f7551c, enumC2214ab, str2, str3, 0, 0);
        return m9585a(jM18322a, enumC2214ab, str4, str5, this.f7551c);
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9222a(EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, long j, EnumC2706n enumC2706n, String str4, String str5) {
        if (strArr == null || strArr.length <= 0) {
            return -1L;
        }
        String str6 = strArr[0];
        String str7 = !TextUtils.isEmpty(str3) ? str3 : str2;
        C4904y.m18639b("requestSendMessage", getClass().getSimpleName());
        long jM18322a = C4843bh.m18322a();
        C2204r.m10017a(GlobalApplication.m18732r().getContentResolver(), String.valueOf(jM18322a), this.f7551c, enumC2214ab, str2, str3, 0, 0, str4, str5);
        return m9585a(jM18322a, enumC2214ab, str6, str7, this.f7551c);
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9229a(EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, long j, EnumC2706n enumC2706n) {
        if (TextUtils.isEmpty(str2) || strArr == null) {
            if (C4904y.f17872b) {
                C4904y.m18634a("chatMsg is null or recipients is null", f7739a);
            }
            return -1L;
        }
        try {
            return m9259b(EnumC2214ab.APPLINK, enumC2300t, str, strArr, ApplinkMsgEntry.createJson(str2, str3).toString(), (String) null, j, enumC2706n);
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f7739a);
            }
            return -1L;
        }
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: b */
    public long mo9262b(EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, long j, EnumC2706n enumC2706n) throws JSONException {
        if (TextUtils.isEmpty(str2) || strArr == null) {
            if (C4904y.f17872b) {
                C4904y.m18634a("requestSendLiveShare(), chatMsg is null or recipients is null", f7739a);
            }
            return -1L;
        }
        String strM17236b = C4542g.m17236b(str2);
        if (TextUtils.isEmpty(strM17236b)) {
            C4904y.m18634a("requestSendLiveShare(), failed in converting chat msg : " + str2, f7739a);
            return -1L;
        }
        return m9259b(EnumC2214ab.LIVESHARE, enumC2300t, str, strArr, strM17236b, (String) null, j, enumC2706n);
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: c */
    public long mo9271c(EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, long j, EnumC2706n enumC2706n) throws JSONException {
        if (TextUtils.isEmpty(str2) || strArr == null) {
            if (C4904y.f17872b) {
                C4904y.m18634a("requestSendLiveRecommend(), chatMsg is null or recipients is null", f7739a);
            }
            return -1L;
        }
        String strM17241f = C4542g.m17241f(str2);
        if (TextUtils.isEmpty(strM17241f)) {
            C4904y.m18634a("requestSendLiveRecommend(), failed in converting chat msg : " + str2, f7739a);
            return -1L;
        }
        return m9259b(EnumC2214ab.LIVERECOMMEND, enumC2300t, str, strArr, strM17241f, (String) null, j, enumC2706n);
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9219a(EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str, String[] strArr, String str2, long j, EnumC2706n enumC2706n) {
        if (C4904y.f17872b) {
            C4904y.m18639b("requestSendMediaChatImpl(), not_supported_method", f7739a);
            return -1L;
        }
        return -1L;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9231a(EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j, String str3, EnumC2706n enumC2706n) {
        if (C4904y.f17872b) {
            C4904y.m18639b("ownRequestSendGeoTag(), not_supported_method", f7739a);
            return -1L;
        }
        return -1L;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9238a(File file, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, boolean z, String str3, String str4, String str5, EnumC2706n enumC2706n, String str6, String str7) throws Throwable {
        long jM18322a = C4843bh.m18322a();
        String strDecode = Uri.decode(Uri.fromFile(file).toString());
        String strM10587a = RunnableC2440g.m10587a(file, enumC2214ab);
        if (strM10587a == null) {
            C2684ab.m11290a(f7739a, "requestSendFile(), FILE Extention : forced to be '%s' with parameter", str);
        } else {
            str = strM10587a;
        }
        if (!C4894o.m18609a(enumC2214ab, str) || file.length() > 31457280) {
            C2684ab.m11290a(f7739a, "requestSendFile(), not support ext. or excess limited size", new Object[0]);
            return -1L;
        }
        String strM18603a = null;
        if (C4873ck.m18500a()) {
            String str8 = GlobalApplication.m18732r().getExternalFilesDir(null).getAbsolutePath() + "/" + this.f7551c;
            if (!file.getAbsolutePath().contains(str8)) {
                String strValueOf = String.valueOf(System.currentTimeMillis());
                String strSubstring = "";
                if (file.getName().indexOf(".") > -1) {
                    strSubstring = file.getName().substring(file.getName().lastIndexOf("."));
                } else if (str != null) {
                    strSubstring = "." + str;
                }
                strM18603a = C4894o.m18603a(file.getAbsolutePath(), str8, strValueOf + strSubstring);
            }
        }
        if (strM18603a != null) {
            file = new File(Uri.parse(strM18603a).getPath());
        } else {
            strM18603a = strDecode;
        }
        if (TextUtils.isEmpty(strM18603a)) {
            C2684ab.m11290a(f7739a, "requestSendFile(), invalid Local File URI", new Object[0]);
            return -1L;
        }
        String str9 = "\n\n\n\n\n\n";
        if (!TextUtils.isEmpty(str4)) {
            str9 = "mixed\n\n\n\n\n\n" + str4;
        }
        C2204r.m10015a(GlobalApplication.m18732r().getContentResolver(), String.valueOf(jM18322a), this.f7551c, enumC2214ab, strM18603a, 0, str9, 0, str5, str6, str7);
        String strM18613b = enumC2214ab == EnumC2214ab.AUDIO ? C4894o.m18613b(strM18603a) : str3;
        switch (enumC2214ab) {
            case AUDIO:
            case CALENDAR:
            case CONTACT:
            case DOCUMENT:
            case FILE:
                if (TextUtils.isEmpty(strM18613b)) {
                    return -1L;
                }
                C2204r.m10030a(GlobalApplication.m18732r().getContentResolver(), this.f7551c, Long.valueOf(jM18322a), strM18613b);
                break;
        }
        return m9581a(jM18322a, file, str, enumC2214ab, enumC2300t, str2, strArr, strM18613b, str4, str5, enumC2706n);
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public boolean mo9251a(File file, boolean z, String str, String str2, String str3, EnumC2214ab enumC2214ab, ArrayList<String> arrayList, EnumC2706n enumC2706n) throws Throwable {
        String string;
        String strM18603a = C4894o.m18603a(file.getAbsolutePath(), GlobalApplication.m10279a().getExternalFilesDir(null).getAbsolutePath() + "/" + this.f7551c, file.getName());
        Long lValueOf = Long.valueOf(C4843bh.m18322a());
        String[] strArrSplit = str.split("\n");
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        int length = strArrSplit.length;
        if (length < 5) {
            C2684ab.m11290a(f7739a, "requestSendMediaChatForward(), token length is too short (%d)", Integer.valueOf(length));
            return false;
        }
        String str4 = length > 5 ? strArrSplit[5] : null;
        String str5 = strArrSplit[2] + "\n" + strArrSplit[3] + "\n" + strArrSplit[4];
        if (str3 != null) {
            StringBuilder sb = new StringBuilder();
            if (length == 5) {
                for (int i = 0; i < 5; i++) {
                    sb.append(strArrSplit[i] + "\n");
                }
                sb.append("\n");
            } else {
                for (int i2 = 0; i2 < 6; i2++) {
                    sb.append(strArrSplit[i2] + "\n");
                }
            }
            sb.append(str3 + "\n");
            string = sb.toString();
        } else {
            string = str;
        }
        C2204r.m10014a(GlobalApplication.m18732r().getContentResolver(), String.valueOf(lValueOf), this.f7551c, enumC2214ab, strM18603a, 0, string, 0, null);
        C2204r.m10055d(GlobalApplication.m18732r().getContentResolver(), lValueOf);
        if (enumC2214ab == EnumC2214ab.CONTACT || enumC2214ab == EnumC2214ab.CALENDAR || enumC2214ab == EnumC2214ab.DOCUMENT || enumC2214ab == EnumC2214ab.FILE) {
            C2204r.m10030a(GlobalApplication.m18732r().getContentResolver(), this.f7551c, lValueOf, str4);
        }
        m9586a(lValueOf.longValue(), this.f7552d, (String) null, strArr, z, str4, file, str2, str5, enumC2214ab, str3, enumC2706n);
        return true;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9232a(EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j, String str3, String str4, EnumC2706n enumC2706n, String str5, String str6) {
        if (C4904y.f17872b) {
            C4904y.m18639b("ownRequestSendAniconChat(), not_supported_method", f7739a);
            return -1L;
        }
        return -1L;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9208a(long j, EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j2, EnumC2706n enumC2706n) {
        if (C4904y.f17872b) {
            C4904y.m18639b("ownReSendGeoTag(), not_supported_method", f7739a);
            return -1L;
        }
        return -1L;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9216a(long j, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, String str3, boolean z, long j2, EnumC2706n enumC2706n) {
        if (C4904y.f17872b) {
            C4904y.m18639b("reSend", getClass().getSimpleName());
        }
        C2204r.m10056e(CommonApplication.m18732r().getContentResolver(), Long.valueOf(j));
        if (strArr != null && strArr.length > 0) {
            return m9585a(j, enumC2214ab, strArr[0], str3, this.f7551c);
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("reSendImpl(), error!! receiver is null or empty.", f7739a);
        }
        return -1L;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9213a(long j, File file, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, boolean z, String str3, String str4, String str5, EnumC2706n enumC2706n) {
        C2438e.m10572a().m10575a(f7742j, str2, file, j, this.f7551c, enumC2300t, enumC2214ab, str, strArr, str3, true, str4, str5, enumC2706n);
        return j;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9203a(long j, EnumC2300t enumC2300t, String str, String str2, String[] strArr, boolean z, String str3, String str4, EnumC2214ab enumC2214ab, EnumC2706n enumC2706n) {
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("\n");
            String strSubstring = null;
            if (strArrSplit.length > 6) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 6; i < strArrSplit.length; i++) {
                    stringBuffer.append(strArrSplit[i] + "\n");
                }
                strSubstring = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
            }
            if (strArrSplit.length > 4) {
                C2204r.m10056e(CommonApplication.m18732r().getContentResolver(), Long.valueOf(j));
                return m9586a(j, this.f7552d, (String) null, strArr, z, str3, (File) null, str4, strArrSplit[2] + "\n" + strArrSplit[3] + "\n" + strArrSplit[4], enumC2214ab, strSubstring, enumC2706n);
            }
        }
        return -1L;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9209a(long j, EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j2, String str3) {
        if (C4904y.f17872b) {
            C4904y.m18639b("ownRequestSendGeoTag(), not_supported_method", f7739a);
            return -1L;
        }
        return -1L;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public void mo9243a(long j) {
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9227a(EnumC2300t enumC2300t, String str) {
        return 0L;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public void mo9244a(String str) {
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: b */
    public void mo9266b(long j) {
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: c */
    public boolean mo9272c() {
        return false;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9226a(EnumC2214ab enumC2214ab, String str, String[] strArr, String[] strArr2) {
        return 0L;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9241a(String str, String[] strArr, String[] strArr2, boolean z) {
        return 0L;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: d */
    public void mo9274d() {
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public boolean mo9252a(String str, String str2, int i) {
        return false;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: e */
    public boolean mo9276e() {
        return true;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: f */
    public void mo9278f() {
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9240a(String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String[] strArr, String str2, String str3) {
        return 0L;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public boolean mo9248a(EnumC2300t enumC2300t, String str, Long l, String str2, String str3, long j, boolean z) {
        return false;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public boolean mo9247a(EnumC2300t enumC2300t, String str, Long l, String str2, String str3, long j) {
        return false;
    }
}
