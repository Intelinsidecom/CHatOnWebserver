package com.sec.chaton.calllog.common.view;

import com.sec.chaton.util.C3250y;
import java.lang.reflect.Method;

/* compiled from: HoverUtil.java */
/* renamed from: com.sec.chaton.calllog.common.view.a */
/* loaded from: classes.dex */
public class C0827a {
    /* renamed from: a */
    public static Object m4380a(Object obj) throws SecurityException {
        if (obj == null) {
            C3250y.m11442a("Parameter is null!!!", "[HoverUtil]");
            return null;
        }
        for (Method method : obj.getClass().getDeclaredMethods()) {
            if (method.getName().equals("isEllipsis")) {
                try {
                    if (!method.isAccessible()) {
                        method.setAccessible(true);
                    }
                    if (method.getParameterTypes().length > 0) {
                        C3250y.m11442a("Need to check parameter of isEllipsis()!!!", "[HoverUtil]");
                        return false;
                    }
                    if (!method.getReturnType().toString().equals("boolean")) {
                        C3250y.m11442a("Need to check returnType of isEllipsis()!!!", "[HoverUtil]");
                        return false;
                    }
                    return method.invoke(obj, new Object[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        C3250y.m11442a("There is not isEllipsis method!!!", "[HoverUtil]");
        return null;
    }
}
