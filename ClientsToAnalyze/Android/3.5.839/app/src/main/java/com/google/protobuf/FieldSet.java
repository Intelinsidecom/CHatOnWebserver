package com.google.protobuf;

import com.google.protobuf.FieldSet.FieldDescriptorLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> {
    private static final FieldSet DEFAULT_INSTANCE = new FieldSet(true);
    private final SmallSortedMap<FieldDescriptorType, Object> fields = SmallSortedMap.newFieldMap(16);
    private boolean isImmutable;

    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        Internal.EnumLiteMap<?> getEnumType();

        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite);

        boolean isPacked();

        boolean isRepeated();
    }

    private FieldSet() {
    }

    private FieldSet(boolean z) {
        makeImmutable();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet<>();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return DEFAULT_INSTANCE;
    }

    public void makeImmutable() {
        if (!this.isImmutable) {
            this.fields.makeImmutable();
            this.isImmutable = true;
        }
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public FieldSet<FieldDescriptorType> m19950clone() {
        FieldSet<FieldDescriptorType> fieldSetNewFieldSet = newFieldSet();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fields.getNumArrayEntries()) {
                break;
            }
            Map.Entry<K, Object> arrayEntryAt = this.fields.getArrayEntryAt(i2);
            fieldSetNewFieldSet.setField((FieldDescriptorLite) arrayEntryAt.getKey(), arrayEntryAt.getValue());
            i = i2 + 1;
        }
        Iterator it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            fieldSetNewFieldSet.setField((FieldDescriptorLite) entry.getKey(), entry.getValue());
        }
        return fieldSetNewFieldSet;
    }

    public void clear() {
        this.fields.clear();
    }

    public Map<FieldDescriptorType, Object> getAllFields() {
        return this.fields.isImmutable() ? this.fields : Collections.unmodifiableMap(this.fields);
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        return this.fields.entrySet().iterator();
    }

    public boolean hasField(FieldDescriptorType fielddescriptortype) {
        if (fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.fields.get(fielddescriptortype) != null;
    }

    public Object getField(FieldDescriptorType fielddescriptortype) {
        return this.fields.get(fielddescriptortype);
    }

    public void setField(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.isRepeated()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                verifyType(fielddescriptortype.getLiteType(), it.next());
            }
            obj = arrayList;
        } else {
            verifyType(fielddescriptortype.getLiteType(), obj);
        }
        this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) obj);
    }

    public void clearField(FieldDescriptorType fielddescriptortype) {
        this.fields.remove(fielddescriptortype);
    }

    public int getRepeatedFieldCount(FieldDescriptorType fielddescriptortype) {
        if (!fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object obj = this.fields.get(fielddescriptortype);
        if (obj == null) {
            return 0;
        }
        return ((List) obj).size();
    }

    public Object getRepeatedField(FieldDescriptorType fielddescriptortype, int i) {
        if (!fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object obj = this.fields.get(fielddescriptortype);
        if (obj == null) {
            throw new IndexOutOfBoundsException();
        }
        return ((List) obj).get(i);
    }

    public void setRepeatedField(FieldDescriptorType fielddescriptortype, int i, Object obj) {
        if (!fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object obj2 = this.fields.get(fielddescriptortype);
        if (obj2 == null) {
            throw new IndexOutOfBoundsException();
        }
        verifyType(fielddescriptortype.getLiteType(), obj);
        ((List) obj2).set(i, obj);
    }

    public void addRepeatedField(FieldDescriptorType fielddescriptortype, Object obj) {
        List arrayList;
        if (!fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        verifyType(fielddescriptortype.getLiteType(), obj);
        Object obj2 = this.fields.get(fielddescriptortype);
        if (obj2 == null) {
            arrayList = new ArrayList();
            this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) arrayList);
        } else {
            arrayList = (List) obj2;
        }
        arrayList.add(obj);
    }

    private static void verifyType(WireFormat.FieldType fieldType, Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        boolean z = false;
        switch (fieldType.getJavaType()) {
            case INT:
                z = obj instanceof Integer;
                break;
            case LONG:
                z = obj instanceof Long;
                break;
            case FLOAT:
                z = obj instanceof Float;
                break;
            case DOUBLE:
                z = obj instanceof Double;
                break;
            case BOOLEAN:
                z = obj instanceof Boolean;
                break;
            case STRING:
                z = obj instanceof String;
                break;
            case BYTE_STRING:
                z = obj instanceof ByteString;
                break;
            case ENUM:
                z = obj instanceof Internal.EnumLite;
                break;
            case MESSAGE:
                z = obj instanceof MessageLite;
                break;
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public boolean isInitialized() {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            if (!isInitialized(this.fields.getArrayEntryAt(i))) {
                return false;
            }
        }
        Iterator it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            if (!isInitialized((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private boolean isInitialized(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            if (key.isRepeated()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((MessageLite) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else if (!((MessageLite) entry.getValue()).isInitialized()) {
                return false;
            }
        }
        return true;
    }

    static int getWireFormatForFieldType(WireFormat.FieldType fieldType, boolean z) {
        if (z) {
            return 2;
        }
        return fieldType.getWireType();
    }

    public void mergeFrom(FieldSet<FieldDescriptorType> fieldSet) {
        for (int i = 0; i < fieldSet.fields.getNumArrayEntries(); i++) {
            mergeFromField(fieldSet.fields.getArrayEntryAt(i));
        }
        Iterator it = fieldSet.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            mergeFromField((Map.Entry) it.next());
        }
    }

    private void mergeFromField(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.isRepeated()) {
            Object obj = this.fields.get(key);
            if (obj == null) {
                this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) key, (FieldDescriptorType) new ArrayList((List) value));
                return;
            } else {
                ((List) obj).addAll((List) value);
                return;
            }
        }
        if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            Object obj2 = this.fields.get(key);
            if (obj2 == null) {
                this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) key, (FieldDescriptorType) value);
                return;
            } else {
                this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) key, (FieldDescriptorType) key.internalMergeFrom(((MessageLite) obj2).toBuilder(), (MessageLite) value).build());
                return;
            }
        }
        this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) key, (FieldDescriptorType) value);
    }

    /* renamed from: com.google.protobuf.FieldSet$1 */
    /* synthetic */ class C06951 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[WireFormat.FieldType.values().length];

        static {
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = new int[WireFormat.JavaType.values().length];
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError e20) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError e21) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError e22) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError e23) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError e24) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError e25) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError e26) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError e27) {
            }
        }
    }

    public static Object readPrimitiveField(CodedInputStream codedInputStream, WireFormat.FieldType fieldType) {
        switch (C06951.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                return Double.valueOf(codedInputStream.readDouble());
            case 2:
                return Float.valueOf(codedInputStream.readFloat());
            case 3:
                return Long.valueOf(codedInputStream.readInt64());
            case 4:
                return Long.valueOf(codedInputStream.readUInt64());
            case 5:
                return Integer.valueOf(codedInputStream.readInt32());
            case 6:
                return Long.valueOf(codedInputStream.readFixed64());
            case 7:
                return Integer.valueOf(codedInputStream.readFixed32());
            case 8:
                return Boolean.valueOf(codedInputStream.readBool());
            case 9:
                return codedInputStream.readString();
            case 10:
                return codedInputStream.readBytes();
            case 11:
                return Integer.valueOf(codedInputStream.readUInt32());
            case 12:
                return Integer.valueOf(codedInputStream.readSFixed32());
            case 13:
                return Long.valueOf(codedInputStream.readSFixed64());
            case 14:
                return Integer.valueOf(codedInputStream.readSInt32());
            case 15:
                return Long.valueOf(codedInputStream.readSInt64());
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fields.getNumArrayEntries()) {
                break;
            }
            Map.Entry<K, Object> arrayEntryAt = this.fields.getArrayEntryAt(i2);
            writeField((FieldDescriptorLite) arrayEntryAt.getKey(), arrayEntryAt.getValue(), codedOutputStream);
            i = i2 + 1;
        }
        Iterator it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            writeField((FieldDescriptorLite) entry.getKey(), entry.getValue(), codedOutputStream);
        }
    }

    public void writeMessageSetTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            writeMessageSetTo(this.fields.getArrayEntryAt(i), codedOutputStream);
        }
        Iterator it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            writeMessageSetTo((Map.Entry) it.next(), codedOutputStream);
        }
    }

    private void writeMessageSetTo(Map.Entry<FieldDescriptorType, Object> entry, CodedOutputStream codedOutputStream) throws IOException {
        FieldDescriptorType key = entry.getKey();
        if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !key.isRepeated() && !key.isPacked()) {
            codedOutputStream.writeMessageSetExtension(entry.getKey().getNumber(), (MessageLite) entry.getValue());
        } else {
            writeField(key, entry.getValue(), codedOutputStream);
        }
    }

    private static void writeElement(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.writeGroup(i, (MessageLite) obj);
        } else {
            codedOutputStream.writeTag(i, getWireFormatForFieldType(fieldType, false));
            writeElementNoTag(codedOutputStream, fieldType, obj);
        }
    }

    private static void writeElementNoTag(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (C06951.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.writeDoubleNoTag(((Double) obj).doubleValue());
                break;
            case 2:
                codedOutputStream.writeFloatNoTag(((Float) obj).floatValue());
                break;
            case 3:
                codedOutputStream.writeInt64NoTag(((Long) obj).longValue());
                break;
            case 4:
                codedOutputStream.writeUInt64NoTag(((Long) obj).longValue());
                break;
            case 5:
                codedOutputStream.writeInt32NoTag(((Integer) obj).intValue());
                break;
            case 6:
                codedOutputStream.writeFixed64NoTag(((Long) obj).longValue());
                break;
            case 7:
                codedOutputStream.writeFixed32NoTag(((Integer) obj).intValue());
                break;
            case 8:
                codedOutputStream.writeBoolNoTag(((Boolean) obj).booleanValue());
                break;
            case 9:
                codedOutputStream.writeStringNoTag((String) obj);
                break;
            case 10:
                codedOutputStream.writeBytesNoTag((ByteString) obj);
                break;
            case 11:
                codedOutputStream.writeUInt32NoTag(((Integer) obj).intValue());
                break;
            case 12:
                codedOutputStream.writeSFixed32NoTag(((Integer) obj).intValue());
                break;
            case 13:
                codedOutputStream.writeSFixed64NoTag(((Long) obj).longValue());
                break;
            case 14:
                codedOutputStream.writeSInt32NoTag(((Integer) obj).intValue());
                break;
            case 15:
                codedOutputStream.writeSInt64NoTag(((Long) obj).longValue());
                break;
            case 16:
                codedOutputStream.writeGroupNoTag((MessageLite) obj);
                break;
            case 17:
                codedOutputStream.writeMessageNoTag((MessageLite) obj);
                break;
            case 18:
                codedOutputStream.writeEnumNoTag(((Internal.EnumLite) obj).getNumber());
                break;
        }
    }

    public static void writeField(FieldDescriptorLite<?> fieldDescriptorLite, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (fieldDescriptorLite.isRepeated()) {
            List list = (List) obj;
            if (fieldDescriptorLite.isPacked()) {
                codedOutputStream.writeTag(number, 2);
                int iComputeElementSizeNoTag = 0;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    iComputeElementSizeNoTag += computeElementSizeNoTag(liteType, it.next());
                }
                codedOutputStream.writeRawVarint32(iComputeElementSizeNoTag);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    writeElementNoTag(codedOutputStream, liteType, it2.next());
                }
                return;
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                writeElement(codedOutputStream, liteType, number, it3.next());
            }
            return;
        }
        writeElement(codedOutputStream, liteType, number, obj);
    }

    public int getSerializedSize() {
        int iComputeFieldSize = 0;
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            Map.Entry<K, Object> arrayEntryAt = this.fields.getArrayEntryAt(i);
            iComputeFieldSize += computeFieldSize((FieldDescriptorLite) arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        Iterator it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iComputeFieldSize += computeFieldSize((FieldDescriptorLite) entry.getKey(), entry.getValue());
        }
        return iComputeFieldSize;
    }

    public int getMessageSetSerializedSize() {
        int messageSetSerializedSize = 0;
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            messageSetSerializedSize += getMessageSetSerializedSize(this.fields.getArrayEntryAt(i));
        }
        Iterator it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            messageSetSerializedSize += getMessageSetSerializedSize((Map.Entry) it.next());
        }
        return messageSetSerializedSize;
    }

    private int getMessageSetSerializedSize(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        return (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.isRepeated() || key.isPacked()) ? computeFieldSize(key, entry.getValue()) : CodedOutputStream.computeMessageSetExtensionSize(entry.getKey().getNumber(), (MessageLite) entry.getValue());
    }

    private static int computeElementSize(WireFormat.FieldType fieldType, int i, Object obj) {
        int iComputeTagSize = CodedOutputStream.computeTagSize(i);
        if (fieldType == WireFormat.FieldType.GROUP) {
            iComputeTagSize *= 2;
        }
        return iComputeTagSize + computeElementSizeNoTag(fieldType, obj);
    }

    private static int computeElementSizeNoTag(WireFormat.FieldType fieldType, Object obj) {
        switch (C06951.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.computeDoubleSizeNoTag(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.computeFloatSizeNoTag(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.computeInt64SizeNoTag(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.computeFixed64SizeNoTag(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.computeFixed32SizeNoTag(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.computeBoolSizeNoTag(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.computeStringSizeNoTag((String) obj);
            case 10:
                return CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
            case 11:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) obj).intValue());
            case 12:
                return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) obj).intValue());
            case 13:
                return CodedOutputStream.computeSFixed64SizeNoTag(((Long) obj).longValue());
            case 14:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite) obj);
            case 17:
                return CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            case 18:
                return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) obj).getNumber());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int computeFieldSize(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        int iComputeElementSize = 0;
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (fieldDescriptorLite.isRepeated()) {
            if (fieldDescriptorLite.isPacked()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    iComputeElementSize += computeElementSizeNoTag(liteType, it.next());
                }
                return CodedOutputStream.computeRawVarint32Size(iComputeElementSize) + CodedOutputStream.computeTagSize(number) + iComputeElementSize;
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                iComputeElementSize += computeElementSize(liteType, number, it2.next());
            }
            return iComputeElementSize;
        }
        return computeElementSize(liteType, number, obj);
    }
}
