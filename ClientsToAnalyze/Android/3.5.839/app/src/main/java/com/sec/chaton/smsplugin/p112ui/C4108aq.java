package com.sec.chaton.smsplugin.p112ui;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.os.Build;
import android.provider.Telephony;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1730gc;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2216ad;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p110g.C3869o;
import com.sec.chaton.smsplugin.p110g.C3870p;
import com.sec.chaton.smsplugin.p110g.C3872r;
import com.sec.chaton.smsplugin.p111h.C3875a;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.provider.C3947e;
import com.sec.chaton.smsplugin.spam.C4012bp;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5082e;
import com.sec.google.android.p134a.p135a.C5083f;
import com.sec.google.android.p134a.p135a.C5084g;
import com.sec.google.android.p134a.p135a.C5097t;
import com.sec.google.android.p134a.p135a.C5101x;
import com.sec.google.android.p134a.p135a.C5103z;
import java.util.regex.Pattern;

/* compiled from: MessageItem.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.ui.aq */
/* loaded from: classes.dex */
public class C4108aq {

    /* renamed from: Y */
    private static String f15241Y = "MessageItem";

    /* renamed from: A */
    int f15242A;

    /* renamed from: B */
    boolean f15243B;

    /* renamed from: C */
    public long f15244C;

    /* renamed from: D */
    public long f15245D;

    /* renamed from: E */
    public long f15246E;

    /* renamed from: F */
    public long f15247F;

    /* renamed from: G */
    public EnumC2214ab f15248G;

    /* renamed from: H */
    public int f15249H;

    /* renamed from: I */
    public String f15250I;

    /* renamed from: J */
    public String f15251J;

    /* renamed from: K */
    public String f15252K;

    /* renamed from: L */
    public String f15253L;

    /* renamed from: M */
    public String f15254M;

    /* renamed from: N */
    public String f15255N;

    /* renamed from: O */
    public int f15256O;

    /* renamed from: P */
    public String f15257P;

    /* renamed from: Q */
    public String f15258Q;

    /* renamed from: R */
    public String f15259R;

    /* renamed from: S */
    public String f15260S;

    /* renamed from: T */
    public String f15261T;

    /* renamed from: U */
    public String f15262U;

    /* renamed from: V */
    public int f15263V;

    /* renamed from: W */
    public int f15264W;

    /* renamed from: X */
    public EnumC2216ad f15265X;

    /* renamed from: a */
    final Context f15266a;

    /* renamed from: b */
    public String f15267b;

    /* renamed from: c */
    public long f15268c;

    /* renamed from: d */
    public int f15269d;

    /* renamed from: e */
    long f15270e;

    /* renamed from: f */
    EnumC4109ar f15271f;

    /* renamed from: g */
    public boolean f15272g;

    /* renamed from: h */
    boolean f15273h;

    /* renamed from: i */
    public String f15274i;

    /* renamed from: j */
    public String f15275j;

    /* renamed from: k */
    public String f15276k;

    /* renamed from: l */
    public String f15277l;

    /* renamed from: m */
    public String f15278m;

    /* renamed from: n */
    public Pattern f15279n;

    /* renamed from: o */
    CharSequence f15280o;

    /* renamed from: p */
    boolean f15281p;

    /* renamed from: q */
    boolean f15282q;

    /* renamed from: r */
    Uri f15283r;

    /* renamed from: s */
    int f15284s;

    /* renamed from: t */
    int f15285t;

    /* renamed from: u */
    String f15286u;

    /* renamed from: v */
    C3870p f15287v;

    /* renamed from: w */
    int f15288w;

    /* renamed from: x */
    int f15289x;

    /* renamed from: y */
    boolean f15290y;

    /* renamed from: z */
    long f15291z;

    public C4108aq(Context context, String str, Cursor cursor, C4114aw c4114aw, Pattern pattern) {
        this(context, str, cursor, c4114aw, pattern, false);
    }

