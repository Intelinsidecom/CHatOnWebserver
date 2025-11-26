package com.sec.chaton.p037j.p040c;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.msgsend.C1759s;
import com.sec.chaton.msgsend.EnumC1751k;
import com.sec.chaton.multimedia.doc.FileExplorerActivity;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p037j.p039b.C1552a;
import com.sec.chaton.trunk.p061c.C3025f;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: FileUploadTask.java */
/* renamed from: com.sec.chaton.j.c.i */
/* loaded from: classes.dex */
public class RunnableC1563i implements Runnable {

    /* renamed from: b */
    private static final String f5793b = RunnableC1563i.class.getSimpleName();

    /* renamed from: c */
    private Handler f5795c;

    /* renamed from: e */
    private Handler f5797e;

    /* renamed from: f */
    private long f5798f;

    /* renamed from: g */
    private String f5799g;

    /* renamed from: h */
    private File f5800h;

    /* renamed from: i */
    private EnumC1450r f5801i;

    /* renamed from: j */
    private EnumC1455w f5802j;

    /* renamed from: k */
    private String f5803k;

    /* renamed from: l */
    private String f5804l;

    /* renamed from: n */
    private String f5806n;

    /* renamed from: o */
    private String f5807o;

    /* renamed from: t */
    private String f5812t;

    /* renamed from: u */
    private String f5813u;

    /* renamed from: v */
    private EnumC1751k f5814v;

    /* renamed from: d */
    private int f5796d = 0;

    /* renamed from: s */
    private boolean f5811s = false;

    /* renamed from: m */
    private ArrayList<String> f5805m = new ArrayList<>();

    /* renamed from: p */
    private boolean f5808p = false;

    /* renamed from: q */
    private final Object f5809q = new Object();

    /* renamed from: r */
    private final Object f5810r = new Object();

    /* renamed from: a */
    DataOutputStream f5794a = null;

    /* renamed from: a */
    public String m6648a() {
        return this.f5799g;
    }

    /* renamed from: b */
    public EnumC1450r m6653b() {
        return this.f5801i;
    }

    /* renamed from: c */
    public EnumC1455w m6654c() {
        return this.f5802j;
    }

    /* renamed from: d */
    public String m6655d() {
        return this.f5803k;
    }

    /* renamed from: e */
    public String[] m6656e() {
        return (String[]) this.f5805m.toArray(new String[this.f5805m.size()]);
    }

    /* renamed from: f */
    public String m6657f() {
        return this.f5806n;
    }

    /* renamed from: g */
    public String m6658g() {
        return this.f5804l;
    }

    /* renamed from: h */
    public String m6659h() {
        return this.f5812t;
    }

    /* renamed from: i */
    public EnumC1751k m6660i() {
        return this.f5814v;
    }

    /* renamed from: j */
    public String m6661j() {
        return this.f5813u;
    }

    /* renamed from: k */
    public String m6662k() {
        return this.f5807o;
    }

    /* renamed from: a */
    public void m6649a(Handler handler) {
        this.f5797e = handler;
    }

