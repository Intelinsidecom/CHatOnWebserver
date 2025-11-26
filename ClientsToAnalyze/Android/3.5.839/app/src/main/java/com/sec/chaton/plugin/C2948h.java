package com.sec.chaton.plugin;

import android.content.Context;
import com.sec.common.C4996f;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PlugInManager.java */
/* renamed from: com.sec.chaton.plugin.h */
/* loaded from: classes.dex */
public class C2948h {

    /* renamed from: i */
    private static C2948h f10852i;

    /* renamed from: j */
    private Map<EnumC2949i, InterfaceC2941e> f10853j = new HashMap();

    /* renamed from: h */
    private static final String f10851h = C2948h.class.getSimpleName();

    /* renamed from: a */
    @Deprecated
    public static String f10844a = "com.sec.chaton.action.PLUGIN_INSTALLED";

    /* renamed from: b */
    @Deprecated
    public static String f10845b = "com.sec.chaton.action.PLUGIN_UNINSTALLED";

    /* renamed from: c */
    @Deprecated
    public static String f10846c = "com.sec.chaton.action.PLUGIN_REPLACED";

    /* renamed from: d */
    @Deprecated
    public static String f10847d = "com.sec.chaton.action.PLUGIN_ENABLED";

    /* renamed from: e */
    @Deprecated
    public static String f10848e = "com.sec.chaton.action.PLUGIN_DISABLED";

    /* renamed from: f */
    @Deprecated
    public static String f10849f = "com.sec.chaton.action.PLUGIN_DATA_CLEARED";

    /* renamed from: g */
    public static String f10850g = "plugInType";

    private C2948h() {
    }

    /* renamed from: a */
    public static synchronized C2948h m12190a() {
        if (f10852i == null) {
            f10852i = new C2948h();
        }
        return f10852i;
    }

    /* renamed from: a */
    InterfaceC2941e m12191a(EnumC2949i enumC2949i) throws IllegalAccessException, InstantiationException, C2947g {
        if (!this.f10853j.containsKey(enumC2949i)) {
            try {
                InterfaceC2941e interfaceC2941eNewInstance = enumC2949i.f10861g.newInstance();
                this.f10853j.put(enumC2949i, interfaceC2941eNewInstance);
                return interfaceC2941eNewInstance;
            } catch (IllegalAccessException e) {
                throw new C2947g("Can't initialize PlugIn.", e);
            } catch (InstantiationException e2) {
                throw new C2947g("Can't initialize PlugIn.", e2);
            }
        }
        return this.f10853j.get(enumC2949i);
    }

    /* renamed from: a */
    public boolean m12192a(Context context, EnumC2949i enumC2949i) {
        try {
            return m12191a(enumC2949i).mo12145a(context);
        } catch (C2947g e) {
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f10851h, e.getMessage(), e);
            }
            return false;
        }
    }
}
