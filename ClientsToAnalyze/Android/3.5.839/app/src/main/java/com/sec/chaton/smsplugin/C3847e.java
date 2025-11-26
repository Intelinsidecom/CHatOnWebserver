package com.sec.chaton.smsplugin;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.SystemProperties;
import android.preference.PreferenceManager;
import android.provider.Telephony;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p061g.C2346e;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p102b.C3790i;
import com.sec.chaton.smsplugin.p108e.C3848a;
import com.sec.chaton.smsplugin.p109f.C3852b;
import com.sec.chaton.smsplugin.p111h.C3876aa;
import com.sec.chaton.smsplugin.p111h.C3881d;
import com.sec.chaton.smsplugin.p111h.C3887j;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.smsplugin.p111h.C3898u;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.chaton.smsplugin.spam.C4015bs;
import com.sec.chaton.smsplugin.transaction.MessagingNotification;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import com.sec.widget.C5179v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: MmsConfig.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.e */
/* loaded from: classes.dex */
public class C3847e {

    /* renamed from: f */
    private static boolean f13823f = false;

    /* renamed from: a */
    public static final Boolean f13776a = true;

    /* renamed from: b */
    public static final Boolean f13819b = true;

    /* renamed from: g */
    private static final Boolean f13824g = true;

    /* renamed from: h */
    private static final Boolean f13825h = true;

    /* renamed from: i */
    private static final Boolean f13826i = true;

    /* renamed from: j */
    private static final Boolean f13827j = true;

    /* renamed from: k */
    private static final Boolean f13828k = true;

    /* renamed from: l */
    private static final Boolean f13829l = true;

    /* renamed from: m */
    private static final Boolean f13830m = true;

    /* renamed from: n */
    private static final Boolean f13831n = true;

    /* renamed from: o */
    private static final Boolean f13832o = true;

    /* renamed from: p */
    private static final Boolean f13833p = true;

    /* renamed from: c */
    public static boolean f13820c = false;

    /* renamed from: q */
    private static boolean f13834q = false;

    /* renamed from: r */
    private static int f13835r = 1;

    /* renamed from: s */
    private static int f13836s = 307200;

    /* renamed from: t */
    private static String f13837t = "Android-Mms/2.0";

    /* renamed from: u */
    private static String f13838u = "x-wap-profile";

    /* renamed from: v */
    private static String f13839v = null;

    /* renamed from: w */
    private static String f13840w = null;

    /* renamed from: x */
    private static String f13841x = null;

    /* renamed from: y */
    private static String f13842y = null;

    /* renamed from: z */
    private static int f13843z = 480;

    /* renamed from: A */
    private static int f13750A = 640;

    /* renamed from: B */
    private static int f13751B = Integer.MAX_VALUE;

    /* renamed from: C */
    private static int f13752C = 500;

    /* renamed from: D */
    private static int f13753D = 200;

    /* renamed from: E */
    private static int f13754E = 2;

    /* renamed from: F */
    private static int f13755F = 5000;

    /* renamed from: G */
    private static int f13756G = 60000;

    /* renamed from: H */
    private static int f13757H = 7;

    /* renamed from: I */
    private static boolean f13758I = false;

    /* renamed from: J */
    private static boolean f13759J = true;

    /* renamed from: K */
    private static int f13760K = 4;

    /* renamed from: L */
    private static boolean f13761L = true;

    /* renamed from: M */
    private static boolean f13762M = true;

    /* renamed from: N */
    private static boolean f13763N = false;

    /* renamed from: O */
    private static boolean f13764O = true;

    /* renamed from: P */
    private static boolean f13765P = false;

    /* renamed from: Q */
    private static boolean f13766Q = true;

    /* renamed from: R */
    private static boolean f13767R = false;

    /* renamed from: S */
    private static boolean f13768S = false;

    /* renamed from: T */
    private static int f13769T = -1;

    /* renamed from: U */
    private static int f13770U = 4;

    /* renamed from: V */
    private static boolean f13771V = false;

    /* renamed from: W */
    private static int f13772W = 2;

    /* renamed from: X */
    private static int f13773X = 48;

    /* renamed from: Y */
    private static int f13774Y = 40;

    /* renamed from: Z */
    private static boolean f13775Z = false;

    /* renamed from: aa */
    private static int f13793aa = 10;

    /* renamed from: ab */
    private static int f13794ab = 10;

    /* renamed from: ac */
    private static boolean f13795ac = false;

    /* renamed from: ad */
    private static boolean f13796ad = false;

    /* renamed from: ae */
    private static String f13797ae = "ASCII";

