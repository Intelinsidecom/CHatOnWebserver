package com.samsung.samm.lib.p003a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.infraware.office.evengine.InterfaceC0507E;
import com.samsung.samm.common.SObject;
import com.samsung.samm.common.SObjectImage;
import com.samsung.samm.lib.p003a.C0887a;
import com.samsung.samm.lib.p003a.C0901o;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.samsung.samm.lib.a.d */
/* loaded from: classes.dex */
public class C0890d {

    /* renamed from: c */
    private static String f479c = "SAMM Sample Application";

    /* renamed from: d */
    private static int f480d = 1;

    /* renamed from: e */
    private static int f481e = 0;

    /* renamed from: f */
    private static String f482f = "SDK";

    /* renamed from: P */
    private String f498P;

    /* renamed from: Q */
    private String f499Q;

    /* renamed from: R */
    private String f500R;

    /* renamed from: S */
    private String f501S;

    /* renamed from: T */
    private String f502T;

    /* renamed from: U */
    private String f503U;

    /* renamed from: V */
    private String f504V;

    /* renamed from: W */
    private String f505W;

    /* renamed from: X */
    private String f506X;

    /* renamed from: Y */
    private String f507Y;

    /* renamed from: Z */
    private boolean f508Z;

    /* renamed from: a */
    C0892f f509a;

    /* renamed from: aa */
    private boolean f510aa;

    /* renamed from: b */
    C0894h f511b;

    /* renamed from: i */
    private C0889c f514i;

    /* renamed from: j */
    private C0889c f515j;

    /* renamed from: k */
    private C0888b f516k;

    /* renamed from: l */
    private C0887a f517l;

    /* renamed from: m */
    private C0901o f518m;

    /* renamed from: s */
    private int f524s;

    /* renamed from: t */
    private int f525t;

    /* renamed from: u */
    private int f526u;

    /* renamed from: v */
    private int f527v;

    /* renamed from: z */
    private String f531z;

    /* renamed from: g */
    private LinkedList<SObject> f512g = null;

    /* renamed from: h */
    private a[] f513h = null;

    /* renamed from: n */
    private C0891e f519n = null;

    /* renamed from: o */
    private LinkedList<String> f520o = null;

    /* renamed from: p */
    private int f521p = 1;

    /* renamed from: q */
    private int f522q = 0;

    /* renamed from: r */
    private int f523r = 0;

    /* renamed from: w */
    private int f528w = 0;

    /* renamed from: x */
    private int f529x = 0;

    /* renamed from: y */
    private int f530y = 0;

    /* renamed from: A */
    private String f483A = null;

    /* renamed from: B */
    private int f484B = 0;

    /* renamed from: C */
    private int f485C = 0;

    /* renamed from: D */
    private String f486D = null;

    /* renamed from: E */
    private String f487E = null;

    /* renamed from: F */
    private String f488F = null;

    /* renamed from: G */
    private String f489G = null;

    /* renamed from: H */
    private boolean f490H = false;

    /* renamed from: I */
    private long f491I = 0;

    /* renamed from: J */
    private String f492J = null;

    /* renamed from: K */
    private int f493K = 0;

    /* renamed from: L */
    private int f494L = 0;

    /* renamed from: M */
    private boolean f495M = false;

    /* renamed from: N */
    private int f496N = 0;

    /* renamed from: O */
    private String f497O = null;

    public C0890d(String str, boolean z, boolean z2) {
        this.f498P = null;
        this.f499Q = null;
        this.f500R = null;
        this.f501S = null;
        this.f502T = null;
        this.f503U = null;
        this.f504V = null;
        this.f505W = null;
        this.f506X = null;
        this.f507Y = null;
        this.f508Z = true;
        this.f510aa = true;
        this.f498P = str;
        this.f499Q = C0903q.m584a();
        this.f500R = String.valueOf(this.f498P) + this.f499Q + "/";
        if (!new File(this.f500R).mkdirs()) {
        }
        this.f501S = String.valueOf(this.f500R) + "UpdatedAMSBGImage";
        this.f502T = String.valueOf(this.f500R) + "UpdatedAMSClearImage";
        this.f503U = String.valueOf(this.f500R) + "EmbedSticker";
        this.f504V = String.valueOf(this.f500R) + "EmbedVoiceObject";
        this.f505W = String.valueOf(this.f500R) + "TempAMS.ams";
        this.f506X = String.valueOf(this.f500R) + "TempAuthorImage.png";
        this.f507Y = String.valueOf(this.f500R) + "TempUnrecordedObjectImage.png";
        this.f508Z = z;
        this.f510aa = z2;
        m289U();
    }