    /* renamed from: a */
    public static boolean m6645a(int i, int i2) {
        if (!C1757q.m7251b()) {
            return false;
        }
        C1759s.m7260a(f5793b, "isNeedToChangeStateToPending(), resultCode(%d), faultCode(%d)", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 2:
            case 5:
            case 9:
            case 12:
            case 13:
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
    public static String m6643a(File file, EnumC1455w enumC1455w) {
        String strSubstring;
        try {
            strSubstring = file.getName().substring(file.getName().lastIndexOf("."));
        } catch (IndexOutOfBoundsException e) {
            C3250y.m11443a(e, RunnableC1563i.class.getSimpleName());
        }
        if (strSubstring == null) {
            strSubstring = null;
        } else if (strSubstring.contains(".")) {
            strSubstring = strSubstring.substring(1);
        }
        if (strSubstring == null && enumC1455w == EnumC1455w.AMS && C3025f.m10540b(file.getPath())) {
            strSubstring = "jpg";
            C1759s.m7260a(f5793b, "FILE Extention : forced to be 'JPG' ", new Object[0]);
        }
        if (strSubstring == null) {
            C1759s.m7260a(f5793b, "FILE Extention : could not be determined '", new Object[0]);
        }
        return strSubstring;
    }

    /* renamed from: a */
    public void m6650a(Handler handler, File file, EnumC1455w enumC1455w, Handler handler2) {
        this.f5795c = handler;
        this.f5797e = handler2;
        this.f5800h = file;
        this.f5802j = enumC1455w;
        this.f5803k = m6643a(file, enumC1455w);
    }

    /* renamed from: a */
    public void m6651a(Handler handler, String str, File file, long j, String str2, EnumC1450r enumC1450r, EnumC1455w enumC1455w, String str3, String[] strArr, String str4, boolean z, String str5, String str6, EnumC1751k enumC1751k) {
        this.f5795c = handler;
        this.f5806n = str;
        this.f5798f = j;
        this.f5801i = enumC1450r;
        this.f5799g = str2;
        this.f5800h = file;
        this.f5802j = enumC1455w;
        this.f5812t = str5;
        this.f5813u = str6;
        this.f5814v = enumC1751k;
        this.f5803k = m6643a(file, enumC1455w);
        this.f5804l = str4;
        for (String str7 : strArr) {
            this.f5805m.add(str7);
        }
        this.f5808p = z;
    }

    /* renamed from: l */
    public int m6663l() {
        int i;
        synchronized (this.f5810r) {
            i = this.f5796d;
        }
        return i;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        String mimeTypeFromExtension;
        boolean z;
        int i;
        if (!m6647m()) {
            m6646a(false, 11, null);
            return;
        }
        switch (this.f5802j) {
            case IMAGE:
            case AMS:
                try {
                    mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(this.f5803k.toLowerCase());
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    C3250y.m11443a(e, getClass().getSimpleName());
                }
            case VIDEO:
                mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(this.f5803k.toLowerCase());
                break;
            case AUDIO:
                mimeTypeFromExtension = "audio/" + this.f5803k.toLowerCase();
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
            case DOCUMENT:
            case FILE:
                mimeTypeFromExtension = FileExplorerActivity.m7383a(this.f5803k.toLowerCase());
                break;
            default:
                mimeTypeFromExtension = "";
                break;
        }
        StringBuilder sb = new StringBuilder();
        int iM6642a = m6642a(mimeTypeFromExtension, sb);
        if (iM6642a != 8) {
            C3250y.m11442a("Failed to upload file [nResultCode:" + iM6642a + "]", getClass().getSimpleName());
            if (iM6642a == 12 || iM6642a == 13) {
                int iM6642a2 = m6642a(mimeTypeFromExtension, sb);
                if (iM6642a2 == 8) {
                    i = iM6642a2;
                    z = true;
                } else {
                    i = iM6642a2;
                    z = false;
                }
            } else {
                z = false;
                i = iM6642a;
            }
        } else {
            z = true;
            i = iM6642a;
        }
        m6646a(z, i, sb.toString());
    }

    /* renamed from: m */
    private boolean m6647m() {
        if (this.f5808p) {
            C1373q.m6196e(CommonApplication.m11493l().getContentResolver(), Long.valueOf(this.f5798f));
        }
        return C3243r.m11421a(this.f5802j, this.f5803k) && this.f5800h.length() <= 10485760;
    }

    /* renamed from: a */
    private boolean m6646a(boolean z, int i, String str) throws Throwable {
        int iM6587a = 0;
        if (z) {
            C1373q.m6195d(CommonApplication.m11493l().getContentResolver(), Long.valueOf(this.f5798f));
            Bitmap bitmapM11414a = null;
            if (EnumC1455w.IMAGE == this.f5802j) {
                bitmapM11414a = C3243r.m11414a(CommonApplication.m11493l(), this.f5800h, true, true, false);
            } else if (EnumC1455w.VIDEO == this.f5802j) {
                bitmapM11414a = C3243r.m11414a(CommonApplication.m11493l(), this.f5800h, false, true, false);
            }
            if (bitmapM11414a != null) {
                bitmapM11414a.recycle();
            }
            this.f5807o = str;
        } else {
            if (!TextUtils.isEmpty(str) && str.lastIndexOf(":") > -1) {
                iM6587a = C1552a.m6587a(str.substring(str.lastIndexOf(":") + 1).trim());
            }
            if (this.f5814v != null) {
                if (EnumC1455w.CONTACT == this.f5802j || EnumC1455w.CALENDAR == this.f5802j || EnumC1455w.DOCUMENT == this.f5802j || EnumC1455w.FILE == this.f5802j) {
                    if (!this.f5814v.m7198a() && m6645a(i, iM6587a)) {
                        C1373q.m6157a(GlobalApplication.m11493l().getContentResolver(), Long.valueOf(this.f5798f), this.f5804l);
                    } else {
                        C1373q.m6188b(GlobalApplication.m11493l().getContentResolver(), Long.valueOf(this.f5798f), this.f5804l);
                    }
                } else if (!this.f5814v.m7198a() && m6645a(i, iM6587a)) {
                    C1373q.m6155a(GlobalApplication.m11493l().getContentResolver(), Long.valueOf(this.f5798f));
                } else {
                    C1373q.m6187b(GlobalApplication.m11493l().getContentResolver(), Long.valueOf(this.f5798f));
                }
            }
            this.f5807o = "";
        }
        if (this.f5795c != null) {
            Message messageObtainMessage = this.f5795c.obtainMessage(1);
            messageObtainMessage.arg1 = i;
            messageObtainMessage.arg2 = iM6587a;
            messageObtainMessage.obj = new C1565k(this, z, this.f5798f, str);
            this.f5795c.sendMessage(messageObtainMessage);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x038a, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r3, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0391, code lost:
    
        if (r4 != null) goto L432;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0393, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0396, code lost:
    
        if (r7 != null) goto L442;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0398, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x039b, code lost:
    
        if (r6 != 0) goto L436;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x039d, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x03a4, code lost:
    
        if (r20.f5794a != null) goto L451;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x03a6, code lost:
    
        r20.f5794a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x03ad, code lost:
    
        r2.disconnect();
        r2 = 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x03bc, code lost:
    
        m6644a(100);
        com.sec.chaton.util.C3250y.m11450b("[End uploading] Uploaded FileSize: " + r5 + ", FileName:" + r10 + ", Time(Upload): " + (java.lang.System.currentTimeMillis() - r12), getClass().getSimpleName());
        r3 = new java.io.BufferedInputStream(r2.getInputStream());
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0401, code lost:
    
        r4 = com.sec.chaton.p037j.C1554c.m6591a(r3).trim();
        com.sec.chaton.util.C3250y.m11450b("[Upload IP] " + r4, getClass().getSimpleName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0427, code lost:
    
        if (r3 == null) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0429, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x042c, code lost:
    
        if (r7 == null) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x042e, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0431, code lost:
    
        if (r6 == 0) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0433, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x043a, code lost:
    
        if (r20.f5794a == null) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x043c, code lost:
    
        r20.f5794a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0443, code lost:
    
        r2.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0446, code lost:
    
        if (r4 == null) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0448, code lost:
    
        r22.append("http://").append(r4).append("/file").append("\n").append(r10).append("\n").append(com.sec.chaton.util.C3159aa.m10962a().m10979a("uid", ""));
        r2 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x047d, code lost:
    
        new com.sec.chaton.p025d.C1334l(new android.os.Handler(android.os.Looper.getMainLooper())).m5775a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0490, code lost:
    
        r3 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0491, code lost:
    
        r7 = r6;
        r6 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0493, code lost:
    
        if (r4 != null) goto L457;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0495, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0498, code lost:
    
        if (r7 != null) goto L476;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x049a, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x049d, code lost:
    
        if (r6 != 0) goto L468;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x049f, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x04a6, code lost:
    
        if (r20.f5794a != null) goto L398;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x04a8, code lost:
    
        r20.f5794a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x04af, code lost:
    
        r2.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x04b2, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x04bc, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x04be, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r3, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x04c5, code lost:
    
        if (r4 != null) goto L472;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x04c7, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x04ca, code lost:
    
        if (r7 != null) goto L402;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x04cc, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x04cf, code lost:
    
        if (r6 != 0) goto L394;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x04d1, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x04d8, code lost:
    
        if (r20.f5794a != null) goto L406;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x04da, code lost:
    
        r20.f5794a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x04e1, code lost:
    
        r2.disconnect();
        r2 = 12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x04f0, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x04f2, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r3, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x04f9, code lost:
    
        if (r4 != null) goto L416;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x04fb, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x04fe, code lost:
    
        if (r7 != null) goto L426;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0500, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0503, code lost:
    
        if (r6 != 0) goto L420;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0505, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x050c, code lost:
    
        if (r20.f5794a != null) goto L430;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x050e, code lost:
    
        r20.f5794a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0515, code lost:
    
        r2.disconnect();
        r2 = 13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0524, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0526, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r3, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x052d, code lost:
    
        if (r4 != null) goto L440;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x052f, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0532, code lost:
    
        if (r7 != null) goto L459;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0534, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0537, code lost:
    
        if (r6 != 0) goto L444;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0539, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0540, code lost:
    
        if (r20.f5794a != null) goto L470;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0542, code lost:
    
        r20.f5794a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0549, code lost:
    
        r2.disconnect();
        r2 = 10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x054f, code lost:
    
        r2 = 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0552, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0555, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0557, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x055e, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0561, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0563, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x056a, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x056d, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x056f, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0576, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0579, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L215;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x057b, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0582, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0585, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0587, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x058e, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0591, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0593, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x059a, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x059d, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x059f, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x05a6, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x05a9, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x05ab, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x05b2, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x05b5, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x05b7, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x05be, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x05c1, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L239;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x05c3, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x05ca, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x05cd, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x05cf, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x05d6, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x05d9, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x05db, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x05e2, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x05e5, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L251;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x05e7, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x05ee, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x05f1, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x05f3, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x05fa, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x05fd, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x05ff, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0606, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x0609, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x060b, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0612, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0615, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x0617, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x061e, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0621, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L271;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0623, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x062a, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x062d, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L275;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x062f, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0636, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x0639, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L279;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x063b, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x0642, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x0645, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L283;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0647, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x064e, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x0651, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L287;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x0653, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x065a, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x065d, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L291;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x065f, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x0666, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x0669, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L295;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x066b, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x0672, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x0675, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L299;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x0677, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x067e, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x0681, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x0683, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x068a, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x068d, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x068f, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x0696, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x0699, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L311;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x069b, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x06a2, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x06a5, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L315;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x06a7, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x06ae, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x06b1, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L319;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x06b3, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x06ba, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x06bd, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L323;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x06bf, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x06c6, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x06c9, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L327;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x06cb, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x06d2, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x06d5, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x06d7, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r3, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x06de, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x06e1, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L335;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x06e3, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r3, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x06ea, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x06ed, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L339;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x06ef, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r3, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x01f2, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x06f6, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x06f9, code lost:
    
        if (com.sec.chaton.util.C3250y.f11734b != false) goto L343;
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x06fb, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r3, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x0713, code lost:
    
        r3 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x0714, code lost:
    
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x0717, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x0718, code lost:
    
        r4 = r3;
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x0727, code lost:
    
        r3 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x0728, code lost:
    
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x01f8, code lost:
    
        if (r20.f5811s == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x072b, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x072c, code lost:
    
        r4 = r3;
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x073b, code lost:
    
        r3 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x073c, code lost:
    
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x073f, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x0740, code lost:
    
        r4 = r3;
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x01fa, code lost:
    
        com.sec.chaton.util.C3250y.m11450b("Upload canceled by the user", com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x074f, code lost:
    
        r3 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x0750, code lost:
    
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x0753, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x0754, code lost:
    
        r4 = r3;
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x0769, code lost:
    
        r3 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x076a, code lost:
    
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x076d, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x076e, code lost:
    
        r4 = r3;
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x0780, code lost:
    
        r4 = r5;
        r5 = r6;
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x0786, code lost:
    
        r4 = r3;
        r5 = r6;
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0203, code lost:
    
        if (0 == 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0205, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0208, code lost:
    
        if (r7 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x020a, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x020d, code lost:
    
        if (r6 == 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x020f, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0216, code lost:
    
        if (r20.f5794a == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0218, code lost:
    
        r20.f5794a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x021f, code lost:
    
        r2.disconnect();
        r2 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x027f, code lost:
    
        if (r2.getResponseCode() == 200) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0281, code lost:
    
        r3 = r2.getResponseMessage();
        r5 = new java.io.BufferedInputStream(r2.getErrorStream());
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x028e, code lost:
    
        r4 = com.sec.chaton.p037j.p039b.C1553b.m6588a(com.sec.chaton.p037j.C1554c.m6591a(r5));
        com.sec.chaton.util.C3250y.m11442a("[Upload]" + r3 + ":" + r4, com.sec.chaton.p037j.p040c.RunnableC1563i.f5793b);
        r22.append(r3).append(":").append(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x02d6, code lost:
    
        if (com.sec.common.CommonApplication.m11493l().getResources().getBoolean(com.sec.chaton.R.bool.log_collector) != true) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x02d8, code lost:
    
        com.sec.chaton.p033i.p034a.C1533b.m6523a("01000006", "2001", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x02e0, code lost:
    
        if (r5 == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x02e2, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x02e5, code lost:
    
        if (r7 == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x02e7, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x02ea, code lost:
    
        if (r6 == 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x02ec, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x02f3, code lost:
    
        if (r20.f5794a == null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x02f5, code lost:
    
        r20.f5794a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x02fc, code lost:
    
        r2.disconnect();
        r2 = 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0308, code lost:
    
        if (r11 == false) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x030a, code lost:
    
        com.sec.chaton.util.C3159aa.m10962a().m10983b("is_file_server_primary ", (java.lang.Boolean) false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x031a, code lost:
    
        if (r4 != null) goto L408;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x031c, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x031f, code lost:
    
        if (r6 != null) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0321, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0324, code lost:
    
        if (r5 != null) goto L412;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0326, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x032d, code lost:
    
        if (r20.f5794a != null) goto L422;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x032f, code lost:
    
        r20.f5794a.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0336, code lost:
    
        r2.disconnect();
        r2 = 9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:136:0x047d A[Catch: all -> 0x0490, TRY_ENTER, TRY_LEAVE, TryCatch #54 {all -> 0x0490, blocks: (B:84:0x030a, B:136:0x047d), top: B:461:0x0308 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x04be A[Catch: all -> 0x0710, TRY_LEAVE, TryCatch #55 {all -> 0x0710, blocks: (B:22:0x015a, B:24:0x0172, B:25:0x0179, B:26:0x01d9, B:27:0x01dd, B:59:0x0273, B:61:0x0279, B:63:0x0281, B:185:0x0522, B:187:0x0526, B:169:0x04ee, B:171:0x04f2, B:153:0x04ba, B:155:0x04be, B:106:0x038a, B:122:0x03bc, B:96:0x033c, B:98:0x034f, B:100:0x035c, B:102:0x0360, B:103:0x0382, B:80:0x0304), top: B:463:0x014b }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x04f2 A[Catch: all -> 0x0710, TRY_LEAVE, TryCatch #55 {all -> 0x0710, blocks: (B:22:0x015a, B:24:0x0172, B:25:0x0179, B:26:0x01d9, B:27:0x01dd, B:59:0x0273, B:61:0x0279, B:63:0x0281, B:185:0x0522, B:187:0x0526, B:169:0x04ee, B:171:0x04f2, B:153:0x04ba, B:155:0x04be, B:106:0x038a, B:122:0x03bc, B:96:0x033c, B:98:0x034f, B:100:0x035c, B:102:0x0360, B:103:0x0382, B:80:0x0304), top: B:463:0x014b }] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0526 A[Catch: all -> 0x0710, TRY_LEAVE, TryCatch #55 {all -> 0x0710, blocks: (B:22:0x015a, B:24:0x0172, B:25:0x0179, B:26:0x01d9, B:27:0x01dd, B:59:0x0273, B:61:0x0279, B:63:0x0281, B:185:0x0522, B:187:0x0526, B:169:0x04ee, B:171:0x04f2, B:153:0x04ba, B:155:0x04be, B:106:0x038a, B:122:0x03bc, B:96:0x033c, B:98:0x034f, B:100:0x035c, B:102:0x0360, B:103:0x0382, B:80:0x0304), top: B:463:0x014b }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0172 A[Catch: SocketTimeoutException -> 0x0305, UnknownHostException -> 0x0389, all -> 0x0710, Exception -> 0x0724, EOFException -> 0x0738, SocketException -> 0x074c, TryCatch #55 {all -> 0x0710, blocks: (B:22:0x015a, B:24:0x0172, B:25:0x0179, B:26:0x01d9, B:27:0x01dd, B:59:0x0273, B:61:0x0279, B:63:0x0281, B:185:0x0522, B:187:0x0526, B:169:0x04ee, B:171:0x04f2, B:153:0x04ba, B:155:0x04be, B:106:0x038a, B:122:0x03bc, B:96:0x033c, B:98:0x034f, B:100:0x035c, B:102:0x0360, B:103:0x0382, B:80:0x0304), top: B:463:0x014b }] */
    /* JADX WARN: Removed duplicated region for block: B:394:0x04d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:398:0x04a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:402:0x04cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:406:0x04da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:408:0x031c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:412:0x0326 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:416:0x04fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:418:0x0321 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0505 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:422:0x032f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0500 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:430:0x050e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0393 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:436:0x039d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:440:0x052f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:442:0x0398 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:444:0x0539 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:446:0x01de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:451:0x03a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:457:0x0495 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:459:0x0534 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:468:0x049f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:470:0x0542 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:472:0x04c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:476:0x049a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x030a A[Catch: all -> 0x0490, TRY_ENTER, TRY_LEAVE, TryCatch #54 {all -> 0x0490, blocks: (B:84:0x030a, B:136:0x047d), top: B:461:0x0308 }] */
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
    private int m6642a(java.lang.String r21, java.lang.StringBuilder r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1931
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p037j.p040c.RunnableC1563i.m6642a(java.lang.String, java.lang.StringBuilder):int");
    }

    /* renamed from: a */
    private boolean m6644a(int i) {
        if (this.f5797e == null) {
            return false;
        }
        synchronized (this.f5810r) {
            this.f5796d = i;
        }
        Message messageObtainMessage = this.f5797e.obtainMessage(2);
        messageObtainMessage.arg1 = i;
        return this.f5797e.sendMessage(messageObtainMessage);
    }

    /* renamed from: a */
    public boolean m6652a(boolean z) {
        synchronized (this.f5809q) {
            this.f5811s = z;
        }
        try {
            if (this.f5794a != null) {
                try {
                    this.f5794a.close();
                } catch (IOException e) {
                    if (C3250y.f11734b) {
                        C3250y.m11443a(e, f5793b);
                    }
                }
                return true;
            }
            return true;
        } finally {
            this.f5794a = null;
        }
    }
}
