package android.sec.multiwindow;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Pair;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MultiWindowImpl {
    private static Field sArrangeField = null;
    protected Context mContext;
    private HashMap<String, Pair<Object, Method>> mMethodMap = new HashMap<>();

    public MultiWindowImpl(Context context) throws NoSuchMethodException, SecurityException {
        this.mContext = context;
        Class<?> clsFindClass = findClass("android.view.WindowManagerPolicy$WindowModeHelper");
        putMethod(clsFindClass, null, "mode", new Class[]{Integer.TYPE});
        putMethod(clsFindClass, null, "option", new Class[]{Integer.TYPE});
    }

    protected Class<?> findClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    protected void putMethod(Class<?> cls, Object obj, String str, Class<?>[] clsArr) throws NoSuchMethodException, SecurityException {
        try {
            this.mMethodMap.put(str, new Pair<>(obj, cls.getMethod(str, clsArr)));
        } catch (NoSuchMethodException e) {
        }
    }

    protected Object invoke(String str, Object... objArr) {
        try {
            Pair<Object, Method> pair = this.mMethodMap.get(str);
            return ((Method) pair.second).invoke(pair.first, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected int mode(int i) {
        return ((Integer) invoke("mode", Integer.valueOf(i))).intValue();
    }

    protected int option(int i) {
        return ((Integer) invoke("option", Integer.valueOf(i))).intValue();
    }

    protected int getArrange(Configuration configuration) {
        try {
            if (sArrangeField == null) {
                sArrangeField = configuration.getClass().getField("arrange");
            }
            return sArrangeField.getInt(configuration);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0;
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
            return 0;
        }
    }
}
