package p021c.p023b.p024a;

import com.sec.chaton.privateplugin.data.Spam;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: JSONObject.java */
/* renamed from: c.b.a.c */
/* loaded from: classes.dex */
public class C0339c {

    /* renamed from: a */
    public static final Object f777a = new C0341e();

    /* renamed from: b */
    private Map f778b;

    public C0339c() {
        this.f778b = new HashMap();
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
    public C0339c(p021c.p023b.p024a.C0343g r4) {
        /*
            r3 = this;
            r3.<init>()
            char r0 = r4.m1212c()
            r1 = 123(0x7b, float:1.72E-43)
            if (r0 == r1) goto L16
            java.lang.String r0 = "A JSONObject text must begin with '{'"
            c.b.a.b r0 = r4.m1207a(r0)
            throw r0
        L13:
            r4.m1210a()
        L16:
            char r0 = r4.m1212c()
            switch(r0) {
                case 0: goto L51;
                case 125: goto L6d;
                default: goto L1d;
            }
        L1d:
            r4.m1210a()
            java.lang.Object r0 = r4.m1213d()
            java.lang.String r0 = r0.toString()
            char r1 = r4.m1212c()
            r2 = 61
            if (r1 != r2) goto L59
            char r1 = r4.m1211b()
            r2 = 62
            if (r1 == r2) goto L3b
            r4.m1210a()
        L3b:
            java.lang.Object r1 = r4.m1213d()
            r3.m1195b(r0, r1)
            char r0 = r4.m1212c()
            switch(r0) {
                case 44: goto L65;
                case 59: goto L65;
                case 125: goto L6d;
                default: goto L49;
            }
        L49:
            java.lang.String r0 = "Expected a ',' or '}'"
            c.b.a.b r0 = r4.m1207a(r0)
            throw r0
        L51:
            java.lang.String r0 = "A JSONObject text must end with '}'"
            c.b.a.b r0 = r4.m1207a(r0)
            throw r0
        L59:
            r2 = 58
            if (r1 == r2) goto L3b
            java.lang.String r0 = "Expected a ':' after a key"
            c.b.a.b r0 = r4.m1207a(r0)
            throw r0
        L65:
            char r0 = r4.m1212c()
            r1 = 125(0x7d, float:1.75E-43)
            if (r0 != r1) goto L13
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p021c.p023b.p024a.C0339c.<init>(c.b.a.g):void");
    }

    public C0339c(Map map) {
        this.f778b = map == null ? new HashMap() : map;
    }

    public C0339c(String str) {
        this(new C0343g(str));
    }

    /* renamed from: a */
    public Object m1193a(String str) {
        return m1204j(str);
    }

    /* renamed from: b */
    public boolean m1196b(String str) throws C0338b {
        Object objM1193a = m1193a(str);
        if (objM1193a == null) {
            return false;
        }
        if (objM1193a.equals(Boolean.FALSE) || ((objM1193a instanceof String) && ((String) objM1193a).equalsIgnoreCase("false"))) {
            return false;
        }
        if (objM1193a.equals(Boolean.TRUE) || ((objM1193a instanceof String) && ((String) objM1193a).equalsIgnoreCase("true"))) {
            return true;
        }
        throw new C0338b("JSONObject[" + m1190k(str) + "] is not a Boolean.");
    }

    /* renamed from: c */
    public double m1197c(String str) throws C0338b {
        double dDoubleValue;
        Object objM1193a = m1193a(str);
        if (objM1193a == null) {
            return 0.0d;
        }
        try {
            if (objM1193a instanceof Number) {
                dDoubleValue = ((Number) objM1193a).doubleValue();
            } else {
                dDoubleValue = objM1193a.toString().length() > 0 ? Double.valueOf(objM1193a.toString()).doubleValue() : 0.0d;
            }
            return dDoubleValue;
        } catch (Exception e) {
            throw new C0338b("JSONObject[" + m1190k(str) + "] is not a number.");
        }
    }

    /* renamed from: d */
    public int m1198d(String str) {
        Object objM1193a = m1193a(str);
        if (objM1193a == null) {
            return 0;
        }
        return objM1193a instanceof Number ? ((Number) objM1193a).intValue() : (int) m1197c(str);
    }

    /* renamed from: e */
    public C0337a m1199e(String str) throws C0338b {
        Object objM1193a = m1193a(str);
        if (objM1193a == null) {
            return null;
        }
        if (objM1193a instanceof C0337a) {
            return (C0337a) objM1193a;
        }
        throw new C0338b("JSONObject[" + m1190k(str) + "] is not a JSONArray.");
    }

    /* renamed from: f */
    public C0339c m1200f(String str) throws C0338b {
        Object objM1193a = m1193a(str);
        if (objM1193a == null) {
            return null;
        }
        if (objM1193a instanceof C0339c) {
            return (C0339c) objM1193a;
        }
        throw new C0338b("JSONObject[" + m1190k(str) + "] is not a JSONObject.");
    }

    /* renamed from: g */
    public long m1201g(String str) {
        Object objM1193a = m1193a(str);
        if (objM1193a == null) {
            return 0L;
        }
        if (!(objM1193a instanceof String)) {
            return objM1193a instanceof Number ? ((Number) objM1193a).longValue() : (long) m1197c(str);
        }
        if (objM1193a.toString().length() > 0) {
            return Long.valueOf(objM1193a.toString()).longValue();
        }
        return 0L;
    }

    /* renamed from: h */
    public String m1202h(String str) {
        Object objM1193a = m1193a(str);
        return objM1193a == null ? "" : objM1193a.toString();
    }

    /* renamed from: i */
    public boolean m1203i(String str) {
        return f777a.equals(m1204j(str));
    }

    /* renamed from: a */
    public Iterator m1194a() {
        return this.f778b.keySet().iterator();
    }

    /* renamed from: a */
    public static String m1187a(Number number) throws C0338b {
        if (number == null) {
            throw new C0338b("Null pointer");
        }
        m1188a((Object) number);
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

    /* renamed from: j */
    public Object m1204j(String str) {
        if (str == null) {
            return null;
        }
        return this.f778b.get(str);
    }

    /* renamed from: a */
    public C0339c m1192a(String str, Object obj) throws C0338b {
        if (str == null) {
            throw new C0338b("Null key.");
        }
        if (obj != null) {
            m1188a(obj);
            this.f778b.put(str, obj);
        } else {
            m1205l(str);
        }
        return this;
    }

    /* renamed from: b */
    public C0339c m1195b(String str, Object obj) throws C0338b {
        if (str != null && obj != null) {
            if (m1204j(str) != null) {
                throw new C0338b("Duplicate key \"" + str + "\"");
            }
            m1192a(str, obj);
        }
        return this;
    }

    /* renamed from: k */
    public static String m1190k(String str) {
        int i = 0;
        if (str == null || str.length() == 0) {
            return "\"\"";
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length + 4);
        stringBuffer.append('\"');
        char c2 = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            switch (cCharAt) {
                case '\b':
                    stringBuffer.append("\\b");
                    break;
                case '\t':
                    stringBuffer.append("\\t");
                    break;
                case '\n':
                    stringBuffer.append("\\n");
                    break;
                case '\f':
                    stringBuffer.append("\\f");
                    break;
                case '\r':
                    stringBuffer.append("\\r");
                    break;
                case '\"':
                case '\\':
                    stringBuffer.append('\\');
                    stringBuffer.append(cCharAt);
                    break;
                case '/':
                    if (c2 == '<') {
                        stringBuffer.append('\\');
                    }
                    stringBuffer.append(cCharAt);
                    break;
                default:
                    if (cCharAt < ' ' || ((cCharAt >= 128 && cCharAt < 160) || (cCharAt >= 8192 && cCharAt < 8448))) {
                        stringBuffer.append("\\u" + ("000" + Integer.toHexString(cCharAt)).substring(r1.length() - 4));
                        break;
                    } else {
                        stringBuffer.append(cCharAt);
                        break;
                    }
                    break;
            }
            i++;
            c2 = cCharAt;
        }
        stringBuffer.append('\"');
        return stringBuffer.toString();
    }

    /* renamed from: l */
    public Object m1205l(String str) {
        return this.f778b.remove(str);
    }

    /* renamed from: m */
    public static Object m1191m(String str) {
        if (!str.equals("")) {
            if (str.equalsIgnoreCase("true")) {
                return Boolean.TRUE;
            }
            if (str.equalsIgnoreCase("false")) {
                return Boolean.FALSE;
            }
            if (str.equalsIgnoreCase("null")) {
                return f777a;
            }
            char cCharAt = str.charAt(0);
            if ((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '.' || cCharAt == '-' || cCharAt == '+') {
                if (cCharAt == '0') {
                    if (str.length() > 2 && (str.charAt(1) == 'x' || str.charAt(1) == 'X')) {
                        try {
                            return new Integer(Integer.parseInt(str.substring(2), 16));
                        } catch (Exception e) {
                        }
                    } else {
                        try {
                            return new Integer(Integer.parseInt(str, 8));
                        } catch (Exception e2) {
                        }
                    }
                }
                try {
                    return new Integer(str);
                } catch (Exception e3) {
                    try {
                        return new Long(str);
                    } catch (Exception e4) {
                        try {
                            return new Double(str);
                        } catch (Exception e5) {
                            return str;
                        }
                    }
                }
            }
            return str;
        }
        return str;
    }

    /* renamed from: a */
    static void m1188a(Object obj) throws C0338b {
        if (obj != null) {
            if (obj instanceof Double) {
                if (((Double) obj).isInfinite() || ((Double) obj).isNaN()) {
                    throw new C0338b("JSON does not allow non-finite numbers.");
                }
            } else if (obj instanceof Float) {
                if (((Float) obj).isInfinite() || ((Float) obj).isNaN()) {
                    throw new C0338b("JSON does not allow non-finite numbers.");
                }
            }
        }
    }

    public String toString() {
        try {
            Iterator itM1194a = m1194a();
            StringBuffer stringBuffer = new StringBuffer("{");
            while (itM1194a.hasNext()) {
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(',');
                }
                Object next = itM1194a.next();
                stringBuffer.append(m1190k(next.toString()));
                stringBuffer.append(':');
                stringBuffer.append(m1189b(this.f778b.get(next)));
            }
            stringBuffer.append('}');
            return stringBuffer.toString();
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: b */
    static String m1189b(Object obj) throws C0338b {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (obj instanceof InterfaceC0342f) {
            try {
                String strM1206a = ((InterfaceC0342f) obj).m1206a();
                if (strM1206a instanceof String) {
                    return strM1206a;
                }
                throw new C0338b("Bad value from toJSONString: " + ((Object) strM1206a));
            } catch (Exception e) {
                throw new C0338b(e);
            }
        }
        if (obj instanceof Number) {
            return m1187a((Number) obj);
        }
        if ((obj instanceof Boolean) || (obj instanceof C0339c) || (obj instanceof C0337a)) {
            return obj.toString();
        }
        if (obj instanceof Map) {
            return new C0339c((Map) obj).toString();
        }
        if (obj instanceof Collection) {
            return new C0337a((Collection) obj).toString();
        }
        if (obj.getClass().isArray()) {
            return new C0337a(obj).toString();
        }
        return m1190k(obj.toString());
    }
}
