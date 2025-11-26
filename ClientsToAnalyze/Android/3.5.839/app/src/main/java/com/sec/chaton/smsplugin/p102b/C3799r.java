package com.sec.chaton.smsplugin.p102b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import com.android.common.p027a.C0357a;
import com.android.common.p028b.C0359a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.smsplugin.C3778a;
import com.sec.chaton.smsplugin.C3781b;
import com.sec.chaton.smsplugin.C3805c;
import com.sec.chaton.smsplugin.C3811d;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.C3850f;
import com.sec.chaton.smsplugin.C3854g;
import com.sec.chaton.smsplugin.C3905j;
import com.sec.chaton.smsplugin.p110g.AbstractC3863i;
import com.sec.chaton.smsplugin.p110g.C3855a;
import com.sec.chaton.smsplugin.p110g.C3856b;
import com.sec.chaton.smsplugin.p110g.C3861g;
import com.sec.chaton.smsplugin.p110g.C3869o;
import com.sec.chaton.smsplugin.p110g.C3870p;
import com.sec.chaton.smsplugin.p110g.C3872r;
import com.sec.chaton.smsplugin.p110g.C3873s;
import com.sec.chaton.smsplugin.p111h.AbstractC3900w;
import com.sec.chaton.smsplugin.p111h.C3878ac;
import com.sec.chaton.smsplugin.p111h.C3887j;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.chaton.smsplugin.p112ui.C4323ip;
import com.sec.chaton.smsplugin.p112ui.PluginComposeMessageActivity;
import com.sec.chaton.smsplugin.provider.C3942a;
import com.sec.chaton.smsplugin.provider.C3947e;
import com.sec.chaton.smsplugin.transaction.C4052ac;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.common.CommonApplication;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5082e;
import com.sec.google.android.p134a.p135a.C5086i;
import com.sec.google.android.p134a.p135a.C5097t;
import com.sec.google.android.p134a.p135a.C5103z;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: WorkingMessage.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.b.r */
/* loaded from: classes.dex */
public class C3799r {

    /* renamed from: m */
    private static boolean f13627m = C3847e.m14696b();

    /* renamed from: p */
    private static final String[] f13628p = {"_id", "m_size"};

    /* renamed from: r */
    private static final String[] f13629r = {"_id", "sub", "sub_cs"};

    /* renamed from: s */
    private static final String[] f13630s = {"body"};

    /* renamed from: a */
    private final Activity f13631a;

    /* renamed from: b */
    private final ContentResolver f13632b;

    /* renamed from: c */
    private int f13633c;

    /* renamed from: d */
    private int f13634d;

    /* renamed from: e */
    private C3790i f13635e;

    /* renamed from: f */
    private CharSequence f13636f;

    /* renamed from: g */
    private C3870p f13637g;

    /* renamed from: h */
    private Uri f13638h;

    /* renamed from: i */
    private CharSequence f13639i;

    /* renamed from: n */
    private final InterfaceC3804w f13643n;

    /* renamed from: o */
    private List<String> f13644o;

    /* renamed from: t */
    private final C3942a f13646t;

    /* renamed from: j */
    private boolean f13640j = false;

    /* renamed from: k */
    private volatile boolean f13641k = false;

    /* renamed from: l */
    private volatile boolean f13642l = false;

    /* renamed from: q */
    private String f13645q = null;

    private C3799r(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f13631a = pluginComposeMessageActivity;
        this.f13632b = pluginComposeMessageActivity.getContentResolver();
        this.f13643n = pluginComposeMessageActivity;
        m14434a();
        this.f13646t = new C3942a(this.f13632b);
    }

    /* renamed from: a */
    public static C3799r m14391a(PluginComposeMessageActivity pluginComposeMessageActivity) {
        return new C3799r(pluginComposeMessageActivity);
    }

    /* renamed from: a */
    public void m14434a() {
        this.f13633c = 0;
        this.f13634d = 0;
        this.f13635e = null;
        this.f13636f = "";
        this.f13637g = null;
        this.f13638h = null;
        this.f13639i = null;
        this.f13640j = false;
        this.f13641k = false;
        this.f13642l = false;
        f13627m = C3847e.m14696b();
        this.f13644o = null;
    }

