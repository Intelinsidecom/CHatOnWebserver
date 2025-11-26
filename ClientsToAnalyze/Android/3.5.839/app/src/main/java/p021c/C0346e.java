package p021c;

import com.p137vk.sdk.VKScope;
import com.sec.spp.push.Config;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import p021c.p022a.C0334i;
import p021c.p023b.p024a.C0337a;
import p021c.p023b.p024a.C0338b;
import p021c.p023b.p024a.C0339c;

/* compiled from: User.java */
/* renamed from: c.e */
/* loaded from: classes.dex */
public class C0346e extends C0352k implements Serializable {

    /* renamed from: a */
    static final String[] f802a = {"user", Config.NOTIFICATION_INTENT_SENDER, "recipient", "retweeting_user"};

    /* renamed from: A */
    private Date f803A;

    /* renamed from: B */
    private int f804B;

    /* renamed from: C */
    private int f805C;

    /* renamed from: D */
    private String f806D;

    /* renamed from: E */
    private String f807E;

    /* renamed from: F */
    private String f808F;

    /* renamed from: G */
    private boolean f809G;

    /* renamed from: H */
    private boolean f810H;

    /* renamed from: I */
    private int f811I;

    /* renamed from: J */
    private boolean f812J;

    /* renamed from: K */
    private boolean f813K;

    /* renamed from: b */
    private C0349h f814b;

    /* renamed from: c */
    private int f815c;

    /* renamed from: d */
    private String f816d;

    /* renamed from: e */
    private String f817e;

    /* renamed from: f */
    private String f818f;

    /* renamed from: g */
    private String f819g;

    /* renamed from: h */
    private String f820h;

    /* renamed from: i */
    private String f821i;

    /* renamed from: j */
    private boolean f822j;

    /* renamed from: k */
    private int f823k;

    /* renamed from: l */
    private Date f824l;

    /* renamed from: m */
    private long f825m = -1;

    /* renamed from: n */
    private String f826n = null;

    /* renamed from: o */
    private String f827o = null;

    /* renamed from: p */
    private boolean f828p = false;

    /* renamed from: q */
    private long f829q = -1;

    /* renamed from: r */
    private int f830r = -1;

    /* renamed from: s */
    private boolean f831s = false;

    /* renamed from: t */
    private String f832t = null;

    /* renamed from: u */
    private String f833u;

    /* renamed from: v */
    private String f834v;

    /* renamed from: w */
    private String f835w;

    /* renamed from: x */
    private String f836x;

    /* renamed from: y */
    private String f837y;

    /* renamed from: z */
    private int f838z;

    C0346e(C0339c c0339c) throws C0351j {
        m1216a(c0339c);
    }

    /* renamed from: a */
    private void m1216a(C0339c c0339c) throws C0351j {
        if (c0339c != null) {
            try {
                this.f815c = c0339c.m1198d("id");
                this.f816d = c0339c.m1202h("name");
                this.f817e = c0339c.m1202h("screen_name");
                this.f818f = c0339c.m1202h("location");
                this.f819g = c0339c.m1202h("description");
                this.f820h = c0339c.m1202h("profile_image_url");
                this.f821i = c0339c.m1202h("url");
                this.f822j = c0339c.m1196b("protected");
                this.f823k = c0339c.m1198d("followers_count");
                this.f833u = c0339c.m1202h("profile_background_color");
                this.f834v = c0339c.m1202h("profile_text_color");
                this.f835w = c0339c.m1202h("profile_link_color");
                this.f836x = c0339c.m1202h("profile_sidebar_fill_color");
                this.f837y = c0339c.m1202h("profile_sidebar_border_color");
                this.f838z = c0339c.m1198d("friends_count");
                this.f803A = m1243a(c0339c.m1202h("created_at"), "EEE MMM dd HH:mm:ss z yyyy");
                this.f804B = c0339c.m1198d("favourites_count");
                this.f805C = m1242a("utc_offset", c0339c);
                this.f806D = c0339c.m1202h("time_zone");
                this.f807E = c0339c.m1202h("profile_background_image_url");
                this.f808F = c0339c.m1202h("profile_background_tile");
                this.f809G = m1245c("following", c0339c);
                this.f810H = m1245c(VKScope.NOTIFICATIONS, c0339c);
                this.f811I = c0339c.m1198d("statuses_count");
                if (!c0339c.m1203i("status")) {
                    C0339c c0339cM1200f = c0339c.m1200f("status");
                    this.f824l = m1243a(c0339cM1200f.m1202h("created_at"), "EEE MMM dd HH:mm:ss z yyyy");
                    this.f825m = c0339cM1200f.m1201g("id");
                    this.f826n = c0339cM1200f.m1202h("text");
                    this.f827o = c0339cM1200f.m1202h("source");
                    this.f828p = c0339cM1200f.m1196b("truncated");
                    this.f829q = c0339cM1200f.m1201g("in_reply_to_status_id");
                    this.f830r = c0339cM1200f.m1198d("in_reply_to_user_id");
                    this.f831s = c0339cM1200f.m1196b("favorited");
                    this.f832t = c0339cM1200f.m1202h("in_reply_to_screen_name");
                }
            } catch (C0338b e) {
                throw new C0351j(e.getMessage() + ":" + c0339c.toString(), e);
            }
        }
    }