    public C4108aq(Context context, String str, Cursor cursor, C4114aw c4114aw, Pattern pattern, boolean z) {
        this(context, cursor, c4114aw, pattern, false);
    }

    public C4108aq(Context context, Cursor cursor, C4114aw c4114aw, Pattern pattern, boolean z) throws C5111c {
        long jD;
        this.f15267b = "";
        this.f15291z = 0L;
        this.f15242A = 0;
        this.f15266a = context;
        this.f15268c = cursor.getLong(c4114aw.f15336b);
        this.f15279n = pattern;
        this.f15267b = cursor.getString(c4114aw.f15335a);
        this.f15270e = cursor.getLong(c4114aw.f15337c);
        this.f15290y = z;
        if ("sms".equals(this.f15267b)) {
            this.f15272g = false;
            long j = cursor.getLong(c4114aw.f15342h);
            if (j == -1) {
                this.f15271f = EnumC4109ar.NONE;
            } else if (j >= 64) {
                this.f15271f = EnumC4109ar.FAILED;
            } else if (j >= 32) {
                this.f15271f = EnumC4109ar.PENDING;
            } else {
                this.f15271f = EnumC4109ar.RECEIVED;
            }
            if (this.f15290y) {
                this.f15283r = ContentUris.withAppendedId(C4012bp.f14470f, this.f15268c);
            } else {
                this.f15283r = ContentUris.withAppendedId(Telephony.Sms.CONTENT_URI, this.f15268c);
            }
            this.f15269d = cursor.getInt(c4114aw.f15341g);
            this.f15275j = cursor.getString(c4114aw.f15338d);
            if (Telephony.Sms.isOutgoingFolder(this.f15269d)) {
                this.f15276k = context.getString(R.string.messagelist_sender_self);
            } else {
                this.f15276k = C3782a.m14204a(this.f15275j, false).m14264f();
            }
            this.f15277l = cursor.getString(c4114aw.f15339e);
            this.f15244C = cursor.getLong(c4114aw.f15340f);
            if (!m16314q()) {
                this.f15274i = C4149cd.m16393a(context, this.f15244C);
            }
            this.f15273h = cursor.getInt(c4114aw.f15343i) != 0;
            this.f15282q = C3847e.m14644a(this.f15270e) > 0;
            if (C3847e.m14679ak()) {
                this.f15291z = cursor.getLong(c4114aw.f15353s);
                this.f15242A = cursor.getInt(c4114aw.f15354t);
                return;
            }
            return;
        }
        if ("mms".equals(this.f15267b)) {
            this.f15283r = ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, this.f15268c);
            this.f15269d = cursor.getInt(c4114aw.f15348n);
            this.f15284s = cursor.getInt(c4114aw.f15347m);
            this.f15289x = cursor.getInt(c4114aw.f15351q);
            String string = cursor.getString(c4114aw.f15345k);
            if (!TextUtils.isEmpty(string)) {
                int i = cursor.getInt(c4114aw.f15346l);
                if (Build.VERSION.SDK_INT >= 19) {
                    this.f15286u = C3947e.m15261b(string, i);
                } else {
                    this.f15286u = new C5082e(i, string).m19308c();
                }
            }
            this.f15273h = cursor.getInt(c4114aw.f15352r) != 0;
            C5097t c5097tM19426a = C5097t.m19426a(this.f15266a);
            if (130 == this.f15284s) {
                this.f15271f = EnumC4109ar.NONE;
                C5084g c5084g = (C5084g) c5097tM19426a.m19449a(this.f15283r);
                m16295a(c5084g.mo19324w_(), this.f15283r);
                this.f15277l = new String(c5084g.m19320a());
                this.f15288w = (int) c5084g.m19322e();
                jD = c5084g.m19321c() * 1000;
            } else {
                C5083f c5083f = (C5083f) c5097tM19426a.m19449a(this.f15283r);
                this.f15287v = C3870p.m14882a(context, c5083f.m19309a());
                this.f15243B = this.f15287v.m14921j();
                this.f15285t = C4149cd.m16389a(this.f15287v);
                if (this.f15284s == 132) {
                    C5101x c5101x = (C5101x) c5083f;
                    m16295a(c5101x.mo19324w_(), this.f15283r);
                    jD = c5101x.m19316d() * 1000;
                } else {
                    String string2 = context.getString(R.string.messagelist_sender_self);
                    this.f15275j = string2;
                    this.f15276k = string2;
                    jD = ((C5103z) c5083f).m19316d() * 1000;
                }
                String string3 = cursor.getString(c4114aw.f15349o);
                if (string3 == null || !this.f15275j.equals(context.getString(R.string.messagelist_sender_self))) {
                    this.f15271f = EnumC4109ar.NONE;
                } else {
                    try {
                        if (Integer.parseInt(string3) == 128) {
                            this.f15271f = EnumC4109ar.RECEIVED;
                        } else {
                            this.f15271f = EnumC4109ar.NONE;
                        }
                    } catch (NumberFormatException e) {
                        C3890m.m14999e(f15241Y, "Value for delivery report was invalid.");
                        this.f15271f = EnumC4109ar.NONE;
                    }
                }
                String string4 = cursor.getString(c4114aw.f15350p);
                if (string4 == null || !this.f15275j.equals(context.getString(R.string.messagelist_sender_self))) {
                    this.f15272g = false;
                } else {
                    try {
                        this.f15272g = Integer.parseInt(string4) == 128;
                    } catch (NumberFormatException e2) {
                        C3890m.m14999e(f15241Y, "Value for read report was invalid.");
                        this.f15272g = false;
                    }
                }
                C3869o c3869o = this.f15287v.get(0);
                if (c3869o != null && c3869o.m14861d()) {
                    C3872r c3872rM14874n = c3869o.m14874n();
                    if (c3872rM14874n.m14823x()) {
                        this.f15277l = this.f15266a.getString(R.string.drm_protected_text);
                    } else {
                        this.f15277l = c3872rM14874n.m14940a();
                    }
                    this.f15278m = c3872rM14874n.m14812m();
                }
                this.f15288w = this.f15287v.m14911c();
            }
            if (!m16314q()) {
                this.f15274i = C4149cd.m16393a(context, jD);
                return;
            }
            return;
        }
        throw new C5111c("Unknown type of the message: " + this.f15267b);
    }

    public C4108aq(Context context, Cursor cursor, C1730gc c1730gc, int i, Pattern pattern, boolean z) throws C5111c {
        this.f15267b = "";
        this.f15291z = 0L;
        this.f15242A = 0;
        this.f15266a = context;
        if (i == 1 || i == 2) {
            this.f15268c = cursor.getLong(c1730gc.f6498b);
            this.f15279n = pattern;
            this.f15267b = cursor.getString(c1730gc.f6497a);
            this.f15270e = cursor.getLong(c1730gc.f6499c);
            this.f15290y = z;
            if ("sms".equals(this.f15267b)) {
                this.f15272g = false;
                long j = cursor.getLong(c1730gc.f6504h);
                if (j == -1) {
                    this.f15271f = EnumC4109ar.NONE;
                } else if (j >= 64) {
                    this.f15271f = EnumC4109ar.FAILED;
                } else if (j >= 32) {
                    this.f15271f = EnumC4109ar.PENDING;
                } else {
                    this.f15271f = EnumC4109ar.RECEIVED;
                }
                if (this.f15290y) {
                    this.f15283r = ContentUris.withAppendedId(C4012bp.f14470f, this.f15268c);
                } else {
                    this.f15283r = ContentUris.withAppendedId(Telephony.Sms.CONTENT_URI, this.f15268c);
                }
                this.f15269d = cursor.getInt(c1730gc.f6503g);
                this.f15275j = cursor.getString(c1730gc.f6500d);
                if (Telephony.Sms.isOutgoingFolder(this.f15269d)) {
                    this.f15276k = context.getString(R.string.messagelist_sender_self);
                } else {
                    this.f15276k = C3782a.m14204a(this.f15275j, false).m14264f();
                }
                this.f15277l = cursor.getString(c1730gc.f6501e);
                this.f15244C = cursor.getLong(c1730gc.f6502f);
                if (!m16314q()) {
                    this.f15274i = C4149cd.m16393a(context, this.f15244C);
                }
                this.f15273h = cursor.getInt(c1730gc.f6505i) != 0;
                if (C3847e.m14679ak()) {
                    this.f15291z = cursor.getLong(c1730gc.f6515s);
                    this.f15242A = cursor.getInt(c1730gc.f6516t);
                    return;
                }
                return;
            }
            if ("mms".equals(this.f15267b)) {
                this.f15283r = ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, this.f15268c);
                this.f15269d = cursor.getInt(c1730gc.f6510n);
                this.f15284s = cursor.getInt(c1730gc.f6509m);
                this.f15289x = cursor.getInt(c1730gc.f6513q);
                String string = cursor.getString(c1730gc.f6507k);
                if (!TextUtils.isEmpty(string)) {
                    int i2 = cursor.getInt(c1730gc.f6508l);
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.f15286u = C3947e.m15261b(string, i2);
                    } else {
                        this.f15286u = new C5082e(i2, string).m19308c();
                    }
                }
                this.f15273h = cursor.getInt(c1730gc.f6514r) != 0;
                C5097t c5097tM19426a = C5097t.m19426a(this.f15266a);
                if (130 == this.f15284s) {
                    this.f15271f = EnumC4109ar.NONE;
                    C5084g c5084g = (C5084g) c5097tM19426a.m19449a(this.f15283r);
                    m16295a(c5084g.mo19324w_(), this.f15283r);
                    this.f15277l = new String(c5084g.m19320a());
                    this.f15288w = (int) c5084g.m19322e();
                    this.f15244C = c5084g.m19321c() * 1000;
                } else {
                    C5083f c5083f = (C5083f) c5097tM19426a.m19449a(this.f15283r);
                    this.f15287v = C3870p.m14882a(context, c5083f.m19309a());
                    this.f15243B = this.f15287v.m14921j();
                    this.f15285t = C4149cd.m16389a(this.f15287v);
                    if (this.f15284s == 132) {
                        C5101x c5101x = (C5101x) c5083f;
                        m16295a(c5101x.mo19324w_(), this.f15283r);
                        this.f15244C = c5101x.m19316d() * 1000;
                    } else {
                        String string2 = context.getString(R.string.messagelist_sender_self);
                        this.f15275j = string2;
                        this.f15276k = string2;
                        this.f15244C = ((C5103z) c5083f).m19316d() * 1000;
                    }
                    String string3 = cursor.getString(c1730gc.f6511o);
                    if (string3 == null || !this.f15275j.equals(context.getString(R.string.messagelist_sender_self))) {
                        this.f15271f = EnumC4109ar.NONE;
                    } else {
                        try {
                            if (Integer.parseInt(string3) == 128) {
                                this.f15271f = EnumC4109ar.RECEIVED;
                            } else {
                                this.f15271f = EnumC4109ar.NONE;
                            }
                        } catch (NumberFormatException e) {
                            C3890m.m14999e(f15241Y, "Value for delivery report was invalid.");
                            this.f15271f = EnumC4109ar.NONE;
                        }
                    }
                    String string4 = cursor.getString(c1730gc.f6512p);
                    if (string4 == null || !this.f15275j.equals(context.getString(R.string.messagelist_sender_self))) {
                        this.f15272g = false;
                    } else {
                        try {
                            this.f15272g = Integer.parseInt(string4) == 128;
                        } catch (NumberFormatException e2) {
                            C3890m.m14999e(f15241Y, "Value for read report was invalid.");
                            this.f15272g = false;
                        }
                    }
                    C3869o c3869o = this.f15287v.get(0);
                    if (c3869o != null && c3869o.m14861d()) {
                        C3872r c3872rM14874n = c3869o.m14874n();
                        if (c3872rM14874n.m14823x()) {
                            this.f15277l = this.f15266a.getString(R.string.drm_protected_text);
                        } else {
                            this.f15277l = c3872rM14874n.m14940a();
                        }
                        this.f15278m = c3872rM14874n.m14812m();
                    }
                    this.f15288w = this.f15287v.m14911c();
                }
                if (!m16314q()) {
                    this.f15274i = C4149cd.m16393a(context, this.f15244C);
                    return;
                }
                return;
            }
            throw new C5111c("Unknown type of the message: " + this.f15267b);
        }
        if (i == 0) {
            this.f15245D = cursor.getLong(c1730gc.f6517u);
            this.f15246E = cursor.getLong(c1730gc.f6518v);
            this.f15247F = cursor.getLong(c1730gc.f6519w);
            this.f15254M = cursor.getString(c1730gc.f6522z);
            this.f15248G = EnumC2214ab.m10070a(cursor.getInt(c1730gc.f6520x));
            this.f15249H = cursor.getInt(c1730gc.f6521y);
            this.f15250I = cursor.getString(c1730gc.f6482A);
            this.f15251J = cursor.getString(c1730gc.f6483B);
            this.f15252K = cursor.getString(c1730gc.f6484C);
            this.f15253L = cursor.getString(c1730gc.f6522z);
            this.f15255N = cursor.getString(c1730gc.f6486E);
            this.f15256O = cursor.getInt(c1730gc.f6487F);
            this.f15257P = cursor.getString(c1730gc.f6488G);
            this.f15258Q = cursor.getString(c1730gc.f6489H);
            this.f15259R = cursor.getString(c1730gc.f6490I);
            this.f15260S = cursor.getString(c1730gc.f6491J);
            this.f15261T = cursor.getString(c1730gc.f6492K);
            this.f15262U = cursor.getString(c1730gc.f6493L);
            this.f15263V = cursor.getInt(c1730gc.f6494M);
            this.f15264W = cursor.getInt(c1730gc.f6495N);
            this.f15265X = EnumC2216ad.m10082a(cursor.getInt(c1730gc.f6496O));
        }
    }

    /* renamed from: a */
    private void m16295a(C5082e c5082e, Uri uri) {
        if (c5082e != null) {
            this.f15275j = c5082e.m19308c();
        } else {
            this.f15275j = C3875a.m14950a(this.f15266a, uri);
        }
        this.f15276k = TextUtils.isEmpty(this.f15275j) ? "" : C3782a.m14204a(this.f15275j, false).m14264f();
    }

    /* renamed from: a */
    public void m16298a(CharSequence charSequence) {
        this.f15280o = charSequence;
    }

    /* renamed from: a */
    public CharSequence m16297a() {
        boolean zM16316s = m16316s();
        if (zM16316s != this.f15281p) {
            this.f15281p = zM16316s;
            this.f15280o = null;
        }
        return this.f15280o;
    }

    public String toString() {
        return "type: " + this.f15267b + " box: " + this.f15269d + " uri: " + this.f15283r + " address: " + this.f15275j + " contact: " + this.f15276k + " read: " + this.f15272g + " delivery status: " + this.f15271f;
    }

    /* renamed from: b */
    public EnumC2214ab m16299b() {
        if (m16312o()) {
            return EnumC2214ab.TEXT;
        }
        if (this.f15285t == 0) {
            return EnumC2214ab.TEXT;
        }
        if (this.f15285t == 1) {
            return EnumC2214ab.IMAGE;
        }
        if (this.f15285t == 2) {
            return EnumC2214ab.VIDEO;
        }
        if (this.f15285t == 3) {
            return EnumC2214ab.AUDIO;
        }
        if (this.f15285t == 5) {
            if (this.f15287v.m14924m().m14744a().equalsIgnoreCase("text/x-vCard")) {
                return EnumC2214ab.CONTACT;
            }
            if (this.f15287v.m14924m().m14744a().equalsIgnoreCase("text/x-vCalendar")) {
                return EnumC2214ab.CALENDAR;
            }
        }
        return null;
    }

    /* renamed from: c */
    public String m16300c() {
        C3869o c3869o = this.f15287v.get(0);
        if (c3869o == null) {
            C3890m.m14999e(f15241Y, "slide may not be null.");
            return null;
        }
        if (this.f15285t == 1) {
            return c3869o.m14875o().m14816q();
        }
        if (this.f15285t == 2) {
            return c3869o.m14877q().m14816q();
        }
        if (this.f15285t == 3) {
            return c3869o.m14876p().m14816q();
        }
        if (this.f15285t != 5) {
            return null;
        }
        return this.f15287v.m14924m().m14748d();
    }

    /* renamed from: d */
    public void m16301d() {
        ContentValues contentValues = new ContentValues(4);
        contentValues.put("err_type", (Integer) 0);
        contentValues.put("retry_index", (Integer) 0);
        contentValues.put("due_time", (Integer) 0);
        contentValues.put("last_try", (String) null);
        SqliteWrapper.update(this.f15266a, this.f15266a.getContentResolver(), Telephony.MmsSms.PendingMessages.CONTENT_URI, contentValues, "msg_id=" + this.f15268c, (String[]) null);
    }

    /* renamed from: e */
    public Uri m16302e() {
        return m16309l() ? ContentUris.withAppendedId(C4149cd.f15441b, this.f15268c) : this.f15283r;
    }

    /* renamed from: f */
    public int m16303f() {
        return this.f15285t;
    }

    /* renamed from: g */
    public boolean m16304g() {
        return this.f15273h;
    }

    /* renamed from: h */
    public C3870p m16305h() {
        return this.f15287v;
    }

    /* renamed from: i */
    public int m16306i() {
        return m16309l() ? this.f15242A : this.f15269d;
    }

    /* renamed from: j */
    public long m16307j() {
        return this.f15268c;
    }

    /* renamed from: k */
    public long m16308k() {
        return this.f15270e;
    }

    /* renamed from: l */
    public boolean m16309l() {
        return this.f15268c == this.f15291z;
    }

    /* renamed from: m */
    public boolean m16310m() {
        int iM16306i = m16306i();
        return (m16311n() && iM16306i == 1) || (m16312o() && iM16306i == 1);
    }

    /* renamed from: n */
    public boolean m16311n() {
        if (this.f15267b == null) {
            return false;
        }
        return this.f15267b.equals("mms");
    }

    /* renamed from: o */
    public boolean m16312o() {
        if (this.f15267b == null) {
            return false;
        }
        return this.f15267b.equals("sms");
    }

    /* renamed from: p */
    public boolean m16313p() {
        return this.f15284s != 130;
    }

    /* renamed from: q */
    public boolean m16314q() {
        return (m16311n() && this.f15269d == 4) || (m16312o() && (m16306i() == 5 || m16306i() == 4 || m16306i() == 6));
    }

    /* renamed from: r */
    public boolean m16315r() {
        return (m16311n() && this.f15269d == 1) || (m16312o() && m16306i() == 1);
    }

    /* renamed from: s */
    public boolean m16316s() {
        return !m16317t() && m16314q();
    }

    /* renamed from: t */
    public boolean m16317t() {
        return (m16311n() && this.f15289x >= 10) || (m16312o() && m16306i() == 5);
    }

    /* renamed from: u */
    public String m16318u() {
        return m16311n() ? m16296v() : this.f15277l;
    }

    /* renamed from: v */
    private String m16296v() {
        if (!m16313p() || this.f15287v == null || this.f15287v.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = this.f15287v.size();
        for (int i = 0; i < size; i++) {
            C3872r c3872rM14874n = this.f15287v.get(i).m14874n();
            if (c3872rM14874n != null) {
                sb.append(c3872rM14874n.m14940a());
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
