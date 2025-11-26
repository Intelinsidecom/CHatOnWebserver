package com.sec.chaton.smsplugin.p110g;

import android.content.Context;
import android.net.Uri;
import com.sec.chaton.smsplugin.p108e.C3849b;

/* compiled from: RegionMediaModel.java */
/* renamed from: com.sec.chaton.smsplugin.g.m */
/* loaded from: classes.dex */
public abstract class AbstractC3867m extends AbstractC3863i {

    /* renamed from: m */
    protected C3868n f13900m;

    /* renamed from: n */
    protected boolean f13901n;

    public AbstractC3867m(Context context, String str, Uri uri, C3868n c3868n) {
        this(context, str, (String) null, (String) null, uri, c3868n);
    }

    public AbstractC3867m(Context context, String str, String str2, String str3, Uri uri, C3868n c3868n) {
        super(context, str, str2, str3, uri);
        this.f13901n = true;
        this.f13900m = c3868n;
    }

    public AbstractC3867m(Context context, String str, String str2, String str3, byte[] bArr, C3868n c3868n) {
        super(context, str, str2, str3, bArr);
        this.f13901n = true;
        this.f13900m = c3868n;
    }

    public AbstractC3867m(Context context, String str, String str2, String str3, C3849b c3849b, C3868n c3868n) {
        super(context, str, str2, str3, c3849b);
        this.f13901n = true;
        this.f13900m = c3868n;
    }

    /* renamed from: F */
    public C3868n m14836F() {
        return this.f13900m;
    }

    /* renamed from: G */
    public boolean m14837G() {
        return this.f13901n;
    }
}
