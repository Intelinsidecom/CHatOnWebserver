package com.sec.chaton.smsplugin.p110g;

import android.content.Context;
import com.sec.chaton.smsplugin.p108e.C3849b;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.google.android.p134a.p135a.C5080c;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.p146b.p147a.p148a.InterfaceC5237b;

/* compiled from: TextModel.java */
/* renamed from: com.sec.chaton.smsplugin.g.r */
/* loaded from: classes.dex */
public class C3872r extends AbstractC3867m {

    /* renamed from: o */
    private CharSequence f13934o;

    /* renamed from: p */
    private final int f13935p;

    public C3872r(Context context, String str, String str2, C3868n c3868n) {
        this(context, str, str2, 106, new byte[0], c3868n);
    }

    public C3872r(Context context, String str, String str2, int i, byte[] bArr, C3868n c3868n) {
        super(context, "text", str, str2, bArr != null ? bArr : new byte[0], c3868n);
        this.f13935p = i == 0 ? 4 : i;
        this.f13934o = m14939a(bArr);
    }

    /* renamed from: a */
    private CharSequence m14939a(byte[] bArr) {
        String str;
        if (bArr != null) {
            try {
                if (this.f13935p == 0) {
                    str = new String(bArr);
                } else {
                    str = new String(bArr, C5080c.m19300a(this.f13935p));
                }
                return str;
            } catch (UnsupportedEncodingException e) {
                C3890m.m14995a("Mms/text", "Unsupported encoding: " + this.f13935p, e);
                return new String(bArr);
            }
        }
        return "";
    }

    public C3872r(Context context, String str, String str2, int i, C3849b c3849b, C3868n c3868n) {
        super(context, "text", str, str2, c3849b, c3868n);
        this.f13935p = i == 0 ? 4 : i;
    }

    /* renamed from: a */
    public String m14940a() {
        if (this.f13934o == null) {
            try {
                this.f13934o = m14939a(m14815p());
            } catch (IOException e) {
                C3890m.m14995a("Mms/text", e.getMessage(), e);
                this.f13934o = e.getMessage();
            }
        }
        if (!(this.f13934o instanceof String)) {
            this.f13934o = this.f13934o.toString();
        }
        return this.f13934o.toString();
    }

    /* renamed from: a */
    public void m14941a(CharSequence charSequence) {
        this.f13934o = charSequence;
        m14833a(true);
    }

    @Deprecated
    /* renamed from: a */
    public void m14942a(CharSequence charSequence, boolean z) {
        this.f13934o = charSequence;
        if (z) {
            this.f13886h = this.f13934o.toString().getBytes().length;
        }
        m14833a(true);
    }

    /* renamed from: b */
    public void m14943b() {
        this.f13934o = new String(this.f13934o.toString());
    }

    /* renamed from: d */
    public int m14944d() {
        return this.f13935p;
    }

    @Override // org.p146b.p147a.p148a.InterfaceC5239d
    /* renamed from: a */
    public void mo14745a(InterfaceC5237b interfaceC5237b) {
        if (interfaceC5237b.mo14494b().equals("SmilMediaStart")) {
            this.f13901n = true;
        } else if (this.f13885g != 1) {
            this.f13901n = false;
        }
        m14833a(false);
    }
}
