package com.sec.chaton.smsplugin.p110g;

import android.content.ContentResolver;
import android.content.Context;
import android.preference.PreferenceManager;
import com.sec.chaton.smsplugin.C3778a;
import com.sec.chaton.smsplugin.C3781b;
import com.sec.chaton.smsplugin.C3805c;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.C3850f;
import com.sec.chaton.smsplugin.C3854g;
import com.sec.chaton.smsplugin.C3905j;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p112ui.SMSPreferenceActivity;
import com.sec.chaton.util.C4822an;
import com.sec.google.android.p134a.C5077a;
import java.util.ArrayList;

/* compiled from: CarrierContentRestriction.java */
/* renamed from: com.sec.chaton.smsplugin.g.c */
/* loaded from: classes.dex */
public class C3857c implements InterfaceC3858d {

    /* renamed from: a */
    private static final ArrayList<String> f13861a = C5077a.m19285a();

    /* renamed from: b */
    private static final ArrayList<String> f13862b = C5077a.m19287b();

    /* renamed from: c */
    private static final ArrayList<String> f13863c = C5077a.m19289c();

    @Override // com.sec.chaton.smsplugin.p110g.InterfaceC3858d
    /* renamed from: a */
    public void mo14757a(int i, int i2, ContentResolver contentResolver) {
        if (i < 0 || i2 < 0) {
            throw new C3778a("Negative message size or increase size");
        }
        int i3 = i + i2;
        if (i3 < 0 || i3 > C3847e.m14697c()) {
            if (C3847e.m14652aC() && C4822an.m18218a()) {
                if (i2 > C3847e.m14653aD()) {
                    throw new C3781b("Exeed large file size limitation");
                }
                return;
            }
            throw new C3805c("Exceed message size limitation");
        }
    }

    @Override // com.sec.chaton.smsplugin.p110g.InterfaceC3858d
    /* renamed from: a */
    public void mo14756a(int i, int i2) {
        C3890m.m14996b(C3857c.class.getSimpleName(), "width:" + i + "height:" + i2);
        C3890m.m14996b(C3857c.class.getSimpleName(), "width:" + C3847e.m14707m() + "height:" + C3847e.m14707m());
        if (i > C3847e.m14707m() || ((i2 > C3847e.m14706l() && i > C3847e.m14706l()) || i2 > C3847e.m14707m())) {
            throw new C3850f("content resolution exceeds restriction.");
        }
    }

    @Override // com.sec.chaton.smsplugin.p110g.InterfaceC3858d
    /* renamed from: a */
    public void mo14758a(String str) {
        if (str == null) {
            throw new C3778a("Null content type to be check");
        }
        if (!f13861a.contains(str)) {
            throw new C3905j("Unsupported image content type : " + str);
        }
    }

    @Override // com.sec.chaton.smsplugin.p110g.InterfaceC3858d
    /* renamed from: b */
    public void mo14760b(String str) {
        if (str == null) {
            throw new C3778a("Null content type to be check");
        }
        if (!f13862b.contains(str)) {
            throw new C3905j("Unsupported audio content type : " + str);
        }
    }

    @Override // com.sec.chaton.smsplugin.p110g.InterfaceC3858d
    /* renamed from: c */
    public void mo14761c(String str) {
        if (str == null) {
            throw new C3778a("Null content type to be check");
        }
        if (!f13863c.contains(str)) {
            throw new C3905j("Unsupported video content type : " + str);
        }
    }

    @Override // com.sec.chaton.smsplugin.p110g.InterfaceC3858d
    /* renamed from: a */
    public void mo14755a(int i) {
        if (i != 0) {
            throw new C3854g("Rotation exceeds restriction.");
        }
    }

    @Override // com.sec.chaton.smsplugin.p110g.InterfaceC3858d
    /* renamed from: a */
    public void mo14759a(String str, int i) {
        if (str == null) {
            throw new C3778a("Null content type to be check");
        }
        if (str.equalsIgnoreCase("image/jpeg") || str.equalsIgnoreCase("image/jpg") || str.equalsIgnoreCase("image/gif") || str.equalsIgnoreCase("image/vnd.wap.wbmp")) {
            return;
        }
        if (i == 0 || i == 1) {
            throw new C3778a("PNG image");
        }
    }

    /* renamed from: a */
    public static int m14754a(Context context) {
        return SMSPreferenceActivity.m16175a(PreferenceManager.getDefaultSharedPreferences(context).getString("pref_key_mms_creation_mode", "free"));
    }
}
