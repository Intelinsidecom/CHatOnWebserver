package com.sec.chaton.p018c.p019a;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.p022d.C0496a;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0635o;
import com.sec.chaton.util.C1324bt;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1341p;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: FileUploadTask.java */
/* renamed from: com.sec.chaton.c.a.k */
/* loaded from: classes.dex */
public class RunnableC0474k implements Runnable {

    /* renamed from: b */
    private Handler f1510b;

    /* renamed from: d */
    private Handler f1512d;

    /* renamed from: e */
    private long f1513e;

    /* renamed from: f */
    private String f1514f;

    /* renamed from: g */
    private File f1515g;

    /* renamed from: h */
    private EnumC0665r f1516h;

    /* renamed from: i */
    private EnumC0651d f1517i;

    /* renamed from: j */
    private String f1518j;

    /* renamed from: k */
    private String f1519k;

    /* renamed from: m */
    private String f1521m;

    /* renamed from: n */
    private String f1522n;

    /* renamed from: c */
    private int f1511c = 0;

    /* renamed from: r */
    private boolean f1526r = false;

    /* renamed from: l */
    private ArrayList f1520l = new ArrayList();

    /* renamed from: o */
    private boolean f1523o = false;

    /* renamed from: p */
    private final Object f1524p = new Object();

    /* renamed from: q */
    private final Object f1525q = new Object();

    /* renamed from: a */
    DataOutputStream f1509a = null;

    /* renamed from: a */
    public EnumC0665r m2423a() {
        return this.f1516h;
    }

    /* renamed from: b */
    public EnumC0651d m2426b() {
        return this.f1517i;
    }

    /* renamed from: c */
    public String m2427c() {
        return this.f1518j;
    }

    /* renamed from: d */
    public String[] m2428d() {
        return (String[]) this.f1520l.toArray(new String[this.f1520l.size()]);
    }

    /* renamed from: e */
    public String m2429e() {
        return this.f1521m;
    }

    /* renamed from: f */
    public String m2430f() {
        return this.f1519k;
    }

    /* renamed from: g */
    public String m2431g() {
        return this.f1522n;
    }

    /* renamed from: a */
    public void m2424a(Handler handler) {
        this.f1512d = handler;
    }

    /* renamed from: a */
    public void m2425a(Handler handler, String str, File file, long j, String str2, EnumC0665r enumC0665r, EnumC0651d enumC0651d, String[] strArr, String str3, boolean z) {
        this.f1510b = handler;
        this.f1521m = str;
        this.f1513e = j;
        this.f1516h = enumC0665r;
        this.f1514f = str2;
        this.f1515g = file;
        this.f1517i = enumC0651d;
        String strSubstring = this.f1515g.getName().substring(this.f1515g.getName().lastIndexOf("."));
        if (strSubstring != null && strSubstring.contains(".")) {
            this.f1518j = strSubstring.substring(1);
        } else {
            this.f1518j = strSubstring;
        }
        this.f1519k = str3;
        for (String str4 : strArr) {
            this.f1520l.add(str4);
        }
        this.f1523o = z;
    }

    /* renamed from: h */
    public int m2432h() {
        int i;
        synchronized (this.f1525q) {
            i = this.f1511c;
        }
        return i;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        String mimeTypeFromExtension;
        if (!m2422j()) {
            m2421a(false, 11, null);
            return;
        }
        switch (this.f1517i) {
            case IMAGE:
                mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(this.f1518j.toLowerCase());
                break;
            case VIDEO:
                mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(this.f1518j.toLowerCase());
                break;
            case AUDIO:
                mimeTypeFromExtension = "audio/" + this.f1518j.toLowerCase();
                break;
            case CALENDAR:
                mimeTypeFromExtension = "text/x-vcalendar";
                break;
            case CONTACT:
                mimeTypeFromExtension = "text/x-vcard";
                break;
            case GEO:
                mimeTypeFromExtension = "text/x-map";
                break;
            default:
                mimeTypeFromExtension = "";
                break;
        }
        StringBuilder sb = new StringBuilder();
        int iM2417a = m2417a(mimeTypeFromExtension, sb);
        m2421a(iM2417a == 8, iM2417a, sb.toString());
    }