    /* renamed from: U */
    private void m289U() {
        this.f509a = new C0892f();
        this.f511b = this.f509a.m436c();
        this.f512g = new LinkedList<>();
        m302af();
        this.f514i = new C0889c(this.f501S, this.f508Z);
        this.f515j = new C0889c(this.f502T, this.f510aa);
        this.f516k = new C0888b(this.f498P, this.f500R);
        this.f517l = new C0887a(this.f500R, this.f499Q);
        this.f518m = new C0901o();
        this.f519n = new C0891e();
        this.f520o = new LinkedList<>();
        m348e();
        this.f523r = 0;
        this.f524s = 0;
        this.f525t = 0;
        this.f528w = 0;
        this.f529x = 0;
        this.f531z = null;
        this.f483A = null;
        this.f484B = 0;
        this.f485C = 0;
        this.f486D = null;
        this.f487E = null;
        this.f488F = null;
        this.f489G = null;
        this.f490H = false;
        this.f491I = 0L;
        this.f492J = null;
        this.f493K = 0;
        this.f494L = 0;
        this.f495M = false;
        this.f496N = 0;
        this.f497O = "1.3g";
    }

    /* renamed from: a */
    public boolean m324a() {
        return C0903q.m598c(this.f500R);
    }

    /* renamed from: b */
    public boolean m338b() {
        String[] list = new File(this.f498P).list();
        if (list == null) {
            return false;
        }
        for (int i = 0; i < list.length; i++) {
            if (new File(String.valueOf(this.f498P) + list[i]).isDirectory() && System.currentTimeMillis() - Long.parseLong(list[i]) >= 86400000 && !C0903q.m598c(String.valueOf(this.f498P) + list[i])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: V */
    private int m290V() {
        if (this.f497O != null) {
            return this.f497O.length();
        }
        return 0;
    }

    /* renamed from: c */
    public LinkedList<SObject> m343c() {
        return this.f512g;
    }

    /* renamed from: d */
    public void m345d() {
        this.f512g.clear();
    }

    /* renamed from: e */
    public void m348e() {
        m323a(1);
        m337b(0);
    }

    /* renamed from: a */
    public void m323a(int i) {
        this.f521p = i;
    }

    /* renamed from: b */
    public void m337b(int i) {
        this.f522q = i;
    }

    /* renamed from: f */
    public int m351f() {
        return this.f512g.size();
    }

    /* renamed from: c */
    public SObject m342c(int i) {
        return this.f512g.get(i);
    }

    /* renamed from: d */
    public void m346d(int i) {
        this.f524s = i;
    }

    /* renamed from: g */
    public int m354g() {
        return this.f524s;
    }

    /* renamed from: e */
    public void m349e(int i) {
        this.f525t = i;
    }

    /* renamed from: h */
    public int m357h() {
        return this.f525t;
    }

    /* renamed from: f */
    public void m352f(int i) {
        this.f526u = i;
    }

    /* renamed from: i */
    public int m360i() {
        return this.f526u;
    }

    /* renamed from: g */
    public void m355g(int i) {
        this.f527v = i;
    }

    /* renamed from: j */
    public int m363j() {
        return this.f527v;
    }

    /* renamed from: k */
    public String m366k() {
        return this.f499Q;
    }

    /* renamed from: l */
    public String m368l() {
        return this.f505W;
    }

    /* renamed from: a */
    public String m322a(String str) {
        if (str == null) {
            Log.e("SAMMLibraryCore", "getTempSaveSAMMDataName : invalid sDataKey!");
            return null;
        }
        return String.valueOf(this.f498P) + str + "/TempAMS.ams";
    }

    /* renamed from: m */
    public int m370m() {
        return this.f514i.m264a();
    }

    /* renamed from: h */
    public void m358h(int i) {
        this.f514i.m265a(i);
    }

    /* renamed from: n */
    public int m372n() {
        return this.f514i.m271b();
    }

    /* renamed from: i */
    public void m361i(int i) {
        this.f514i.m280f(i);
    }

    /* renamed from: o */
    public int m374o() {
        return this.f514i.m281g();
    }

    /* renamed from: b */
    public boolean m341b(String str) {
        return this.f514i.m270a(str, this.f526u, this.f527v);
    }

    /* renamed from: p */
    public String m376p() {
        return this.f514i.m282h();
    }

    /* renamed from: q */
    public String m378q() {
        return this.f514i.m283i();
    }

    /* renamed from: a */
    public boolean m326a(Bitmap bitmap) {
        return this.f514i.m267a(bitmap, this.f526u, this.f527v);
    }

    /* renamed from: a */
    public boolean m325a(int i, int i2) {
        return this.f514i.m266a(i, i2);
    }

    /* renamed from: b */
    public boolean m340b(Bitmap bitmap) {
        if (bitmap != null) {
            return this.f515j.m267a(bitmap, this.f526u, this.f527v);
        }
        this.f515j.m265a(0);
        return true;
    }

    /* renamed from: r */
    public String m379r() {
        return this.f515j.m283i();
    }

    /* renamed from: j */
    public void m364j(int i) {
        this.f516k.m254a(i);
    }

    /* renamed from: s */
    public int m380s() {
        return this.f516k.m253a();
    }

    /* renamed from: k */
    public void m367k(int i) {
        this.f516k.m259b(i);
    }

    /* renamed from: t */
    public int m381t() {
        return this.f516k.m260c();
    }

    /* renamed from: c */
    public boolean m344c(String str) {
        return this.f516k.m257a(str);
    }

    /* renamed from: u */
    public String m382u() {
        return this.f516k.m258b();
    }

    /* renamed from: v */
    public String m383v() {
        return this.f516k.m261d();
    }

    /* renamed from: a */
    public boolean m332a(String str, String str2, Bitmap bitmap, int i) {
        return this.f517l.m233a(str, str2, bitmap, i);
    }

    /* renamed from: d */
    public boolean m347d(String str) {
        return this.f517l.m232a(str);
    }

    /* renamed from: l */
    public boolean m369l(int i) {
        return this.f517l.m230a(i);
    }

    /* renamed from: m */
    public C0887a.a m371m(int i) {
        return this.f517l.m235b(i);
    }

    /* renamed from: w */
    public int m384w() {
        return this.f517l.m234b();
    }

    /* renamed from: a */
    public boolean m331a(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return this.f518m.m545a(str, str2, i, i2, i3, i4, i5, i6, i7, this.f521p);
    }

    /* renamed from: n */
    public C0901o.a m373n(int i) {
        return this.f518m.m542a(i, this.f521p);
    }

    /* renamed from: o */
    public String m375o(int i) {
        return String.valueOf(this.f503U) + i + ".png";
    }

    /* renamed from: x */
    public String m385x() {
        return this.f503U;
    }

    /* renamed from: e */
    public boolean m350e(String str) {
        if (str == null) {
            this.f531z = str;
            return true;
        }
        if (str.length() > 65535) {
            Log.e("SAMMLibraryCore", "setAMSTitle: Title string length is out of bound!!!");
            return false;
        }
        this.f531z = str;
        return true;
    }

    /* renamed from: y */
    public String m386y() {
        return this.f531z;
    }

    /* renamed from: W */
    private int m291W() {
        if (this.f531z != null) {
            return this.f531z.length();
        }
        return 0;
    }

    /* renamed from: a */
    public static boolean m296a(String str, int i, int i2, String str2) {
        if (str == null || str.length() <= 0) {
            Log.e("SAMMLibraryCore", "setAMSAppID: App ID Name string is invalid!!!");
            return false;
        }
        if (i < 0 || i > 65535 || i2 < 0 || i2 > 65535) {
            Log.e("SAMMLibraryCore", "setAMSAppID Parameter is out of range!!! (VerMajor:" + i + ", VerMinor:" + i2 + ")");
            return false;
        }
        if (str.length() > 65535) {
            Log.e("SAMMLibraryCore", "setAMSAppID: App ID Name string length is out of bound!!!");
            return false;
        }
        if (str2 != null && str.length() > 65535) {
            Log.e("SAMMLibraryCore", "setAMSAppID: Patch Version string length is out of bound!!!");
            return false;
        }
        f479c = str;
        f480d = i & InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MAX_EVENT;
        f481e = i2 & InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MAX_EVENT;
        f482f = str2;
        return true;
    }

    /* renamed from: z */
    public static String m305z() {
        return f482f != null ? String.format("%s %d.%d %s", f479c, Integer.valueOf(f480d), Integer.valueOf(f481e), f482f) : String.format("%s %d.%d", f479c, Integer.valueOf(f480d), Integer.valueOf(f481e));
    }

    /* renamed from: A */
    public static String m285A() {
        return f479c;
    }

    /* renamed from: B */
    public static int m286B() {
        return f480d;
    }

    /* renamed from: C */
    public static int m287C() {
        return f481e;
    }

    /* renamed from: D */
    public static String m288D() {
        return f482f;
    }

    /* renamed from: X */
    private int m292X() {
        if (f479c != null) {
            return f479c.length();
        }
        return 0;
    }

    /* renamed from: Y */
    private int m293Y() {
        if (f482f != null) {
            return f482f.length();
        }
        return 0;
    }

    /* renamed from: E */
    public String m306E() {
        if (this.f483A == null) {
            return "Unknown App";
        }
        if (this.f486D != null) {
            return String.format("%s %d.%d %s", this.f483A, Integer.valueOf(this.f484B), Integer.valueOf(this.f485C), this.f486D);
        }
        return String.format("%s %d.%d", this.f483A, Integer.valueOf(this.f484B), Integer.valueOf(this.f485C));
    }

    /* renamed from: F */
    public String m307F() {
        return this.f483A;
    }

    /* renamed from: G */
    public int m308G() {
        return this.f484B;
    }

    /* renamed from: H */
    public int m309H() {
        return this.f485C;
    }

    /* renamed from: I */
    public String m310I() {
        return this.f486D;
    }

    /* renamed from: a */
    public boolean m333a(String str, String str2, String str3, Bitmap bitmap) {
        if (str != null && str.length() > 65535) {
            Log.e("SAMMLibraryCore", "setAMSAuthor: Author name string length is out of bound!!!");
            return false;
        }
        if (str2 != null && str2.length() > 65535) {
            Log.e("SAMMLibraryCore", "setAMSAuthor: Author Phone Number string length is out of bound!!!");
            return false;
        }
        if (str3 != null && str3.length() > 65535) {
            Log.e("SAMMLibraryCore", "setAMSAuthor: Author Email string length is out of bound!!!");
            return false;
        }
        this.f487E = str;
        this.f488F = str2;
        this.f489G = str3;
        if (bitmap != null) {
            if (C0902p.m576a(this.f506X, bitmap)) {
                this.f490H = true;
            } else {
                this.f490H = false;
                Log.e("SAMMLibraryCore", "setAMSAuthor: Fail to save Author Image!!!");
                return false;
            }
        } else {
            this.f490H = false;
        }
        return true;
    }

    /* renamed from: J */
    public String m311J() {
        return this.f487E;
    }

    /* renamed from: K */
    public String m312K() {
        return this.f488F;
    }

    /* renamed from: L */
    public String m313L() {
        return this.f489G;
    }

    /* renamed from: M */
    public Bitmap m314M() {
        if (this.f490H) {
            return BitmapFactory.decodeFile(this.f506X);
        }
        return null;
    }

    /* renamed from: Z */
    private int m294Z() {
        if (this.f487E != null) {
            return this.f487E.length();
        }
        return 0;
    }

    /* renamed from: aa */
    private int m297aa() {
        if (this.f488F != null) {
            return this.f488F.length();
        }
        return 0;
    }

    /* renamed from: ab */
    private int m298ab() {
        if (this.f489G != null) {
            return this.f489G.length();
        }
        return 0;
    }

    /* renamed from: N */
    public long m315N() {
        return this.f491I;
    }

    /* renamed from: p */
    public boolean m377p(int i) {
        if (i != 0 && i != 1 && (i < 2 || i >= 256)) {
            return false;
        }
        this.f496N = i;
        return true;
    }

    /* renamed from: O */
    public int m316O() {
        return this.f496N;
    }

    /* renamed from: f */
    public boolean m353f(String str) {
        if (str != null && str.length() > 65535) {
            Log.e("SAMMLibraryCore", "setAMSHypertext: Hypertext string length is out of bound!!!");
            return false;
        }
        this.f492J = str;
        return true;
    }

    /* renamed from: P */
    public String m317P() {
        return this.f492J;
    }

    /* renamed from: ac */
    private int m299ac() {
        if (this.f492J != null) {
            return this.f492J.length();
        }
        return 0;
    }

    /* renamed from: b */
    public boolean m339b(int i, int i2) {
        if (i < -90000000 || i > 90000000 || i2 < -180000000 || i2 > 180000000) {
            Log.e("SAMMLibraryCore", "setAMSGeoTag Parameter out of range!!! (Latitude:" + i + ", Longitude:" + i2 + ")");
            return false;
        }
        this.f493K = i;
        this.f494L = i2;
        return true;
    }

    /* renamed from: Q */
    public int m318Q() {
        return this.f493K;
    }

    /* renamed from: R */
    public int m319R() {
        return this.f494L;
    }

    /* renamed from: S */
    public String[] m320S() {
        return this.f519n.m410b("SAMM___LIBRARY___TAG___KEY", (String[]) null);
    }

    /* renamed from: g */
    public boolean m356g(String str) {
        if (str == null || str.isEmpty() || str.length() > 65535) {
            Log.e("SAMMLibraryCore", "TAG string is invalid!!!");
            return false;
        }
        if (this.f520o == null) {
            return false;
        }
        if (!this.f520o.contains(str)) {
            this.f520o.add(str);
        }
        int size = this.f520o.size();
        if (size <= 0) {
            return false;
        }
        String[] strArr = new String[size];
        Iterator<String> it = this.f520o.iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = it.next();
            i++;
        }
        this.f519n.m401a("SAMM___LIBRARY___TAG___KEY", strArr);
        return true;
    }

    /* renamed from: h */
    public boolean m359h(String str) {
        if (str == null || str.isEmpty()) {
            Log.e("SAMMLibraryCore", "TAG string is invalid!!!");
            return false;
        }
        if (this.f520o == null || !this.f520o.contains(str)) {
            return false;
        }
        this.f520o.remove(str);
        int size = this.f520o.size();
        if (size > 0) {
            String[] strArr = new String[size];
            Iterator<String> it = this.f520o.iterator();
            int i = 0;
            while (it.hasNext()) {
                strArr[i] = it.next();
                i++;
            }
            return this.f519n.m401a("SAMM___LIBRARY___TAG___KEY", strArr);
        }
        return this.f519n.m414d("SAMM___LIBRARY___TAG___KEY");
    }

    /* renamed from: a */
    public boolean m330a(String str, String str2) {
        return this.f519n.m397a(str, str2);
    }

    /* renamed from: b */
    public String m336b(String str, String str2) {
        return this.f519n.m405b(str, str2);
    }

    /* renamed from: i */
    public boolean m362i(String str) {
        return this.f519n.m395a(str);
    }

    /* renamed from: a */
    public boolean m328a(String str, int i) {
        return this.f519n.m396a(str, i);
    }

    /* renamed from: b */
    public int m335b(String str, int i) {
        return this.f519n.m403b(str, i);
    }

    /* renamed from: j */
    public boolean m365j(String str) {
        return this.f519n.m407b(str);
    }

    /* renamed from: T */
    public void m321T() {
        m289U();
    }

    /* renamed from: a */
    public boolean m327a(SObject sObject) throws Throwable {
        if (sObject == null) {
            Log.e("SAMMLibraryCore", "Invalid AnimationObject");
            return false;
        }
        while (this.f523r > this.f512g.size()) {
            if (this.f512g.removeLast() == null) {
                return false;
            }
            this.f523r--;
        }
        if ((sObject instanceof SObjectImage) && sObject.getStyle() == 2) {
            sObject.putTempData("SAMM___LIBRARY___IMAGE___PATH___KEY", this.f503U);
            int tempIntData = sObject.getTempIntData("SAMM___LIBRARY___IMAGE___ID___KEY", -1);
            if (tempIntData < 0) {
                int iM295a = m295a(sObject, this.f512g, this.f526u, this.f527v, true, this.f529x);
                if (iM295a < 0) {
                    return false;
                }
                if (iM295a == this.f529x) {
                    this.f529x++;
                }
                sObject.putTempData("SAMM___LIBRARY___IMAGE___ID___KEY", iM295a);
            } else if (this.f529x <= tempIntData) {
                this.f529x = tempIntData + 1;
            }
        }
        boolean zAdd = this.f512g.add(sObject);
        if (zAdd) {
            return zAdd;
        }
        return false;
    }

    /* renamed from: k */
    public static boolean m303k(String str) {
        C0892f c0892f = new C0892f();
        if (c0892f.m435b(str)) {
            return c0892f.m437d();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:405:0x02a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m329a(java.lang.String r11, com.samsung.samm.lib.C0906d r12, int r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2082
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.samm.lib.p003a.C0890d.m329a(java.lang.String, com.samsung.samm.lib.d, int):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0468 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m334a(java.lang.String r13, boolean r14, android.graphics.Rect r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2491
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.samm.lib.p003a.C0890d.m334a(java.lang.String, boolean, android.graphics.Rect):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v19, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.RandomAccessFile] */
    /* renamed from: l */
    public static boolean m304l(String str) throws Throwable {
        RandomAccessFile randomAccessFile;
        Object obj;
        boolean z = false;
        int iM430a = C0892f.m430a(str);
        if (iM430a > 0) {
            ?? r3 = 0;
            r3 = 0;
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    randomAccessFile = new RandomAccessFile(str, "rw");
                } catch (FileNotFoundException e) {
                    e = e;
                    randomAccessFile = null;
                } catch (IOException e2) {
                    e = e2;
                }
                try {
                    randomAccessFile.skipBytes(iM430a);
                    long j = iM430a;
                    randomAccessFile.setLength(j);
                    Object obj2 = randomAccessFile;
                    long j2 = j;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                            obj2 = randomAccessFile;
                            j2 = j;
                        } catch (IOException e3) {
                            String str2 = "Read AMS Header Error : IOException : " + e3;
                            Log.e("SAMMLibraryCore", str2);
                            e3.printStackTrace();
                            obj2 = str2;
                            j2 = "Read AMS Header Error : IOException : ";
                        }
                    }
                    z = true;
                    obj = obj2;
                    r3 = j2;
                } catch (FileNotFoundException e4) {
                    e = e4;
                    String str3 = "SAMMLibraryCore";
                    Log.e("SAMMLibraryCore", "FileNotFoundException : " + e);
                    e.printStackTrace();
                    obj = randomAccessFile;
                    r3 = str3;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                            obj = randomAccessFile;
                            r3 = str3;
                        } catch (IOException e5) {
                            String str4 = "Read AMS Header Error : IOException : " + e5;
                            Log.e("SAMMLibraryCore", str4);
                            e5.printStackTrace();
                            obj = "SAMMLibraryCore";
                            r3 = str4;
                        }
                    }
                    return z;
                } catch (IOException e6) {
                    e = e6;
                    r3 = randomAccessFile;
                    Log.e("SAMMLibraryCore", "IOException : " + e);
                    e.printStackTrace();
                    if (r3 != 0) {
                        try {
                            r3.close();
                        } catch (IOException e7) {
                            r3 = "Read AMS Header Error : IOException : " + e7;
                            Log.e("SAMMLibraryCore", r3);
                            e7.printStackTrace();
                        }
                    }
                    return z;
                }
            } catch (Throwable th2) {
                th = th2;
                r3 = obj;
                if (r3 != 0) {
                    try {
                        r3.close();
                    } catch (IOException e8) {
                        Log.e("SAMMLibraryCore", "Read AMS Header Error : IOException : " + e8);
                        e8.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return z;
    }

    /* renamed from: ad */
    private boolean m300ad() {
        boolean z;
        if (this.f512g == null || this.f513h == null) {
            return false;
        }
        if (this.f512g.size() == 0) {
            return true;
        }
        for (int i = 0; i < 255; i++) {
            this.f513h[i].m388a(-1);
        }
        Iterator<SObject> it = this.f512g.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            SObject next = it.next();
            if ((next instanceof SObjectImage) && next.getStyle() == 2) {
                int tempIntData = next.getTempIntData("SAMM___LIBRARY___IMAGE___ID___KEY", -1);
                if (tempIntData < 0) {
                    return false;
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= i2) {
                        z = false;
                        break;
                    }
                    if (this.f513h[i3].m387a() == tempIntData) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z) {
                    continue;
                } else if (i2 < 255) {
                    this.f513h[i2].m388a(tempIntData);
                    i2++;
                } else {
                    Log.e("SAMMLibraryCore", "The number of object images is out of bound (255)");
                    return false;
                }
            }
        }
        Iterator<SObject> it2 = this.f512g.iterator();
        while (it2.hasNext()) {
            SObject next2 = it2.next();
            if ((next2 instanceof SObjectImage) && next2.getStyle() == 2) {
                int tempIntData2 = next2.getTempIntData("SAMM___LIBRARY___IMAGE___ID___KEY", -1);
                if (tempIntData2 < 0) {
                    return false;
                }
                for (int i4 = 0; i4 < i2; i4++) {
                    int iM387a = this.f513h[i4].m387a();
                    if (iM387a == tempIntData2 && i4 != iM387a) {
                        next2.putTempData("SAMM___LIBRARY___IMAGE___ID___KEY", i4);
                    }
                }
            }
        }
        this.f530y = i2;
        return true;
    }

    /* renamed from: ae */
    private boolean m301ae() {
        int iM472j = this.f511b.m472j();
        Iterator<SObject> it = this.f512g.iterator();
        while (it.hasNext()) {
            SObject next = it.next();
            if ((next instanceof SObjectImage) && next.getStyle() == 2) {
                int tempIntData = next.getTempIntData("SAMM___LIBRARY___IMAGE___ID___KEY", -1);
                if (tempIntData < 0) {
                    return false;
                }
                for (int i = 0; i < iM472j; i++) {
                    int iM387a = this.f513h[i].m387a();
                    if (i == tempIntData && i != iM387a) {
                        next.putTempData("SAMM___LIBRARY___IMAGE___ID___KEY", iM387a);
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: af */
    private void m302af() {
        this.f513h = null;
        this.f513h = new a[255];
        for (int i = 0; i < 255; i++) {
            this.f513h[i] = new a();
        }
        this.f530y = 0;
    }

    /* renamed from: com.samsung.samm.lib.a.d$a */
    public class a {

        /* renamed from: b */
        private int f533b = 0;

        /* renamed from: c */
        private int f534c = -1;

        /* renamed from: d */
        private int f535d = 0;

        public a() {
        }

        /* renamed from: a */
        public int m387a() {
            return this.f534c;
        }

        /* renamed from: a */
        public void m388a(int i) {
            this.f534c = i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x02d6, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x02d7, code lost:
    
        android.util.Log.e("SAMMLibraryCore", "getImageID IOException : " + r5);
        r5.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0067, code lost:
    
        if (r5 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
    
        r5.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:121:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x029b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m295a(com.samsung.samm.common.SObject r19, java.util.LinkedList<com.samsung.samm.common.SObject> r20, int r21, int r22, boolean r23, int r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 834
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.samm.lib.p003a.C0890d.m295a(com.samsung.samm.common.SObject, java.util.LinkedList, int, int, boolean, int):int");
    }
}
