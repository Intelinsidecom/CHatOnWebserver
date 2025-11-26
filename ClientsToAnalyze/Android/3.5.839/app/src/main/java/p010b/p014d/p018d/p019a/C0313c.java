package p010b.p014d.p018d.p019a;

import com.sec.chaton.privateplugin.data.Spam;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: JSONObject.java */
/* renamed from: b.d.d.a.c */
/* loaded from: classes.dex */
public class C0313c {

    /* renamed from: a */
    public static final Object f693a = new C0315e();

    /* renamed from: b */
    private Map f694b;

    public C0313c() {
        this.f694b = new HashMap();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:200)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:61)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:281)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public C0313c(p010b.p014d.p018d.p019a.C0316f r4) {
        /*
            r3 = this;
            r3.<init>()
            char r0 = r4.m1071d()
            r1 = 123(0x7b, float:1.72E-43)
            if (r0 == r1) goto L2b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "A JSONObject text must begin with '{' found:"
            java.lang.StringBuilder r0 = r0.append(r1)
            char r1 = r4.m1071d()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            b.d.d.a.b r0 = r4.m1065a(r0)
            throw r0
        L28:
            r4.m1068a()
        L2b:
            char r0 = r4.m1071d()
            switch(r0) {
                case 0: goto L66;
                case 125: goto L82;
                default: goto L32;
            }
        L32:
            r4.m1068a()
            java.lang.Object r0 = r4.m1072e()
            java.lang.String r0 = r0.toString()
            char r1 = r4.m1071d()
            r2 = 61
            if (r1 != r2) goto L6e
            char r1 = r4.m1070c()
            r2 = 62
            if (r1 == r2) goto L50
            r4.m1068a()
        L50:
            java.lang.Object r1 = r4.m1072e()
            r3.m1060b(r0, r1)
            char r0 = r4.m1071d()
            switch(r0) {
                case 44: goto L7a;
                case 59: goto L7a;
                case 125: goto L82;
                default: goto L5e;
            }
        L5e:
            java.lang.String r0 = "Expected a ',' or '}'"
            b.d.d.a.b r0 = r4.m1065a(r0)
            throw r0
        L66:
            java.lang.String r0 = "A JSONObject text must end with '}'"
            b.d.d.a.b r0 = r4.m1065a(r0)
            throw r0
        L6e:
            r2 = 58
            if (r1 == r2) goto L50
            java.lang.String r0 = "Expected a ':' after a key"
            b.d.d.a.b r0 = r4.m1065a(r0)
            throw r0
        L7a:
            char r0 = r4.m1071d()
            r1 = 125(0x7d, float:1.75E-43)
            if (r0 != r1) goto L28
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p010b.p014d.p018d.p019a.C0313c.<init>(b.d.d.a.f):void");
    }

    public C0313c(Map map) {
        this.f694b = new HashMap();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    this.f694b.put(entry.getKey(), m1052c(value));
                }
            }
        }
    }

    public C0313c(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this();
        m1053d(obj);
    }

    public C0313c(String str) {
        this(new C0316f(str));
    }

    /* renamed from: a */
    public Object m1057a(String str) throws C0312b {
        if (str == null) {
            throw new C0312b("Null key.");
        }
        Object objM1063e = m1063e(str);
        if (objM1063e == null) {
            throw new C0312b("JSONObject[" + m1054f(str) + "] not found.");
        }
        return objM1063e;
    }

    /* renamed from: b */
    public C0311a m1059b(String str) throws C0312b {
        Object objM1057a = m1057a(str);
        if (objM1057a instanceof C0311a) {
            return (C0311a) objM1057a;
        }
        throw new C0312b("JSONObject[" + m1054f(str) + "] is not a JSONArray.");
    }

    /* renamed from: c */
    public String m1061c(String str) throws C0312b {
        Object objM1057a = m1057a(str);
        if (objM1057a == f693a) {
            return null;
        }
        return objM1057a.toString();
    }

    /* renamed from: d */
    public boolean m1062d(String str) {
        return f693a.equals(m1063e(str));
    }

    /* renamed from: a */
    public Iterator m1058a() {
        return this.f694b.keySet().iterator();
    }

    /* renamed from: a */
    public static String m1049a(Number number) throws C0312b {
        if (number == null) {
            throw new C0312b("Null pointer");
        }
        m1050a((Object) number);
        String string = number.toString();
        if (string.indexOf(46) > 0 && string.indexOf(101) < 0 && string.indexOf(69) < 0) {
            while (string.endsWith(Spam.ACTIVITY_CANCEL)) {
                string = string.substring(0, string.length() - 1);
            }
            if (string.endsWith(".")) {
                return string.substring(0, string.length() - 1);
            }
            return string;
        }
        return string;
    }

    /* renamed from: e */
    public Object m1063e(String str) {
        if (str == null) {
            return null;
        }
        return this.f694b.get(str);
    }

    /* renamed from: d */
    private void m1053d(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String lowerCase;
        Class<?> cls = obj.getClass();
        for (Method method : cls.getClassLoader() != null ? cls.getMethods() : cls.getDeclaredMethods()) {
            try {
                if (Modifier.isPublic(method.getModifiers())) {
                    String name = method.getName();
                    String strSubstring = "";
                    if (name.startsWith("get")) {
                        if (name.equals("getClass") || name.equals("getDeclaringClass")) {
                            strSubstring = "";
                        } else {
                            strSubstring = name.substring(3);
                        }
                    } else if (name.startsWith("is")) {
                        strSubstring = name.substring(2);
                    }
                    if (strSubstring.length() > 0 && Character.isUpperCase(strSubstring.charAt(0)) && method.getParameterTypes().length == 0) {
                        if (strSubstring.length() == 1) {
                            lowerCase = strSubstring.toLowerCase();
                        } else {
                            lowerCase = !Character.isUpperCase(strSubstring.charAt(1)) ? strSubstring.substring(0, 1).toLowerCase() + strSubstring.substring(1) : strSubstring;
                        }
                        Object objInvoke = method.invoke(obj, (Object[]) null);
                        if (objInvoke != null) {
                            this.f694b.put(lowerCase, m1052c(objInvoke));
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public C0313c m1056a(String str, Object obj) throws C0312b {
        if (str == null) {
            throw new C0312b("Null key.");
        }
        if (obj != null) {
            m1050a(obj);
            this.f694b.put(str, obj);
        } else {
            m1064g(str);
        }
        return this;
    }

    /* renamed from: b */
    public C0313c m1060b(String str, Object obj) throws C0312b {
        if (str != null && obj != null) {
            if (m1063e(str) != null) {
                throw new C0312b("Duplicate key \"" + str + "\"");
            }
            m1056a(str, obj);
        }
        return this;
    }

    /* renamed from: f */
    public static String m1054f(String str) {
        int i = 0;
        if (str == null || str.length() == 0) {
            return "\"\"";
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 4);
        sb.append('\"');
        char c2 = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            switch (cCharAt) {
                case '\b':
                    sb.append("\\b");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\"':
                case '\\':
                    sb.append('\\');
                    sb.append(cCharAt);
                    break;
                case '/':
                    if (c2 == '<') {
                        sb.append('\\');
                    }
                    sb.append(cCharAt);
                    break;
                default:
                    if (cCharAt < ' ' || ((cCharAt >= 128 && cCharAt < 160) || (cCharAt >= 8192 && cCharAt < 8448))) {
                        sb.append("\\u").append(("000" + Integer.toHexString(cCharAt)).substring(r1.length() - 4));
                        break;
                    } else {
                        sb.append(cCharAt);
                        break;
                    }
                    break;
            }
            i++;
            c2 = cCharAt;
        }
        sb.append('\"');
        return sb.toString();
    }

    /* renamed from: g */
    public Object m1064g(String str) {
        return this.f694b.remove(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Integer] */
    /* renamed from: h */
    public static Object m1055h(String str) throws NumberFormatException {
        if (!str.equals("")) {
            if (str.equalsIgnoreCase("true")) {
                return Boolean.TRUE;
            }
            if (str.equalsIgnoreCase("false")) {
                return Boolean.FALSE;
            }
            if (str.equalsIgnoreCase("null")) {
                return f693a;
            }
            char cCharAt = str.charAt(0);
            if ((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '.' || cCharAt == '-' || cCharAt == '+') {
                if (cCharAt == '0' && str.length() > 2 && (str.charAt(1) == 'x' || str.charAt(1) == 'X')) {
                    try {
                        return Integer.valueOf(Integer.parseInt(str.substring(2), 16));
                    } catch (Exception e) {
                    }
                }
                try {
                    if (str.indexOf(46) > -1 || str.indexOf(101) > -1 || str.indexOf(69) > -1) {
                        str = Double.valueOf(str);
                    } else {
                        ?? l = new Long(str);
                        str = l.longValue() == ((long) l.intValue()) ? Integer.valueOf(l.intValue()) : l;
                    }
                    return str;
                } catch (Exception e2) {
                    return str;
                }
            }
            return str;
        }
        return str;
    }

    /* renamed from: a */
    public static void m1050a(Object obj) throws C0312b {
        if (obj != null) {
            if (obj instanceof Double) {
                if (((Double) obj).isInfinite() || ((Double) obj).isNaN()) {
                    throw new C0312b("JSON does not allow non-finite numbers.");
                }
            } else if (obj instanceof Float) {
                if (((Float) obj).isInfinite() || ((Float) obj).isNaN()) {
                    throw new C0312b("JSON does not allow non-finite numbers.");
                }
            }
        }
    }

    public String toString() {
        try {
            Iterator itM1058a = m1058a();
            StringBuilder sb = new StringBuilder("{");
            while (itM1058a.hasNext()) {
                if (sb.length() > 1) {
                    sb.append(',');
                }
                Object next = itM1058a.next();
                sb.append(m1054f(next.toString()));
                sb.append(':');
                sb.append(m1051b(this.f694b.get(next)));
            }
            sb.append('}');
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m1051b(Object obj) {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (obj instanceof Number) {
            return m1049a((Number) obj);
        }
        if ((obj instanceof Boolean) || (obj instanceof C0313c) || (obj instanceof C0311a)) {
            return obj.toString();
        }
        if (obj instanceof Map) {
            return new C0313c((Map) obj).toString();
        }
        if (obj instanceof Collection) {
            return new C0311a((Collection) obj).toString();
        }
        if (obj.getClass().isArray()) {
            return new C0311a(obj).toString();
        }
        return m1054f(obj.toString());
    }

    /* renamed from: c */
    public static Object m1052c(Object obj) {
        try {
            if (obj == null) {
                return f693a;
            }
            if (!(obj instanceof C0313c) && !(obj instanceof C0311a) && !f693a.equals(obj) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Short) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Boolean) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof String)) {
                if (obj instanceof Collection) {
                    return new C0311a((Collection) obj);
                }
                if (obj.getClass().isArray()) {
                    return new C0311a(obj);
                }
                if (obj instanceof Map) {
                    return new C0313c((Map) obj);
                }
                Package r0 = obj.getClass().getPackage();
                String name = r0 != null ? r0.getName() : "";
                if (name.startsWith("java.") || name.startsWith("javax.") || obj.getClass().getClassLoader() == null) {
                    return obj.toString();
                }
                return new C0313c(obj);
            }
            return obj;
        } catch (Exception e) {
            return null;
        }
    }
}
