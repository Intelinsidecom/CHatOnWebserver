package com.sec.chaton.p061g;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.p055d.C2097bc;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.google.android.p134a.C5111c;
import java.util.HashMap;

/* compiled from: FreeSmsInviteSender.java */
/* renamed from: com.sec.chaton.g.a */
/* loaded from: classes.dex */
public class C2342a {

    /* renamed from: c */
    private static HashMap<Integer, C2342a> f8325c = new HashMap<>();

    /* renamed from: a */
    C2097bc f8326a;

    /* renamed from: b */
    Handler f8327b;

    /* renamed from: d */
    private final int f8328d;

    /* renamed from: e */
    private final Context f8329e;

    /* renamed from: f */
    private final String[] f8330f;

    /* renamed from: g */
    private final String[] f8331g;

    /* renamed from: h */
    private ProgressDialog f8332h;

    /* renamed from: i */
    private C2344c f8333i;

    /* renamed from: j */
    private Handler f8334j;

    public C2342a(Context context, String[] strArr, String[] strArr2) {
        this.f8332h = null;
        this.f8334j = null;
        this.f8327b = new HandlerC2343b(this, Looper.getMainLooper());
        this.f8329e = context;
        this.f8330f = strArr;
        this.f8331g = strArr2;
        this.f8328d = hashCode();
        this.f8334j = this.f8334j;
        this.f8326a = new C2097bc(this.f8327b);
        f8325c.put(Integer.valueOf(this.f8328d), this);
    }

    public C2342a(Context context, String[] strArr, String[] strArr2, Handler handler, C2344c c2344c) {
        this(context, strArr, strArr2);
        this.f8334j = handler;
        this.f8333i = c2344c;
    }

    /* renamed from: a */
    public boolean m10265a() throws C5111c {
        try {
            this.f8326a.m9375b();
            return false;
        } catch (Exception e) {
            if (this.f8333i != null) {
                this.f8333i.m10267a(true, 0, 0);
            }
            C3890m.m14995a("FreeSmsInviteSender", "SmsMessageSender.sendMessage: caught", e);
            throw new C5111c("SmsMessageSender.sendMessage: caught " + e + " from SmsManager.sendTextMessage()");
        }
    }
}
