package com.sec.chaton.updates;

import com.sec.chaton.p065io.entry.inner.NewUpdateAdditionalEntry;
import com.sec.chaton.p065io.entry.inner.NewUpdateSenderEntry;
import java.io.Serializable;

/* compiled from: UpdatesItem.java */
/* renamed from: com.sec.chaton.updates.p */
/* loaded from: classes.dex */
public class C4709p implements Serializable {

    /* renamed from: a */
    private NewUpdateSenderEntry f17056a;

    /* renamed from: b */
    private String f17057b;

    /* renamed from: c */
    private String f17058c;

    /* renamed from: d */
    private EnumC4700g f17059d;

    /* renamed from: e */
    private String f17060e;

    /* renamed from: f */
    private String f17061f;

    /* renamed from: g */
    private String f17062g;

    /* renamed from: h */
    private NewUpdateAdditionalEntry f17063h;

    /* renamed from: i */
    private EnumC4699f f17064i;

    /* renamed from: j */
    private EnumC4697d f17065j;

    /* renamed from: k */
    private EnumC4698e f17066k;

    public C4709p(NewUpdateSenderEntry newUpdateSenderEntry, String str, String str2, String str3, String str4, String str5, String str6, NewUpdateAdditionalEntry newUpdateAdditionalEntry) {
        this.f17056a = newUpdateSenderEntry;
        this.f17057b = str;
        this.f17058c = str2;
        if (str3 == null) {
            this.f17059d = EnumC4700g.NORMAL;
        } else {
            this.f17059d = EnumC4700g.m17760a(str3);
        }
        this.f17060e = str4;
        this.f17061f = str5;
        this.f17062g = str6;
        this.f17063h = newUpdateAdditionalEntry;
        this.f17064i = EnumC4699f.m17758a(str);
        this.f17065j = EnumC4697d.m17754a(str2);
        if (newUpdateAdditionalEntry != null && newUpdateAdditionalEntry.media != null) {
            this.f17066k = EnumC4698e.m17756a(newUpdateAdditionalEntry.media);
        } else {
            this.f17066k = EnumC4698e.NONE;
        }
    }

    /* renamed from: a */
    public String m17763a(int i) {
        return this.f17056a.buddy.get(i).f8575id;
    }

    /* renamed from: b */
    public String m17765b(int i) {
        return this.f17056a.buddy.get(i).name;
    }

    /* renamed from: a */
    public EnumC4700g m17762a() {
        return this.f17059d;
    }

    /* renamed from: b */
    public String m17764b() {
        return this.f17060e;
    }

    /* renamed from: c */
    public String m17766c() {
        return this.f17061f;
    }

    /* renamed from: d */
    public boolean m17767d() {
        if (this.f17063h == null || this.f17063h.comment == null) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    public String m17768e() {
        return this.f17063h.comment;
    }

    /* renamed from: f */
    public int m17769f() {
        if (this.f17063h == null || this.f17063h.buddy_count == null) {
            return 0;
        }
        return Integer.valueOf(this.f17063h.buddy_count).intValue();
    }

    /* renamed from: g */
    public EnumC4698e m17770g() {
        return this.f17066k;
    }

    /* renamed from: h */
    public boolean m17771h() {
        return this.f17056a.buddy.size() == 1;
    }

    /* renamed from: i */
    public EnumC4699f m17772i() {
        return this.f17064i;
    }

    /* renamed from: j */
    public EnumC4697d m17773j() {
        return this.f17065j;
    }

    /* renamed from: k */
    public boolean m17774k() {
        if (this.f17062g == null || !"true".equals(this.f17062g)) {
            return true;
        }
        return false;
    }

    /* renamed from: l */
    public void m17775l() {
        this.f17062g = null;
    }
}
