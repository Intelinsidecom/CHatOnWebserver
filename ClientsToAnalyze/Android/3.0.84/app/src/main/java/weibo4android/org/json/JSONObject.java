package weibo4android.org.json;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/* loaded from: classes.dex */
public class JSONObject {
    public static final Object NULL = new Null();
    private Map map;

    final class Null {
        private Null() {
        }

        protected final Object clone() {
            return this;
        }

        public boolean equals(Object obj) {
            return obj == null || obj == this;
        }

        public String toString() {
            return "null";
        }
    }

    public JSONObject() {
        this.map = new HashMap();
    }

    public JSONObject(JSONObject jSONObject, String[] strArr) throws JSONException {
        this();
        for (int i = 0; i < strArr.length; i++) {
            putOnce(strArr[i], jSONObject.opt(strArr[i]));
        }
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
    public JSONObject(weibo4android.org.json.JSONTokener r4) {
        /*
            r3 = this;
            r3.<init>()
            char r0 = r4.nextClean()
            r1 = 123(0x7b, float:1.72E-43)
            if (r0 == r1) goto L15
            java.lang.String r0 = "A JSONObject text must begin with '{'"
            weibo4android.org.json.JSONException r0 = r4.syntaxError(r0)
            throw r0
        L12:
            r4.back()
        L15:
            char r0 = r4.nextClean()
            switch(r0) {
                case 0: goto L4f;
                case 125: goto L69;
                default: goto L1c;
            }
        L1c:
            r4.back()
            java.lang.Object r0 = r4.nextValue()
            java.lang.String r0 = r0.toString()
            char r1 = r4.nextClean()
            r2 = 61
            if (r1 != r2) goto L56
            char r1 = r4.next()
            r2 = 62
            if (r1 == r2) goto L3a
            r4.back()
        L3a:
            java.lang.Object r1 = r4.nextValue()
            r3.putOnce(r0, r1)
            char r0 = r4.nextClean()
            switch(r0) {
                case 44: goto L61;
                case 59: goto L61;
                case 125: goto L69;
                default: goto L48;
            }
        L48:
            java.lang.String r0 = "Expected a ',' or '}'"
            weibo4android.org.json.JSONException r0 = r4.syntaxError(r0)
            throw r0
        L4f:
            java.lang.String r0 = "A JSONObject text must end with '}'"
            weibo4android.org.json.JSONException r0 = r4.syntaxError(r0)
            throw r0
        L56:
            r2 = 58
            if (r1 == r2) goto L3a
            java.lang.String r0 = "Expected a ':' after a key"
            weibo4android.org.json.JSONException r0 = r4.syntaxError(r0)
            throw r0
        L61:
            char r0 = r4.nextClean()
            r1 = 125(0x7d, float:1.75E-43)
            if (r0 != r1) goto L12
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: weibo4android.org.json.JSONObject.<init>(weibo4android.org.json.JSONTokener):void");
    }

    public JSONObject(Map map) {
        this.map = map == null ? new HashMap() : map;
    }

    public JSONObject(Map map, boolean z) {
        this.map = new HashMap();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                this.map.put(entry.getKey(), new JSONObject(entry.getValue(), z));
            }
        }
    }

    public JSONObject(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this();
        populateInternalMap(obj, false);
    }

    public JSONObject(Object obj, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this();
        populateInternalMap(obj, z);
    }

    private void populateInternalMap(Object obj, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String lowerCase;
        Class<?> cls = obj.getClass();
        if (cls.getClassLoader() == null) {
            z = false;
        }
        for (Method method : z ? cls.getMethods() : cls.getDeclaredMethods()) {
            try {
                String name = method.getName();
                String strSubstring = "";
                if (name.startsWith("get")) {
                    strSubstring = name.substring(3);
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
                    if (objInvoke == null) {
                        this.map.put(lowerCase, NULL);
                    } else if (objInvoke.getClass().isArray()) {
                        this.map.put(lowerCase, new JSONArray(objInvoke, z));
                    } else if (objInvoke instanceof Collection) {
                        this.map.put(lowerCase, new JSONArray((Collection) objInvoke, z));
                    } else if (objInvoke instanceof Map) {
                        this.map.put(lowerCase, new JSONObject((Map) objInvoke, z));
                    } else if (isStandardProperty(objInvoke.getClass())) {
                        this.map.put(lowerCase, objInvoke);
                    } else if (objInvoke.getClass().getPackage().getName().startsWith("java") || objInvoke.getClass().getClassLoader() == null) {
                        this.map.put(lowerCase, objInvoke.toString());
                    } else {
                        this.map.put(lowerCase, new JSONObject(objInvoke, z));
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean isStandardProperty(Class cls) {
        return cls.isPrimitive() || cls.isAssignableFrom(Byte.class) || cls.isAssignableFrom(Short.class) || cls.isAssignableFrom(Integer.class) || cls.isAssignableFrom(Long.class) || cls.isAssignableFrom(Float.class) || cls.isAssignableFrom(Double.class) || cls.isAssignableFrom(Character.class) || cls.isAssignableFrom(String.class) || cls.isAssignableFrom(Boolean.class);
    }

    public JSONObject(Object obj, String[] strArr) {
        this();
        Class<?> cls = obj.getClass();
        for (String str : strArr) {
            try {
                putOpt(str, cls.getField(str).get(obj));
            } catch (Exception e) {
            }
        }
    }

    public JSONObject(String str) {
        this(new JSONTokener(str));
    }

    public JSONObject accumulate(String str, Object obj) throws JSONException {
        testValidity(obj);
        Object objOpt = opt(str);
        if (objOpt == null) {
            if (obj instanceof JSONArray) {
                obj = new JSONArray().put(obj);
            }
            put(str, obj);
        } else if (objOpt instanceof JSONArray) {
            ((JSONArray) objOpt).put(obj);
        } else {
            put(str, new JSONArray().put(objOpt).put(obj));
        }
        return this;
    }

    public JSONObject append(String str, Object obj) throws JSONException {
        testValidity(obj);
        Object objOpt = opt(str);
        if (objOpt == null) {
            put(str, new JSONArray().put(obj));
        } else if (objOpt instanceof JSONArray) {
            put(str, ((JSONArray) objOpt).put(obj));
        } else {
            throw new JSONException("JSONObject[" + str + "] is not a JSONArray.");
        }
        return this;
    }

    public static String doubleToString(double d) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            return "null";
        }
        String string = Double.toString(d);
        if (string.indexOf(46) > 0 && string.indexOf(101) < 0 && string.indexOf(69) < 0) {
            while (string.endsWith("0")) {
                string = string.substring(0, string.length() - 1);
            }
            if (string.endsWith(".")) {
                return string.substring(0, string.length() - 1);
            }
            return string;
        }
        return string;
    }

    public Object get(String str) {
        return opt(str);
    }

    public boolean getBoolean(String str) throws JSONException {
        Object obj = get(str);
        if (obj == null) {
            return false;
        }
        if (obj.equals(Boolean.FALSE) || ((obj instanceof String) && ((String) obj).equalsIgnoreCase("false"))) {
            return false;
        }
        if (obj.equals(Boolean.TRUE) || ((obj instanceof String) && ((String) obj).equalsIgnoreCase("true"))) {
            return true;
        }
        throw new JSONException("JSONObject[" + quote(str) + "] is not a Boolean.");
    }

    public double getDouble(String str) throws JSONException {
        double dDoubleValue;
        Object obj = get(str);
        if (obj == null) {
            return 0.0d;
        }
        try {
            if (obj instanceof Number) {
                dDoubleValue = ((Number) obj).doubleValue();
            } else {
                dDoubleValue = obj.toString().length() > 0 ? Double.valueOf(obj.toString()).doubleValue() : 0.0d;
            }
            return dDoubleValue;
        } catch (Exception e) {
            throw new JSONException("JSONObject[" + quote(str) + "] is not a number.");
        }
    }

    public int getInt(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0;
        }
        return obj instanceof Number ? ((Number) obj).intValue() : (int) getDouble(str);
    }

    public JSONArray getJSONArray(String str) throws JSONException {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        throw new JSONException("JSONObject[" + quote(str) + "] is not a JSONArray.");
    }

    public JSONObject getJSONObject(String str) throws JSONException {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        throw new JSONException("JSONObject[" + quote(str) + "] is not a JSONObject.");
    }

    public long getLong(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0L;
        }
        if (!(obj instanceof String)) {
            return obj instanceof Number ? ((Number) obj).longValue() : (long) getDouble(str);
        }
        if (obj.toString().length() > 0) {
            return Long.valueOf(obj.toString()).longValue();
        }
        return 0L;
    }

    public static String[] getNames(JSONObject jSONObject) {
        int length = jSONObject.length();
        if (length == 0) {
            return null;
        }
        Iterator itKeys = jSONObject.keys();
        String[] strArr = new String[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (!itKeys.hasNext()) {
                return strArr;
            }
            strArr[i2] = (String) itKeys.next();
            i = i2 + 1;
        }
    }

    public static String[] getNames(Object obj) {
        Field[] fields;
        int length;
        String[] strArr = null;
        if (obj != null && (length = (fields = obj.getClass().getFields()).length) != 0) {
            strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = fields[i].getName();
            }
        }
        return strArr;
    }

    public String getString(String str) {
        Object obj = get(str);
        return obj == null ? "" : obj.toString();
    }

    public boolean has(String str) {
        return this.map.containsKey(str);
    }

    public boolean isNull(String str) {
        return NULL.equals(opt(str));
    }

    public Iterator keys() {
        return this.map.keySet().iterator();
    }

    public int length() {
        return this.map.size();
    }

    public JSONArray names() {
        JSONArray jSONArray = new JSONArray();
        Iterator itKeys = keys();
        while (itKeys.hasNext()) {
            jSONArray.put(itKeys.next());
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return jSONArray;
    }

    public static String numberToString(Number number) throws JSONException {
        if (number == null) {
            throw new JSONException("Null pointer");
        }
        testValidity(number);
        String string = number.toString();
        if (string.indexOf(46) > 0 && string.indexOf(101) < 0 && string.indexOf(69) < 0) {
            while (string.endsWith("0")) {
                string = string.substring(0, string.length() - 1);
            }
            if (string.endsWith(".")) {
                return string.substring(0, string.length() - 1);
            }
            return string;
        }
        return string;
    }

    public Object opt(String str) {
        if (str == null) {
            return null;
        }
        return this.map.get(str);
    }

    public boolean optBoolean(String str) {
        return optBoolean(str, false);
    }

    public boolean optBoolean(String str, boolean z) {
        try {
            return getBoolean(str);
        } catch (Exception e) {
            return z;
        }
    }

    public JSONObject put(String str, Collection collection) throws JSONException {
        put(str, new JSONArray(collection));
        return this;
    }

    public double optDouble(String str) {
        return optDouble(str, Double.NaN);
    }

    public double optDouble(String str, double d) {
        try {
            Object objOpt = opt(str);
            return objOpt instanceof Number ? ((Number) objOpt).doubleValue() : new Double((String) objOpt).doubleValue();
        } catch (Exception e) {
            return d;
        }
    }

    public int optInt(String str) {
        return optInt(str, 0);
    }

    public int optInt(String str, int i) {
        try {
            return getInt(str);
        } catch (Exception e) {
            return i;
        }
    }

    public JSONArray optJSONArray(String str) {
        Object objOpt = opt(str);
        if (objOpt instanceof JSONArray) {
            return (JSONArray) objOpt;
        }
        return null;
    }

    public JSONObject optJSONObject(String str) {
        Object objOpt = opt(str);
        if (objOpt instanceof JSONObject) {
            return (JSONObject) objOpt;
        }
        return null;
    }

    public long optLong(String str) {
        return optLong(str, 0L);
    }

    public long optLong(String str, long j) {
        try {
            return getLong(str);
        } catch (Exception e) {
            return j;
        }
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public String optString(String str, String str2) {
        Object objOpt = opt(str);
        return objOpt != null ? objOpt.toString() : str2;
    }

    public JSONObject put(String str, boolean z) throws JSONException {
        put(str, z ? Boolean.TRUE : Boolean.FALSE);
        return this;
    }

    public JSONObject put(String str, double d) throws JSONException {
        put(str, new Double(d));
        return this;
    }

    public JSONObject put(String str, int i) throws JSONException {
        put(str, new Integer(i));
        return this;
    }

    public JSONObject put(String str, long j) throws JSONException {
        put(str, new Long(j));
        return this;
    }

    public JSONObject put(String str, Map map) throws JSONException {
        put(str, new JSONObject(map));
        return this;
    }

    public JSONObject put(String str, Object obj) throws JSONException {
        if (str == null) {
            throw new JSONException("Null key.");
        }
        if (obj != null) {
            testValidity(obj);
            this.map.put(str, obj);
        } else {
            remove(str);
        }
        return this;
    }

    public JSONObject putOnce(String str, Object obj) throws JSONException {
        if (str != null && obj != null) {
            if (opt(str) != null) {
                throw new JSONException("Duplicate key \"" + str + "\"");
            }
            put(str, obj);
        }
        return this;
    }

    public JSONObject putOpt(String str, Object obj) throws JSONException {
        if (str != null && obj != null) {
            put(str, obj);
        }
        return this;
    }

    public static String quote(String str) {
        int i = 0;
        if (str == null || str.length() == 0) {
            return "\"\"";
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length + 4);
        stringBuffer.append('\"');
        char c = 0;
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
                    if (c == '<') {
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
            c = cCharAt;
        }
        stringBuffer.append('\"');
        return stringBuffer.toString();
    }

    public Object remove(String str) {
        return this.map.remove(str);
    }

    public Iterator sortedKeys() {
        return new TreeSet(this.map.keySet()).iterator();
    }

    public static Object stringToValue(String str) {
        if (!str.equals("")) {
            if (str.equalsIgnoreCase("true")) {
                return Boolean.TRUE;
            }
            if (str.equalsIgnoreCase("false")) {
                return Boolean.FALSE;
            }
            if (str.equalsIgnoreCase("null")) {
                return NULL;
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

    static void testValidity(Object obj) throws JSONException {
        if (obj != null) {
            if (obj instanceof Double) {
                if (((Double) obj).isInfinite() || ((Double) obj).isNaN()) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
            } else if (obj instanceof Float) {
                if (((Float) obj).isInfinite() || ((Float) obj).isNaN()) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
            }
        }
    }

    public JSONArray toJSONArray(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            jSONArray2.put(opt(jSONArray.getString(i)));
        }
        return jSONArray2;
    }

    public String toString() {
        try {
            Iterator itKeys = keys();
            StringBuffer stringBuffer = new StringBuffer("{");
            while (itKeys.hasNext()) {
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(',');
                }
                Object next = itKeys.next();
                stringBuffer.append(quote(next.toString()));
                stringBuffer.append(':');
                stringBuffer.append(valueToString(this.map.get(next)));
            }
            stringBuffer.append('}');
            return stringBuffer.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public String toString(int i) {
        return toString(i, 0);
    }

    String toString(int i, int i2) {
        int length = length();
        if (length == 0) {
            return "{}";
        }
        Iterator itSortedKeys = sortedKeys();
        StringBuffer stringBuffer = new StringBuffer("{");
        int i3 = i2 + i;
        if (length == 1) {
            Object next = itSortedKeys.next();
            stringBuffer.append(quote(next.toString()));
            stringBuffer.append(": ");
            stringBuffer.append(valueToString(this.map.get(next), i, i2));
        } else {
            while (itSortedKeys.hasNext()) {
                Object next2 = itSortedKeys.next();
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(",\n");
                } else {
                    stringBuffer.append('\n');
                }
                for (int i4 = 0; i4 < i3; i4++) {
                    stringBuffer.append(' ');
                }
                stringBuffer.append(quote(next2.toString()));
                stringBuffer.append(": ");
                stringBuffer.append(valueToString(this.map.get(next2), i, i3));
            }
            if (stringBuffer.length() > 1) {
                stringBuffer.append('\n');
                for (int i5 = 0; i5 < i2; i5++) {
                    stringBuffer.append(' ');
                }
            }
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    static String valueToString(Object obj) throws JSONException {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (obj instanceof JSONString) {
            try {
                String jSONString = ((JSONString) obj).toJSONString();
                if (jSONString instanceof String) {
                    return jSONString;
                }
                throw new JSONException("Bad value from toJSONString: " + ((Object) jSONString));
            } catch (Exception e) {
                throw new JSONException(e);
            }
        }
        if (obj instanceof Number) {
            return numberToString((Number) obj);
        }
        if ((obj instanceof Boolean) || (obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            return obj.toString();
        }
        if (obj instanceof Map) {
            return new JSONObject((Map) obj).toString();
        }
        if (obj instanceof Collection) {
            return new JSONArray((Collection) obj).toString();
        }
        if (obj.getClass().isArray()) {
            return new JSONArray(obj).toString();
        }
        return quote(obj.toString());
    }

    static String valueToString(Object obj, int i, int i2) {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        try {
            if (obj instanceof JSONString) {
                String jSONString = ((JSONString) obj).toJSONString();
                if (jSONString instanceof String) {
                    return jSONString;
                }
            }
        } catch (Exception e) {
        }
        if (obj instanceof Number) {
            return numberToString((Number) obj);
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).toString(i, i2);
        }
        if (obj instanceof JSONArray) {
            return ((JSONArray) obj).toString(i, i2);
        }
        if (obj instanceof Map) {
            return new JSONObject((Map) obj).toString(i, i2);
        }
        if (obj instanceof Collection) {
            return new JSONArray((Collection) obj).toString(i, i2);
        }
        if (obj.getClass().isArray()) {
            return new JSONArray(obj).toString(i, i2);
        }
        return quote(obj.toString());
    }

    public Writer write(Writer writer) throws JSONException, IOException {
        boolean z = false;
        try {
            Iterator itKeys = keys();
            writer.write(123);
            while (itKeys.hasNext()) {
                if (z) {
                    writer.write(44);
                }
                Object next = itKeys.next();
                writer.write(quote(next.toString()));
                writer.write(58);
                Object obj = this.map.get(next);
                if (obj instanceof JSONObject) {
                    ((JSONObject) obj).write(writer);
                } else if (obj instanceof JSONArray) {
                    ((JSONArray) obj).write(writer);
                } else {
                    writer.write(valueToString(obj));
                }
                z = true;
            }
            writer.write(125);
            return writer;
        } catch (IOException e) {
            throw new JSONException(e);
        }
    }
}
