package com.sec.chaton.p067j.p070c;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C2684ab;
import com.sec.chaton.msgsend.C2716x;
import com.sec.chaton.msgsend.C2717y;
import com.sec.chaton.msgsend.EnumC2692aj;
import com.sec.chaton.msgsend.EnumC2706n;
import com.sec.chaton.multimedia.doc.FileExplorerActivity;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p067j.p069b.C2431a;
import com.sec.chaton.qmlog.C3119a;
import com.sec.chaton.qmlog.EnumC3124f;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.DataOutputStream;
import java.io.File;
import java.util.ArrayList;

/* compiled from: FileUploadTask.java */
/* renamed from: com.sec.chaton.j.c.g */
/* loaded from: classes.dex */
public class RunnableC2440g implements Runnable {

    /* renamed from: b */
    private static final String f8737b = RunnableC2440g.class.getSimpleName();

    /* renamed from: c */
    private Handler f8739c;

    /* renamed from: e */
    private Handler f8741e;

    /* renamed from: f */
    private long f8742f;

    /* renamed from: g */
    private String f8743g;

    /* renamed from: h */
    private File f8744h;

    /* renamed from: i */
    private EnumC2300t f8745i;

    /* renamed from: j */
    private EnumC2214ab f8746j;

    /* renamed from: k */
    private String f8747k;

    /* renamed from: l */
    private String f8748l;

    /* renamed from: n */
    private String f8750n;

    /* renamed from: o */
    private String f8751o;

    /* renamed from: t */
    private String f8756t;

    /* renamed from: u */
    private String f8757u;

    /* renamed from: v */
    private EnumC2706n f8758v;

    /* renamed from: d */
    private int f8740d = 0;

    /* renamed from: s */
    private boolean f8755s = false;

    /* renamed from: m */
    private ArrayList<String> f8749m = new ArrayList<>();

    /* renamed from: p */
    private boolean f8752p = false;

    /* renamed from: q */
    private final Object f8753q = new Object();

    /* renamed from: r */
    private final Object f8754r = new Object();

    /* renamed from: a */
    DataOutputStream f8738a = null;

    /* renamed from: a */
    public String m10592a() {
        return this.f8743g;
    }

    /* renamed from: b */
    public EnumC2300t m10597b() {
        return this.f8745i;
    }

    /* renamed from: c */
    public EnumC2214ab m10598c() {
        return this.f8746j;
    }

    /* renamed from: d */
    public String m10599d() {
        return this.f8747k;
    }

    /* renamed from: e */
    public String[] m10600e() {
        return (String[]) this.f8749m.toArray(new String[this.f8749m.size()]);
    }

    /* renamed from: f */
    public String m10601f() {
        return this.f8750n;
    }

    /* renamed from: g */
    public String m10602g() {
        return this.f8748l;
    }

    /* renamed from: h */
    public String m10603h() {
        return this.f8756t;
    }

    /* renamed from: i */
    public EnumC2706n m10604i() {
        return this.f8758v;
    }

    /* renamed from: j */
    public String m10605j() {
        return this.f8757u;
    }

    /* renamed from: k */
    public String m10606k() {
        return this.f8751o;
    }

    /* renamed from: a */
    public void m10593a(Handler handler) {
        this.f8741e = handler;
    }

    /* renamed from: a */
    public static boolean m10589a(int i, int i2) {
        if (!C2717y.m11398b()) {
            return false;
        }
        C2684ab.m11290a(f8737b, "isNeedToChangeStateToPending(), resultCode(%d), faultCode(%d)", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 2:
            case 5:
            case 9:
            case 12:
            case 13:
            case 14:
                break;
            case 3:
            case 4:
            case 6:
            case 8:
            case 10:
            case 11:
            default:
                return false;
            case 7:
                if (i2 != 11006) {
                    return false;
                }
                break;
        }
        return true;
    }