    /* renamed from: af */
    private static boolean f13798af = false;

    /* renamed from: ag */
    private static boolean f13799ag = false;

    /* renamed from: ah */
    private static boolean f13800ah = false;

    /* renamed from: ai */
    private static int f13801ai = 5120;

    /* renamed from: aj */
    private static boolean f13802aj = false;

    /* renamed from: ak */
    private static boolean f13803ak = false;

    /* renamed from: al */
    private static int f13804al = 140;

    /* renamed from: am */
    private static boolean f13805am = true;

    /* renamed from: an */
    private static boolean f13806an = false;

    /* renamed from: ao */
    private static boolean f13807ao = false;

    /* renamed from: d */
    public static boolean f13821d = false;

    /* renamed from: ap */
    private static boolean f13808ap = true;

    /* renamed from: aq */
    private static volatile Boolean f13809aq = null;

    /* renamed from: ar */
    private static int f13810ar = 10;

    /* renamed from: as */
    private static volatile Boolean f13811as = null;

    /* renamed from: at */
    private static volatile Boolean f13812at = null;

    /* renamed from: au */
    private static volatile Boolean f13813au = null;

    /* renamed from: e */
    public static boolean f13822e = false;

    /* renamed from: av */
    private static boolean f13814av = false;

    /* renamed from: aw */
    private static boolean f13815aw = false;

    /* renamed from: ax */
    private static boolean f13816ax = false;

    /* renamed from: ay */
    private static boolean f13817ay = false;

    /* renamed from: az */
    private static String f13818az = "";

    /* renamed from: aA */
    private static boolean f13777aA = false;

    /* renamed from: aB */
    private static boolean f13778aB = false;

    /* renamed from: aC */
    private static boolean f13779aC = false;

    /* renamed from: aD */
    private static String f13780aD = "";

    /* renamed from: aE */
    private static String f13781aE = null;

    /* renamed from: aF */
    private static String f13782aF = "";

    /* renamed from: aG */
    private static String f13783aG = "";

    /* renamed from: aH */
    private static int f13784aH = 240000;

    /* renamed from: aI */
    private static boolean f13785aI = false;

    /* renamed from: aJ */
    private static long f13786aJ = -1;

    /* renamed from: aK */
    private static int f13787aK = -1;

    /* renamed from: aL */
    private static int f13788aL = 3;

    /* renamed from: aM */
    private static String f13789aM = null;

    /* renamed from: aN */
    private static String f13790aN = null;

    /* renamed from: aO */
    private static final Uri f13791aO = Telephony.Threads.CONTENT_URI.buildUpon().appendQueryParameter("simple", "true").build();

    /* renamed from: aP */
    private static ArrayList<String> f13792aP = new ArrayList<>();

    /* renamed from: a */
    public static void m14645a(Context context) throws Resources.NotFoundException {
        m14695b(context);
        if (!m14664aO()) {
            m14668aS();
        }
        C3892o.m15031e();
    }

    /* renamed from: a */
    public static int m14643a() {
        return f13760K;
    }

    /* renamed from: b */
    public static boolean m14696b() {
        return f13835r == 1;
    }

    /* renamed from: c */
    public static int m14697c() {
        return f13836s;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m14698d() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.C3847e.m14698d():java.lang.String");
    }

    /* renamed from: e */
    public static boolean m14699e() {
        return f13834q;
    }

    /* renamed from: f */
    public static String m14700f() {
        return f13837t;
    }

    /* renamed from: g */
    public static String m14701g() {
        return f13838u;
    }

    /* renamed from: h */
    public static String m14702h() {
        return f13839v;
    }

    /* renamed from: i */
    public static String m14703i() {
        return f13840w;
    }

    /* renamed from: j */
    public static String m14704j() {
        return f13841x;
    }

    /* renamed from: k */
    public static String m14705k() {
        return f13842y;
    }

    /* renamed from: l */
    public static int m14706l() {
        return C4149cd.m16426c() < C4149cd.m16430d() ? C4149cd.m16426c() : C4149cd.m16430d();
    }

    /* renamed from: m */
    public static int m14707m() {
        return C4149cd.m16426c() < C4149cd.m16430d() ? C4149cd.m16430d() : C4149cd.m16426c();
    }

    /* renamed from: n */
    public static int m14708n() {
        return f13751B;
    }

    /* renamed from: o */
    public static int m14709o() {
        if (f13769T > -1) {
            return f13769T;
        }
        return 2000;
    }

    /* renamed from: p */
    public static int m14710p() {
        return f13752C;
    }

