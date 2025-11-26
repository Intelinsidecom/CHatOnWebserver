package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import com.sec.chaton.smsplugin.p110g.C3866l;
import com.sec.chaton.smsplugin.p111h.C3890m;
import java.lang.reflect.InvocationTargetException;

/* compiled from: PresenterFactory.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gy */
/* loaded from: classes.dex */
public class C4278gy {
    /* renamed from: a */
    public static AbstractC4277gx m16480a(String str, Context context, InterfaceC4343ji interfaceC4343ji, C3866l c3866l) {
        try {
            if (str.indexOf(".") == -1) {
                str = "com.sec.chaton.smsplugin.ui." + str;
            }
            return (AbstractC4277gx) Class.forName(str).getConstructor(Context.class, InterfaceC4343ji.class, C3866l.class).newInstance(context, interfaceC4343ji, c3866l);
        } catch (ClassNotFoundException e) {
            C3890m.m14995a("PresenterFactory", "Type not found: " + str, e);
            return null;
        } catch (IllegalAccessException e2) {
            C3890m.m14995a("PresenterFactory", "Unexpected IllegalAccessException", e2);
            return null;
        } catch (InstantiationException e3) {
            C3890m.m14995a("PresenterFactory", "Unexpected InstantiationException", e3);
            return null;
        } catch (NoSuchMethodException e4) {
            C3890m.m14995a("PresenterFactory", "No such constructor.", e4);
            return null;
        } catch (InvocationTargetException e5) {
            C3890m.m14995a("PresenterFactory", "Unexpected InvocationTargetException", e5);
            return null;
        }
    }
}