    /* renamed from: a */
    public int m1217a() {
        return this.f815c;
    }

    /* renamed from: b */
    public String m1218b() {
        return this.f816d;
    }

    /* renamed from: c */
    public String m1219c() {
        return this.f817e;
    }

    /* renamed from: d */
    public URL m1220d() {
        try {
            return new URL(this.f820h);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static C0347f m1215a(C0334i c0334i) throws C0351j {
        C0339c c0339cM1175c = c0334i.m1175c();
        try {
            C0337a c0337aM1199e = c0339cM1175c.m1199e("users");
            int iM1179a = c0337aM1199e.m1179a();
            ArrayList arrayList = new ArrayList(iM1179a);
            for (int i = 0; i < iM1179a; i++) {
                arrayList.add(new C0346e(c0337aM1199e.m1184c(i)));
            }
            long jM1201g = c0339cM1175c.m1201g("previous_curosr");
            long jM1201g2 = c0339cM1175c.m1201g("next_cursor");
            if (jM1201g2 == -1) {
                jM1201g2 = c0339cM1175c.m1201g("nextCursor");
            }
            return new C0347f(arrayList, jM1201g, jM1201g2);
        } catch (C0338b e) {
            throw new C0351j(e);
        }
    }

    public int hashCode() {
        return this.f815c;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this != obj) {
            return (obj instanceof C0346e) && ((C0346e) obj).f815c == this.f815c;
        }
        return true;
    }

    public String toString() {
        return "User{weibo=" + this.f814b + ", id=" + this.f815c + ", name='" + this.f816d + "', screenName='" + this.f817e + "', location='" + this.f818f + "', description='" + this.f819g + "', profileImageUrl='" + this.f820h + "', url='" + this.f821i + "', isProtected=" + this.f822j + ", followersCount=" + this.f823k + ", statusCreatedAt=" + this.f824l + ", statusId=" + this.f825m + ", statusText='" + this.f826n + "', statusSource='" + this.f827o + "', statusTruncated=" + this.f828p + ", statusInReplyToStatusId=" + this.f829q + ", statusInReplyToUserId=" + this.f830r + ", statusFavorited=" + this.f831s + ", statusInReplyToScreenName='" + this.f832t + "', profileBackgroundColor='" + this.f833u + "', profileTextColor='" + this.f834v + "', profileLinkColor='" + this.f835w + "', profileSidebarFillColor='" + this.f836x + "', profileSidebarBorderColor='" + this.f837y + "', friendsCount=" + this.f838z + ", createdAt=" + this.f803A + ", favouritesCount=" + this.f804B + ", utcOffset=" + this.f805C + ", timeZone='" + this.f806D + "', profileBackgroundImageUrl='" + this.f807E + "', profileBackgroundTile='" + this.f808F + "', following=" + this.f809G + ", notificationEnabled=" + this.f810H + ", statusesCount=" + this.f811I + ", geoEnabled=" + this.f812J + ", verified=" + this.f813K + '}';
    }
}
