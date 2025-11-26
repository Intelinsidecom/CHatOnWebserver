package com.sec.chaton.plugin;

import android.content.Context;
import com.sec.common.C3330f;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PlugInManager.java */
/* renamed from: com.sec.chaton.plugin.g */
/* loaded from: classes.dex */
public class C1954g {

    /* renamed from: i */
    private static C1954g f7476i;

    /* renamed from: j */
    private Map<EnumC1955h, InterfaceC1951d> f7477j = new HashMap();

    /* renamed from: h */
    private static final String f7475h = C1954g.class.getSimpleName();

    /* renamed from: a */
    public static String f7468a = "com.sec.chaton.action.PLUGIN_INSTALLED";

    /* renamed from: b */
    public static String f7469b = "com.sec.chaton.action.PLUGIN_UNINSTALLED";

    /* renamed from: c */
    public static String f7470c = "com.sec.chaton.action.PLUGIN_REPLACED";

    /* renamed from: d */
    public static String f7471d = "com.sec.chaton.action.PLUGIN_ENABLED";

    /* renamed from: e */
    public static String f7472e = "com.sec.chaton.action.PLUGIN_DISABLED";

    /* renamed from: f */
    public static String f7473f = "com.sec.chaton.action.PLUGIN_DATA_CLEARED";

    /* renamed from: g */
    public static String f7474g = "plugInType";

    private C1954g() {
    }

    /* renamed from: a */
    public static synchronized C1954g m7916a() {
        if (f7476i == null) {
            f7476i = new C1954g();
        }
        return f7476i;
    }

    /* renamed from: a */
    InterfaceC1951d m7917a(EnumC1955h enumC1955h) throws IllegalAccessException, InstantiationException, C1953f {
        if (!this.f7477j.containsKey(enumC1955h)) {
            try {
                InterfaceC1951d interfaceC1951dNewInstance = enumC1955h.f7483e.newInstance();
                this.f7477j.put(enumC1955h, interfaceC1951dNewInstance);
                return interfaceC1951dNewInstance;
            } catch (IllegalAccessException e) {
                throw new C1953f("Can't initialize PlugIn.", e);
            } catch (InstantiationException e2) {
                throw new C1953f("Can't initialize PlugIn.", e2);
            }
        }
        return this.f7477j.get(enumC1955h);
    }

    /* renamed from: a */
    public boolean m7918a(Context context, EnumC1955h enumC1955h) {
        try {
            return m7917a(enumC1955h).mo7906b(context);
        } catch (C1953f e) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(f7475h, e.getMessage(), e);
            }
            return false;
        }
    }
}