    /* renamed from: q */
    public static int m14711q() {
        return f13753D;
    }

    /* renamed from: r */
    public static int m14712r() {
        return f13756G;
    }

    /* renamed from: s */
    public static int m14713s() {
        return f13757H;
    }

    /* renamed from: t */
    public static boolean m14714t() {
        return f13762M;
    }

    /* renamed from: u */
    public static boolean m14715u() {
        return f13758I;
    }

    /* renamed from: v */
    public static String m14716v() {
        return f13780aD;
    }

    /* renamed from: w */
    public static boolean m14717w() {
        return f13778aB;
    }

    /* renamed from: x */
    public static String m14718x() {
        return f13782aF;
    }

    /* renamed from: y */
    public static String m14719y() {
        return "";
    }

    /* renamed from: z */
    public static String m14720z() {
        return "";
    }

    /* renamed from: A */
    public static String m14617A() {
        return f13789aM;
    }

    /* renamed from: aQ */
    private static void m14666aQ() {
        try {
            f13781aE = SystemProperties.get("ril.cdma.usernai");
        } catch (Exception e) {
            C3890m.m14996b("MmsConfig", "setDefaultUserNai exception " + e);
        }
    }

    /* renamed from: B */
    public static String m14618B() {
        return "Proxy-Authorization";
    }

    /* renamed from: C */
    public static int m14619C() {
        return f13784aH;
    }

    /* renamed from: D */
    public static boolean m14620D() {
        return false;
    }

    /* renamed from: E */
    public static boolean m14621E() {
        return false;
    }

    /* renamed from: F */
    public static boolean m14622F() {
        if (!m14620D()) {
        }
        return false;
    }

    /* renamed from: G */
    public static boolean m14623G() {
        if (!m14622F()) {
        }
        return false;
    }

    /* renamed from: H */
    public static boolean m14624H() {
        return f13779aC;
    }

    /* renamed from: I */
    public static String m14625I() {
        return f13781aE;
    }

    /* renamed from: J */
    public static boolean m14626J() {
        return f13785aI;
    }