    /* renamed from: a */
    public static C3799r m14392a(PluginComposeMessageActivity pluginComposeMessageActivity, Uri uri) {
        if (!uri.toString().startsWith(Telephony.Mms.Draft.CONTENT_URI.toString())) {
            C5097t c5097tM19426a = C5097t.m19426a(pluginComposeMessageActivity);
            if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
                C3811d.m14485a("load: moving %s to drafts", uri);
            }
            try {
                uri = c5097tM19426a.m19444a(uri, Telephony.Mms.Draft.CONTENT_URI);
            } catch (C5111c e) {
                C3811d.m14487c("Can't move %s to drafts", uri);
                return null;
            }
        }
        C3799r c3799r = new C3799r(pluginComposeMessageActivity);
        if (c3799r.m14410a(uri)) {
            return c3799r;
        }
        return null;
    }

    /* renamed from: w */
    private void m14429w() {
        int size = this.f13637g.size();
        if (size == 0) {
            m14442a(false);
        } else if (size > 1) {
            this.f13634d = 4;
        } else {
            C3869o c3869oM14914d = this.f13637g.get(0);
            if (c3869oM14914d != null) {
                if (c3869oM14914d.m14863e()) {
                    this.f13634d = 1;
                } else if (c3869oM14914d.m14867g()) {
                    this.f13634d = 2;
                } else if (c3869oM14914d.m14865f()) {
                    this.f13634d = 3;
                } else if (this.f13637g.m14921j()) {
                    this.f13634d = 5;
                }
            }
        }
        m14397a(4, m14456f(), false);
    }

    /* renamed from: a */
    private boolean m14410a(Uri uri) {
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3811d.m14485a("loadFromUri %s", uri);
        }
        try {
            this.f13637g = C3870p.m14881a(this.f13631a, uri);
            this.f13638h = uri;
            m14432z();
            m14429w();
            return true;
        } catch (C5111c e) {
            C3811d.m14487c("Couldn't load URI %s", uri);
            return false;
        }
    }

    /* renamed from: a */
    public static C3799r m14393a(PluginComposeMessageActivity pluginComposeMessageActivity, C3790i c3790i, C3799r c3799r) {
        c3799r.m14422c(c3790i);
        return c3799r;
    }

    /* renamed from: c */
    private void m14422c(C3790i c3790i) {
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3811d.m14485a("loadFromConversation %s", c3790i);
        }
        if (c3790i.m14359d() > 0) {
            this.f13636f = m14426e(c3790i);
            if (c3790i.m14362g() != null && c3790i.m14362g().m14313c() != null) {
                m14441a(new ArrayList(Arrays.asList(c3790i.m14362g().m14313c())));
            }
            if (!TextUtils.isEmpty(this.f13636f)) {
                this.f13642l = true;
            }
            StringBuilder sb = new StringBuilder();
            Uri uriM14388a = m14388a(this.f13631a, c3790i, sb);
            if (uriM14388a != null && m14410a(uriM14388a)) {
                if (sb.length() > 0) {
                    m14439a((CharSequence) sb.toString(), false);
                }
                this.f13641k = true;
            }
        }
    }

    /* renamed from: a */
    public void m14438a(CharSequence charSequence) {
        this.f13636f = charSequence;
    }

    /* renamed from: b */
    public CharSequence m14444b() {
        return this.f13636f;
    }

    /* renamed from: c */
    public boolean m14452c() {
        return this.f13636f != null && TextUtils.getTrimmedLength(this.f13636f) > 0;
    }

    /* renamed from: a */
    public void m14442a(boolean z) {
        this.f13634d = 0;
        this.f13637g = null;
        if (this.f13638h != null) {
            m14400a(this.f13638h, (String) null, (String[]) null);
            this.f13638h = null;
        }
        m14397a(4, false, z);
        if (z) {
            this.f13643n.mo14473a();
        }
    }

    /* renamed from: a */
    public int m14433a(int i, Uri uri, boolean z) {
        int i2;
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3811d.m14485a("setAttachment type=%d uri %s", Integer.valueOf(i), uri);
        }
        if (i == 0 && this.f13634d == 4 && this.f13637g != null && uri == null && !z) {
            new C4323ip(this.f13631a, this.f13637g).m16493b();
        }
        m14430x();
        try {
            if (z) {
                m14415b(i, uri);
            } else {
                m14396a(i, uri);
            }
            i2 = 0;
        } catch (C3781b e) {
            i2 = -9;
        } catch (C3805c e2) {
            i2 = -2;
        } catch (C3850f e3) {
            i2 = -4;
        } catch (C3854g e4) {
            i2 = -8;
        } catch (C3905j e5) {
            i2 = -3;
        } catch (C3778a e6) {
            i2 = -5;
        } catch (C5111c e7) {
            i2 = -1;
        }
        if (i2 == 0) {
            this.f13634d = i;
        } else if (z) {
            new C4323ip(this.f13631a, this.f13637g).m16494b(this.f13637g.size() - 1);
        }
        this.f13643n.mo14473a();
        if ((C4809aa.m18104a().m18119a("pref_key_auto_transform_to_mms", (Boolean) false).booleanValue() || "450".equals(C4822an.m18243k())) && !z && this.f13634d == 0 && i == 0) {
            int[] iArrCalculateLength = SmsMessage.calculateLength(m14444b(), false);
            int i3 = iArrCalculateLength[0];
            int i4 = iArrCalculateLength[1];
            int i5 = iArrCalculateLength[3];
            if (C3847e.m14677ai() && 3 == i5) {
                i4 *= 2;
            }
            if ((!C3847e.m14677ai() || i4 <= 80) && i3 <= C3847e.m14643a()) {
                m14397a(4, m14456f(), true);
            } else {
                m14449b(true, false);
            }
        } else {
            m14397a(4, m14456f(), true);
        }
        m14429w();
        return i2;
    }

    /* renamed from: d */
    public boolean m14454d() {
        if (!TextUtils.isEmpty(m14472v())) {
            return false;
        }
        if (m14452c() || m14460j() || m14456f() || m14458h()) {
            return true;
        }
        return m14455e();
    }

    /* renamed from: e */
    public boolean m14455e() {
        return (this.f13633c & 16) > 0;
    }

    /* renamed from: x */
    private void m14430x() {
        if (this.f13637g == null) {
            C3870p c3870pM14880a = C3870p.m14880a(this.f13631a);
            c3870pM14880a.add(new C3869o(c3870pM14880a));
            this.f13637g = c3870pM14880a;
        }
    }

    /* renamed from: a */
    private void m14396a(int i, Uri uri) {
        C3855a c3855a;
        AbstractC3863i c3861g;
        C3869o c3869oM14914d = this.f13637g.get(0);
        if (c3869oM14914d == null) {
            C3890m.m14997c("Mms", "[WorkingMessage] changeMedia: no slides!");
            return;
        }
        c3869oM14914d.m14871k();
        c3869oM14914d.m14873m();
        c3869oM14914d.m14872l();
        this.f13637g.m14919g();
        this.f13634d = 0;
        if (i != 0) {
            m14425d((String) null);
            if (i == 1) {
                c3861g = new C3861g(this.f13631a, uri, this.f13637g.m14913d().m14786a());
                c3855a = null;
            } else if (i == 2) {
                C3873s c3873s = new C3873s(this.f13631a, uri, this.f13637g.m14913d().m14786a());
                m14408a(c3873s);
                c3861g = c3873s;
                c3855a = null;
            } else if (i == 3) {
                C3856b c3856b = new C3856b(this.f13631a, uri);
                m14408a(c3856b);
                c3861g = c3856b;
                c3855a = null;
            } else if (i == 5) {
                c3855a = new C3855a(this.f13631a, uri, false);
                c3861g = null;
            } else {
                throw new IllegalArgumentException("changeMedia type=" + i + ", uri=" + uri);
            }
            AbstractC3863i abstractC3863iM14876p = c3869oM14914d.m14865f() ? c3869oM14914d.m14876p() : null;
            if (c3869oM14914d.m14863e()) {
                abstractC3863iM14876p = c3869oM14914d.m14875o();
            }
            if (c3869oM14914d.m14867g()) {
                abstractC3863iM14876p = c3869oM14914d.m14877q();
            }
            if (i != 5) {
                if (i == 3) {
                    c3869oM14914d.m14872l();
                    c3869oM14914d.m14873m();
                } else if (i == 1) {
                    c3869oM14914d.m14871k();
                    c3869oM14914d.m14873m();
                } else {
                    c3869oM14914d.m14871k();
                    c3869oM14914d.m14873m();
                    c3869oM14914d.m14872l();
                }
            }
            if (i != 5) {
                try {
                    c3869oM14914d.add(c3861g);
                } catch (C3781b e) {
                    c3869oM14914d.add(abstractC3863iM14876p);
                    throw new C3781b("ExceedLargeFileSizeException");
                } catch (C3805c e2) {
                    c3869oM14914d.add(abstractC3863iM14876p);
                    throw new C3805c("ExceedMessageSizeException");
                } catch (C3850f e3) {
                    c3869oM14914d.add(abstractC3863iM14876p);
                    throw new C3850f("ResolutionException");
                } catch (C3905j e4) {
                    c3869oM14914d.add(abstractC3863iM14876p);
                    throw new C3905j("UnsupportContentTypeException");
                } catch (C3778a e5) {
                    c3869oM14914d.add(abstractC3863iM14876p);
                    throw new C3778a("ContentRestrictionException");
                }
            } else {
                this.f13637g.m14904a(c3855a);
            }
            if (i == 2 || i == 3) {
                c3869oM14914d.m14868h(c3861g.m14811l());
            }
        }
    }

    /* renamed from: b */
    private void m14415b(int i, Uri uri) {
        if (i != 0) {
            if (!(this.f13637g.size() != 1 || this.f13637g.m14916e()) || new C4323ip(this.f13631a, this.f13637g).m16491a()) {
                AbstractC3863i c3856b = null;
                C3855a c3855a = null;
                C3869o c3869oM14914d = this.f13637g.get(this.f13637g.size() - 1);
                if (i == 1) {
                    c3856b = new C3861g(this.f13631a, uri, this.f13637g.m14913d().m14786a());
                } else if (i == 2) {
                    c3856b = new C3873s(this.f13631a, uri, this.f13637g.m14913d().m14786a());
                } else if (i == 3) {
                    c3856b = new C3856b(this.f13631a, uri);
                } else if (i == 5) {
                    c3855a = new C3855a(this.f13631a, uri, false);
                } else {
                    throw new IllegalArgumentException("changeMedia type=" + i + ", uri=" + uri);
                }
                if (c3869oM14914d != null && i != 5) {
                    c3869oM14914d.add(c3856b);
                } else {
                    this.f13637g.m14904a(c3855a);
                }
                if (c3869oM14914d != null) {
                    if (i == 2 || i == 3) {
                        c3869oM14914d.m14868h(c3856b.m14811l());
                    }
                }
            }
        }
    }

    /* renamed from: f */
    public boolean m14456f() {
        return this.f13634d > 0;
    }

    /* renamed from: g */
    public C3870p m14457g() {
        return this.f13637g;
    }

    /* renamed from: h */
    public boolean m14458h() {
        return this.f13634d == 4;
    }

    /* renamed from: a */
    public void m14439a(CharSequence charSequence, boolean z) {
        if (C3847e.m14657aH()) {
            if (charSequence != null && C3847e.m14661aL()) {
                this.f13639i = C3878ac.m14956a(charSequence.toString(), C3847e.m14635S());
            } else if (charSequence != null && charSequence.length() > C3847e.m14635S()) {
                this.f13639i = charSequence.subSequence(0, C3847e.m14635S());
            } else {
                this.f13639i = charSequence;
            }
        } else {
            this.f13639i = charSequence;
        }
        m14397a(2, charSequence != null, z);
    }

    /* renamed from: i */
    public CharSequence m14459i() {
        return this.f13639i;
    }

    /* renamed from: j */
    public boolean m14460j() {
        return this.f13639i != null && TextUtils.getTrimmedLength(this.f13639i) > 0;
    }

    /* renamed from: y */
    private void m14431y() {
        C3872r c3872rM14874n;
        if (this.f13637g != null && this.f13637g.size() == 1) {
            C3869o c3869oM14914d = this.f13637g.get(0);
            if (c3869oM14914d == null) {
                C3890m.m14996b("WorkingMessage", "slide may not be null.");
                return;
            }
            if (!c3869oM14914d.m14861d()) {
                c3872rM14874n = new C3872r(this.f13631a, "text/plain", "text_0.txt", this.f13637g.m14913d().m14790b());
                c3869oM14914d.add((AbstractC3863i) c3872rM14874n);
            } else {
                c3872rM14874n = c3869oM14914d.m14874n();
            }
            c3872rM14874n.m14941a(this.f13636f);
        }
    }

    /* renamed from: z */
    private void m14432z() {
        C3869o c3869oM14914d = this.f13637g.get(0);
        if (c3869oM14914d != null && c3869oM14914d.m14861d()) {
            this.f13636f = c3869oM14914d.m14874n().m14940a();
        }
    }

    /* renamed from: e */
    private void m14427e(boolean z) {
        if (!m14460j()) {
            m14439a((CharSequence) null, z);
        }
    }

    /* renamed from: b */
    public void m14448b(boolean z) {
        m14461k();
        if (m14470t()) {
            m14430x();
            m14431y();
        }
    }

    /* renamed from: a */
    public void m14441a(List<String> list) {
        this.f13644o = new ArrayList(list);
        if (list != null) {
            int size = list.size();
            switch (size) {
                case 0:
                    break;
                case 1:
                    list.get(0);
                    break;
                default:
                    String str = "{...} len=" + size;
                    break;
            }
        }
    }

    /* renamed from: a */
    public void m14440a(String str) {
        if (this.f13644o == null) {
            this.f13644o = new ArrayList();
        }
        if (!this.f13644o.contains(str)) {
            this.f13644o.add(str);
        }
    }

    /* renamed from: b */
    public void m14447b(String str) {
        int iIndexOf;
        if (this.f13644o != null && (iIndexOf = this.f13644o.indexOf(str)) > -1) {
            this.f13644o.remove(iIndexOf);
        }
    }

    /* renamed from: k */
    public void m14461k() {
        if (this.f13644o != null) {
            C3789h c3789hM14301a = C3789h.m14301a((Iterable<String>) this.f13644o, false);
            if (this.f13635e != null) {
                this.f13635e.m14352a(c3789hM14301a);
            }
        }
    }

    /* renamed from: l */
    public C3789h m14462l() {
        if (this.f13644o == null) {
            return null;
        }
        return C3789h.m14301a((Iterable<String>) this.f13644o, false);
    }

    /* renamed from: m */
    public String m14463m() {
        if (this.f13644o == null) {
            return null;
        }
        return C3789h.m14301a((Iterable<String>) this.f13644o, false).m14308a();
    }

    /* renamed from: n */
    public void m14464n() {
        m14397a(16, false, false);
    }

    /* renamed from: c */
    public Uri m14450c(boolean z) {
        if (this.f13640j) {
            C3811d.m14486b("saveAsMms mDiscarded: true mConversation: " + this.f13635e + " returning NULL uri and bailing", new Object[0]);
            return null;
        }
        m14397a(16, true, z);
        m14448b(true);
        try {
            C3887j.m14982c().m14987a(true);
            if (!this.f13635e.m14362g().isEmpty()) {
                this.f13635e.m14360e();
            }
            this.f13635e.m14356b(true);
            C5097t c5097tM19426a = C5097t.m19426a(this.f13631a);
            C5103z c5103zM14413b = m14413b(this.f13635e, this.f13639i);
            if (this.f13638h == null) {
                this.f13638h = m14412b(c5097tM19426a, c5103zM14413b, this.f13637g);
            } else {
                m14417b(this.f13638h, c5097tM19426a, this.f13637g, c5103zM14413b);
            }
            this.f13641k = true;
            C3887j.m14982c().m14987a(false);
            return this.f13638h;
        } catch (Throwable th) {
            C3887j.m14982c().m14987a(false);
            throw th;
        }
    }

    /* renamed from: d */
    public void m14453d(boolean z) {
        if (this.f13640j) {
            C3811d.m14486b("saveDraft mDiscarded: true mConversation: " + this.f13635e + " skipping saving draft and bailing", new Object[0]);
            return;
        }
        if (this.f13635e == null) {
            throw new IllegalStateException("saveDraft() called with no conversation");
        }
        C3811d.m14485a("saveDraft for mConversation " + this.f13635e, new Object[0]);
        m14448b(false);
        if (m14470t()) {
            m14419b(this.f13635e, z);
            this.f13641k = true;
        } else {
            String string = this.f13636f.toString();
            if (!TextUtils.isEmpty(string)) {
                m14403a(this.f13635e, string, z);
                this.f13642l = true;
            } else {
                m14428f(this.f13635e);
                this.f13638h = null;
            }
        }
        this.f13635e.m14356b(true);
    }

    /* renamed from: o */
    public synchronized void m14465o() {
        C3811d.m14485a("[WorkingMessage] discard", new Object[0]);
        if (!this.f13640j) {
            this.f13640j = true;
            if (this.f13641k) {
                m14428f(this.f13635e);
            }
            if (this.f13642l) {
                m14446b(this.f13635e);
            }
            m14437a(this.f13635e, true);
        }
    }

    /* renamed from: p */
    public void m14466p() {
        this.f13640j = false;
    }

    /* renamed from: q */
    public boolean m14467q() {
        return this.f13640j;
    }

    /* renamed from: a */
    public void m14435a(Bundle bundle) {
        if (m14460j()) {
            bundle.putString("subject", this.f13639i.toString());
        }
        if (this.f13638h != null) {
            bundle.putParcelable("msg_uri", this.f13638h);
        } else if (m14452c()) {
            bundle.putString("sms_body", this.f13636f.toString());
        }
    }

    /* renamed from: b */
    public void m14445b(Bundle bundle) {
        if (bundle != null) {
            m14439a((CharSequence) bundle.getString("subject"), false);
            Uri uri = (Uri) bundle.getParcelable("msg_uri");
            if (uri != null) {
                m14410a(uri);
            } else {
                this.f13636f = bundle.getString("sms_body");
            }
        }
    }

    /* renamed from: A */
    private void m14386A() {
        C3890m.m14997c("WorkingMessage", "-- mWorkingRecipients:");
        if (this.f13644o != null) {
            int size = this.f13644o.size();
            for (int i = 0; i < size; i++) {
                C3890m.m14997c("WorkingMessage", "   [" + i + "] " + this.f13644o.get(i));
            }
            C3890m.m14997c("WorkingMessage", "");
        }
    }

    /* renamed from: r */
    public void m14468r() {
        C3890m.m14997c("WorkingMessage", "WorkingMessage:");
        m14386A();
        if (this.f13635e != null) {
            C3890m.m14997c("WorkingMessage", "mConversation: " + this.f13635e.toString());
        }
    }

    /* renamed from: a */
    public void m14436a(C3790i c3790i) {
        this.f13635e = c3790i;
        m14443a(c3790i.m14362g().m14311b(), false);
    }

    /* renamed from: s */
    public C3790i m14469s() {
        return this.f13635e;
    }

    /* renamed from: a */
    public void m14443a(boolean z, boolean z2) {
        if (C3847e.m14705k() != null) {
            m14397a(1, false, z2);
        } else {
            m14397a(1, z, z2);
        }
    }

    /* renamed from: t */
    public boolean m14470t() {
        return this.f13633c > 0;
    }

    /* renamed from: b */
    public void m14449b(boolean z, boolean z2) {
        m14397a(8, z, z2);
    }

    /* renamed from: a */
    private static String m14395a(int i) {
        if (i == 0) {
            return "<none>";
        }
        StringBuilder sb = new StringBuilder();
        if ((i & 1) > 0) {
            sb.append("RECIPIENTS_REQUIRE_MMS | ");
        }
        if ((i & 2) > 0) {
            sb.append("HAS_SUBJECT | ");
        }
        if ((i & 4) > 0) {
            sb.append("HAS_ATTACHMENT | ");
        }
        if ((i & 8) > 0) {
            sb.append("LENGTH_REQUIRES_MMS | ");
        }
        if ((i & 16) > 0) {
            sb.append("FORCE_MMS | ");
        }
        sb.delete(sb.length() - 3, sb.length());
        return sb.toString();
    }

    /* renamed from: a */
    private void m14397a(int i, boolean z, boolean z2) {
        if (f13627m) {
            int i2 = this.f13633c;
            if (z) {
                this.f13633c |= i;
            } else {
                this.f13633c &= i ^ (-1);
            }
            if (this.f13633c == 16 && (i2 & (-17)) > 0) {
                this.f13633c = 0;
            }
            if (z2) {
                if (i2 == 0 && this.f13633c != 0) {
                    this.f13643n.mo14477b_(true);
                } else if (i2 != 0 && this.f13633c == 0) {
                    this.f13643n.mo14477b_(false);
                }
            }
            if (i2 != this.f13633c && C3890m.m15000f("Mms:app", C3890m.f13993b)) {
                Object[] objArr = new Object[3];
                objArr[0] = z ? "+" : "-";
                objArr[1] = m14395a(i);
                objArr[2] = m14395a(this.f13633c);
                C3811d.m14485a("updateState: %s%s = %s", objArr);
            }
        }
    }

    /* renamed from: c */
    public void m14451c(String str) {
        long jM14359d = this.f13635e.m14359d();
        if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
            C3811d.m14485a("send origThreadid: " + jM14359d, new Object[0]);
        }
        m14427e(true);
        m14448b(true);
        C3790i c3790i = this.f13635e;
        String string = this.f13636f.toString();
        if (m14470t() || m14411a(c3790i, string)) {
            if (C3847e.m14702h() == null) {
                C3778a c3778a = new C3778a("WorkingMessage.send MMS sending failure. mms_config.xml is missing uaProfUrl setting.  uaProfUrl is required for MMS service, but can be absent for SMS.");
                C3890m.m14995a("WorkingMessage", "WorkingMessage.send MMS sending failure. mms_config.xml is missing uaProfUrl setting.  uaProfUrl is required for MMS service, but can be absent for SMS.", c3778a);
                throw c3778a;
            }
            new Thread(new RunnableC3800s(this, c3790i, this.f13639i, this.f13637g, this.f13638h, C5097t.m19426a(this.f13631a), this.f13645q)).start();
        } else {
            new Thread(new RunnableC3801t(this, c3790i, this.f13636f.toString(), str)).start();
        }
        C3795n.m14381a(c3790i.m14359d(), c3790i.m14362g());
        this.f13640j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m14424d(C3790i c3790i) {
        new C0357a(this.f13631a).m1253a(new ArrayList(Arrays.asList(c3790i.m14362g().m14313c())));
    }

    /* renamed from: a */
    private boolean m14411a(C3790i c3790i, String str) {
        if (C3847e.m14705k() != null) {
            String[] strArrM14313c = c3790i.m14362g().m14313c();
            int length = strArrM14313c.length;
            for (int i = 0; i < length; i++) {
                if (Telephony.Mms.isEmailAddress(strArrM14313c[i]) || C4149cd.m16418a(strArrM14313c[i])) {
                    if (SmsMessage.calculateLength(strArrM14313c[i] + " " + str, false)[0] > (C3847e.m14657aH() ? C3847e.m14643a() : 1)) {
                        m14397a(1, true, true);
                        m14430x();
                        m14431y();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m14402a(C3790i c3790i, String str, String str2) {
        C0359a.m1254a(this.f13631a);
        this.f13643n.mo14476b();
        c3790i.m14359d();
        long jM14360e = c3790i.m14360e();
        m14409a(str, C3789h.m14307c(c3790i.m14362g().m14308a()), jM14360e);
        m14398a(jM14360e);
    }

    /* renamed from: a */
    private void m14409a(String str, String str2, long j) {
        String[] strArrSplit = TextUtils.split(str2, Config.KEYVALUE_SPLIT);
        C3890m.m14996b("Mms:transaction", "sendSmsWorker sending message: recipients=" + str2 + ", threadId=" + j);
        try {
            new C4052ac(this.f13631a, strArrSplit, str, j).mo15606a(j);
            AbstractC3900w.m15065a().m15068a(this.f13631a, j);
        } catch (Exception e) {
            C3890m.m14995a("WorkingMessage", "Failed to send SMS message, threadId=" + j, e);
        }
        this.f13643n.mo14475a(null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00df A[Catch: all -> 0x0124, TryCatch #2 {all -> 0x0124, blocks: (B:3:0x000a, B:5:0x0021, B:6:0x003b, B:8:0x0048, B:10:0x005e, B:12:0x0067, B:14:0x006e, B:16:0x007a, B:19:0x00b5, B:25:0x00d6, B:26:0x00d9, B:28:0x00df, B:29:0x00e9, B:46:0x012e, B:41:0x0120, B:42:0x0123, B:35:0x0103, B:37:0x010f, B:38:0x011a, B:21:0x00c8, B:23:0x00ce), top: B:68:0x000a, inners: #8, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012e A[Catch: all -> 0x0124, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0124, blocks: (B:3:0x000a, B:5:0x0021, B:6:0x003b, B:8:0x0048, B:10:0x005e, B:12:0x0067, B:14:0x006e, B:16:0x007a, B:19:0x00b5, B:25:0x00d6, B:26:0x00d9, B:28:0x00df, B:29:0x00e9, B:46:0x012e, B:41:0x0120, B:42:0x0123, B:35:0x0103, B:37:0x010f, B:38:0x011a, B:21:0x00c8, B:23:0x00ce), top: B:68:0x000a, inners: #8, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m14401a(com.sec.chaton.smsplugin.p102b.C3790i r12, android.net.Uri r13, com.sec.google.android.p134a.p135a.C5097t r14, com.sec.chaton.smsplugin.p110g.C3870p r15, com.sec.google.android.p134a.p135a.C5103z r16, java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p102b.C3799r.m14401a(com.sec.chaton.smsplugin.b.i, android.net.Uri, com.sec.google.android.a.a.t, com.sec.chaton.smsplugin.g.p, com.sec.google.android.a.a.z, java.lang.String):void");
    }

    /* renamed from: b */
    private void m14416b(Uri uri) {
        try {
            C5097t.m19426a(this.f13631a).m19444a(uri, Telephony.Mms.Outbox.CONTENT_URI);
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("err_type", (Integer) 10);
            SqliteWrapper.update(this.f13631a, this.f13632b, Telephony.MmsSms.PendingMessages.CONTENT_URI, contentValues, "msg_id=" + ContentUris.parseId(uri), (String[]) null);
        } catch (C5111c e) {
            C3890m.m14995a("WorkingMessage", "Failed to move message to outbox and mark as error: " + uri, e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0083 A[DONT_GENERATE, PHI: r5
  0x0083: PHI (r5v2 android.net.Uri) = (r5v1 android.net.Uri), (r5v0 android.net.Uri) binds: [B:15:0x0081, B:22:0x008e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.net.Uri m14388a(android.content.Context r7, com.sec.chaton.smsplugin.p102b.C3790i r8, java.lang.StringBuilder r9) {
        /*
            r5 = 0
            r2 = 0
            java.lang.String r0 = "Mms:app"
            java.lang.String r1 = com.sec.chaton.smsplugin.p111h.C3890m.f13993b
            boolean r0 = com.sec.chaton.smsplugin.p111h.C3890m.m15000f(r0, r1)
            if (r0 == 0) goto L26
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "readDraftMmsMessage conv: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r2]
            com.sec.chaton.smsplugin.C3811d.m14485a(r0, r1)
        L26:
            android.content.ContentResolver r1 = r7.getContentResolver()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "thread_id = "
            java.lang.StringBuilder r0 = r0.append(r2)
            long r2 = r8.m14359d()
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r4 = r0.toString()
            android.net.Uri r2 = android.provider.Telephony.Mms.Draft.CONTENT_URI
            java.lang.String[] r3 = com.sec.chaton.smsplugin.p102b.C3799r.f13629r
            r0 = r7
            r6 = r5
            android.database.Cursor r1 = android.database.sqlite.SqliteWrapper.query(r0, r1, r2, r3, r4, r5, r6)
            if (r1 == 0) goto L8e
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L87
            if (r0 == 0) goto L8e
            android.net.Uri r0 = android.provider.Telephony.Mms.Draft.CONTENT_URI     // Catch: java.lang.Throwable -> L87
            r2 = 0
            long r2 = r1.getLong(r2)     // Catch: java.lang.Throwable -> L87
            android.net.Uri r5 = android.content.ContentUris.withAppendedId(r0, r2)     // Catch: java.lang.Throwable -> L87
            r0 = 1
            r2 = 2
            java.lang.String r0 = com.sec.chaton.smsplugin.p112ui.C4149cd.m16395a(r1, r0, r2)     // Catch: java.lang.Throwable -> L87
            if (r0 == 0) goto L6a
            r9.append(r0)     // Catch: java.lang.Throwable -> L87
        L6a:
            java.lang.String r0 = "Mms:app"
            java.lang.String r2 = com.sec.chaton.smsplugin.p111h.C3890m.f13993b     // Catch: java.lang.Throwable -> L87
            boolean r0 = com.sec.chaton.smsplugin.p111h.C3890m.m15000f(r0, r2)     // Catch: java.lang.Throwable -> L87
            if (r0 == 0) goto L81
            java.lang.String r0 = "readDraftMmsMessage uri: "
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L87
            r3 = 0
            r2[r3] = r5     // Catch: java.lang.Throwable -> L87
            com.sec.chaton.smsplugin.C3811d.m14485a(r0, r2)     // Catch: java.lang.Throwable -> L87
        L81:
            if (r1 == 0) goto L86
        L83:
            r1.close()
        L86:
            return r5
        L87:
            r0 = move-exception
            if (r1 == 0) goto L8d
            r1.close()
        L8d:
            throw r0
        L8e:
            if (r1 == 0) goto L86
            goto L83
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p102b.C3799r.m14388a(android.content.Context, com.sec.chaton.smsplugin.b.i, java.lang.StringBuilder):android.net.Uri");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static C5103z m14413b(C3790i c3790i, CharSequence charSequence) {
        String[] strArrM14309a = c3790i.m14362g().m14309a(true);
        C5103z c5103z = new C5103z();
        C5082e[] c5082eArrM19303a = C5082e.m19303a(strArrM14309a);
        if (c5082eArrM19303a != null) {
            c5103z.m19466a(c5082eArrM19303a);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            c5103z.m19313a_(new C5082e(charSequence.toString()));
        }
        c5103z.m19311a(System.currentTimeMillis() / 1000);
        return c5103z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static Uri m14412b(C5097t c5097t, C5103z c5103z, C3870p c3870p) {
        try {
            C5086i c5086iM14899a = c3870p.m14899a();
            c5103z.m19312a(c5086iM14899a);
            Uri uriM19447a = c5097t.m19447a(c5103z, Telephony.Mms.Draft.CONTENT_URI);
            c3870p.m14905a(c5086iM14899a);
            return uriM19447a;
        } catch (C5111c e) {
            return null;
        }
    }

    /* renamed from: b */
    private void m14419b(C3790i c3790i, boolean z) {
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3811d.m14485a("asyncUpdateDraftMmsMessage conv=%s mMessageUri=%s", c3790i, this.f13638h);
        }
        new Thread(new RunnableC3802u(this, c3790i, z)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m14417b(Uri uri, C5097t c5097t, C3870p c3870p, C5103z c5103z) {
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3811d.m14485a("updateDraftMmsMessage uri=%s", uri);
        }
        if (uri == null) {
            C3890m.m14999e("WorkingMessage", "updateDraftMmsMessage null uri");
            return;
        }
        c5097t.m19451a(uri, c5103z);
        C5086i c5086iM14899a = c3870p.m14899a();
        try {
            c5097t.m19450a(uri, c5086iM14899a);
        } catch (C5111c e) {
            C3890m.m14999e("WorkingMessage", "updateDraftMmsMessage: cannot update message " + uri);
        }
        c3870p.m14905a(c5086iM14899a);
    }

    /* renamed from: e */
    private String m14426e(C3790i c3790i) {
        boolean z;
        String string;
        long jM14359d = c3790i.m14359d();
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3890m.m14996b("WorkingMessage", "readDraftSmsMessage conv: " + c3790i);
        }
        if (jM14359d <= 0) {
            return "";
        }
        Cursor cursorQuery = SqliteWrapper.query(this.f13631a, this.f13632b, ContentUris.withAppendedId(Telephony.Sms.Conversations.CONTENT_URI, jM14359d), f13630s, "type=3", (String[]) null, (String) null);
        if (cursorQuery == null) {
            z = false;
            string = "";
        } else {
            try {
                if (!cursorQuery.moveToFirst()) {
                    z = false;
                    string = "";
                } else {
                    string = cursorQuery.getString(0);
                    z = true;
                }
            } finally {
                cursorQuery.close();
            }
        }
        if (z && c3790i.m14365j() == 0) {
            m14446b(c3790i);
            m14437a(c3790i, true);
        }
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(!TextUtils.isEmpty(string));
            C3811d.m14485a("readDraftSmsMessage haveDraft: ", objArr);
        }
        return string;
    }

    /* renamed from: a */
    public void m14437a(C3790i c3790i, boolean z) {
        if (z && c3790i.m14365j() == 0) {
            c3790i.m14361f();
        }
        c3790i.m14356b(false);
    }

    /* renamed from: a */
    private void m14403a(C3790i c3790i, String str, boolean z) {
        new Thread(new RunnableC3803v(this, c3790i, str, z)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m14418b(C3790i c3790i, String str) {
        long jM14359d = c3790i.m14359d();
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3811d.m14485a("updateDraftSmsMessage tid=%d, contents=\"%s\"", Long.valueOf(jM14359d), str);
        }
        if (jM14359d > 0) {
            if (C3847e.m14650aA() && jM14359d > 0 && c3790i.m14365j() > 0) {
                SqliteWrapper.delete(this.f13631a, this.f13632b, ContentUris.withAppendedId(Telephony.Sms.Conversations.CONTENT_URI, jM14359d), "type=3", (String[]) null);
            }
            ContentValues contentValues = new ContentValues(3);
            contentValues.put("thread_id", Long.valueOf(jM14359d));
            contentValues.put("body", str);
            contentValues.put("type", (Integer) 3);
            SqliteWrapper.insert(this.f13631a, this.f13632b, Telephony.Sms.CONTENT_URI, contentValues);
            m14428f(c3790i);
            this.f13638h = null;
            C3947e.m15253a(this.f13632b, jM14359d);
        }
    }

    /* renamed from: a */
    private void m14400a(Uri uri, String str, String[] strArr) {
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3811d.m14485a("asyncDelete %s where %s", uri, str);
        }
        this.f13646t.m15239a((Handler) null, uri, -1, (Object) null, str);
    }

    /* renamed from: b */
    public void m14446b(C3790i c3790i) {
        this.f13642l = false;
        long jM14359d = c3790i.m14359d();
        if (jM14359d > 0) {
            this.f13646t.m15246d(null, -1, null, jM14359d);
        }
    }

    /* renamed from: a */
    private void m14398a(long j) {
        SqliteWrapper.delete(this.f13631a, this.f13632b, ContentUris.withAppendedId(Telephony.Sms.Conversations.CONTENT_URI, j), "type=3", (String[]) null);
    }

    /* renamed from: f */
    private void m14428f(C3790i c3790i) {
        this.f13641k = false;
        long jM14359d = c3790i.m14359d();
        if (jM14359d > 0) {
            m14400a(Telephony.Mms.Draft.CONTENT_URI, "thread_id = " + jM14359d, (String[]) null);
        }
    }

    /* renamed from: a */
    private void m14408a(AbstractC3863i abstractC3863i) {
        if (C3847e.m14652aC() && C4822an.m18218a()) {
            int iM14817r = abstractC3863i.m14817r();
            Uri uriM14813n = abstractC3863i.m14813n();
            if (iM14817r > C3847e.m14697c() && iM14817r <= C3847e.m14653aD() && C3847e.m14652aC() && C4822an.m18218a()) {
                if (uriM14813n != null) {
                    String strM14421c = m14421c(uriM14813n);
                    if (!TextUtils.isEmpty(strM14421c)) {
                        m14425d(strM14421c);
                        return;
                    } else {
                        C3890m.m14996b("WorkingMessage", "Large file path is invalid");
                        throw new IllegalArgumentException("changeMedia , uri=" + uriM14813n);
                    }
                }
                C3890m.m14996b("WorkingMessage", "Large file URI is invalid");
                throw new IllegalArgumentException("changeMedia n uri=" + uriM14813n);
            }
        }
    }

    /* renamed from: c */
    private String m14421c(Uri uri) {
        String string = null;
        if (uri == null) {
            return null;
        }
        if (uri.getScheme().equals("content")) {
            Cursor cursorQuery = SqliteWrapper.query(CommonApplication.m18732r(), GlobalApplication.m18732r().getContentResolver(), uri, (String[]) null, (String) null, (String[]) null, (String) null);
            if (cursorQuery == null) {
                return null;
            }
            try {
                if (cursorQuery.moveToFirst()) {
                    try {
                        string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                    } catch (IllegalArgumentException e) {
                        string = uri.toString();
                    }
                }
                return string;
            } finally {
                cursorQuery.close();
            }
        }
        return uri.toString();
    }

    /* renamed from: d */
    private void m14425d(String str) {
        if (C3847e.m14652aC() && C4822an.m18218a()) {
            this.f13645q = str;
        } else {
            this.f13645q = null;
        }
    }

    /* renamed from: u */
    public void m14471u() {
        this.f13645q = null;
    }

    /* renamed from: v */
    public String m14472v() {
        if (C3847e.m14652aC() && C4822an.m18218a()) {
            return this.f13645q;
        }
        return null;
    }
}
