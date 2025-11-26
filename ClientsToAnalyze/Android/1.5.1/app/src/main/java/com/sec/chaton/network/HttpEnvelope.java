package com.sec.chaton.network;

import com.sec.chaton.util.ServerAddressMgr;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* loaded from: classes.dex */
public class HttpEnvelope {

    /* renamed from: a */
    private ServerAddressMgr.ServerWhat f2429a;

    /* renamed from: b */
    private String f2430b;

    /* renamed from: c */
    private String f2431c;

    /* renamed from: d */
    private RequestMethod f2432d;

    /* renamed from: e */
    private List f2433e;

    /* renamed from: f */
    private List f2434f;

    /* renamed from: g */
    private Class f2435g;

    /* renamed from: h */
    private int f2436h;

    /* renamed from: i */
    private Class f2437i;

    public class Builder {

        /* renamed from: a */
        protected String f2438a;

        /* renamed from: b */
        protected ServerAddressMgr.ServerWhat f2439b;

        /* renamed from: e */
        protected Class f2442e;

        /* renamed from: f */
        protected int f2443f;

        /* renamed from: g */
        protected String f2444g;

        /* renamed from: i */
        protected Class f2446i;

        /* renamed from: c */
        protected RequestMethod f2440c = RequestMethod.GET;

        /* renamed from: d */
        protected List f2441d = new ArrayList();

        /* renamed from: h */
        protected List f2445h = new ArrayList();

        public Builder(ServerAddressMgr.ServerWhat serverWhat, String str) {
            this.f2439b = serverWhat;
            this.f2438a = str;
        }

        /* renamed from: a */
        public Builder m2737a(int i) {
            this.f2443f = i;
            return this;
        }

        /* renamed from: a */
        public Builder m2738a(RequestMethod requestMethod) {
            this.f2440c = requestMethod;
            return this;
        }

        /* renamed from: a */
        public Builder m2739a(Class cls) {
            this.f2442e = cls;
            return this;
        }

        /* renamed from: a */
        public Builder m2740a(String str) {
            this.f2444g = str;
            return this;
        }

        /* renamed from: a */
        public Builder m2741a(String str, String str2) {
            if (str != null && str2 != null) {
                this.f2441d.add(new BasicNameValuePair(str, str2));
            }
            return this;
        }

        /* renamed from: a */
        public HttpEnvelope m2742a() {
            return new HttpEnvelope(this);
        }

        /* renamed from: b */
        public Builder m2743b(Class cls) {
            this.f2446i = cls;
            return this;
        }

        /* renamed from: b */
        public Builder m2744b(String str, String str2) {
            if (str != null && str2 != null) {
                this.f2445h.add(new BasicNameValuePair(str, str2));
            }
            return this;
        }
    }

    public enum RequestMethod {
        GET,
        POST,
        PUT,
        DELETE
    }

    private HttpEnvelope(Builder builder) {
        this.f2430b = builder.f2438a;
        this.f2432d = builder.f2440c;
        this.f2433e = builder.f2441d;
        this.f2434f = builder.f2445h;
        this.f2435g = builder.f2442e;
        this.f2436h = builder.f2443f;
        this.f2429a = builder.f2439b;
        this.f2431c = builder.f2444g;
        this.f2437i = builder.f2446i;
    }

    /* renamed from: a */
    public ServerAddressMgr.ServerWhat m2728a() {
        return this.f2429a;
    }

    /* renamed from: b */
    public String m2729b() {
        return this.f2430b;
    }

    /* renamed from: c */
    public RequestMethod m2730c() {
        return this.f2432d;
    }

    /* renamed from: d */
    public List m2731d() {
        return this.f2433e;
    }

    /* renamed from: e */
    public List m2732e() {
        return this.f2434f;
    }

    /* renamed from: f */
    public Class m2733f() {
        return this.f2435g;
    }

    /* renamed from: g */
    public int m2734g() {
        return this.f2436h;
    }

    /* renamed from: h */
    public String m2735h() {
        return this.f2431c;
    }

    /* renamed from: i */
    public Class m2736i() {
        return this.f2437i;
    }
}
