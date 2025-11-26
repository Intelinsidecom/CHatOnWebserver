package com.google.protobuf;

import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
public final class WireFormat {
    static final int MESSAGE_SET_ITEM = 1;
    static final int MESSAGE_SET_MESSAGE = 3;
    static final int MESSAGE_SET_TYPE_ID = 2;
    static final int TAG_TYPE_BITS = 3;
    static final int TAG_TYPE_MASK = 7;
    public static final int WIRETYPE_END_GROUP = 4;
    public static final int WIRETYPE_FIXED32 = 5;
    public static final int WIRETYPE_FIXED64 = 1;
    public static final int WIRETYPE_LENGTH_DELIMITED = 2;
    public static final int WIRETYPE_START_GROUP = 3;
    public static final int WIRETYPE_VARINT = 0;
    static final int MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
    static final int MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
    static final int MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
    static final int MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);

    private WireFormat() {
    }

    static int getTagWireType(int tag) {
        return tag & 7;
    }

    public static int getTagFieldNumber(int tag) {
        return tag >>> 3;
    }

    static int makeTag(int fieldNumber, int wireType) {
        return (fieldNumber << 3) | wireType;
    }

    public enum JavaType {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(false),
        STRING(""),
        BYTE_STRING(ByteString.EMPTY),
        ENUM(null),
        MESSAGE(null);

        private final Object defaultDefault;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static JavaType[] valuesCustom() {
            JavaType[] javaTypeArrValuesCustom = values();
            int length = javaTypeArrValuesCustom.length;
            JavaType[] javaTypeArr = new JavaType[length];
            System.arraycopy(javaTypeArrValuesCustom, 0, javaTypeArr, 0, length);
            return javaTypeArr;
        }

        JavaType(Object defaultDefault) {
            this.defaultDefault = defaultDefault;
        }

        Object getDefaultDefault() {
            return this.defaultDefault;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'STRING' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static class FieldType {
        public static final FieldType BYTES;
        private static final /* synthetic */ FieldType[] ENUM$VALUES;
        public static final FieldType MESSAGE;
        public static final FieldType STRING;
        private final JavaType javaType;
        private final int wireType;
        public static final FieldType DOUBLE = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);
        public static final FieldType FLOAT = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);
        public static final FieldType INT64 = new FieldType("INT64", 2, JavaType.LONG, 0);
        public static final FieldType UINT64 = new FieldType("UINT64", 3, JavaType.LONG, 0);
        public static final FieldType INT32 = new FieldType("INT32", 4, JavaType.INT, 0);
        public static final FieldType FIXED64 = new FieldType("FIXED64", 5, JavaType.LONG, 1);
        public static final FieldType FIXED32 = new FieldType("FIXED32", 6, JavaType.INT, 5);
        public static final FieldType BOOL = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
        public static final FieldType GROUP = new FieldType("GROUP", 9, JavaType.MESSAGE, 3) { // from class: com.google.protobuf.WireFormat.FieldType.2
            {
                FieldType fieldType = null;
            }

            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        };
        public static final FieldType UINT32 = new FieldType("UINT32", 12, JavaType.INT, 0);
        public static final FieldType ENUM = new FieldType("ENUM", 13, JavaType.ENUM, 0);
        public static final FieldType SFIXED32 = new FieldType("SFIXED32", 14, JavaType.INT, 5);
        public static final FieldType SFIXED64 = new FieldType("SFIXED64", 15, JavaType.LONG, 1);
        public static final FieldType SINT32 = new FieldType("SINT32", 16, JavaType.INT, 0);
        public static final FieldType SINT64 = new FieldType("SINT64", 17, JavaType.LONG, 0);

        public static FieldType valueOf(String str) {
            return (FieldType) Enum.valueOf(FieldType.class, str);
        }

        public static FieldType[] values() {
            FieldType[] fieldTypeArr = ENUM$VALUES;
            int length = fieldTypeArr.length;
            FieldType[] fieldTypeArr2 = new FieldType[length];
            System.arraycopy(fieldTypeArr, 0, fieldTypeArr2, 0, length);
            return fieldTypeArr2;
        }

        static {
            int i = 2;
            STRING = new FieldType("STRING", 8, JavaType.STRING, i) { // from class: com.google.protobuf.WireFormat.FieldType.1
                {
                    FieldType fieldType = null;
                }

                @Override // com.google.protobuf.WireFormat.FieldType
                public boolean isPackable() {
                    return false;
                }
            };
            MESSAGE = new FieldType("MESSAGE", 10, JavaType.MESSAGE, i) { // from class: com.google.protobuf.WireFormat.FieldType.3
                {
                    FieldType fieldType = null;
                }

                @Override // com.google.protobuf.WireFormat.FieldType
                public boolean isPackable() {
                    return false;
                }
            };
            BYTES = new FieldType("BYTES", 11, JavaType.BYTE_STRING, i) { // from class: com.google.protobuf.WireFormat.FieldType.4
                {
                    FieldType fieldType = null;
                }

                @Override // com.google.protobuf.WireFormat.FieldType
                public boolean isPackable() {
                    return false;
                }
            };
            ENUM$VALUES = new FieldType[]{DOUBLE, FLOAT, INT64, UINT64, INT32, FIXED64, FIXED32, BOOL, STRING, GROUP, MESSAGE, BYTES, UINT32, ENUM, SFIXED32, SFIXED64, SINT32, SINT64};
        }

        private FieldType(String str, int i, JavaType javaType, int wireType) {
            this.javaType = javaType;
            this.wireType = wireType;
        }

        /* synthetic */ FieldType(String str, int i, JavaType javaType, int i2, FieldType fieldType) {
            this(str, i, javaType, i2);
        }

        public JavaType getJavaType() {
            return this.javaType;
        }

        public int getWireType() {
            return this.wireType;
        }

        public boolean isPackable() {
            return true;
        }
    }
}