    /* renamed from: a */
    public static String m10587a(File file, EnumC2214ab enumC2214ab) {
        String strSubstring;
        try {
            strSubstring = file.getName().substring(file.getName().lastIndexOf("."));
        } catch (IndexOutOfBoundsException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f8737b);
            }
        }
        if (strSubstring == null) {
            strSubstring = null;
        } else if (strSubstring.contains(".")) {
            strSubstring = strSubstring.substring(1);
        }
        if (strSubstring == null && enumC2214ab == EnumC2214ab.AMS) {
            strSubstring = "jpg";
            C2684ab.m11290a(f8737b, "FILE Extention : forced to be 'JPG' ", new Object[0]);
        }
        if (strSubstring == null) {
            C2684ab.m11290a(f8737b, "FILE Extention : could not be determined '", new Object[0]);
        }
        return strSubstring;
    }

    /* renamed from: a */
    public void m10594a(Handler handler, File file, EnumC2214ab enumC2214ab, Handler handler2) {
        this.f8739c = handler;
        this.f8741e = handler2;
        this.f8744h = file;
        this.f8746j = enumC2214ab;
        this.f8747k = m10587a(file, enumC2214ab);
    }

    /* renamed from: a */
    public void m10595a(Handler handler, String str, File file, long j, String str2, EnumC2300t enumC2300t, EnumC2214ab enumC2214ab, String str3, String[] strArr, String str4, boolean z, String str5, String str6, EnumC2706n enumC2706n) {
        this.f8739c = handler;
        this.f8750n = str;
        this.f8742f = j;
        this.f8745i = enumC2300t;
        this.f8743g = str2;
        this.f8744h = file;
        this.f8746j = enumC2214ab;
        this.f8756t = str5;
        this.f8757u = str6;
        this.f8758v = enumC2706n;
        this.f8747k = m10587a(file, enumC2214ab);
        this.f8748l = str4;
        for (String str7 : strArr) {
            this.f8749m.add(str7);
        }
        this.f8752p = z;
    }

    /* renamed from: l */
    public int m10607l() {
        int i;
        synchronized (this.f8754r) {
            i = this.f8740d;
        }
        return i;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        boolean z;
        int i;
        if (!m10591m()) {
            m10590a(false, 11, null);
            return;
        }
        String strM11579b = "";
        switch (this.f8746j) {
            case IMAGE:
            case AMS:
            case VIDEO:
                if (this.f8747k != null) {
                    strM11579b = MimeTypeMap.getSingleton().getMimeTypeFromExtension(this.f8747k.toLowerCase());
                    break;
                }
                break;
            case AUDIO:
                if (this.f8747k != null) {
                    strM11579b = "audio/" + this.f8747k.toLowerCase();
                    break;
                }
                break;
            case CALENDAR:
                strM11579b = "text/x-vcalendar";
                break;
            case CONTACT:
                strM11579b = "text/x-vcard";
                break;
            case GEO:
                strM11579b = "text/x-map";
                break;
            case DOCUMENT:
            case FILE:
                if (this.f8747k != null) {
                    strM11579b = FileExplorerActivity.m11579b(this.f8747k.toLowerCase());
                    break;
                }
                break;
            default:
                strM11579b = "";
                break;
        }
        StringBuilder sb = new StringBuilder();
        int iM10586a = m10586a(strM11579b, sb);
        if (this.f8755s) {
            C2204r.m10041b(CommonApplication.m18732r().getContentResolver(), Long.valueOf(this.f8742f));
            C2716x.m11379a(this.f8743g, this.f8742f, EnumC2692aj.FAILED);
            i = 6;
            z = false;
        } else if (iM10586a != 8) {
            if (C4904y.f17875e) {
                C4904y.m18634a("Failed to upload file [nResultCode:" + iM10586a + "]", f8737b);
            }
            if (iM10586a == 12 || iM10586a == 13) {
                int iM10586a2 = m10586a(strM11579b, sb);
                if (iM10586a2 == 8) {
                    i = iM10586a2;
                    z = true;
                } else {
                    i = iM10586a2;
                    z = false;
                }
            } else {
                z = false;
                i = iM10586a;
            }
        } else {
            z = true;
            i = iM10586a;
        }
        m10590a(z, i, sb.toString());
    }

    /* renamed from: m */
    private boolean m10591m() throws Throwable {
        if (this.f8752p) {
            C2204r.m10056e(CommonApplication.m18732r().getContentResolver(), Long.valueOf(this.f8742f));
        }
        if (!C4894o.m18609a(this.f8746j, this.f8747k) || this.f8744h.length() > 31457280) {
            return false;
        }
        if (C2349a.m10301a("chaton_qmlog_sending")) {
            C3119a.m12716a().m12719a(this, System.currentTimeMillis());
            C3119a.m12716a().m12720a(this, this.f8742f, this.f8744h.length());
        }
        Bitmap bitmapM18598a = null;
        if (EnumC2214ab.IMAGE == this.f8746j) {
            bitmapM18598a = C4894o.m18599a(CommonApplication.m18732r(), this.f8744h, true, true, false, C2349a.m10301a("full_image_feature"));
        } else if (EnumC2214ab.VIDEO == this.f8746j) {
            bitmapM18598a = C4894o.m18598a(CommonApplication.m18732r(), this.f8744h, false, true, false);
        }
        if (bitmapM18598a != null) {
            bitmapM18598a.recycle();
        }
        return true;
    }

    /* renamed from: a */
    private boolean m10590a(boolean z, int i, String str) {
        int iM10532a = 0;
        if (z) {
            C2204r.m10055d(CommonApplication.m18732r().getContentResolver(), Long.valueOf(this.f8742f));
            this.f8751o = str;
        } else {
            if (!TextUtils.isEmpty(str) && str.lastIndexOf(":") > -1) {
                iM10532a = C2431a.m10532a(str.substring(str.lastIndexOf(":") + 1).trim());
            }
            if (this.f8758v != null) {
                if (EnumC2214ab.CONTACT == this.f8746j || EnumC2214ab.CALENDAR == this.f8746j || EnumC2214ab.DOCUMENT == this.f8746j || EnumC2214ab.FILE == this.f8746j) {
                    if (!this.f8758v.m11326a() && m10589a(i, iM10532a)) {
                        C2204r.m10001a(GlobalApplication.m18732r().getContentResolver(), Long.valueOf(this.f8742f), this.f8748l);
                    } else {
                        C2204r.m10042b(GlobalApplication.m18732r().getContentResolver(), Long.valueOf(this.f8742f), this.f8748l);
                    }
                } else if (!this.f8758v.m11326a() && m10589a(i, iM10532a)) {
                    C2204r.m9999a(GlobalApplication.m18732r().getContentResolver(), Long.valueOf(this.f8742f));
                } else {
                    C2204r.m10041b(GlobalApplication.m18732r().getContentResolver(), Long.valueOf(this.f8742f));
                }
            }
            this.f8751o = "";
        }
        if (this.f8739c != null) {
            Message messageObtainMessage = this.f8739c.obtainMessage(1);
            messageObtainMessage.arg1 = i;
            messageObtainMessage.arg2 = iM10532a;
            messageObtainMessage.obj = new C2442i(this, z, this.f8742f, str);
            this.f8739c.sendMessage(messageObtainMessage);
        }
        if (C2349a.m10301a("chaton_qmlog_sending")) {
            C3119a.m12716a().m12721a(this, EnumC3124f.FILEUPLOAD, z ? System.currentTimeMillis() : -1L);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x02ce, code lost:
    
        if (r5 != null) goto L442;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x02d0, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02d7, code lost:
    
        if (r20.f8738a != null) goto L455;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02d9, code lost:
    
        r20.f8738a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02e0, code lost:
    
        r2.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02e6, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02e8, code lost:
    
        r20.f8738a = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02ec, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02fa, code lost:
    
        if (r2.getResponseCode() == 200) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02fc, code lost:
    
        r3 = r2.getResponseMessage();
        r5 = new java.io.BufferedInputStream(r2.getErrorStream());
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0309, code lost:
    
        r4 = com.sec.chaton.p067j.p069b.C2432b.m10533a(com.sec.chaton.p067j.C2433c.m10535a(r5));
        com.sec.chaton.util.C4904y.m18634a("[Upload]" + r3 + ":" + r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
        r22.append(r3).append(":").append(r4);
        com.sec.chaton.p063i.p064a.C2404a.m10431a("01000006", "2001", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x034f, code lost:
    
        if (r5 == null) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0351, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0354, code lost:
    
        if (r7 == null) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0356, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0359, code lost:
    
        if (r6 == 0) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x035b, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0362, code lost:
    
        if (r20.f8738a == null) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0364, code lost:
    
        r20.f8738a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x036b, code lost:
    
        r2.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x03c1, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r3, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x03c8, code lost:
    
        if (r4 != null) goto L449;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x03ca, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x03cd, code lost:
    
        if (r7 != null) goto L461;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x03cf, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x03d2, code lost:
    
        if (r6 != 0) goto L475;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x03d4, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x03db, code lost:
    
        if (r20.f8738a != null) goto L491;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x03dd, code lost:
    
        r20.f8738a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x03e4, code lost:
    
        r2.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x03f3, code lost:
    
        m10588a(100);
        r8 = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x03fe, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b == false) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0400, code lost:
    
        com.sec.chaton.util.C4904y.m18639b("[End uploading] Uploaded FileSize: " + r5 + ", FileName:" + r10 + ", Time(Upload): " + (r8 - r12), com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0430, code lost:
    
        r3 = new java.io.BufferedInputStream(r2.getInputStream());
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0439, code lost:
    
        r4 = com.sec.chaton.p067j.C2433c.m10535a(r3).trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0443, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b == false) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0445, code lost:
    
        com.sec.chaton.util.C4904y.m18639b("[Upload IP] " + r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x045e, code lost:
    
        if (r3 == null) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0460, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0463, code lost:
    
        if (r7 == null) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0465, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0468, code lost:
    
        if (r6 == 0) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x046a, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0471, code lost:
    
        if (r20.f8738a == null) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0473, code lost:
    
        r20.f8738a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x047a, code lost:
    
        r2.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x047d, code lost:
    
        if (r4 == null) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0486, code lost:
    
        if (r4.startsWith("https://") != false) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x048f, code lost:
    
        if (r4.startsWith("http://") == false) goto L241;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0491, code lost:
    
        r22.append(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0496, code lost:
    
        r22.append("/file").append("\n").append(r10).append("\n").append(com.sec.chaton.util.C4809aa.m18104a().m18121a("uid", ""));
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x04c6, code lost:
    
        new com.sec.chaton.p055d.C2132m(new android.os.Handler(android.os.Looper.getMainLooper())).m9552a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x04d9, code lost:
    
        r3 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x04da, code lost:
    
        r7 = r6;
        r6 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x04dc, code lost:
    
        if (r4 != null) goto L471;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x04de, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x04e1, code lost:
    
        if (r7 != null) goto L485;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x04e3, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x04e6, code lost:
    
        if (r6 != 0) goto L499;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x04e8, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x04ef, code lost:
    
        if (r20.f8738a != null) goto L511;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x04f1, code lost:
    
        r20.f8738a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x04f8, code lost:
    
        r2.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x04fb, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0505, code lost:
    
        if (com.sec.chaton.util.C4904y.f17875e != false) goto L197;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0507, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r3, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x050e, code lost:
    
        if (r4 != null) goto L481;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0510, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0513, code lost:
    
        if (r7 != null) goto L495;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0515, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0518, code lost:
    
        if (r6 != 0) goto L507;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x051a, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0521, code lost:
    
        if (r20.f8738a != null) goto L519;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0523, code lost:
    
        r20.f8738a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x052a, code lost:
    
        r2.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0539, code lost:
    
        if (com.sec.chaton.util.C4904y.f17875e != false) goto L213;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x053b, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r3, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0542, code lost:
    
        if (r4 != null) goto L513;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0544, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x0547, code lost:
    
        if (r7 != null) goto L440;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0549, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x054c, code lost:
    
        if (r6 != 0) goto L453;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x054e, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0555, code lost:
    
        if (r20.f8738a != null) goto L465;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0557, code lost:
    
        r20.f8738a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x055e, code lost:
    
        r2.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x056d, code lost:
    
        if (com.sec.chaton.util.C4904y.f17875e != false) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x056f, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r3, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0576, code lost:
    
        if (r4 != null) goto L457;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0578, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x057b, code lost:
    
        if (r7 != null) goto L473;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x057d, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0580, code lost:
    
        if (r6 != 0) goto L489;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0582, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0589, code lost:
    
        if (r20.f8738a != null) goto L501;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x058b, code lost:
    
        r20.f8738a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0592, code lost:
    
        r2.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0598, code lost:
    
        r22.append("http://").append(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x05a6, code lost:
    
        return 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x05a9, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x05ac, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L246;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x05ae, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x05b5, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x05b8, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x05ba, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x05c1, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x05c4, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x05c6, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x05cd, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x05d0, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x05d2, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x05d9, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x05dc, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L262;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x05de, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x05e5, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x05e8, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x05ea, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x05f1, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x05f4, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x05f6, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x05fd, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0600, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0602, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0609, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x060c, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L278;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x060e, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0615, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0618, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L282;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x061a, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0621, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x0624, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x0626, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x062d, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x0630, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L290;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x0632, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x0639, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x063c, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x063e, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x0645, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x0648, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L298;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x064a, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x0651, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x0654, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x0656, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x065d, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x0660, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L306;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x0662, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x0669, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x066c, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L310;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x066e, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x0675, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x0678, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L314;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x067a, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x0681, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x0684, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L318;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x0686, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x068d, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x0690, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x0692, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x0699, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x069c, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L326;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x069e, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x06a5, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x06a8, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L330;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x06aa, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x06b1, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x06b4, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x06b6, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x06bd, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x06c0, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L338;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x06c2, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x06c9, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x06cc, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L342;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x06ce, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x06d5, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x06d8, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L346;
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x06da, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x06e1, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x06e4, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L350;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x06e6, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x06ed, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x06f0, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x06f2, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x06f9, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x06fc, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L358;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x06fe, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x0705, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x0708, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L362;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x070a, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x0711, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x0714, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L366;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x0716, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x071d, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x0720, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L370;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x0722, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r4, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x0729, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x072c, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x072e, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r3, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x0735, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x0738, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L378;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x073a, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r3, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x0741, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x0744, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L382;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x0746, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r3, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x074d, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x0750, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L386;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x0752, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r3, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x076a, code lost:
    
        r3 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x076b, code lost:
    
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x076e, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x076f, code lost:
    
        r4 = r3;
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x077e, code lost:
    
        r3 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x077f, code lost:
    
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x0782, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x0783, code lost:
    
        r4 = r3;
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x0792, code lost:
    
        r3 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x0793, code lost:
    
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x0796, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x0797, code lost:
    
        r4 = r3;
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x07a6, code lost:
    
        r3 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x07a7, code lost:
    
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x07aa, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01fd, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x07ab, code lost:
    
        r4 = r3;
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x07c0, code lost:
    
        r3 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x07c1, code lost:
    
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x07c4, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:428:0x07c5, code lost:
    
        r4 = r3;
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:0x07d7, code lost:
    
        r4 = r5;
        r5 = r6;
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x07dd, code lost:
    
        r4 = r3;
        r5 = r6;
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0203, code lost:
    
        if (r20.f8755s == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0205, code lost:
    
        com.sec.chaton.util.C4904y.m18639b("Upload canceled by the user", com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0211, code lost:
    
        if (r20.f8738a == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0213, code lost:
    
        r20.f8738a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x021b, code lost:
    
        r20.f8738a = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0221, code lost:
    
        if (0 != 0) goto L493;
     */
    /* JADX WARN: Code restructure failed: missing block: B:537:?, code lost:
    
        return 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0223, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:542:?, code lost:
    
        return 9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:543:?, code lost:
    
        return 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:544:?, code lost:
    
        return 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:545:?, code lost:
    
        return 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:546:?, code lost:
    
        return 12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:547:?, code lost:
    
        return 13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:548:?, code lost:
    
        return 10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0226, code lost:
    
        if (r7 != null) goto L505;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0228, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x022b, code lost:
    
        if (r6 != 0) goto L517;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x022d, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0234, code lost:
    
        if (r20.f8738a != null) goto L447;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0236, code lost:
    
        r20.f8738a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x023d, code lost:
    
        r2.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x029a, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x029d, code lost:
    
        if (com.sec.chaton.util.C4904y.f17872b != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x029f, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r3, com.sec.chaton.p067j.p070c.RunnableC2440g.f8737b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02a5, code lost:
    
        r20.f8738a = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x02b1, code lost:
    
        if (r11 == false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02b3, code lost:
    
        com.sec.chaton.util.C4809aa.m18104a().m18125b("is_file_server_primary ", (java.lang.Boolean) false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02c4, code lost:
    
        if (r4 != null) goto L503;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x02c6, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x02c9, code lost:
    
        if (r6 != null) goto L515;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x02cb, code lost:
    
        r6.close();
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:178:0x04c6 A[Catch: all -> 0x04d9, TRY_ENTER, TRY_LEAVE, TryCatch #35 {all -> 0x04d9, blocks: (B:94:0x02b3, B:178:0x04c6), top: B:477:0x02b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0507 A[Catch: all -> 0x0767, TRY_LEAVE, TryCatch #44 {all -> 0x0767, blocks: (B:27:0x015f, B:29:0x0178, B:30:0x0181, B:32:0x01ab, B:33:0x01cf, B:34:0x01e4, B:35:0x01e8, B:111:0x02ee, B:113:0x02f4, B:115:0x02fc, B:227:0x056b, B:229:0x056f, B:211:0x0537, B:213:0x053b, B:195:0x0503, B:197:0x0507, B:138:0x03c1, B:154:0x03f3, B:156:0x0400, B:157:0x0430, B:128:0x0371, B:130:0x0384, B:132:0x0391, B:134:0x0395, B:135:0x03b9, B:90:0x02ad), top: B:488:0x0150 }] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x053b A[Catch: all -> 0x0767, TRY_LEAVE, TryCatch #44 {all -> 0x0767, blocks: (B:27:0x015f, B:29:0x0178, B:30:0x0181, B:32:0x01ab, B:33:0x01cf, B:34:0x01e4, B:35:0x01e8, B:111:0x02ee, B:113:0x02f4, B:115:0x02fc, B:227:0x056b, B:229:0x056f, B:211:0x0537, B:213:0x053b, B:195:0x0503, B:197:0x0507, B:138:0x03c1, B:154:0x03f3, B:156:0x0400, B:157:0x0430, B:128:0x0371, B:130:0x0384, B:132:0x0391, B:134:0x0395, B:135:0x03b9, B:90:0x02ad), top: B:488:0x0150 }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x056f A[Catch: all -> 0x0767, TRY_LEAVE, TryCatch #44 {all -> 0x0767, blocks: (B:27:0x015f, B:29:0x0178, B:30:0x0181, B:32:0x01ab, B:33:0x01cf, B:34:0x01e4, B:35:0x01e8, B:111:0x02ee, B:113:0x02f4, B:115:0x02fc, B:227:0x056b, B:229:0x056f, B:211:0x0537, B:213:0x053b, B:195:0x0503, B:197:0x0507, B:138:0x03c1, B:154:0x03f3, B:156:0x0400, B:157:0x0430, B:128:0x0371, B:130:0x0384, B:132:0x0391, B:134:0x0395, B:135:0x03b9, B:90:0x02ad), top: B:488:0x0150 }] */
    /* JADX WARN: Removed duplicated region for block: B:440:0x0549 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:442:0x02d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:449:0x03ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:453:0x054e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:455:0x02d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:457:0x0578 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:461:0x03cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:465:0x0557 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:471:0x04de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:473:0x057d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:475:0x03d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:481:0x0510 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:485:0x04e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:489:0x0582 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:491:0x03dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:495:0x0515 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:499:0x04e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:501:0x058b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:503:0x02c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:507:0x051a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:511:0x04f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:513:0x0544 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:515:0x02cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:519:0x0523 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02b3 A[Catch: all -> 0x04d9, TRY_ENTER, TRY_LEAVE, TryCatch #35 {all -> 0x04d9, blocks: (B:94:0x02b3, B:178:0x04c6), top: B:477:0x02b1 }] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v21, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v22, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v30, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m10586a(java.lang.String r21, java.lang.StringBuilder r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2018
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p067j.p070c.RunnableC2440g.m10586a(java.lang.String, java.lang.StringBuilder):int");
    }

    /* renamed from: a */
    private boolean m10588a(int i) {
        if (this.f8741e == null) {
            return false;
        }
        synchronized (this.f8754r) {
            this.f8740d = i;
        }
        Message messageObtainMessage = this.f8741e.obtainMessage(2);
        messageObtainMessage.arg1 = i;
        return this.f8741e.sendMessage(messageObtainMessage);
    }

    /* renamed from: a */
    public boolean m10596a(boolean z) {
        synchronized (this.f8753q) {
            this.f8755s = z;
        }
        return true;
    }
}
