package com.google.protobuf;

/* loaded from: classes.dex */
public final class WireFormat {

    /* renamed from: a */
    static final int f242a = m352a(1, 3);

    /* renamed from: b */
    static final int f243b = m352a(1, 4);

    /* renamed from: c */
    static final int f244c = m352a(2, 0);

    /* renamed from: d */
    static final int f245d = m352a(3, 2);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public class FieldType {

        /* renamed from: a */
        public static final FieldType f246a = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);

        /* renamed from: b */
        public static final FieldType f247b = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);

        /* renamed from: c */
        public static final FieldType f248c = new FieldType("INT64", 2, JavaType.LONG, 0);

        /* renamed from: d */
        public static final FieldType f249d = new FieldType("UINT64", 3, JavaType.LONG, 0);

        /* renamed from: e */
        public static final FieldType f250e = new FieldType("INT32", 4, JavaType.INT, 0);

        /* renamed from: f */
        public static final FieldType f251f = new FieldType("FIXED64", 5, JavaType.LONG, 1);

        /* renamed from: g */
        public static final FieldType f252g = new FieldType("FIXED32", 6, JavaType.INT, 5);

        /* renamed from: h */
        public static final FieldType f253h = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);

        /* renamed from: i */
        public static final FieldType f254i = new C0056d("STRING", 8, JavaType.STRING, 2);

        /* renamed from: j */
        public static final FieldType f255j = new C0054b("GROUP", 9, JavaType.MESSAGE, 3);

        /* renamed from: k */
        public static final FieldType f256k = new C0055c("MESSAGE", 10, JavaType.MESSAGE, 2);

        /* renamed from: l */
        public static final FieldType f257l = new C0057e("BYTES", 11, JavaType.BYTE_STRING, 2);

        /* renamed from: m */
        public static final FieldType f258m = new FieldType("UINT32", 12, JavaType.INT, 0);

        /* renamed from: n */
        public static final FieldType f259n = new FieldType("ENUM", 13, JavaType.ENUM, 0);

        /* renamed from: o */
        public static final FieldType f260o = new FieldType("SFIXED32", 14, JavaType.INT, 5);

        /* renamed from: p */
        public static final FieldType f261p = new FieldType("SFIXED64", 15, JavaType.LONG, 1);

        /* renamed from: q */
        public static final FieldType f262q = new FieldType("SINT32", 16, JavaType.INT, 0);

        /* renamed from: r */
        public static final FieldType f263r = new FieldType("SINT64", 17, JavaType.LONG, 0);

        /* renamed from: u */
        private static final /* synthetic */ FieldType[] f264u = {f246a, f247b, f248c, f249d, f250e, f251f, f252g, f253h, f254i, f255j, f256k, f257l, f258m, f259n, f260o, f261p, f262q, f263r};

        /* renamed from: s */
        private final JavaType f265s;

        /* renamed from: t */
        private final int f266t;

        private FieldType(String str, int i, JavaType javaType, int i2) {
            this.f265s = javaType;
            this.f266t = i2;
        }

        public static FieldType valueOf(String str) {
            return (FieldType) Enum.valueOf(FieldType.class, str);
        }

        public static FieldType[] values() {
            return (FieldType[]) f264u.clone();
        }
    }

    public enum JavaType {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(false),
        STRING(""),
        BYTE_STRING(ByteString.f218a),
        ENUM(null),
        MESSAGE(null);


        /* renamed from: j */
        private final Object f277j;

        JavaType(Object obj) {
            this.f277j = obj;
        }
    }

    private WireFormat() {
    }

    /* renamed from: a */
    static int m351a(int i) {
        return i & 7;
    }

    /* renamed from: a */
    static int m352a(int i, int i2) {
        return (i << 3) | i2;
    }

    /* renamed from: b */
    public static int m353b(int i) {
        return i >>> 3;
    }
}
