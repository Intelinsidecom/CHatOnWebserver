package p010b;

import com.p137vk.sdk.api.VKApiConst;
import com.sec.amsoma.AMSLibs;
import p010b.p014d.p015a.AbstractC0297l;
import p010b.p014d.p016b.C0305c;
import p010b.p014d.p016b.C0306d;
import p010b.p014d.p018d.p019a.C0312b;
import p010b.p014d.p018d.p019a.C0313c;

/* compiled from: TwitterException.java */
/* renamed from: b.g */
/* loaded from: classes.dex */
public class C0320g extends Exception implements InterfaceC0322i {

    /* renamed from: g */
    private static final String[] f702g = {"twitter4j"};

    /* renamed from: a */
    boolean f703a;

    /* renamed from: b */
    private int f704b;

    /* renamed from: c */
    private int f705c;

    /* renamed from: d */
    private C0267a f706d;

    /* renamed from: e */
    private AbstractC0297l f707e;

    /* renamed from: f */
    private String f708f;

    public C0320g(String str, Throwable th) {
        super(str, th);
        this.f704b = -1;
        this.f705c = -1;
        this.f706d = null;
        this.f708f = null;
        this.f703a = false;
        m1076a(str);
    }

    public C0320g(String str) {
        this(str, (Throwable) null);
    }

    public C0320g(String str, AbstractC0297l abstractC0297l) {
        this(str);
        this.f707e = abstractC0297l;
        this.f704b = abstractC0297l.m1025a();
    }

    public C0320g(String str, Exception exc, int i) {
        this(str, exc);
        this.f704b = i;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        if (this.f708f != null && this.f705c != -1) {
            sb.append("message - ").append(this.f708f).append("\n");
            sb.append("code - ").append(this.f705c).append("\n");
        } else {
            sb.append(super.getMessage());
        }
        if (this.f704b != -1) {
            return m1075a(this.f704b) + "\n" + sb.toString();
        }
        return sb.toString();
    }

    /* renamed from: a */
    private void m1076a(String str) {
        if (str != null && str.startsWith("{")) {
            try {
                C0313c c0313c = new C0313c(str);
                if (!c0313c.m1062d("errors")) {
                    C0313c c0313cM1047b = c0313c.m1059b("errors").m1047b(0);
                    this.f708f = c0313cM1047b.m1061c(VKApiConst.MESSAGE);
                    this.f705c = C0306d.m1035b("code", c0313cM1047b);
                }
            } catch (C0312b e) {
            }
        }
    }

    /* renamed from: a */
    public InterfaceC0281c m1078a() {
        if (this.f707e == null) {
            return null;
        }
        return C0305c.m1032a(this.f707e);
    }