    /* renamed from: K */
    public static boolean m14627K() {
        if (f13809aq == null) {
            synchronized (C3847e.class) {
                if (f13809aq == null) {
                    if ("samsung".equalsIgnoreCase(SystemProperties.get("ro.product.manufacturer", ""))) {
                        f13809aq = true;
                    } else {
                        f13809aq = false;
                    }
                }
            }
        }
        return f13809aq.booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Boolean] */
    /* renamed from: L */
    public static boolean m14628L() {
        Throwable th;
        Cursor cursorQuery;
        Cursor cursor = null;
        if (f13811as == null) {
            synchronized (C3847e.class) {
                ?? r0 = f13811as;
                if (r0 == 0) {
                    try {
                        try {
                            cursorQuery = CommonApplication.m18732r().getContentResolver().query(Telephony.Threads.CONTENT_URI.buildUpon().appendQueryParameter("simple", "true").build(), new String[]{"unread_count"}, null, null, null);
                        } catch (SQLiteException e) {
                            cursorQuery = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                        try {
                            if (cursorQuery == null) {
                                throw new SQLiteException();
                            }
                            f13811as = true;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        } catch (SQLiteException e2) {
                            C3890m.m14994a("MmsConfig", "MMS/SMS provider does not have 'UNREAD_COUNT'");
                            f13811as = false;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return f13811as.booleanValue();
                        }
                    } catch (Throwable th3) {
                        cursor = r0;
                        th = th3;
                    }
                }
            }
        }
        return f13811as.booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: M */
    public static boolean m14629M() {
        Throwable th;
        Cursor cursorQuery;
        Cursor cursor = null;
        if (f13813au == null) {
            synchronized (C3847e.class) {
                if (f13813au == null) {
                    ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
                    try {
                    } catch (Throwable th2) {
                        cursor = contentResolver;
                        th = th2;
                    }
                    try {
                        try {
                            cursorQuery = contentResolver.query(Uri.parse("content://mms-sms/spam-filter"), new String[]{"_id", "filter_type", "enable", "filter", "criteria"}, null, null, "filter");
                        } catch (SQLiteException e) {
                            cursorQuery = null;
                        } catch (IllegalStateException e2) {
                        } catch (RuntimeException e3) {
                        }
                        try {
                        } catch (SQLiteException e4) {
                            C3890m.m14994a("MmsConfig", "MMS/SMS provider does not have native spam filter");
                            f13813au = false;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return f13813au.booleanValue();
                        } catch (IllegalStateException e5) {
                            cursor = cursorQuery;
                            C3890m.m14994a("MmsConfig", "MMS/SMS provider does not have native spam filter");
                            f13813au = false;
                            if (cursor != null) {
                                cursor.close();
                            }
                            return f13813au.booleanValue();
                        } catch (RuntimeException e6) {
                            cursor = cursorQuery;
                            C3890m.m14994a("MmsConfig", "MMS/SMS provider does not have native spam filter");
                            f13813au = false;
                            if (cursor != null) {
                                cursor.close();
                            }
                            return f13813au.booleanValue();
                        }
                        if (cursorQuery == null) {
                            throw new SQLiteException();
                        }
                        C3890m.m14994a("MmsConfig", "MMS/SMS provider does have native spam filter");
                        f13813au = true;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            }
        }
        return f13813au.booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Boolean] */
    /* renamed from: aR */
    private static boolean m14667aR() {
        Throwable th;
        Cursor cursorQuery;
        Cursor cursor = null;
        if (f13812at == null) {
            synchronized (C3847e.class) {
                ?? r0 = f13812at;
                if (r0 == 0) {
                    try {
                        try {
                            cursorQuery = CommonApplication.m18732r().getContentResolver().query(Telephony.Sms.CONTENT_URI, new String[]{"hidden", VKApiConst.GROUP_ID, "group_type"}, null, null, null);
                        } catch (SQLiteException e) {
                            cursorQuery = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                        try {
                            if (cursorQuery == null) {
                                throw new SQLiteException();
                            }
                            f13812at = true;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        } catch (SQLiteException e2) {
                            C3890m.m14994a("MmsConfig", "MMS/SMS provider does not have 'group_id'");
                            f13812at = false;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return f13812at.booleanValue();
                        }
                    } catch (Throwable th3) {
                        cursor = r0;
                        th = th3;
                    }
                }
            }
        }
        return f13812at.booleanValue();
    }

    /* renamed from: N */
    public static int m14630N() {
        return f13770U;
    }

    /* renamed from: O */
    public static boolean m14631O() {
        return f13771V;
    }

    /* renamed from: P */
    public static int m14632P() {
        return f13772W;
    }

    /* renamed from: Q */
    public static int m14633Q() {
        return f13773X;
    }

    /* renamed from: R */
    public static boolean m14634R() {
        return f13759J;
    }

    /* renamed from: S */
    public static int m14635S() {
        return f13774Y;
    }

    /* renamed from: a */
    public static final void m14648a(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        if (!xmlPullParser.getName().equals(str)) {
            throw new XmlPullParserException("Unexpected start tag: found " + xmlPullParser.getName() + ", expected " + str);
        }
    }

    /* renamed from: a */
    public static final void m14647a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                return;
            }
        } while (next != 1);
    }

    /* renamed from: b */
    private static void m14695b(Context context) throws Resources.NotFoundException {
        XmlResourceParser xml = context.getResources().getXml(R.xml.mms_config);
        try {
            try {
                try {
                    m14648a(xml, "mms_config");
                    while (true) {
                        m14647a(xml);
                        String name = xml.getName();
                        if (name == null) {
                            break;
                        }
                        String attributeName = xml.getAttributeName(0);
                        String attributeValue = xml.getAttributeValue(0);
                        String text = xml.next() == 4 ? xml.getText() : null;
                        if (text != null) {
                            C3890m.m14994a("MmsConfig", "tag: " + name + " value: " + attributeValue + " - " + text);
                        }
                        if (text != null && "name".equalsIgnoreCase(attributeName)) {
                            if ("bool".equals(name)) {
                                if ("enabledMMS".equalsIgnoreCase(attributeValue)) {
                                    f13835r = "true".equalsIgnoreCase(text) ? 1 : 0;
                                } else if ("enabledTransID".equalsIgnoreCase(attributeValue)) {
                                    f13834q = "true".equalsIgnoreCase(text);
                                } else if ("enabledNotifyWapMMSC".equalsIgnoreCase(attributeValue)) {
                                    f13758I = "true".equalsIgnoreCase(text);
                                } else if ("aliasEnabled".equalsIgnoreCase(attributeValue)) {
                                    f13771V = "true".equalsIgnoreCase(text);
                                } else if ("allowAttachAudio".equalsIgnoreCase(attributeValue)) {
                                    f13759J = "true".equalsIgnoreCase(text);
                                } else if ("enableMultipartSMS".equalsIgnoreCase(attributeValue)) {
                                    f13761L = "true".equalsIgnoreCase(text);
                                } else if ("enableSlideDuration".equalsIgnoreCase(attributeValue)) {
                                    f13762M = "true".equalsIgnoreCase(text);
                                } else if ("disableMenuRequestMmsReadReport".equalsIgnoreCase(attributeValue)) {
                                    f13763N = !"true".equalsIgnoreCase(text);
                                } else if ("enableSMSDeliveryReports".equalsIgnoreCase(attributeValue)) {
                                    f13764O = "true".equalsIgnoreCase(text);
                                } else if ("disableMenuRequestMmsDeliveryReport".equalsIgnoreCase(attributeValue)) {
                                    f13765P = !"true".equalsIgnoreCase(text);
                                } else if ("enableMessagePriorityDuringComposing".equalsIgnoreCase(attributeValue)) {
                                    f13766Q = "true".equalsIgnoreCase(text);
                                } else if ("enableUAPBuildId".equalsIgnoreCase(attributeValue)) {
                                    f13767R = "true".equalsIgnoreCase(text);
                                } else if ("enableHttpUserNaiHeader".equalsIgnoreCase(attributeValue)) {
                                    f13779aC = "true".equalsIgnoreCase(text);
                                } else if ("enableFromFieldMDN".equalsIgnoreCase(attributeValue)) {
                                    f13768S = "true".equalsIgnoreCase(text);
                                } else if ("mmsResizing".equalsIgnoreCase(attributeValue)) {
                                    f13778aB = "true".equalsIgnoreCase(text);
                                } else if ("mmsClatEnabled".equalsIgnoreCase(attributeValue)) {
                                    f13785aI = "true".equalsIgnoreCase(text);
                                }
                            } else if ("int".equals(name)) {
                                if ("maxMessageSize".equalsIgnoreCase(attributeValue)) {
                                    f13836s = Integer.parseInt(text);
                                } else if ("maxImageHeight".equalsIgnoreCase(attributeValue)) {
                                    f13843z = Integer.parseInt(text);
                                } else if ("maxImageWidth".equalsIgnoreCase(attributeValue)) {
                                    f13750A = Integer.parseInt(text);
                                } else if ("defaultSMSMessagesPerThread".equalsIgnoreCase(attributeValue)) {
                                    f13752C = Integer.parseInt(text);
                                } else if ("defaultMMSMessagesPerThread".equalsIgnoreCase(attributeValue)) {
                                    f13753D = Integer.parseInt(text);
                                } else if ("minMessageCountPerThread".equalsIgnoreCase(attributeValue)) {
                                    f13754E = Integer.parseInt(text);
                                } else if ("maxMessageCountPerThread".equalsIgnoreCase(attributeValue)) {
                                    f13755F = Integer.parseInt(text);
                                } else if ("recipientLimit".equalsIgnoreCase(attributeValue)) {
                                    f13751B = Integer.parseInt(text);
                                    if (f13751B < 0) {
                                        f13751B = Integer.MAX_VALUE;
                                    }
                                } else if ("httpSocketTimeout".equalsIgnoreCase(attributeValue)) {
                                    f13756G = Integer.parseInt(text);
                                } else if ("minimumSlideElementDuration".equalsIgnoreCase(attributeValue)) {
                                    f13757H = Integer.parseInt(text);
                                } else if ("maxSizeScaleForPendingMmsAllowed".equalsIgnoreCase(attributeValue)) {
                                    f13770U = Integer.parseInt(text);
                                } else if ("aliasMinChars".equalsIgnoreCase(attributeValue)) {
                                    f13772W = Integer.parseInt(text);
                                } else if ("aliasMaxChars".equalsIgnoreCase(attributeValue)) {
                                    f13773X = Integer.parseInt(text);
                                } else if ("smsToMmsTextThreshold".equalsIgnoreCase(attributeValue)) {
                                    f13760K = Integer.parseInt(text);
                                } else if ("maxMessageTextSize".equalsIgnoreCase(attributeValue)) {
                                    f13769T = Integer.parseInt(text);
                                } else if ("maxSubjectLength".equalsIgnoreCase(attributeValue)) {
                                    f13774Y = Integer.parseInt(text);
                                } else if ("mmsModeCaptureVideoMaxSize".equalsIgnoreCase(attributeValue)) {
                                    f13786aJ = Integer.parseInt(text);
                                } else if ("maxRecipientLengthAs".equalsIgnoreCase(attributeValue)) {
                                    f13787aK = Integer.parseInt(text);
                                } else if ("minRecipientLengthAs".equalsIgnoreCase(attributeValue)) {
                                    f13788aL = Integer.parseInt(text);
                                }
                            } else if ("string".equals(name)) {
                                if ("userAgent".equalsIgnoreCase(attributeValue)) {
                                    f13837t = text;
                                } else if ("uaProfTagName".equalsIgnoreCase(attributeValue)) {
                                    f13838u = text;
                                } else if ("uaProfUrl".equalsIgnoreCase(attributeValue)) {
                                    f13839v = text;
                                } else if ("httpParams".equalsIgnoreCase(attributeValue)) {
                                    f13840w = text;
                                } else if ("httpParamsLine1Key".equalsIgnoreCase(attributeValue)) {
                                    f13841x = text;
                                } else if ("emailGatewayNumber".equalsIgnoreCase(attributeValue)) {
                                    f13842y = text;
                                } else if ("enableLimitOnMmsSubject".equalsIgnoreCase(attributeValue)) {
                                    m14646a(text);
                                } else if ("mmsMDNTagName".equalsIgnoreCase(attributeValue)) {
                                    f13780aD = text;
                                } else if ("commonOperator".equalsIgnoreCase(attributeValue)) {
                                    f13782aF = text;
                                } else if ("commonRegion".equalsIgnoreCase(attributeValue)) {
                                    f13783aG = text;
                                } else if ("smsDiscardPrefix".equalsIgnoreCase(attributeValue)) {
                                    f13789aM = text;
                                } else if ("enableMmsUaUapAutoCreate".equalsIgnoreCase(attributeValue)) {
                                    f13790aN = text;
                                }
                            } else if ("uaprofurl".equals(name)) {
                                if (attributeValue != null && attributeValue.equalsIgnoreCase(SystemProperties.get("ro.product.model"))) {
                                    f13839v = text;
                                }
                            } else if ("useragent".equals(name) && attributeValue != null && attributeValue.equalsIgnoreCase(SystemProperties.get("ro.product.model"))) {
                                f13837t = text;
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    C3890m.m14995a("MmsConfig", "loadMmsSettings caught ", e);
                    if (xml != null) {
                    }
                } catch (XmlPullParserException e2) {
                    C3890m.m14995a("MmsConfig", "loadMmsSettings caught ", e2);
                    if (xml != null) {
                    }
                }
            } catch (IOException e3) {
                C3890m.m14995a("MmsConfig", "loadMmsSettings caught ", e3);
                if (xml != null) {
                }
            }
            String str = (m14696b() && f13839v == null) ? "uaProfUrl" : null;
            if (str != null) {
                C3890m.m14999e("MmsConfig", str);
            }
        } finally {
            if (xml != null) {
                xml.close();
            }
        }
    }

    /* renamed from: T */
    public static boolean m14636T() {
        return true;
    }

    /* renamed from: U */
    public static boolean m14637U() {
        return f13795ac;
    }

    /* renamed from: V */
    public static boolean m14638V() {
        return f13796ad;
    }

    /* renamed from: W */
    public static String m14639W() {
        return f13797ae;
    }

    /* renamed from: X */
    public static boolean m14640X() {
        return f13798af;
    }

    /* renamed from: Y */
    public static int m14641Y() {
        return f13836s - f13801ai;
    }

    /* renamed from: Z */
    public static boolean m14642Z() {
        return f13802aj;
    }

    /* renamed from: aa */
    public static boolean m14669aa() {
        return f13803ak;
    }

    /* renamed from: ab */
    public static int m14670ab() {
        return f13804al;
    }

    /* renamed from: ac */
    public static boolean m14671ac() {
        return f13805am;
    }

    /* renamed from: ad */
    public static boolean m14672ad() {
        return f13806an;
    }

    /* renamed from: ae */
    public static boolean m14673ae() {
        return f13807ao;
    }

    /* renamed from: af */
    public static boolean m14674af() {
        return f13821d;
    }

    /* renamed from: ag */
    public static boolean m14675ag() {
        return f13808ap;
    }

    /* renamed from: ah */
    public static boolean m14676ah() {
        return "SHW-M250K".equalsIgnoreCase(SystemProperties.get("ro.build.product"));
    }

    /* renamed from: ai */
    public static boolean m14677ai() {
        return "45006".equals(SystemProperties.get("gsm.operator.numeric"));
    }

    /* renamed from: aj */
    public static boolean m14678aj() {
        return "LG-F240S".equalsIgnoreCase(SystemProperties.get("ro.product.model"));
    }

    /* renamed from: ak */
    public static boolean m14679ak() {
        return m14667aR();
    }

    /* renamed from: al */
    public static boolean m14680al() {
        return f13815aw;
    }

    /* renamed from: am */
    public static boolean m14681am() {
        return f13814av;
    }

    /* renamed from: an */
    public static boolean m14682an() {
        return f13816ax;
    }

    /* renamed from: ao */
    public static String m14683ao() {
        return f13818az;
    }

    /* renamed from: ap */
    public static boolean m14684ap() {
        return m14683ao().equals("SKT") || m14683ao().equals("KT") || m14683ao().equals("LGU+") || m14683ao().equals("KOR_OPEN");
    }

    /* renamed from: aq */
    public static boolean m14685aq() {
        return f13777aA;
    }

    /* renamed from: ar */
    public static boolean m14686ar() {
        if (Build.VERSION.SDK_INT < 19 || !f13819b.booleanValue()) {
            return false;
        }
        return true;
    }

    /* renamed from: as */
    public static boolean m14687as() {
        if (f13824g == null) {
            return false;
        }
        return f13824g.booleanValue();
    }

    /* renamed from: aS */
    private static void m14668aS() {
        f13792aP.add("222");
        f13792aP.add("262");
    }

    /* renamed from: at */
    public static boolean m14688at() {
        if (m14686ar()) {
            boolean zM15023b = C3892o.m15023b();
            C3892o.m15031e();
            return zM15023b;
        }
        if (!m14687as() || !C4822an.m18218a()) {
            return true;
        }
        if (m14664aO()) {
            return C2349a.m10301a("default_sms_feature");
        }
        if (C4822an.m18196F()) {
            return true;
        }
        if (!f13792aP.contains(C4822an.m18243k())) {
            return true;
        }
        return false;
    }

    /* renamed from: au */
    public static boolean m14689au() {
        return false;
    }

    /* renamed from: av */
    public static boolean m14690av() {
        return false;
    }

    /* renamed from: aw */
    public static boolean m14691aw() {
        return C5034k.m19106k() && C4822an.m18234f() != null && C4822an.m18228d() != null && C4822an.m18218a() && C4809aa.m18104a().m18119a("free_sms_is_available", (Boolean) false).booleanValue();
    }

    /* renamed from: ax */
    public static boolean m14692ax() {
        if (f13825h == null) {
            return false;
        }
        return f13825h.booleanValue();
    }

    /* renamed from: ay */
    public static boolean m14693ay() {
        if (f13826i == null) {
            return false;
        }
        return f13826i.booleanValue();
    }

    /* renamed from: az */
    public static boolean m14694az() {
        if (f13828k == null) {
            return false;
        }
        return f13828k.booleanValue();
    }

    /* renamed from: aA */
    public static boolean m14650aA() {
        if (!C4822an.m18196F()) {
        }
        return true;
    }

    /* renamed from: aB */
    public static boolean m14651aB() {
        if (f13830m == null) {
            return false;
        }
        return f13830m.booleanValue();
    }

    /* renamed from: aC */
    public static boolean m14652aC() {
        return f13833p.booleanValue() && C4822an.m18205O();
    }

    /* renamed from: aD */
    public static int m14653aD() {
        return 1073741824;
    }

    /* renamed from: aE */
    public static boolean m14654aE() {
        int i;
        if (!C5034k.m19106k() || !C4822an.m18218a() || !C4809aa.m18104a().m18119a("pref_key_using_sms_mms_mode", Boolean.valueOf(m14688at())).booleanValue() || !C4809aa.m18104a().m18119a("pref_key_is_free_sms_enable", (Boolean) false).booleanValue()) {
            return false;
        }
        String strM18243k = C4822an.m18243k();
        if (strM18243k != null && strM18243k.equals("404") && (i = Calendar.getInstance().get(11)) >= 21 && i <= 9) {
            C5179v.m19811a(GlobalApplication.m18732r(), GlobalApplication.m18732r().getResources().getString(R.string.freesms_dnd_alert, 9, 9), 0).show();
            return false;
        }
        return C4809aa.m18104a().m18120a("free_sms_remain_count", (Integer) 200).intValue() > 0;
    }

    /* renamed from: aF */
    public static void m14655aF() {
        if (!C4809aa.m18104a().m18129b("free_sms_is_available")) {
            C4809aa.m18104a().m18125b("free_sms_is_available", Boolean.valueOf(m14689au()));
        }
        if (!C4809aa.m18104a().m18129b("pref_key_is_free_sms_enable")) {
            C4809aa.m18104a().m18125b("pref_key_is_free_sms_enable", Boolean.valueOf(m14690av()));
        }
        C2346e.m10271a().m10276b();
    }

    /* renamed from: aG */
    public static boolean m14656aG() {
        if (m14658aI() || m14659aJ()) {
            return C2349a.m10301a("sms_feature") && f13823f;
        }
        return false;
    }

    /* renamed from: aH */
    public static boolean m14657aH() {
        if (f13776a == null || !m14658aI()) {
            return false;
        }
        return f13776a.booleanValue();
    }

    /* renamed from: aI */
    public static boolean m14658aI() {
        String strM18243k = C4822an.m18243k();
        if (strM18243k == null) {
            return false;
        }
        if (!"310".equals(strM18243k) && !"311".equals(strM18243k)) {
            return false;
        }
        return true;
    }

    /* renamed from: aJ */
    public static boolean m14659aJ() {
        String strM18243k = C4822an.m18243k();
        if (strM18243k == null || !"450".equals(strM18243k)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m14649a(int i) {
        return (i >= 100 && i <= 104) || i == 110;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0058  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m14644a(long r7) {
        /*
            r2 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "_id = "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r3 = r0.toString()
            r6 = 0
            android.net.Uri r0 = android.provider.Telephony.Threads.CONTENT_URI
            android.net.Uri$Builder r0 = r0.buildUpon()
            java.lang.String r1 = "simple"
            java.lang.String r4 = "true"
            android.net.Uri$Builder r0 = r0.appendQueryParameter(r1, r4)
            android.net.Uri r1 = r0.build()
            android.content.Context r0 = com.sec.common.CommonApplication.m18732r()
            android.content.ContentResolver r0 = r0.getContentResolver()
            r4 = r2
            r5 = r2
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)
            if (r1 == 0) goto L5a
            int r0 = r1.getCount()
            if (r0 <= 0) goto L58
            r1.moveToFirst()
            java.lang.String r0 = "type"
            int r0 = r1.getColumnIndex(r0)
            int r0 = r1.getInt(r0)
            boolean r2 = m14649a(r0)
            if (r2 == 0) goto L58
        L54:
            r1.close()
        L57:
            return r0
        L58:
            r0 = r6
            goto L54
        L5a:
            r0 = r6
            goto L57
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.C3847e.m14644a(long):int");
    }

    /* renamed from: aK */
    public static long m14660aK() {
        if (f13786aJ == -1) {
            f13786aJ = m14641Y();
        }
        return f13786aJ;
    }

    /* renamed from: a */
    private static void m14646a(String str) {
        if (str != null && str.length() > 0) {
            String[] strArrSplit = str.split(",");
            if (strArrSplit != null) {
                try {
                    if (strArrSplit.length == 2) {
                        f13774Y = Integer.parseInt(strArrSplit[0].trim());
                        if (strArrSplit[1].trim().equalsIgnoreCase("byte")) {
                            f13775Z = true;
                        }
                        if (strArrSplit[1].trim().equalsIgnoreCase("Ksc5601byte")) {
                            f13775Z = true;
                            return;
                        }
                        return;
                    }
                } catch (NumberFormatException e) {
                    f13774Y = 40;
                    f13775Z = false;
                    return;
                }
            }
            if (strArrSplit != null && strArrSplit.length == 1) {
                f13774Y = Integer.parseInt(strArrSplit[0].trim());
                f13775Z = false;
                return;
            } else {
                f13774Y = 40;
                f13775Z = false;
                return;
            }
        }
        f13774Y = 40;
        f13775Z = false;
    }

    /* renamed from: aL */
    public static boolean m14661aL() {
        return f13775Z;
    }

    /* renamed from: aM */
    public static int m14662aM() {
        return f13787aK;
    }

    /* renamed from: aN */
    public static int m14663aN() {
        return f13788aL;
    }

    /* renamed from: aO */
    public static boolean m14664aO() {
        if (f13832o == null) {
            return false;
        }
        return f13832o.booleanValue();
    }

    /* renamed from: aP */
    public static void m14665aP() {
        PreferenceManager.setDefaultValues(CommonApplication.m18732r(), R.xml.preferences, false);
        m14645a(CommonApplication.m18732r());
        C3782a.m14211a(CommonApplication.m18732r());
        C3887j.m14979a(CommonApplication.m18732r());
        C3790i.m14333b(CommonApplication.m18732r());
        C3881d.m14965a(CommonApplication.m18732r());
        C3898u.m15060a(CommonApplication.m18732r());
        C3848a.m14722a(CommonApplication.m18732r());
        C3852b.m14738a(CommonApplication.m18732r());
        C3876aa.m14952a(CommonApplication.m18732r());
        MessagingNotification.m15521a(CommonApplication.m18732r());
        C4015bs.m15437a(CommonApplication.m18732r());
    }
}
