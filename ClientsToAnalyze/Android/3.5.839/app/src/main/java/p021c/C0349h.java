package p021c;

import com.p137vk.sdk.api.VKApiConst;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import p021c.p022a.C0326a;
import p021c.p022a.C0328c;
import p021c.p022a.C0332g;
import p021c.p022a.C0333h;
import p021c.p022a.C0334i;
import p021c.p023b.p024a.C0338b;

/* compiled from: Weibo.java */
/* renamed from: c.h */
/* loaded from: classes.dex */
public class C0349h extends C0353l implements Serializable {

    /* renamed from: a */
    public static String f842a = "1552112022";

    /* renamed from: b */
    public static String f843b = "bd9e3b147ece106f9cee159758a28ec1";

    /* renamed from: c */
    public static final C0350i f844c = new C0350i("im");

    /* renamed from: d */
    public static final C0350i f845d = new C0350i("sms");

    /* renamed from: e */
    public static final C0350i f846e = new C0350i("none");

    /* renamed from: i */
    private String f847i = C0325a.m1098d() + "api.t.sina.com.cn/";

    /* renamed from: j */
    private String f848j = C0325a.m1098d() + "api.t.sina.com.cn/";

    /* renamed from: k */
    private String f849k = "https://api.weibo.com/oauth2/";

    /* renamed from: l */
    private SimpleDateFormat f850l = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);

    @Override // p021c.C0353l
    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo1233b(String str, String str2) {
        super.mo1233b(str, str2);
    }

    @Override // p021c.C0353l
    /* renamed from: e */
    public /* bridge */ /* synthetic */ void mo1237e(String str) {
        super.mo1237e(str);
    }

    @Override // p021c.C0353l
    /* renamed from: f */
    public /* bridge */ /* synthetic */ void mo1238f(String str) {
        super.mo1238f(str);
    }

    @Override // p021c.C0353l
    /* renamed from: g */
    public /* bridge */ /* synthetic */ void mo1239g(String str) {
        super.mo1239g(str);
    }

    @Override // p021c.C0353l
    /* renamed from: h */
    public /* bridge */ /* synthetic */ void mo1240h(String str) {
        super.mo1240h(str);
    }

    /* renamed from: a */
    public C0346e m1226a(String str) {
        return new C0346e(m1225a(m1232b() + "users/show.json", new C0332g[]{new C0332g("user_id", str)}, this.f858f.m1141a()).m1175c());
    }

    /* renamed from: a */
    public C0347f m1227a(String str, int i, int i2) {
        return C0346e.m1215a(m1225a(m1232b() + "statuses/friends.json", new C0332g[]{new C0332g("uid", str), new C0332g("cursor", i), new C0332g(VKApiConst.COUNT, i2)}, true));
    }

    /* renamed from: b */
    public C0345d m1231b(String str) {
        return new C0345d(this.f858f.m1136a(m1232b() + "statuses/update.json", new C0332g[]{new C0332g("status", str)}, true));
    }

    /* renamed from: a */
    public synchronized void m1229a(String str, String str2) {
        this.f858f.m1140a(str, str2);
    }

    /* renamed from: c */
    public C0333h m1234c(String str) {
        return this.f858f.m1146c(str);
    }

    /* renamed from: a */
    public synchronized C0326a m1224a() {
        return this.f858f.m1142b();
    }

    /* renamed from: a */
    public void m1228a(C0326a c0326a) {
        this.f858f.m1138a(c0326a);
    }

    /* renamed from: d */
    public boolean m1236d(String str) throws C0351j {
        try {
            return Boolean.valueOf(this.f858f.m1136a(m1235c() + "revokeoauth2", new C0332g[]{new C0332g("access_token", str)}, false).m1175c().m1196b("Result")).booleanValue();
        } catch (C0338b e) {
            throw new C0351j(e.getMessage() + ":", e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0349h c0349h = (C0349h) obj;
        if (this.f847i.equals(c0349h.f847i) && this.f850l.equals(c0349h.f850l) && this.f858f.equals(c0349h.f858f) && this.f848j.equals(c0349h.f848j)) {
            return this.f859g.equals(c0349h.f859g);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f858f.hashCode() * 31) + this.f847i.hashCode()) * 31) + this.f848j.hashCode()) * 31) + this.f859g.hashCode()) * 31) + this.f850l.hashCode();
    }

    public String toString() {
        return "Weibo{http=" + this.f858f + ", baseURL='" + this.f847i + "', searchBaseURL='" + this.f848j + "', source='" + this.f859g + "', format=" + this.f850l + '}';
    }

    public C0349h() {
        this.f850l.setTimeZone(TimeZone.getTimeZone("GMT"));
        this.f858f.m1148d(C0325a.m1098d() + "api.t.sina.com.cn/oauth/request_token");
        this.f858f.m1149e(C0325a.m1098d() + "api.t.sina.com.cn/oauth/authorize");
        this.f858f.m1150f(C0325a.m1098d() + "api.t.sina.com.cn/oauth/access_token");
    }

    /* renamed from: b */
    public String m1232b() {
        return this.f847i;
    }

    /* renamed from: c */
    public String m1235c() {
        return this.f849k;
    }

    /* renamed from: a */
    protected C0334i m1225a(String str, C0332g[] c0332gArr, boolean z) {
        String str2;
        if (str.indexOf("?") == -1) {
            str2 = str + "?source=" + f842a;
        } else {
            str2 = str.indexOf("source") == -1 ? str + "&source=" + f842a : str;
        }
        if (c0332gArr != null && c0332gArr.length > 0) {
            str2 = str2 + "&" + C0328c.m1127a(c0332gArr);
        }
        return this.f858f.m1135a(str2, z);
    }

    /* renamed from: b */
    public C0336b m1230b(String str, int i, int i2) {
        return new C0336b(m1225a(m1232b() + "friends/ids.json", new C0332g[]{new C0332g("uid", str), new C0332g("cursor", i), new C0332g(VKApiConst.COUNT, i2)}, true), this);
    }
}