    /* renamed from: b */
    public int m1079b() {
        if (this.f704b == 400) {
            InterfaceC0281c interfaceC0281cM1078a = m1078a();
            if (interfaceC0281cM1078a == null) {
                return -1;
            }
            return interfaceC0281cM1078a.mo976a();
        }
        if (this.f704b != 420) {
            return -1;
        }
        try {
            String strMo1026a = this.f707e.mo1026a("Retry-After");
            if (strMo1026a == null) {
                return -1;
            }
            return Integer.valueOf(strMo1026a).intValue();
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /* renamed from: c */
    public String m1080c() {
        return m1077e().m944c();
    }

    /* renamed from: e */
    private C0267a m1077e() {
        if (this.f706d == null) {
            this.f706d = new C0267a(this, f702g);
        }
        return this.f706d;
    }

    /* renamed from: d */
    public String m1081d() {
        return this.f708f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0320g c0320g = (C0320g) obj;
        if (this.f705c == c0320g.f705c && this.f703a == c0320g.f703a && this.f704b == c0320g.f704b) {
            if (this.f708f == null ? c0320g.f708f != null : !this.f708f.equals(c0320g.f708f)) {
                return false;
            }
            if (this.f706d == null ? c0320g.f706d != null : !this.f706d.equals(c0320g.f706d)) {
                return false;
            }
            if (this.f707e != null) {
                if (this.f707e.equals(c0320g.f707e)) {
                    return true;
                }
            } else if (c0320g.f707e == null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f708f != null ? this.f708f.hashCode() : 0) + (((this.f707e != null ? this.f707e.hashCode() : 0) + (((this.f706d != null ? this.f706d.hashCode() : 0) + (((this.f704b * 31) + this.f705c) * 31)) * 31)) * 31)) * 31) + (this.f703a ? 1 : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getMessage() + (this.f703a ? "" : "\nRelevant discussions can be found on the Internet at:\n\thttp://www.google.co.jp/search?q=" + m1077e().m942a() + " or\n\thttp://www.google.co.jp/search?q=" + m1077e().m943b()) + "\nTwitterException{" + (this.f703a ? "" : "exceptionCode=[" + m1080c() + "], ") + "statusCode=" + this.f704b + ", message=" + this.f708f + ", code=" + this.f705c + ", retryAfter=" + m1079b() + ", rateLimitStatus=" + m1078a() + ", version=" + C0324k.m1088a() + '}';
    }

    /* renamed from: a */
    private static String m1075a(int i) {
        String str;
        switch (i) {
            case 304:
                str = "There was no new data to return.";
                break;
            case AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE /* 400 */:
                str = "The request was invalid. An accompanying error message will explain why. This is the status code will be returned during version 1.0 rate limiting(https://dev.twitter.com/pages/rate-limiting). In API v1.1, a request without authentication is considered invalid and you will get this response.";
                break;
            case 401:
                str = "Authentication credentials (https://dev.twitter.com/pages/auth) were missing or incorrect. Ensure that you have set valid consumer key/secret, access token/secret, and the system clock is in sync.";
                break;
            case 403:
                str = "The request is understood, but it has been refused. An accompanying error message will explain why. This code is used when requests are being denied due to update limits (https://support.twitter.com/articles/15364-about-twitter-limits-update-api-dm-and-following).";
                break;
            case 404:
                str = "The URI requested is invalid or the resource requested, such as a user, does not exists. Also returned when the requested format is not supported by the requested method.";
                break;
            case 406:
                str = "Returned by the Search API when an invalid format is specified in the request.\nReturned by the Streaming API when one or more of the parameters are not suitable for the resource. The track parameter, for example, would throw this error if:\n The track keyword is too long or too short.\n The bounding box specified is invalid.\n No predicates defined for filtered resource, for example, neither track nor follow parameter defined.\n Follow userid cannot be read.";
                break;
            case 420:
                str = "Returned by the Search and Trends API when you are being rate limited (https://dev.twitter.com/docs/rate-limiting).\nReturned by the Streaming API:\n Too many login attempts in a short period of time.\n Running too many copies of the same application authenticating with the same account name.";
                break;
            case 422:
                str = "Returned when an image uploaded to POST account/update_profile_banner(https://dev.twitter.com/docs/api/1/post/account/update_profile_banner) is unable to be processed.";
                break;
            case 429:
                str = "Returned in API v1.1 when a request cannot be served due to the application's rate limit having been exhausted for the resource. See Rate Limiting in API v1.1.(https://dev.twitter.com/docs/rate-limiting/1.1)";
                break;
            case 500:
                str = "Something is broken. Please post to the group (https://dev.twitter.com/docs/support) so the Twitter team can investigate.";
                break;
            case 502:
                str = "Twitter is down or being upgraded.";
                break;
            case 503:
                str = "The Twitter servers are up, but overloaded with requests. Try again later.";
                break;
            case 504:
                str = "The Twitter servers are up, but the request couldn't be serviced due to some failure within our stack. Try again later.";
                break;
            default:
                str = "";
                break;
        }
        return i + ":" + str;
    }
}
