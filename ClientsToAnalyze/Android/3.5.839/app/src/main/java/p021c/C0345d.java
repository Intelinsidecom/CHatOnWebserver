package p021c;

import java.io.Serializable;
import java.util.Date;
import p021c.p022a.C0334i;
import p021c.p023b.p024a.C0338b;
import p021c.p023b.p024a.C0339c;

/* compiled from: Status.java */
/* renamed from: c.d */
/* loaded from: classes.dex */
public class C0345d extends C0352k implements Serializable {

    /* renamed from: a */
    private Date f786a;

    /* renamed from: b */
    private long f787b;

    /* renamed from: c */
    private String f788c;

    /* renamed from: d */
    private String f789d;

    /* renamed from: e */
    private boolean f790e;

    /* renamed from: f */
    private long f791f;

    /* renamed from: g */
    private int f792g;

    /* renamed from: h */
    private boolean f793h;

    /* renamed from: i */
    private String f794i;

    /* renamed from: j */
    private double f795j;

    /* renamed from: k */
    private double f796k;

    /* renamed from: l */
    private String f797l;

    /* renamed from: m */
    private String f798m;

    /* renamed from: n */
    private String f799n;

    /* renamed from: o */
    private C0344c f800o;

    /* renamed from: p */
    private C0346e f801p;

    C0345d(C0334i c0334i) throws C0351j {
        super(c0334i);
        this.f795j = -1.0d;
        this.f796k = -1.0d;
        this.f801p = null;
        C0339c c0339cM1175c = c0334i.m1175c();
        try {
            this.f787b = c0339cM1175c.m1201g("id");
            this.f788c = c0339cM1175c.m1202h("text");
            this.f789d = c0339cM1175c.m1202h("source");
            this.f786a = m1243a(c0339cM1175c.m1202h("created_at"), "EEE MMM dd HH:mm:ss z yyyy");
            this.f791f = m1244b("in_reply_to_status_id", c0339cM1175c);
            this.f792g = m1242a("in_reply_to_user_id", c0339cM1175c);
            this.f793h = m1245c("favorited", c0339cM1175c);
            this.f797l = c0339cM1175c.m1202h("thumbnail_pic");
            this.f798m = c0339cM1175c.m1202h("bmiddle_pic");
            this.f799n = c0339cM1175c.m1202h("original_pic");
            if (!c0339cM1175c.m1203i("user")) {
                this.f801p = new C0346e(c0339cM1175c.m1200f("user"));
            }
            this.f794i = c0339cM1175c.m1202h("inReplyToScreenName");
            if (!c0339cM1175c.m1203i("retweeted_status")) {
                this.f800o = new C0344c(c0339cM1175c.m1200f("retweeted_status"));
            }
        } catch (C0338b e) {
            throw new C0351j(e.getMessage() + ":" + c0339cM1175c.toString(), e);
        }
    }

    public int hashCode() {
        return (int) this.f787b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this != obj) {
            return (obj instanceof C0345d) && ((C0345d) obj).f787b == this.f787b;
        }
        return true;
    }

    public String toString() {
        return "Status{createdAt=" + this.f786a + ", id=" + this.f787b + ", text='" + this.f788c + "', source='" + this.f789d + "', isTruncated=" + this.f790e + ", inReplyToStatusId=" + this.f791f + ", inReplyToUserId=" + this.f792g + ", isFavorited=" + this.f793h + ", thumbnail_pic=" + this.f797l + ", bmiddle_pic=" + this.f798m + ", original_pic=" + this.f799n + ", inReplyToScreenName='" + this.f794i + "', latitude=" + this.f795j + ", longitude=" + this.f796k + ", retweetDetails=" + this.f800o + ", user=" + this.f801p + '}';
    }
}
