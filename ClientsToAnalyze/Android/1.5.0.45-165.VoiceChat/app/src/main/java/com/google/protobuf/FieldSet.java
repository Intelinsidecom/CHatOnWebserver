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
    private static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$WireFormat$FieldType;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType;
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

    static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$WireFormat$FieldType() {
        int[] iArr = $SWITCH_TABLE$com$google$protobuf$WireFormat$FieldType;
        if (iArr == null) {
            iArr = new int[WireFormat.FieldType.values().length];
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[WireFormat.FieldType.BYTES.ordinal()] = 12;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[WireFormat.FieldType.ENUM.ordinal()] = 14;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[WireFormat.FieldType.GROUP.ordinal()] = 10;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[WireFormat.FieldType.MESSAGE.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[WireFormat.FieldType.SFIXED32.ordinal()] = 15;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[WireFormat.FieldType.SFIXED64.ordinal()] = 16;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[WireFormat.FieldType.SINT32.ordinal()] = 17;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr[WireFormat.FieldType.SINT64.ordinal()] = 18;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr[WireFormat.FieldType.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError e16) {
            }
            try {
                iArr[WireFormat.FieldType.UINT32.ordinal()] = 13;
            } catch (NoSuchFieldError e17) {
            }
            try {
                iArr[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError e18) {
            }
            $SWITCH_TABLE$com$google$protobuf$WireFormat$FieldType = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType() {
        int[] iArr = $SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType;
        if (iArr == null) {
            iArr = new int[WireFormat.JavaType.valuesCustom().length];
            try {
                iArr[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError e9) {
            }
            $SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType = iArr;
        }
        return iArr;
    }

    private FieldSet() {
    }

    private FieldSet(boolean dummy) {
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
    public FieldSet<FieldDescriptorType> m3101clone() {
        FieldSet<FieldDescriptorType> clone = newFieldSet();
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            Map.Entry<K, Object> arrayEntryAt = this.fields.getArrayEntryAt(i);
            clone.setField((FieldDescriptorLite) arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        Iterator it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            Map.Entry<FieldDescriptorType, Object> entry = (Map.Entry) it.next();
            FieldDescriptorType descriptor = entry.getKey();
            clone.setField(descriptor, entry.getValue());
        }
        return clone;
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

    public boolean hasField(FieldDescriptorType descriptor) {
        if (descriptor.isRepeated()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.fields.get(descriptor) != null;
    }

    public Object getField(FieldDescriptorType descriptor) {
        return this.fields.get(descriptor);
    }

    public void setField(FieldDescriptorType descriptor, Object value) {
        if (descriptor.isRepeated()) {
            if (!(value instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List newList = new ArrayList();
            newList.addAll((List) value);
            for (Object element : newList) {
                verifyType(descriptor.getLiteType(), element);
            }
            value = newList;
        } else {
            verifyType(descriptor.getLiteType(), value);
        }
        this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) descriptor, (FieldDescriptorType) value);
    }

    public void clearField(FieldDescriptorType descriptor) {
        this.fields.remove(descriptor);
    }

    public int getRepeatedFieldCount(FieldDescriptorType descriptor) {
        if (!descriptor.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object value = this.fields.get(descriptor);
        if (value == null) {
            return 0;
        }
        return ((List) value).size();
    }

    public Object getRepeatedField(FieldDescriptorType descriptor, int index) {
        if (!descriptor.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object value = this.fields.get(descriptor);
        if (value == null) {
            throw new IndexOutOfBoundsException();
        }
        return ((List) value).get(index);
    }

    public void setRepeatedField(FieldDescriptorType descriptor, int index, Object value) {
        if (!descriptor.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object list = this.fields.get(descriptor);
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        verifyType(descriptor.getLiteType(), value);
        ((List) list).set(index, value);
    }

    public void addRepeatedField(FieldDescriptorType descriptor, Object value) {
        List list;
        if (!descriptor.isRepeated()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        verifyType(descriptor.getLiteType(), value);
        Object existingValue = this.fields.get(descriptor);
        if (existingValue == null) {
            list = new ArrayList();
            this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) descriptor, (FieldDescriptorType) list);
        } else {
            list = (List) existingValue;
        }
        list.add(value);
    }

    private static void verifyType(WireFormat.FieldType type, Object value) {
        if (value == null) {
            throw new NullPointerException();
        }
        boolean isValid = false;
        switch ($SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType()[type.getJavaType().ordinal()]) {
            case 1:
                isValid = value instanceof Integer;
                break;
            case 2:
                isValid = value instanceof Long;
                break;
            case 3:
                isValid = value instanceof Float;
                break;
            case 4:
                isValid = value instanceof Double;
                break;
            case 5:
                isValid = value instanceof Boolean;
                break;
            case 6:
                isValid = value instanceof String;
                break;
            case 7:
                isValid = value instanceof ByteString;
                break;
            case 8:
                isValid = value instanceof Internal.EnumLite;
                break;
            case 9:
                isValid = value instanceof MessageLite;
                break;
        }
        if (!isValid) {
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
            Map.Entry<FieldDescriptorType, Object> entry = (Map.Entry) it.next();
            if (!isInitialized(entry)) {
                return false;
            }
        }
        return true;
    }

    private boolean isInitialized(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType descriptor = entry.getKey();
        if (descriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            if (descriptor.isRepeated()) {
                for (MessageLite element : (List) entry.getValue()) {
                    if (!element.isInitialized()) {
                        return false;
                    }
                }
            } else if (!((MessageLite) entry.getValue()).isInitialized()) {
                return false;
            }
        }
        return true;
    }

    static int getWireFormatForFieldType(WireFormat.FieldType type, boolean isPacked) {
        if (isPacked) {
            return 2;
        }
        return type.getWireType();
    }

    public void mergeFrom(FieldSet<FieldDescriptorType> other) {
        for (int i = 0; i < other.fields.getNumArrayEntries(); i++) {
            mergeFromField(other.fields.getArrayEntryAt(i));
        }
        Iterator it = other.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            Map.Entry<FieldDescriptorType, Object> entry = (Map.Entry) it.next();
            mergeFromField(entry);
        }
    }

    private void mergeFromField(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType descriptor = entry.getKey();
        Object otherValue = entry.getValue();
        if (descriptor.isRepeated()) {
            Object value = this.fields.get(descriptor);
            if (value == null) {
                this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) descriptor, (FieldDescriptorType) new ArrayList((List) otherValue));
                return;
            } else {
                ((List) value).addAll((List) otherValue);
                return;
            }
        }
        if (descriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            Object value2 = this.fields.get(descriptor);
            if (value2 == null) {
                this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) descriptor, (FieldDescriptorType) otherValue);
                return;
            } else {
                this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) descriptor, (FieldDescriptorType) descriptor.internalMergeFrom(((MessageLite) value2).toBuilder(), (MessageLite) otherValue).build());
                return;
            }
        }
        this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) descriptor, (FieldDescriptorType) otherValue);
    }

    public static Object readPrimitiveField(CodedInputStream input, WireFormat.FieldType type) throws IOException {
        switch ($SWITCH_TABLE$com$google$protobuf$WireFormat$FieldType()[type.ordinal()]) {
            case 1:
                return Double.valueOf(input.readDouble());
            case 2:
                return Float.valueOf(input.readFloat());
            case 3:
                return Long.valueOf(input.readInt64());
            case 4:
                return Long.valueOf(input.readUInt64());
            case 5:
                return Integer.valueOf(input.readInt32());
            case 6:
                return Long.valueOf(input.readFixed64());
            case 7:
                return Integer.valueOf(input.readFixed32());
            case 8:
                return Boolean.valueOf(input.readBool());
            case 9:
                return input.readString();
            case 10:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 11:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 12:
                return input.readBytes();
            case 13:
                return Integer.valueOf(input.readUInt32());
            case 14:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            case 15:
                return Integer.valueOf(input.readSFixed32());
            case 16:
                return Long.valueOf(input.readSFixed64());
            case 17:
                return Integer.valueOf(input.readSInt32());
            case 18:
                return Long.valueOf(input.readSInt64());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            Map.Entry<K, Object> arrayEntryAt = this.fields.getArrayEntryAt(i);
            writeField((FieldDescriptorLite) arrayEntryAt.getKey(), arrayEntryAt.getValue(), output);
        }
        Iterator it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            Map.Entry<FieldDescriptorType, Object> entry = (Map.Entry) it.next();
            writeField(entry.getKey(), entry.getValue(), output);
        }
    }

    public void writeMessageSetTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            writeMessageSetTo(this.fields.getArrayEntryAt(i), output);
        }
        Iterator it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            Map.Entry<FieldDescriptorType, Object> entry = (Map.Entry) it.next();
            writeMessageSetTo(entry, output);
        }
    }

    private void writeMessageSetTo(Map.Entry<FieldDescriptorType, Object> entry, CodedOutputStream output) throws IOException {
        FieldDescriptorType descriptor = entry.getKey();
        if (descriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !descriptor.isRepeated() && !descriptor.isPacked()) {
            output.writeMessageSetExtension(entry.getKey().getNumber(), (MessageLite) entry.getValue());
        } else {
            writeField(descriptor, entry.getValue(), output);
        }
    }

    private static void writeElement(CodedOutputStream output, WireFormat.FieldType type, int number, Object value) throws IOException {
        if (type == WireFormat.FieldType.GROUP) {
            output.writeGroup(number, (MessageLite) value);
        } else {
            output.writeTag(number, getWireFormatForFieldType(type, false));
            writeElementNoTag(output, type, value);
        }
    }

    private static void writeElementNoTag(CodedOutputStream output, WireFormat.FieldType type, Object value) throws IOException {
        switch ($SWITCH_TABLE$com$google$protobuf$WireFormat$FieldType()[type.ordinal()]) {
            case 1:
                output.writeDoubleNoTag(((Double) value).doubleValue());
                break;
            case 2:
                output.writeFloatNoTag(((Float) value).floatValue());
                break;
            case 3:
                output.writeInt64NoTag(((Long) value).longValue());
                break;
            case 4:
                output.writeUInt64NoTag(((Long) value).longValue());
                break;
            case 5:
                output.writeInt32NoTag(((Integer) value).intValue());
                break;
            case 6:
                output.writeFixed64NoTag(((Long) value).longValue());
                break;
            case 7:
                output.writeFixed32NoTag(((Integer) value).intValue());
                break;
            case 8:
                output.writeBoolNoTag(((Boolean) value).booleanValue());
                break;
            case 9:
                output.writeStringNoTag((String) value);
                break;
            case 10:
                output.writeGroupNoTag((MessageLite) value);
                break;
            case 11:
                output.writeMessageNoTag((MessageLite) value);
                break;
            case 12:
                output.writeBytesNoTag((ByteString) value);
                break;
            case 13:
                output.writeUInt32NoTag(((Integer) value).intValue());
                break;
            case 14:
                output.writeEnumNoTag(((Internal.EnumLite) value).getNumber());
                break;
            case 15:
                output.writeSFixed32NoTag(((Integer) value).intValue());
                break;
            case 16:
                output.writeSFixed64NoTag(((Long) value).longValue());
                break;
            case 17:
                output.writeSInt32NoTag(((Integer) value).intValue());
                break;
            case 18:
                output.writeSInt64NoTag(((Long) value).longValue());
                break;
        }
    }

    public static void writeField(FieldDescriptorLite<?> descriptor, Object value, CodedOutputStream output) throws IOException {
        WireFormat.FieldType type = descriptor.getLiteType();
        int number = descriptor.getNumber();
        if (descriptor.isRepeated()) {
            List<?> valueList = (List) value;
            if (descriptor.isPacked()) {
                output.writeTag(number, 2);
                int dataSize = 0;
                for (Object element : valueList) {
                    dataSize += computeElementSizeNoTag(type, element);
                }
                output.writeRawVarint32(dataSize);
                for (Object element2 : valueList) {
                    writeElementNoTag(output, type, element2);
                }
                return;
            }
            for (Object element3 : valueList) {
                writeElement(output, type, number, element3);
            }
            return;
        }
        writeElement(output, type, number, value);
    }

    public int getSerializedSize() {
        int size = 0;
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            Map.Entry<K, Object> arrayEntryAt = this.fields.getArrayEntryAt(i);
            size += computeFieldSize((FieldDescriptorLite) arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        Iterator it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            Map.Entry<FieldDescriptorType, Object> entry = (Map.Entry) it.next();
            size += computeFieldSize(entry.getKey(), entry.getValue());
        }
        return size;
    }

    public int getMessageSetSerializedSize() {
        int size = 0;
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            size += getMessageSetSerializedSize(this.fields.getArrayEntryAt(i));
        }
        Iterator it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            Map.Entry<FieldDescriptorType, Object> entry = (Map.Entry) it.next();
            size += getMessageSetSerializedSize(entry);
        }
        return size;
    }

    private int getMessageSetSerializedSize(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType descriptor = entry.getKey();
        return (descriptor.getLiteJavaType() != WireFormat.JavaType.MESSAGE || descriptor.isRepeated() || descriptor.isPacked()) ? computeFieldSize(descriptor, entry.getValue()) : CodedOutputStream.computeMessageSetExtensionSize(entry.getKey().getNumber(), (MessageLite) entry.getValue());
    }

    private static int computeElementSize(WireFormat.FieldType type, int number, Object value) {
        int tagSize = CodedOutputStream.computeTagSize(number);
        if (type == WireFormat.FieldType.GROUP) {
            tagSize *= 2;
        }
        return computeElementSizeNoTag(type, value) + tagSize;
    }

    private static int computeElementSizeNoTag(WireFormat.FieldType type, Object value) {
        switch ($SWITCH_TABLE$com$google$protobuf$WireFormat$FieldType()[type.ordinal()]) {
            case 1:
                return CodedOutputStream.computeDoubleSizeNoTag(((Double) value).doubleValue());
            case 2:
                return CodedOutputStream.computeFloatSizeNoTag(((Float) value).floatValue());
            case 3:
                return CodedOutputStream.computeInt64SizeNoTag(((Long) value).longValue());
            case 4:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) value).longValue());
            case 5:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) value).intValue());
            case 6:
                return CodedOutputStream.computeFixed64SizeNoTag(((Long) value).longValue());
            case 7:
                return CodedOutputStream.computeFixed32SizeNoTag(((Integer) value).intValue());
            case 8:
                return CodedOutputStream.computeBoolSizeNoTag(((Boolean) value).booleanValue());
            case 9:
                return CodedOutputStream.computeStringSizeNoTag((String) value);
            case 10:
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite) value);
            case 11:
                return CodedOutputStream.computeMessageSizeNoTag((MessageLite) value);
            case 12:
                return CodedOutputStream.computeBytesSizeNoTag((ByteString) value);
            case 13:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) value).intValue());
            case 14:
                return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) value).getNumber());
            case 15:
                return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) value).intValue());
            case 16:
                return CodedOutputStream.computeSFixed64SizeNoTag(((Long) value).longValue());
            case 17:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) value).intValue());
            case 18:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) value).longValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int computeFieldSize(FieldDescriptorLite<?> descriptor, Object value) {
        WireFormat.FieldType type = descriptor.getLiteType();
        int number = descriptor.getNumber();
        if (descriptor.isRepeated()) {
            if (descriptor.isPacked()) {
                int dataSize = 0;
                for (Object element : (List) value) {
                    dataSize += computeElementSizeNoTag(type, element);
                }
                return CodedOutputStream.computeTagSize(number) + dataSize + CodedOutputStream.computeRawVarint32Size(dataSize);
            }
            int size = 0;
            for (Object element2 : (List) value) {
                size += computeElementSize(type, number, element2);
            }
            return size;
        }
        int size2 = computeElementSize(type, number, value);
        return size2;
    }
}