    /* renamed from: a */
    private boolean m2420a(String str) {
        String upperCase = str.toUpperCase();
        return "JPEG".equals(upperCase) || "JPG".equals(upperCase) || "PNG".equals(upperCase);
    }

    /* renamed from: a */
    private boolean m2419a(File file, String str) {
        if (file == null) {
            return false;
        }
        String upperCase = str.toUpperCase();
        if (!"MP4".equals(upperCase) && !"3GP".equals(upperCase)) {
            return false;
        }
        String str2 = "." + upperCase.toUpperCase();
        return file.length() <= 10485760;
    }

    /* renamed from: j */
    private boolean m2422j() {
        if (this.f1523o) {
            C0635o.m2947c(GlobalApplication.m3100a().getContentResolver(), Long.valueOf(this.f1513e));
        } else {
            if (EnumC0651d.IMAGE == this.f1517i) {
                if (!m2420a(this.f1518j)) {
                    return false;
                }
            } else if (EnumC0651d.VIDEO == this.f1517i && !m2419a(this.f1515g, this.f1518j)) {
                return false;
            }
            String string = Uri.fromFile(this.f1515g).toString();
            this.f1515g.getName().substring(0, this.f1515g.getName().indexOf("."));
            if (C1327bw.m4595a()) {
                String str = GlobalApplication.m3100a().getExternalFilesDir(null).getAbsolutePath() + "/" + this.f1514f;
                if (!this.f1515g.getAbsolutePath().contains(str)) {
                    string = C1324bt.m4581a(this.f1515g.getAbsolutePath(), str, String.valueOf(System.currentTimeMillis()) + this.f1515g.getName().substring(this.f1515g.getName().indexOf(".")));
                }
            }
            C0635o.m2943b(GlobalApplication.m3100a().getContentResolver(), String.valueOf(this.f1513e), this.f1514f, this.f1517i, string, this.f1520l.size());
            if (string == null) {
                return false;
            }
            this.f1515g = new File(Uri.parse(string).getPath());
            if (this.f1517i == EnumC0651d.CONTACT || this.f1517i == EnumC0651d.CALENDAR) {
                C0635o.m2935a(GlobalApplication.m3100a().getContentResolver(), this.f1514f, Long.valueOf(this.f1513e), this.f1519k);
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m2421a(boolean z, int i, String str) throws Throwable {
        if (z) {
            C0635o.m2924a(GlobalApplication.m3100a().getContentResolver(), Long.valueOf(this.f1513e), true);
            Bitmap bitmapM4580a = null;
            if (EnumC0651d.IMAGE == this.f1517i) {
                bitmapM4580a = C1324bt.m4580a(GlobalApplication.m3100a(), this.f1515g, true);
            } else if (EnumC0651d.VIDEO == this.f1517i) {
                bitmapM4580a = C1324bt.m4580a(GlobalApplication.m3100a(), this.f1515g, false);
            }
            if (bitmapM4580a != null) {
                bitmapM4580a.recycle();
            }
            this.f1522n = str;
        } else {
            iM2519a = TextUtils.isEmpty(str) ? 0 : C0496a.m2519a(str.substring(str.lastIndexOf(":") + 1).trim());
            if (EnumC0651d.CONTACT == this.f1517i || EnumC0651d.CALENDAR == this.f1517i) {
                C0635o.m2922a(GlobalApplication.m3100a().getContentResolver(), Long.valueOf(this.f1513e), this.f1519k);
            } else {
                C0635o.m2919a(GlobalApplication.m3100a().getContentResolver(), Long.valueOf(this.f1513e));
            }
            this.f1522n = "";
        }
        if (this.f1510b != null) {
            Message messageObtainMessage = this.f1510b.obtainMessage(1);
            messageObtainMessage.arg1 = i;
            messageObtainMessage.arg2 = iM2519a;
            messageObtainMessage.obj = new C0475l(this, z, this.f1513e);
            this.f1510b.sendMessage(messageObtainMessage);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x03b7, code lost:
    
        if (r8 != 0) goto L320;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x03b9, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x03c0, code lost:
    
        if (r23.f1509a != null) goto L271;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x03c2, code lost:
    
        r23.f1509a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x03c9, code lost:
    
        r4.disconnect();
        r4 = 10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x03da, code lost:
    
        m2418a(100);
        com.sec.chaton.util.C1341p.m4658b("[End uploading] Uploaded FileSize: " + r6 + ", FileName:" + r12 + "." + r13 + ", Time(Upload): " + (java.lang.System.currentTimeMillis() - r15), getClass().getSimpleName());
        r5 = new java.io.BufferedInputStream(r4.getInputStream());
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x042b, code lost:
    
        r6 = com.sec.chaton.p018c.C0495d.m2503a(r5).trim();
        com.sec.chaton.util.C1341p.m4658b("[Upload IP] " + r6, getClass().getSimpleName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0451, code lost:
    
        if (r5 == null) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0453, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0456, code lost:
    
        if (r9 == null) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0458, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x045b, code lost:
    
        if (r8 == 0) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x045d, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0464, code lost:
    
        if (r23.f1509a == null) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0466, code lost:
    
        r23.f1509a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x046d, code lost:
    
        r4.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0470, code lost:
    
        if (r6 == null) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0472, code lost:
    
        r25.append("http://").append(r6).append("/file").append("\n").append(r12).append(".").append(r13).append("\n").append(com.sec.chaton.util.C1323bs.m4575a().getString("uid", ""));
        r4 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x04b1, code lost:
    
        new com.sec.chaton.p013a.C0225x(new android.os.Handler(android.os.Looper.getMainLooper())).m869a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x04c4, code lost:
    
        r5 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x04c5, code lost:
    
        r9 = r8;
        r8 = r7;
        r7 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x04c8, code lost:
    
        if (r7 != null) goto L275;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x04ca, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x04cd, code lost:
    
        if (r9 != null) goto L291;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x04cf, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x04d2, code lost:
    
        if (r8 != 0) goto L305;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x04d4, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x04db, code lost:
    
        if (r23.f1509a != null) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x04dd, code lost:
    
        r23.f1509a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x04e4, code lost:
    
        r4.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x04e7, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x04e8, code lost:
    
        r4 = 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x04eb, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x04ee, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x04f0, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r6, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x04fc, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x04ff, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0501, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r6, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x050d, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0510, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0512, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r6, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x051e, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0521, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0523, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r6, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x052f, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0532, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0534, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r6, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0541, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0544, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0546, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r6, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0553, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0556, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0558, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r6, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0565, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0568, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x056a, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r6, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0577, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x057a, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x057c, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r6, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0589, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x058c, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x058e, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r6, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x059b, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x059e, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x05a0, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r6, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x05ad, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x05b0, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x05b2, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r6, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x0607, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x060a, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x060c, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r6, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0619, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x061c, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x061e, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r6, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x062b, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x062e, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L215;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0630, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r6, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x063d, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0640, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0642, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r6, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x064f, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0652, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0654, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r5, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0661, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x0664, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0666, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r5, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x0673, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0676, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0678, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r5, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0685, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0688, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x068a, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r5, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x06a8, code lost:
    
        r5 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x06a9, code lost:
    
        r7 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x06ac, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x06ad, code lost:
    
        r7 = r5;
        r5 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x06bf, code lost:
    
        r5 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x06c0, code lost:
    
        r7 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x06c3, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x06c4, code lost:
    
        r7 = r5;
        r5 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x06d5, code lost:
    
        r7 = r8;
        r8 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x06da, code lost:
    
        r6 = r5;
        r7 = r8;
        r8 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x02bc, code lost:
    
        if (r4.getResponseCode() == 200) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x02be, code lost:
    
        r5 = r4.getResponseMessage();
        r6 = new java.io.BufferedInputStream(r4.getErrorStream());
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x02cb, code lost:
    
        r7 = com.sec.chaton.p018c.p022d.C0497b.m2520a(com.sec.chaton.p018c.C0495d.m2503a(r6));
        com.sec.chaton.util.C1341p.m4651a("[Upload]" + r5 + ":" + r7, getClass().getSimpleName());
        r25.append(r5).append(":").append(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x030b, code lost:
    
        if (r6 == null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x030d, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0310, code lost:
    
        if (r9 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0312, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0315, code lost:
    
        if (r8 == 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0317, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x031e, code lost:
    
        if (r23.f1509a == null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0320, code lost:
    
        r23.f1509a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0327, code lost:
    
        r4.disconnect();
        r4 = 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0334, code lost:
    
        if (r14 == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0336, code lost:
    
        com.sec.chaton.util.C1323bs.m4575a().edit().putBoolean("is_file_server_primary ", false).commit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x034a, code lost:
    
        if (r6 != null) goto L269;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x034c, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x034f, code lost:
    
        if (r8 != null) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0351, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0354, code lost:
    
        if (r7 != null) goto L299;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0356, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x035d, code lost:
    
        if (r23.f1509a != null) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x035f, code lost:
    
        r23.f1509a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0366, code lost:
    
        r4.disconnect();
        r4 = 9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x039e, code lost:
    
        if (com.sec.chaton.util.C1341p.f4578b != false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x03a0, code lost:
    
        com.sec.chaton.util.C1341p.m4653a(r5, getClass().getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x03ad, code lost:
    
        if (r7 != null) goto L262;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x03af, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x03b2, code lost:
    
        if (r9 != null) goto L279;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x03b4, code lost:
    
        r9.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x04b1 A[Catch: all -> 0x04c4, TRY_ENTER, TRY_LEAVE, TryCatch #27 {all -> 0x04c4, blocks: (B:74:0x0336, B:124:0x04b1), top: B:297:0x0334 }] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x03af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0241 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x034c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:271:0x03c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0218 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x04ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x03b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0351 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x022e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x04cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0356 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0233 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:305:0x04d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x035f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0238 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x04dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:320:0x03b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0336 A[Catch: all -> 0x04c4, TRY_ENTER, TRY_LEAVE, TryCatch #27 {all -> 0x04c4, blocks: (B:74:0x0336, B:124:0x04b1), top: B:297:0x0334 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x03a0 A[Catch: all -> 0x06a5, TRY_LEAVE, TryCatch #3 {all -> 0x06a5, blocks: (B:22:0x018b, B:23:0x0211, B:24:0x0217, B:51:0x02ae, B:53:0x02b6, B:55:0x02be, B:92:0x039c, B:94:0x03a0, B:110:0x03da, B:86:0x036c, B:88:0x0388, B:89:0x0394, B:70:0x032f), top: B:266:0x017c }] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v19, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.io.InputStream] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m2417a(java.lang.String r24, java.lang.StringBuilder r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1759
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p018c.p019a.RunnableC0474k.m2417a(java.lang.String, java.lang.StringBuilder):int");
    }

    /* renamed from: a */
    private boolean m2418a(int i) {
        if (this.f1512d == null) {
            return false;
        }
        synchronized (this.f1525q) {
            this.f1511c = i;
        }
        Message messageObtainMessage = this.f1512d.obtainMessage(2);
        messageObtainMessage.arg1 = i;
        return this.f1512d.sendMessage(messageObtainMessage);
    }

    /* renamed from: i */
    public boolean m2433i() {
        synchronized (this.f1524p) {
            this.f1526r = true;
        }
        if (this.f1509a != null) {
            try {
                try {
                    this.f1509a.close();
                } catch (IOException e) {
                    if (C1341p.f4578b) {
                        C1341p.m4653a(e, getClass().getName());
                    }
                }
            } finally {
                this.f1509a = null;
            }
        }
        return true;
    }
}
